/**
 * Copyright 2014@ fazalcode
 * All Rights Reserved to fazalcode
 */
package com.piechart.bean;

/**
 * @author Tatarao voleti
 * @date   13-Jan-2014
 *
 */
public class UserBean {
	
	public String userWork;
	public String userEat;
	public String userCommute;
	public String userWatchTv;
	public String userSleep;
	public String getUserWork() {
		return userWork;
	}
	public void setUserWork(String userWork) {
		this.userWork = userWork;
	}
	public String getUserEat() {
		return userEat;
	}
	public void setUserEat(String userEat) {
		this.userEat = userEat;
	}
	public String getUserCommute() {
		return userCommute;
	}
	public void setUserCommute(String userCommute) {
		this.userCommute = userCommute;
	}
	public String getUserWatchTv() {
		return userWatchTv;
	}
	public void setUserWatchTv(String userWatchTv) {
		this.userWatchTv = userWatchTv;
	}
	public String getUserSleep() {
		return userSleep;
	}
	public void setUserSleep(String userSleep) {
		this.userSleep = userSleep;
	}
	@Override
	public String toString() {
		return "UserBean [userWork=" + userWork + ", userEat=" + userEat
				+ ", userCommute=" + userCommute + ", userWatchTv="
				+ userWatchTv + ", userSleep=" + userSleep + "]";
	}
}
