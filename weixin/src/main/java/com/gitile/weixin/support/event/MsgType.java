package com.gitile.weixin.support.event;

/**
 * 微信消息类型,大小写对应微信接口，msgType的枚举值
 */
public enum MsgType {
	EVENT,        //事件
	TEXT,         //文本消息
	IMAGE,
	LOCATION,
	LINK,
	VOICE,
	VIDEO,
	MUSIC,
	NEWS;
}
