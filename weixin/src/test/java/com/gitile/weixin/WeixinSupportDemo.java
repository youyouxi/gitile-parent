package com.gitile.weixin;

import javax.servlet.http.HttpServletRequest;

import com.gitile.weixin.support.WeixinSupport;
import com.gitile.weixin.utils.lang.StringUtils;

public class WeixinSupportDemo extends WeixinSupport {
	
	public WeixinSupportDemo(HttpServletRequest request) {
		super(request);
	}

	/**
	 * 文本消息
	 */
	@Override
	protected void onText() {
		String content = weixinRequest.getContent().trim();
//		String msgId = wechatRequest.getMsgId();
		//文本测试
		if(content.equals("1")){
			responseText("你好，hello world!<a href=\"http://www.baidu.com\">这是链接</a>");
		}
		else if(content.equals("2")){
			responseNew("图文消息", "测试图文消息", "http://upload.qqfuzhi.com/portal/showimg.php?img=e2dnYyk8PHEhIys9Y3t8Z3w9YGd8YXY9YmI9cHx%2BPHtnZ2NMen50f3xydz1wdHosPGFmYX8nTHEuJ3Z2IXFyJnUiICAqcnAnInYhcHJ2InAnKndycidwKyAgdnIqdiN1KitxdyojIysjcSAiJipyK3YqIXd1JCt1JyBxKnIkcCt1JyYkKysicCAjIiokKyogcHd1ICAhcXArciUjI3EhdyYjKiIncSclIiUqJyAkInEgKiV2IiEiJnEgKyp2cXV3cCEmJ3EjcHYqJHIrdytwIyYgIHIicHAgcXFwIiIldyIhNXIuISMrNXEuISMr", 
					"http://www.chengn.com");
//			responseNew(title, description, picUrl, url);
//			ArticleResponse item = new ArticleResponse();
//			item.setTitle(title);
//			item.setDescription(description);
//			item.setUrl(url);
//			item.setPicUrl(picUrl);
//			responseNews(item);
//			List<ArticleResponse> items = new ArrayList<ArticleResponse>();
//			items.add(item);
//			responseNews(items);
		}
		else{
			responseText("你好，你的输入为 " + content + "\n"
					+ "请按照如下操作输入:\n"
					+ "1 文本\n"
					+ "2 图文\n");
		}
	}
	/**
	 * 图片消息
	 */
	@Override
	protected void onImage() {
		String picUrl = weixinRequest.getPicUrl();
		String MediaId = weixinRequest.getMediaId();
		String MsgId = weixinRequest.getMsgId();
		String result = "图片消息picUrl:" + picUrl + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
		responseText(result);
		//responseImage(mediaId);
	}

	/**
	 * 语音消息
	 */
	@Override
	protected void onVoice() {
		String Format = weixinRequest.getFormat();
		String MediaId = weixinRequest.getMediaId();//视频消息媒体id，可以调用多媒体文件下载接口拉取数据
		String MsgId = weixinRequest.getMsgId();
		String result = "语音消息Format:" + Format + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
		responseText(result);	
		//responseVoice(mediaId);
		//回复音乐消息
//		MusicResponse music = new MusicResponse();
//		music.setTitle(title);
//		music.setDescription(description);
//		music.setMusicURL(musicURL);
//		music.setHQMusicUrl(hQMusicUrl);
//		music.setThumbMediaId(thumbMediaId);
//		responseMusic(music);
//		responseMusic(title, description, musicURL, hQMusicUrl, thumbMediaId);
	}

	/**
	 * 视频消息
	 */
	@Override
	protected void onVideo() {
		String ThumbMediaId = weixinRequest.getThumbMediaId();
		String MediaId = weixinRequest.getMediaId();//语音消息媒体id，可以调用多媒体文件下载接口拉取数据
		String MsgId = weixinRequest.getMsgId();
		String result = "视频消息ThumbMediaId:" + ThumbMediaId + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
		responseText(result);
		//回复视频消息
//		VideoResponse video = new VideoResponse();
//		video.setTitle(title);
//		video.setDescription(description);
//		video.setMediaId(mediaId);
//		responseVideo(video);
//		responseVideo(mediaId, title, description);
	}
	
	/**
	 * 地理位置消息
	 */
	@Override
	protected void onLocation() {
		String Location_X = weixinRequest.getLocation_X();
		String Location_Y = weixinRequest.getLocation_Y();
		String Scale = weixinRequest.getScale();
		String Label = weixinRequest.getLabel();
		String MsgId = weixinRequest.getMsgId();
		String result = "地理位置消息Location_X:" + Location_X + ", Location_Y:" + Location_Y + 
				", Scale:" + Scale + ", Label:" + Label + 
				", MsgId:" + MsgId;
		responseText(result);	
	}
	/**
	 * 链接消息
	 */
	@Override
	protected void onLink() {
		String Title = weixinRequest.getTitle();
		String Description = weixinRequest.getDescription();
		String Url = weixinRequest.getUrl();
		String MsgId = weixinRequest.getMsgId();
		String result = "链接消息Title:" + Title + ", Description:" + Description + 
				", Url:" + Url + 
				", MsgId:" + MsgId;
		responseText(result);	
	}
	
	
	/**
	 * 未知消息类型，错误处理
	 */
	@Override
	protected void onUnknown() {
		String msgType = weixinRequest.getMsgType();
		String result = "未知消息msgType:" + msgType;
		responseText(result);

	}

