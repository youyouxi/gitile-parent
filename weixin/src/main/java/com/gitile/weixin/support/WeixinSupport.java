package com.gitile.weixin.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gitile.weixin.support.event.EventType;
import com.gitile.weixin.support.event.MsgType;
import com.gitile.weixin.support.request.WeixinRequest;
import com.gitile.weixin.support.response.ArticleResponse;
import com.gitile.weixin.support.response.ImageResponse;
import com.gitile.weixin.support.response.MusicResponse;
import com.gitile.weixin.support.response.VideoResponse;
import com.gitile.weixin.support.response.VoiceResponse;
import com.gitile.weixin.support.response.WeixinResponse;
import com.gitile.weixin.utils.lang.IoUtils;
import com.gitile.weixin.utils.lang.SignatureUtil;
import com.gitile.weixin.utils.lang.StringUtils;
import com.gitile.weixin.utils.lang.XmlUtil;

/**
 * 微信支持入口
 * 抽象方法中，on开头的是msgtype的事件，无on的是event事件
 */
public abstract class WeixinSupport {
	
	private HttpServletRequest request;
	protected WeixinRequest weixinRequest;
	protected WeixinResponse weixinResponse;
	
	/**
	 * 构建微信处理
	 * @param request 微信服务发过来的http请求
	 */
	public WeixinSupport(HttpServletRequest request){
		this.request = request;
		this.weixinRequest = new WeixinRequest();
		this.weixinResponse = new WeixinResponse();
	}

	/**
	 * 调用入口，进行数据接收，事件分发
	 * @return
	 */
	public String execute(){
		String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        String token = Config.instance().getToken();
        //验证请求签名
        if(StringUtils.isEmpty(signature)||!signature.equals(SignatureUtil.generateEventMessageSignature(token,timestamp,nonce))){
        	return "error";
        }
        //首次请求申请验证,返回echostr
		if(StringUtils.isNotEmpty(echostr)){
     		return echostr;
		}
		//分发消息，得到响应
		String result = dispatch();
		return result;
	}

