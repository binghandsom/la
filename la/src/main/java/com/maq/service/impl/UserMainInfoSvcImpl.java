package com.maq.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.maq.base.utils.PropertiesUtil;
import com.maq.base.utils.dto.ResponseMessage;
import com.maq.bean.Account;
import com.maq.bean.UserMainInfo;
import com.maq.dao.UserMainInfoDao;
import com.maq.service.UserMainInfoSvc;

@Service
public class UserMainInfoSvcImpl implements UserMainInfoSvc {
	@Autowired
	private UserMainInfoDao mainInfoDao;
	private Query query;

	/**
	 * 检查昵称是否已经被占用
	 */
	public ResponseMessage checkNickName(String nickName, HttpSession session) {
		query = new Query(Criteria.where("nickName").is(nickName));
		ResponseMessage rm = new ResponseMessage();
		UserMainInfo objTheSame = mainInfoDao.queryOne(query);
		UserMainInfo sessionObj = (UserMainInfo) session.getAttribute("mainInfo");
		if (objTheSame != null && !sessionObj.equals(objTheSame)) {
			rm.setSuccess(false);
		} else {
			rm.setSuccess(true);
		}
		return rm;
	}

	public void save(UserMainInfo baseInfo) {
		mainInfoDao.save(baseInfo);
	}

	/**
	 * 上传照片，不是上传封面头像
	 */
	public ResponseMessage uploadHeadPics(HttpSession session) {
		ResponseMessage rm = new ResponseMessage();
		Account account = (Account) session.getAttribute("account");
		if (account != null) {
			String pathTemp = PropertiesUtil.getPropertyValue("config/properties/common.properties", "fileSystemRoot")
					+ "/picture/userHeadPicturesFolder_temp/" + ((Account) session.getAttribute("account")).getId();
			String pathReal = PropertiesUtil.getPropertyValue("config/properties/common.properties", "fileSystemRoot")
					+ "/picture/userHeadPicturesFolder/" + ((Account) session.getAttribute("account")).getId();
			File tempDir = new File(pathTemp);
			File realDir = new File(pathReal);
			if (!realDir.exists()) {
				realDir.mkdirs();
			}
			try {
				FileUtils.copyDirectory(tempDir, realDir);

				File[] files = tempDir.listFiles();
				List<String> fileNames = new ArrayList<String>();
				for (File file : files) {
					fileNames.add(file.getName());
				}
				String id = null;
				try {
					id = ((Account) session.getAttribute("account")).getId();
				} catch (NullPointerException e) {
					rm.setSuccess(false);
					// session中不存在account
					return rm;
				}

				UserMainInfo userMainInfo = (UserMainInfo) mainInfoDao.queryById(id);
				fileNames.addAll(userMainInfo.getHeadPicList());
				userMainInfo.setHeadPicList(fileNames);
				Update update = new Update();
				update.set("headPicList", fileNames);
				query = new Query();
				query.addCriteria(Criteria.where("id").is(id));
				mainInfoDao.updateFirst(query, update);
				// 清空垃圾文件
				FileUtils.cleanDirectory(tempDir);
				rm.setSuccess(true);
			} catch (IOException e) {
				rm.setSuccess(false);
			}
		}
		return rm;
	}

	public List<UserMainInfo> getMainInfosList(Account account) {
		/**
		 * 根据account信息查找对应的用户mainInfo
		 */
		String id = account.getId();
		UserMainInfo info = mainInfoDao.queryById(id);
		/**
		 * 给出匹配的推荐对象==>>性别相反，兴趣相投。。。
		 */
		query = new Query();
		query.addCriteria(Criteria.where("gender").ne(info.getGender()));
		List<UserMainInfo> infos = mainInfoDao.queryList(query);
		return infos;
	}

	@Override
	public UserMainInfo getMainInfo(String id) {
		UserMainInfo mainInfo = mainInfoDao.queryById(id);
		return mainInfo;
	}

}
