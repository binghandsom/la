package com.maq.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.maq.base.utils.DateUtils;
import com.maq.base.utils.ImageUtil;
import com.maq.base.utils.PropertiesUtil;
import com.maq.base.utils.dto.ResponseMessage;
import com.maq.bean.Account;
import com.maq.bean.UserMainInfo;
import com.maq.service.UserMainInfoSvc;

/**
 * 
 * --^.^-- @author 王兵兵（QQ--1435489083） @date 2016年5月13日 下午3:49:06 --^.^--
 * --------------------------------------------------------------------------
 * Description:用户信息视图控制层
 * --------------------------------------------------------------------------
 */
@Controller
@RequestMapping("userMainInfo")
public class UserMainInfoController {

	@Autowired
	private UserMainInfoSvc umiSvc;

	@RequestMapping("editMainInfo")
	public String editMainInfo() {
		// 编辑基本信息
		return "userInfo/editMainInfo";
	}

	@ResponseBody
	@RequestMapping(value = "checkNickName", method = RequestMethod.POST)
	public ResponseMessage checkNickName(String nickName, HttpSession session) {
		ResponseMessage rm = umiSvc.checkNickName(nickName, session);
		return rm;
	}

	@ResponseBody
	@RequestMapping("loadPhoto")
	public void loadPhoto(String picName, HttpServletResponse response, HttpServletRequest request, String picType,
			HttpSession session) throws IOException {
		String fileAbsolutePath = "";
		if (ImageUtil.TEMP_PICTURE.equals(picType)) {
			fileAbsolutePath = PropertiesUtil.getPropertyValue("config/properties/common.properties", "fileSystemRoot")
					+ "/picture/userHeadPictures_temp/" + picName;
			System.out.println(fileAbsolutePath);
		} else if (ImageUtil.TEMP_PICTURE_LIST.equals(picType)) {
			/**
			 * 真实环境中session是有account的
			 */
			fileAbsolutePath = PropertiesUtil.getPropertyValue("config/properties/common.properties", "fileSystemRoot")
					+ "/picture/userHeadPicturesFolder_temp/" + ((Account) session.getAttribute("account")).getId()
					+ "/" + picName;
		} else if (ImageUtil.HEAD_PICTURE.equals(picType)) {
			fileAbsolutePath = PropertiesUtil.getPropertyValue("config/properties/common.properties", "fileSystemRoot")
					+ "/picture/userHeadPictures" + "/" + picName;
		}
		FileInputStream hFile = new FileInputStream(fileAbsolutePath);
		ImageUtil.photoOutStreamWriting(response, hFile);
	}

	@ResponseBody
	@RequestMapping(value = "uploadHeadPics", method = RequestMethod.POST)
	public ResponseMessage uploadHeadPics(HttpSession session) {
		ResponseMessage rm = umiSvc.uploadHeadPics(session);

		return rm;

	}