	/**
	 * 分发处理，得到响应
	 * @return
	 */
	private String dispatch() {
		String postDataStr = null;
		try {
			 postDataStr = IoUtils.streamToString(request.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 解析数据
		setPostData(postDataStr);
		// 消息分发处理
		dispatchMessage();
		// 响应事件
		String result = response();
		return result;
	}
	
	/**
	 * 得到post数据，对象化
	 * @param xmlStr
	 */
	private void setPostData(String xmlStr){
		try {
			this.weixinRequest = XmlUtil.convertToObject(WeixinRequest.class, xmlStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 消息事件分发
	 */
	private void dispatchMessage(){
		String msgTypeStr = weixinRequest.getMsgType();
		if(StringUtils.isNotEmpty(msgTypeStr)){
			MsgType msgType = MsgType.valueOf(msgTypeStr.toUpperCase());
			switch (msgType) {
			case EVENT:
				dispatchEvent();
				break;
			case TEXT:
				onText();
				break;
			case IMAGE:
				onImage();
				break;
			case VOICE:
				onVoice();
				break;
			case VIDEO:
				onVideo();
				break;
			case LOCATION:
				onLocation();
				break;
			case LINK:
				onLink();
				break;
			default:
				onUnknown();
				break;
			}
		} else {
			onUnknown();
		}
		
	}
	
	/**
	 * event事件分发
	 */
	private void dispatchEvent() {
		EventType event = EventType.valueOf(weixinRequest.getEvent().toUpperCase());
		switch (event) {
		case CLICK:
			click();
			break;
		case SUBSCRIBE:
			subscribe();
			break;
		case UNSUBSCRIBE:
			unSubscribe();
			break;
		case SCAN:
			scan();
			break;
		case LOCATION:
			location();
			break;
		case VIEW:
			view();
			break;
		case TEMPLATESENDJOBFINISH:
			templateMsgCallback();
			break;
		case SCANCODE_PUSH:
			scanCodePush();
			break;
		case SCANCODE_WAITMSG:
			scanCodeWaitMsg();
		    break;
		case PIC_SYSPHOTO:
			picSysPhoto();
		    break;
		case PIC_PHOTO_OR_ALBUM:
			picPhotoOrAlbum();
		    break;
		case PIC_WEIXIN:
			picWeixin();
		    break;
		case LOCATION_SELECT:
			locationSelect();
		    break;
		default:
			break;
		}
	}

	/**
	 * 返回响应数据
	 * @return
	 */
	private String response(){
		String result = null;
		try {
			//设置
			result = XmlUtil.convertToXML(weixinResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 响应数据基础构造
	 */
	private void responseBase(){
		weixinResponse.setToUserName(weixinRequest.getFromUserName());
		weixinResponse.setFromUserName(weixinRequest.getToUserName());
		weixinResponse.setCreateTime(weixinRequest.getCreateTime());
	}
	
	/**
	 * 回复文本消息
	 * @param content 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */
	public void responseText(String content){
		responseBase();
		weixinResponse.setMsgType(MsgType.TEXT.name());
		weixinResponse.setContent(content);
	}
	
	/**
	 * 回复图片消息
	 * @param mediaId 通过上传多媒体文件，得到的id
	 */
	public void responseImage(String mediaId){
		responseBase();
		weixinResponse.setMsgType(MsgType.IMAGE.name());
		ImageResponse image = new ImageResponse();
		image.setMediaId(mediaId);
		weixinResponse.setImage(image);
	}
	
	/**
	 * 回复语音消息
	 * @param mediaId  通过上传多媒体文件，得到的id
	 */
	public void responseVoice(String mediaId){
		responseBase();
		weixinResponse.setMsgType(MsgType.VOICE.name());
		VoiceResponse voice = new VoiceResponse();
		voice.setMediaId(mediaId);
		weixinResponse.setVoice(voice);
	}
	
	/**
	 * 回复视频消息
	 * @param mediaId      通过上传多媒体文件，得到的id
	 * @param title        视频消息的标题
	 * @param description  视频消息的描述
	 */
	public void responseVideo(String mediaId,String title,String description){
		VideoResponse video = new VideoResponse();
		video.setMediaId(mediaId);
		video.setTitle(title);
		video.setDescription(description);
		responseVideo(video);
	}
	
	/**
	 * 回复视频消息
	 * @param video  视频消息
	 */
	public void responseVideo(VideoResponse video){
		responseBase();
		weixinResponse.setMsgType(MsgType.VIDEO.name());
		weixinResponse.setVideo(video);
	}
	
	/**
	 * 回复音乐消息
	 * @param title         音乐标题
	 * @param description   音乐描述
	 * @param musicURL      音乐链接
	 * @param hQMusicUrl    高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 * @param thumbMediaId  缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	public void responseMusic(String title,String description,
			String musicURL,String hQMusicUrl,String thumbMediaId){
		MusicResponse music = new MusicResponse();
		music.setTitle(title);
		music.setDescription(description);
		music.setMusicURL(musicURL);
		music.setHQMusicUrl(hQMusicUrl);
		music.setThumbMediaId(thumbMediaId);
		responseMusic(music);
	}
	
	/**
	 * 回复音乐消息
	 * @param music  音乐消息
	 */
	public void responseMusic(MusicResponse music){
		responseBase();
		weixinResponse.setMsgType(MsgType.MUSIC.name());
		weixinResponse.setMusic(music);
	}
	
	/**
	 * 回复图文消息，单条图文消息
	 * @param title         图文消息标题
	 * @param description   图文消息描述
	 * @param picUrl        图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 * @param url           点击图文消息跳转链接
	 */
	public void responseNew(String title,String description,String picUrl,String url){
		ArticleResponse item = new ArticleResponse();
		item.setTitle(title);
		item.setDescription(description);
		item.setPicUrl(picUrl);
		item.setUrl(url);
		responseNews(item);
	}
	
	/**
	 * 回复图文消息单条
	 * @param item
	 */
	public void responseNews(ArticleResponse item){
		List<ArticleResponse> items = new ArrayList<ArticleResponse>();
		items.add(item);
		responseNews(items);
	}
	
	/**
	 * 回复图文消息
	 * @param items
	 */
	public void responseNews(List<ArticleResponse> items){
		responseBase();
		weixinResponse.setMsgType(MsgType.NEWS.name());
		weixinResponse.setArticleCount(String.valueOf(items.size()));
		weixinResponse.setArticle(items);
		
	}
	
	/**
	 * 文本消息处理Msgtype=text
	 */
    protected abstract void onText();
	/**
	 * 图像消息Msgtype=image
	 */
    protected abstract void onImage();
	/**
	 * 语音消息 Msgtype=voice
	 */
    protected abstract void onVoice();
	/**
	 * 视频 消息Msgtype=video
	 */
    protected abstract void onVideo();
	/**
	 * 地理位置消息Msgtype=location
	 */
    protected abstract void onLocation();
	/**
	 * 链接消息Msgtype=link
	 */
    protected abstract void onLink();
	/**
	 * 未知消息类型的错误处理逻辑，不需要处理则空方法即可
	 */
    protected abstract void onUnknown();
	/**
	 * click点击事件处理event=location
	 */
	protected abstract void click();
	/**
	 * subscribe关注事件处理
	 */
	protected abstract void subscribe();
	/**
	 * unSubscribe取消关注事件处理
	 */
	protected abstract void unSubscribe();
	/**
	 * scan事件处理
	 */
	protected abstract void scan();
	/**
	 * location事件处理event=location
	 */
	protected abstract void location();
	/**
	 * view 事件处理event=location
	 */
	protected abstract void view();
	/**
	 * 模板消息发送回调
	 */
	protected abstract void templateMsgCallback();
	/**
	 * 扫码推事件
	 */
	protected abstract void scanCodePush();
	/**
	 * 扫码推事件且弹出“消息接收中”提示框的事件
	 */
	protected abstract void scanCodeWaitMsg();
	/**
	 * 弹出系统拍照发图的事件
	 */
	protected abstract void picSysPhoto();
	/**
	 * 弹出拍照或者相册发图的事件
	 */
	protected abstract void picPhotoOrAlbum();
	/**
	 * 扫码推事件且弹出“消息接收中”提示框的事件
	 */
	protected abstract void picWeixin();
	/**
	 * 弹出地理位置选择器的事件
	 */
	protected abstract void locationSelect();
}
