package com.gitile.core.file;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.gitile.core.bean.FileInfo;
import com.gitile.core.utils.DateUtils;

/**
 * 文件操作工具类
 *
 */
public class FileUtils extends org.apache.commons.io.FileUtils {

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 * @param type
	 */
	public static boolean deleteFileByRealPath(String realPath) {
		if (StringUtils.isBlank(realPath)) {
			return false;
		}
		try {
			File file = new File(realPath);
			if (file.isFile() && file.exists()) {
				file.delete();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 文件后缀名校验
	 * 
	 * @param fileName
	 * @param regex
	 * @return
	 */
	public static boolean validateFileType(String fileName, String regex) {
		Pattern p = Pattern.compile(regex);
		return p.matcher(fileName.toLowerCase()).matches();
	}

	/**
	 * 文件大小校验
	 * 
	 * @param fileSize
	 * @param limitSize
	 * @return
	 */
	public static boolean validateFileSize(long fileSize, long limitSize) {
		if (fileSize <= limitSize) {
			return true;
		}
		return false;
	}
	
	/**
	 * 文件上传(单个)
	 * 
	 * @param uploadPath
	 * @param myFile
	 * @param subPath
	 * @param id
	 * @return
	 */
	public static String uploadImgFile(String uploadPath, String subPath, MultipartFile myFile, Long id) {
		String filePath = null;
		String realUploadPath = uploadPath + "/" + subPath;
		File uploadPathFile = new File(realUploadPath);
		if (!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		if (null != myFile && !myFile.isEmpty()) {
			try {
				String fileName = myFile.getOriginalFilename();
				String saveFileName = fileName.subSequence(0,
						fileName.lastIndexOf("."))
						+ "_"
						+ DateUtils.dateToString(new Date(), 3)
						+ new Random().nextInt(100)
						+ id.toString()
						+ fileName.substring(fileName.lastIndexOf("."));
				// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
				FileUtils.copyInputStreamToFile(myFile.getInputStream(),
						new File(realUploadPath, saveFileName));
				filePath = subPath + "/" + saveFileName;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
	/**
	 * 获取目录下文件列表
	 * @param path
	 * @return
	 */
	 public static List<FileInfo> getFile(String path){
		 List<FileInfo> result = new ArrayList<FileInfo>();
		 try {
		 	File files = new File(path);
	        File[] array = files.listFiles();
	        for (File file:array) {
				if(file.isFile()) {
					FileInfo info = new FileInfo();
					info.setFileName(file.getName());
					info.setFilePath(file.getPath());
					info.setLastModifiedTime(new Date(file.lastModified()));
					info.setFileLength(buildFileSize(file.length()));
					result.add(info);
				}
			}
		} catch (Exception e) {
			
		}
	    return result;
	 }
	 
	 /**
	  * 组装文件大小
	  * @param fileLength
	  * @return
	  */
	 private static String buildFileSize(Long fileLength) {
		 if(fileLength>0) {
			 DecimalFormat df = new DecimalFormat( "0.## "); 
			 Float si=fileLength/1024f/1024f;
			 return df.format(si)+"M";
		 }
		 return "0M";
	 }

}
