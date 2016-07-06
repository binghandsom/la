package com.maq.base.utils;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * --^.^-- @author 王兵兵（QQ--1435489083） @date 2016年5月16日 下午2:25:53 --^.^--
 * --------------------------------------------------------------------------
 * Description:判断文件是否为图片文件
 * --------------------------------------------------------------------------
 */
public class ImageUtil {
	public static final String TEMP_PICTURE = "tempPicture";// 临时图片
	public static final String HEAD_PICTURE = "headPicture";
	public static final String TEMP_PICTURE_LIST = "tempPictureList";

	public static boolean isImageFile(File file) {
		Image image;
		try {
			image = ImageIO.read((File) file);
			if (image == null) {
				return false;
			}
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static void photoOutStreamWriting(HttpServletResponse response, FileInputStream hFile) throws IOException {
		int i = hFile.available();
		byte data[] = new byte[i];
		// 读数据
		hFile.read(data);

		// 得到向客户端输出二进制数据输出流对象
		OutputStream toClient = response.getOutputStream();
		// 输出数据
		toClient.write(data);

		toClient.flush();
		toClient.close();
		hFile.close();
	}
}
