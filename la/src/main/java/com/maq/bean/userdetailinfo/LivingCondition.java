package com.maq.bean.userdetailinfo;

import org.springframework.data.annotation.Id;

/**
 * 
 * --^.^-- @author 王兵兵（QQ--1435489083） @date 2016年5月31日 下午9:49:21 --^.^--
 * --------------------------------------------------------------------------
 * Description:生活状态
 * --------------------------------------------------------------------------
 */
public class LivingCondition {
	@Id
	private String id;// 用户id

	private String smoking;
	private String drinking;
	private String cooking;
	private String housework;
	// 存款·
	private String deposit;
	private String houseAndCar;
	// 主要消费，
	private String mainConsumption;
	// 自我评价
	private String selfDescription;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getDrinking() {
		return drinking;
	}

	public void setDrinking(String drinking) {
		this.drinking = drinking;
	}

	public String getCooking() {
		return cooking;
	}

	public void setCooking(String cooking) {
		this.cooking = cooking;
	}

	public String gethousework() {
		return housework;
	}

	public void sethousework(String housework) {
		this.housework = housework;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getHouseAndCar() {
		return houseAndCar;
	}

	public void setHouseAndCar(String houseAndCar) {
		this.houseAndCar = houseAndCar;
	}

	public String getMainConsumption() {
		return mainConsumption;
	}

	public void setMainConsumption(String mainConsumption) {
		this.mainConsumption = mainConsumption;
	}

	public String getSelfDescription() {
		return selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

}
