package com.maq.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maq.base.utils.dto.ResponseMessage;
import com.maq.bean.userdetailinfo.LivingCondition;
import com.maq.bean.userdetailinfo.LoveAttitude;
import com.maq.bean.userdetailinfo.MatingPreference;
import com.maq.bean.userdetailinfo.UserInterests;
import com.maq.bean.userdetailinfo.WorkingCondition;
import com.maq.service.UserDetailInfoSvc;

@Controller
@RequestMapping("detailInfos")
public class UserDetailInfoController {
	@Autowired
	private UserDetailInfoSvc udiSvc;

	@RequestMapping("editDetailInfo")
	public String editDetailInfo() {

		// 编辑详细信息
		return "userInfo/editDetailInfo";
	}

	/*
	 * 编辑兴趣页面
	 */
	@RequestMapping("editInterests")
	public String interests() {
		return "userInfo/detailInfos/editInterests";
	}

	/*
	 * 编辑兴趣
	 */
	@ResponseBody
	@RequestMapping(value = "doEditInterests", method = RequestMethod.POST)
	public ResponseMessage doEditInterests(@RequestBody UserInterests userInterests, HttpSession session) {
		return udiSvc.doEditInterests(userInterests, session);
	}

	/*
	 * 编辑兴趣
	 */
	@ResponseBody
	@RequestMapping(value = "doEditLivingCondition", method = RequestMethod.POST)
	public ResponseMessage doEditLivingCondition(@RequestBody LivingCondition livingCondition, HttpSession session) {
		return udiSvc.doEditLivingCondition(livingCondition, session);
	}

	/*
	 * 编辑兴趣
	 */
	@ResponseBody
	@RequestMapping(value = "doEditLoveAttitude", method = RequestMethod.POST)
	public ResponseMessage doEditLoveAttitude(@RequestBody LoveAttitude loveAttitude, HttpSession session) {
		System.out.println("***");
		return udiSvc.doEditLoveAttitude(loveAttitude, session);
	}

	/*
	 * 编辑兴趣
	 */
	@ResponseBody
	@RequestMapping(value = "doEditMatingPreference", method = RequestMethod.POST)
	public ResponseMessage doEditMatingPreference(@RequestBody MatingPreference matingPreference, HttpSession session) {
		return udiSvc.doEditMatingPreference(matingPreference, session);
	}

	/*
	 * 编辑兴趣
	 */
	@ResponseBody
	@RequestMapping(value = "doEditWorkingCondition", method = RequestMethod.POST)
	public ResponseMessage doEditWorkingCondition(@RequestBody WorkingCondition workingCondition, HttpSession session) {
		return udiSvc.doEditWorkingCondition(workingCondition, session);
	}

	/*
	 * 编辑照片页面
	 */
	@RequestMapping("editPhotos")
	public String photoList() {
		System.out.println("#########");
		return "userInfo/detailInfos/editPhotos";
	}

	@RequestMapping("editLivingCondition")
	public String livingCondition() {
		return "userInfo/detailInfos/editLivingCondition";
	}

	@RequestMapping("editWorkingCondition")
	public String workingCondition() {
		return "userInfo/detailInfos/editWorkingCondition";
	}

	@RequestMapping("editLoveAttitude")
	public String editLoveAttitude() {
		return "userInfo/detailInfos/editLoveAttitude";
	}

	@RequestMapping("editMatingPreference")
	public String editMatingPreference() {
		return "userInfo/detailInfos/editMatingPreference";
	}

}
