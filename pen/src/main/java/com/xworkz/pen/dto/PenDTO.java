package com.xworkz.pen.dto;

public class PenDTO {

	private String penName;
	private String penColor;
	private int penPrice;

	public PenDTO() {

	}

	public PenDTO(String penName, String penColor, int penPrice) {
		super();
		this.penName = penName;
		this.penColor = penColor;
		this.penPrice = penPrice;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public String getPenColor() {
		return penColor;
	}

	public void setPenColor(String penColor) {
		this.penColor = penColor;
	}

	public int getPenPrice() {
		return penPrice;
	}

	public void setPenPrice(int penPrice) {
		this.penPrice = penPrice;
	}

	@Override
	public String toString() {
		return "PenDTO [penName=" + penName + ", penColor=" + penColor + ", penPrice=" + penPrice + "]";
	}

}
