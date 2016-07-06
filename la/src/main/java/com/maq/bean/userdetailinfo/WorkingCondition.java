package com.maq.bean.userdetailinfo;

import org.springframework.data.annotation.Id;

/**
 * 
 * --^.^-- @author 王兵兵（QQ--1435489083） @date 2016年5月31日 下午9:49:42 --^.^--
 * --------------------------------------------------------------------------
 * Description:工作状态
 * --------------------------------------------------------------------------
 */

public class WorkingCondition {
	@Id
	private String id;// 用户id
	private String jobKind;// 工作类别 医生/教师。。。
	private String companyKind;// 公司类别 国有/自营/私有/事业单位。。。
	private String busyDegree;// 繁忙程度 有双休/清闲/假期少/经常出差。。。
	private String selfDescription;// 用户自己对工作的总结性描述归纳

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobKind() {
		return jobKind;
	}

	public void setJobKind(String jobKind) {
		this.jobKind = jobKind;
	}

	public String getCompanyKind() {
		return companyKind;
	}

	public void setCompanyKind(String companyKind) {
		this.companyKind = companyKind;
	}

	public String getBusyDegree() {
		return busyDegree;
	}

	public void setBusyDegree(String busyDegree) {
		this.busyDegree = busyDegree;
	}

	public String getSelfDescription() {
		return selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

}
