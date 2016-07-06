package com.maq.base.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	public static String file_path;

	// 文件上传
	public static String uploadFile(MultipartFile file,
			HttpServletRequest request) throws IOException {
		file_path = request.getSession().getServletContext()
				.getInitParameter("photoFilePath");
		String fileName = file.getOriginalFilename();
		File tempFile = new File(file_path,
				new Date().getTime() + String.valueOf(fileName));
		if (!tempFile.getParentFile().exists()) {
			tempFile.getParentFile().mkdir();
		}
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
		file.transferTo(tempFile);
		System.out.println("ab:" + tempFile.getAbsolutePath());
		return tempFile.getAbsolutePath();
	}

	public static File getFile(String fileAbsolutePath) {
		return new File(fileAbsolutePath);
	}

	// 上传用户头像
	public static String uploadUserHeadPhoto(MultipartFile file,
			HttpServletRequest request, String UserId) throws IOException {
		String userHeadPhotoPath = request.getSession().getServletContext()
				.getInitParameter("UserHeadPhotoTempPath");
		String fileName = file.getOriginalFilename();
		int c = fileName.lastIndexOf(".");
		String fileNameSuffix = fileName.substring(c, fileName.length());
		File tempFile = new File(userHeadPhotoPath, UserId + fileNameSuffix);
		if (!tempFile.getParentFile().exists()) {
			tempFile.getParentFile().mkdir();
		}
		if (!tempFile.exists()) {
			tempFile.createNewFile();
		}
		file.transferTo(tempFile);
		System.out.println("ab:" + tempFile.getAbsolutePath());
		return tempFile.getAbsolutePath().replace("\\", "/");
	}
}