package com.javasoft.libs.models;

public class VO {
	private int id;
	private String place;
	private String gender;
	private String train;
	private String seat;
	private String persent;
	private int discount;
	private int fee;
	
	public VO(int id,String place, String gender, String train, String seat, String persent,int discount, int fee) {
		this.id=id;
		this.place = place;
		this.gender = gender;
		this.train = train;
		this.seat = seat;
		this.persent = persent;
		this.discount=discount;
		this.fee = fee;
	}
	public VO(String place, String gender, String train, String seat, String persent,int discount, int fee) {
		
		this.place = place;
		this.gender = gender;
		this.train = train;
		this.seat = seat;
		this.persent = persent;
		this.discount=discount;
		this.fee = fee;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getId() {
		return id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getGender() {
		return gender;
	}
	public int getDiscount() {
		return discount;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTrain() {
		return train;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setTrain(String train) {
		this.train = train;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getPersent() {
		return persent;
	}
	public void setPersent(String persent) {
		this.persent = persent;
	}
	public int getPee() {
		return fee;
	}
	public void setPee(int fee) {
		this.fee = fee;
	}
	
	
}
