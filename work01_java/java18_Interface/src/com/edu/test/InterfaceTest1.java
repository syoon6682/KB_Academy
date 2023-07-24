package com.edu.test;

// 추상메소드(구현부가 없고 선언부만으로 이뤄진 메소드)들의 집합 
interface Flyer{
	void fly(); // 무조건 앞에 public abstract가 붙는다.
	void land();
	void takeOff();
}

class Bird implements Flyer {

	@Override
	public void fly() {
		System.out.println("Bird fly...");
		
	}

	@Override
	public void land() {
		System.out.println("Bird land...");
		
		
	}

	@Override
	public void takeOff() {
		System.out.println("Bird take off...");
		
	}
	
	public String layEggs() {
		return "알을 까다";
	}
	
}

class SuperMan implements Flyer {

	@Override
	public void fly() {
		System.out.println("Superman fly...");
		
	}

	@Override
	public void land() {
		System.out.println("Superman land...");
		
	}

	@Override
	public void takeOff() {
		System.out.println("Superman take off...");
		
	}
	
	public String stopBullet() {
		return "망토로 총알을 막는다";
	}
	
}

public class InterfaceTest1 {

	public static void main(String[] args) {
		
		// 추상메서드가 있는 걸로는 객체를 생성할 수 없다.
		// Flyer f= new Flyer();
		
		// 인터페이스는 객체 생성시 타입으로는 작용함
		// -> Polymorphism
		Flyer b = new Bird();
		Flyer s = new SuperMan();
		
		b.fly();
		s.fly();
		((Bird) b).layEggs();

	}

}