	/**
	 * 扫描二维码事件
	 */
	@Override
	protected void scan() {
		String FromUserName = weixinRequest.getFromUserName();
		String Ticket = weixinRequest.getTicket();
		String result = "扫描二维码事件FromUserName:" + FromUserName + ", Ticket:" + Ticket;
		responseText(result);
	}

	/**
	 * 订阅事件
	 */
	@Override
	protected void subscribe() {
		String FromUserName = weixinRequest.getFromUserName();
		//用户未关注时扫描二维码事件,会多一个EventKey和Ticket节点
		String Ticket = weixinRequest.getTicket();
		String result = "订阅事件FromUserName:" + FromUserName;
		if(StringUtils.isNotEmpty(Ticket)){
			result = "扫描带场景值二维码事件FromUserName:" + FromUserName + ", Ticket:" + Ticket;
		}
		responseText(result);
	}
	
	/**
	 * 取消订阅事件
	 */
	@Override
	protected void unSubscribe() {
		String FromUserName = weixinRequest.getFromUserName();
		String result = "取消订阅事件FromUserName:" + FromUserName;
		responseText(result);
	}
	
	/**
	 * 点击菜单跳转链接时的事件推送
	 */
	@Override
	protected void view() {
		String link = super.weixinRequest.getEventKey();
		responseText("点击菜单跳转链接时的事件推送link:" + link);
	}

	/**
	 * 自定义菜单事件
	 */
	@Override
	protected void click() {
		String key = super.weixinRequest.getEventKey();
		responseText("自定义菜单事件eventKey:" + key);
	}
	
	/**
	 * 上报地理位置事件
	 */
	@Override
	protected void location() {
		String Latitude = weixinRequest.getLatitude();
		String Longitude = weixinRequest.getLongitude();
		String Precision = weixinRequest.getPrecision();
		String result = "上报地理位置事件Latitude:" + Latitude + ", Longitude:" + Longitude + ", Precision:" + Precision;
		responseText(result);
	}

	/**
	 * 弹出地理位置选择器的事件
	 */
	@Override
	protected void locationSelect() {
		String Location_X = weixinRequest.getSendLocationInfo().getLocation_X();
		String Location_Y = weixinRequest.getSendLocationInfo().getLocation_Y();
		String Scale = weixinRequest.getSendLocationInfo().getScale();
		String Label = weixinRequest.getSendLocationInfo().getLabel();
		String Poiname = weixinRequest.getSendLocationInfo().getPoiname();
		String result = "弹出地理位置选择器的事件Location_X:" + Location_X + 
				", Location_Y:" + Location_Y+ 
				", Scale:" + Scale+ 
				", Label:" + Label+ 
				", Poiname:" + Poiname;
		responseText(result);
	}
	/**
	 * 弹出拍照或者相册发图的事件
	 */
	@Override
	protected void picPhotoOrAlbum() {
		String Count = weixinRequest.getSendPicsInfo().getCount();
		String PicMd5Sum = "";
		if(StringUtils.isNotEmpty(Count) && !Count.equals("0")){
			PicMd5Sum = weixinRequest.getSendPicsInfo().getItem().get(0).getPicMd5Sum();
		}
		String result = "弹出系统拍照发图的事件Count:" + Count + ", PicMd5Sum:" + PicMd5Sum;
		responseText(result);
	}
	/**
	 * 弹出系统拍照发图的事件
	 */
	@Override
	protected void picSysPhoto() {
		String Count = weixinRequest.getSendPicsInfo().getCount();
		String result = "弹出系统拍照发图的事件Count:" + Count ;
		responseText(result);
	}
	/**
	 * 弹出微信相册发图器的事件推送
	 */
	@Override
	protected void picWeixin() {
		String Count = weixinRequest.getSendPicsInfo().getCount();
		String result = "弹出系统拍照发图的事件Count:" + Count ;
		responseText(result);
	}
	/**
	 * 扫码推事件
	 * 
	 */
	@Override
	protected void scanCodePush() {
		String ScanType = weixinRequest.getScanCodeInfo().getScanType();
		String ScanResult = weixinRequest.getScanCodeInfo().getScanResult();
		String result = "扫码推事件ScanType:" + ScanType + ", ScanResult:" + ScanResult;
		responseText(result);
	}
	/**
	 * 扫码推事件且弹出“消息接收中”提示框的事件
	 */
	@Override
	protected void scanCodeWaitMsg() {
		String ScanType = weixinRequest.getScanCodeInfo().getScanType();
		String ScanResult = weixinRequest.getScanCodeInfo().getScanResult();
		String result = "扫码推事件ScanType:" + ScanType + ", ScanResult:" + ScanResult;
		responseText(result);
	}
	/**
	 * 模板消息发送成功推送事件
	 */
	@Override
	protected void templateMsgCallback() {
		String MsgID = weixinRequest.getMsgId();
		String Status = weixinRequest.getStatus();
		String result = "模板消息发送成功推送事件MsgID:" + MsgID + ", Status:" + Status;
		System.out.println(result);
	}
}
