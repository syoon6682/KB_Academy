package com.edu.test;


class Car {
	int serialNumber;
	static int counter;
	
	Car(){
		counter++;
		serialNumber = counter;
	}
}

public class StaticExamTest2 {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("===== field =====");
		System.out.println(car1.serialNumber);
		System.out.println(car2.serialNumber);
		System.out.println(car3.serialNumber);
		
		System.out.println("\n===== static V =====");
		System.out.println(car1.counter);
		System.out.println(car2.counter);
		System.out.println(car3.counter);
		System.out.println(Car.counter);
	}
}
