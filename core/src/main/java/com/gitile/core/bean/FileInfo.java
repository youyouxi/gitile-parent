package com.gitile.core.bean;

import java.util.Date;

public class FileInfo implements Comparable<FileInfo> {
	
	private String fileName;
	
	private String filePath;
	
	private String fileLength;
	
	private Date lastModifiedTime;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	@Override
	public int compareTo(FileInfo o) {
		return o.getLastModifiedTime().compareTo(this.getLastModifiedTime());
	}

	public String getFileLength() {
		return fileLength;
	}

	public void setFileLength(String fileLength) {
		this.fileLength = fileLength;
	}

}
