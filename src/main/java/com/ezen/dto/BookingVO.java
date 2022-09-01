package com.ezen.dto;

import java.util.Date;

public class BookingVO {
	private int resv_seq;
	private String name;
	private String phone;
	private Date check_in;
	private Date check_out;
	private String room_no;
	private int adult;
	private int children;
	private String reserve_yn;
	private int price;
	private String breakfast_yn;
	public int getResv_seq() {
		return resv_seq;
	}
	public void setResv_seq(int resv_seq) {
		this.resv_seq = resv_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCheck_in() {
		return check_in;
	}
	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}
	public Date getCheck_out() {
		return check_out;
	}
	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public String getReserve_yn() {
		return reserve_yn;
	}
	public void setReserve_yn(String reserve_yn) {
		this.reserve_yn = reserve_yn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBreakfast_yn() {
		return breakfast_yn;
	}
	public void setBreakfast_yn(String breakfast_yn) {
		this.breakfast_yn = breakfast_yn;
	}
	@Override
	public String toString() {
		return "bookingVO [resv_seq=" + resv_seq + ", name=" + name + ", phone=" + phone + ", check_in=" + check_in
				+ ", check_out=" + check_out + ", room_no=" + room_no + ", adult=" + adult + ", children=" + children
				+ ", reserve_yn=" + reserve_yn + ", price=" + price + ", breakfast_yn=" + breakfast_yn + "]";
	}
}
