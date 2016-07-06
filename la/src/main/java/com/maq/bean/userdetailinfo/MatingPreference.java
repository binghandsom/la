package com.maq.bean.userdetailinfo;

import javax.persistence.Id;

/**
 * 
 * --^.^-- @author 王兵兵（QQ--1435489083） @date 2016年6月2日 下午6:44:18 --^.^--
 * --------------------------------------------------------------------------
 * Description:择偶条件
 * --------------------------------------------------------------------------
 */
public class MatingPreference {
	@Id
	private String id;
	private int gender;// 性别
	private int minAge;// 最小年龄
	private int maxAge;// 最大年龄
	private String workingProvince;// 工作省份
	private String workingCity;// 工作城市
	private String homeProvince;// 家乡省份
	private String homeCity;// 家乡城市
	private int marriage;// 婚姻状态；
	private String eduLevel;// 受教育水平
	private Long minSalary;// 最低月收入
	private Long maxSalary;// 最高月收入
	private String haveChild;// 是否有孩子
	private int minHeight;// 最小身高
	private int maxHeight;// 最大身高
	private int minWeight;// 最小体重
	private int maxWeight;// 最大体重

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public String getWorkingProvince() {
		return workingProvince;
	}

	public void setWorkingProvince(String workingProvince) {
		this.workingProvince = workingProvince;
	}

	public String getWorkingCity() {
		return workingCity;
	}

	public void setWorkingCity(String workingCity) {
		this.workingCity = workingCity;
	}

	public String getHomeProvince() {
		return homeProvince;
	}

	public void setHomeProvince(String homeProvince) {
		this.homeProvince = homeProvince;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public int getMarriage() {
		return marriage;
	}

	public void setMarriage(int marriage) {
		this.marriage = marriage;
	}

	public String getEduLevel() {
		return eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	public Long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public Long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getHaveChild() {
		return haveChild;
	}

	public void setHaveChild(String haveChild) {
		this.haveChild = haveChild;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	public int getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(int minWeight) {
		this.minWeight = minWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

}