	@ResponseBody
	@RequestMapping(value = "isPictureFiles", method = RequestMethod.POST)
	public ResponseMessage isPictureFiles(@RequestParam(value = "file", required = true) MultipartFile file,
			String isNewGroup, HttpSession session) {

		ResponseMessage rm = new ResponseMessage();
		Map<String, String> failReason = new HashMap<String, String>();
		// Account account = new Account();
		// account.setId("xxx");
		// session.setAttribute("account", account);
		String path = PropertiesUtil.getPropertyValue("config/properties/common.properties", "fileSystemRoot")
				+ "/picture/userHeadPicturesFolder_temp/" + ((Account) session.getAttribute("account")).getId();
		/**
		 * 真实环境中session是有account的
		 */
		String fileName = ((Account) session.getAttribute("account")).getId() + RandomStringUtils.random(5, true, false)
				+ System.currentTimeMillis() + ".jpg";
		if (isNewGroup != null && session.getAttribute("headPicFolderPath") != null) {
			String preFolder = session.getAttribute("headPicFolderPath").toString();
			// 当用户第二次之后点击选择图像时，删除上一次的文件夹。防止服务器垃圾文件产生
			File preFolderDir = new File(preFolder); // 输入要删除的文件夹
			try {
				if (!preFolderDir.exists()) {
					preFolderDir.mkdirs();
				}
				FileUtils.cleanDirectory(preFolderDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		session.setAttribute("headPicFolderPath", path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!ImageUtil.isImageFile(targetFile)) {
			rm.setSuccess(false);
			// 删除不满足条件的文件、
			FileUtils.deleteQuietly(targetFile);
			failReason.put("reason", "不是图片文件");
			rm.setMessage(failReason);
		} else if (targetFile.length() > 8 * 1024 * 1024) {
			rm.setSuccess(false);
			// 删除不满足条件的文件
			FileUtils.deleteQuietly(targetFile);
			failReason.put("reason", "图片文件大小不可超过8Mb，请检查");
			rm.setMessage(failReason);
		} else {
			Map<String, String> okMap = new HashMap<String, String>();
			okMap.put("picName", fileName);
			rm.setMessage(okMap);
			rm.setSuccess(true);
		}
		System.out.println(rm.toString());
		return rm;
	}

	@ResponseBody
	@RequestMapping(value = "isPictureFile", method = RequestMethod.POST)
	public ResponseMessage isPictureFile(@RequestParam(value = "headPic", required = true) MultipartFile headPic,
			HttpSession session) {
		ResponseMessage rm = new ResponseMessage();
		Map<String, String> failReason = new HashMap<String, String>();
		String path = PropertiesUtil.getPropertyValue("config/properties/common.properties", "fileSystemRoot")
				+ "/picture/userHeadPictures_temp";

		// Account account = new Account();
		// account.setId("xxx");
		// session.setAttribute("account", account);
		/**
		 * 真实环境中session是有account的
		 */
		String fileName = ((Account) session.getAttribute("account")).getId() + RandomStringUtils.random(5, true, false)
				+ System.currentTimeMillis() + ".jpg";
		if (session.getAttribute("headPicPath") != null) {
			String preFile = session.getAttribute("headPicPath").toString();
			// 当用户第二次之后点击选择图像时，删除上一次的文件。防止服务器垃圾文件产生
			File f = new File(preFile); // 输入要删除的文件位置
			if (f.exists()) {
				f.delete();
			}
		}
		session.setAttribute("headPicPath", path + "/" + fileName);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			headPic.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!ImageUtil.isImageFile(targetFile)) {
			rm.setSuccess(false);
			failReason.put("reason", "不是图片文件");
			rm.setMessage(failReason);
		} else if (targetFile.length() > 8 * 1024 * 1024) {
			rm.setSuccess(false);
			failReason.put("reason", "图片文件大小不可超过8Mb，请检查");
			rm.setMessage(failReason);
		} else {
			Map<String, String> okMap = new HashMap<String, String>();
			okMap.put("picName", fileName);
			rm.setMessage(okMap);
			rm.setSuccess(true);
		}
		System.out.println(rm.toString());
		return rm;
	}

	@RequestMapping(value = "doEditMainInfo", method = RequestMethod.POST)
	public String doEditMainInfo(HttpSession session, ModelMap modelM, String birthDay, String constellation,
			String nickName, int gender, int marriage, String declaration, int height, int salary, String goWhere) {
		String headPicPath = session.getAttribute("headPicPath").toString();
		File headPic = new File(headPicPath);
		Date _birthDay = DateUtils.strToDate(birthDay, DateUtils.CH_DATE_FORMATE_STR);

		String id = "";
		try {
			id = ((Account) session.getAttribute("account")).getId();
		} catch (NullPointerException e) {
			// 返回登陆页
			return "userAccount/regAndLogin";
		}
		UserMainInfo baseInfo = umiSvc.getMainInfo(id);
		if (baseInfo == null) {
			baseInfo = new UserMainInfo();
			baseInfo.setId(id);
		}
		baseInfo.setNickName(nickName);
		baseInfo.setHeight(height);
		baseInfo.setBirthDay(_birthDay);
		baseInfo.setConstellation(constellation);
		baseInfo.setCreateDate(new Date());
		baseInfo.setDeclaration(declaration);
		baseInfo.setGender(gender);
		baseInfo.setSalary(salary);

		System.out.println(baseInfo);
		String path = PropertiesUtil.getPropertyValue("config/properties/common.properties", "fileSystemRoot")
				+ "/picture/userHeadPictures";
		// Account account = new Account();
		// account.setId("xxx");
		// session.setAttribute("account", account);
		/**
		 * 真实环境中session是有account的
		 */
		String fileName = id + RandomStringUtils.random(5, true, false) + System.currentTimeMillis() + ".jpg";
		System.out.println(fileName);
		File targetFile = new File(path);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存将temp文件移动到正规文件中
		try {
			// *在list列表对应的文件夹中也添加一份同样的文件，便于展览使用
			String pathForPicListFolder = PropertiesUtil.getPropertyValue("config/properties/common.properties",
					"fileSystemRoot") + "/picture/userHeadPicturesFolder/"
					+ ((Account) session.getAttribute("account")).getId();
			FileUtils.copyFile(headPic, new File(pathForPicListFolder + "/" + fileName));
			headPic.renameTo(new File(targetFile, fileName));

		} catch (Exception e) {
			e.printStackTrace();
		}
		baseInfo.setHeadPic(fileName);
		//
		UserMainInfo mainInfo = umiSvc.getMainInfo(id);
		List<String> headPicList = null;
		if (mainInfo == null) {
			// 等于null表示第一次注册进入编辑主要信息页
			headPicList = new ArrayList<String>();
		} else {
			// 表示登陆后，编辑已有信息，修改照片
			headPicList = mainInfo.getHeadPicList();
		}
		headPicList.add(fileName);
		baseInfo.setHeadPicList(headPicList);
		umiSvc.save(baseInfo);
		session.setAttribute("mainInfo", baseInfo);
		if ("editDetailInfo".equals(goWhere)) {
			return "userInfo/editDetailInfo";
		} else if ("lookingLover".equals(goWhere)) {
			return "common/index";
		}
		// 未知情形，异常
		return "userAccount/regAndLogin";
	}

	@RequestMapping(value = "selfInfo", method = RequestMethod.GET)
	public String selfInfo(HttpSession session) {
		// 判断session是否有account==null
		// 如果为null则不予观看，跳转至登录页

		// 查找对应的用户的信息给予显示
		// 在service中执行查找逻辑
		return "userInfo/selfInfo";
	}

}
