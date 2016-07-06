package com.maq.bean.userdetailinfo;

import javax.persistence.Id;

public class LoveAttitude {
	@Id
	private String id;
	private String loveTimes;// 恋爱次数 ()
	private String dislikedShengxiao;// 不喜欢的生肖
	private String whenShouldMarry;// 何时应该结婚
	private String wantChild;// 是否想要孩子
	private String liveWithParents;// 婚后是否和父母同住
	private String liveWithParentsInLaw;// 是否愿意与对方父母同住
	private String whetherAcceptDistance;// 是否接受异地恋
	private String desiredEngagementWays;// 喜欢的约会方式

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoveTimes() {
		return loveTimes;
	}

	public void setLoveTimes(String loveTimes) {
		this.loveTimes = loveTimes;
	}

	public String getDislikedShengxiao() {
		return dislikedShengxiao;
	}

	public void setDislikedShengxiao(String dislikedShengxiao) {
		this.dislikedShengxiao = dislikedShengxiao;
	}

	public String getWhenShouldMarry() {
		return whenShouldMarry;
	}

	public void setWhenShouldMarry(String whenShouldMarry) {
		this.whenShouldMarry = whenShouldMarry;
	}

	public String getWantChild() {
		return wantChild;
	}

	public void setWantChild(String wantChild) {
		this.wantChild = wantChild;
	}

	public String getLiveWithParents() {
		return liveWithParents;
	}

	public void setLiveWithParents(String liveWithParents) {
		this.liveWithParents = liveWithParents;
	}

	public String getLiveWithParentsInLaw() {
		return liveWithParentsInLaw;
	}

	public void setLiveWithParentsInLaw(String liveWithParentsInLaw) {
		this.liveWithParentsInLaw = liveWithParentsInLaw;
	}

	public String getWhetherAcceptDistance() {
		return whetherAcceptDistance;
	}

	public void setWhetherAcceptDistance(String whetherAcceptDistance) {
		this.whetherAcceptDistance = whetherAcceptDistance;
	}

	public String getdesiredEngagementWays() {
		return desiredEngagementWays;
	}

	public void setdesiredEngagementWays(String desiredEngagementWays) {
		this.desiredEngagementWays = desiredEngagementWays;
	}

}
