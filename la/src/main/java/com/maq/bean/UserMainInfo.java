package com.maq.bean;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * 
 * --^.^-- @author 王兵兵（QQ--1435489083） @date 2016年5月13日 下午4:12:49 --^.^--
 * --------------------------------------------------------------------------
 * Description:用户信息
 * --------------------------------------------------------------------------
 */
public class UserMainInfo {
	@Id
	private String id;// 用户id
	/** 昵称 */
	private String nickName;
	private String headPic;// 头像图片名、包含id和时间 作为展示用
	private List<String> headPicList;// 头像图片列表
	/** 创建时间 */
	private Date createDate;
	private Date birthDay;// 生日
	/** 最后一次登录时间 */
	private Date lastLoginDate;
	private int gender;// 性别
	private int height;// 身高
	private int salary;// 月薪
	private int marriage;// 婚姻状态，0/1/2 未婚/离异/丧偶

	private String constellation;// 星座
	private String declaration;// 爱情宣言

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public int getMarriage() {
		return marriage;
	}

	public void setMarriage(int marriage) {
		this.marriage = marriage;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public List<String> getHeadPicList() {
		return headPicList;
	}

	public void setHeadPicList(List<String> headPicList) {
		this.headPicList = headPicList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMainInfo other = (UserMainInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserMainInfo [id=" + id + ", nickName=" + nickName + ", headPic=" + headPic + ", headPicList="
				+ headPicList + ", createDate=" + createDate + ", birthDay=" + birthDay + ", lastLoginDate="
				+ lastLoginDate + ", gender=" + gender + ", height=" + height + ", salary=" + salary + ", marriage="
				+ marriage + ", constellation=" + constellation + ", declaration=" + declaration + "]";
	}

}
