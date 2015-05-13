package com.gitile.weixin.support.request;

import javax.xml.bind.annotation.XmlElement;

/**
 * 发送的图片信息项
 */
public class Item {
	
	private String PicMd5Sum;

	@XmlElement(name="PicMd5Sum")
	public String getPicMd5Sum() {
		return PicMd5Sum;
	}
	public void setPicMd5Sum(String picMd5Sum) {
		PicMd5Sum = picMd5Sum;
	}
	
}
