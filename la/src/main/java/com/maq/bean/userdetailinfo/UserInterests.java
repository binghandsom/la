package com.maq.bean.userdetailinfo;


import org.springframework.data.annotation.Id;

/**
 * 
 * --^.^-- @author 王兵兵（QQ--1435489083） @date 2016年5月30日 下午9:53:55 --^.^--
 * --------------------------------------------------------------------------
 * Description:兴趣类
 * --------------------------------------------------------------------------
 */
public class UserInterests {
	@Id
	private String id;// 用户id
	// 2.兴趣 ：1运动2活动（电影/聊天/逛街。。。）3音乐类型4美食（甜食。。。）5影视类型6宠物（狗/猫/鸡）7最想去的地方
	private String fondSports;// 喜爱的运动
	private String fondActivities;// 喜爱的活动
	private String fondPlaces;// 想去的地方
	private String fondPets;// 喜爱的宠物
	private String fondMusics;// 喜爱的音乐
	private String fondFoods;// 喜爱的食物
	private String fondFilms;// 喜爱的影视
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFondSports() {
		return fondSports;
	}
	public void setFondSports(String fondSports) {
		this.fondSports = fondSports;
	}
	public String getFondActivities() {
		return fondActivities;
	}
	public void setFondActivities(String fondActivities) {
		this.fondActivities = fondActivities;
	}
	public String getFondPlaces() {
		return fondPlaces;
	}
	public void setFondPlaces(String fondPlaces) {
		this.fondPlaces = fondPlaces;
	}
	public String getFondPets() {
		return fondPets;
	}
	public void setFondPets(String fondPets) {
		this.fondPets = fondPets;
	}
	public String getFondMusics() {
		return fondMusics;
	}
	public void setFondMusics(String fondMusics) {
		this.fondMusics = fondMusics;
	}
	public String getFondFoods() {
		return fondFoods;
	}
	public void setFondFoods(String fondFoods) {
		this.fondFoods = fondFoods;
	}
	public String getFondFilms() {
		return fondFilms;
	}
	public void setFondFilms(String fondFilms) {
		this.fondFilms = fondFilms;
	}
	@Override
	public String toString() {
		return "UserInterests [id=" + id + ", fondSports=" + fondSports + ", fondActivities=" + fondActivities
				+ ", fondPlaces=" + fondPlaces + ", fondPets=" + fondPets + ", fondMusics=" + fondMusics
				+ ", fondFoods=" + fondFoods + ", fondFilms=" + fondFilms + "]";
	}

}
