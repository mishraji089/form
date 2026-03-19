package com.example.demo.dto;

public class DashboardDTO {
	
	private long totalUsers;
	private long maleCount;
	private long femaleCount;
	private long stateCount;
	private double averageAge;
	public long getTotalUsers() {
		return totalUsers;
	}
	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}
	public long getMaleCount() {
		return maleCount;
	}
	public void setMaleCount(long maleCount) {
		this.maleCount = maleCount;
	}
	public long getFemaleCount() {
		return femaleCount;
	}
	public void setFemaleCount(long femaleCount) {
		this.femaleCount = femaleCount;
	}
	public long getStateCount() {
		return stateCount;
	}
	public void setStateCount(long stateCount) {
		this.stateCount = stateCount;
	}
	public double getAverageAge() {
		return averageAge;
	}
	public void setAverageAge(double averageAge) {
		this.averageAge = averageAge;
	}
	
	

}
