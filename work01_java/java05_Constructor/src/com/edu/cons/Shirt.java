package com.edu.cons;

public class Shirt {
	public String brand;
	public boolean longSleeved;
	public char color;
	
	// 값 주입...여기서만 활용되는 변수 -> 지역변수, 로컬변수
	public void setShirt(String brand, boolean longSleeved, char color) {
		this.brand = brand;
		this.longSleeved = longSleeved;
		this.color = color;
	}
	
	//값 반환
	public String getShirt() {
		return brand + ", " + longSleeved + ", " + color;
	}
}
