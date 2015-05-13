package com.gitile.weixin.support.event;

/**
 * 微信事件类型，event字段的枚举
 */
public enum EventType {
	subscribe,             //关注
	unsubscribe,           //取消关注
	CLICK,                 //点击
	SCAN,                  //扫描
	LOCATION,              //上报地理位置
	VIEW,                  //跳转链接
	TEMPLATESENDJOBFINISH, //模板消息发送成功之后事件
	SCANCODE_PUSH,         //扫码推事件
	SCANCODE_WAITMSG,      //扫码推事件且弹出“消息接收中”提示框的事件
	PIC_SYSPHOTO,          //弹出系统拍照发图的事件
	PIC_PHOTO_OR_ALBUM,    //弹出拍照或者相册发图的事件
	PIC_WEIXIN,            //弹出微信相册发图器的事件
	LOCATION_SELECT;       //弹出地理位置选择器的事件
}
