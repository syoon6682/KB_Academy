package spring.service.dice.Impl;

import spring.service.dice.DIce;

public class DiceAImpl implements DIce{
	
	private int value;
	
	///Constructor
	public DiceAImpl() {
		System.out.println("::"+getClass().getName()+" 생성자....");
	}
	
	public DiceAImpl(int value) {
		this.value=value;
		System.out.println("::"+getClass().getName()+" 명시적생성자....");
	}

	//Method (getter/setter)
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public void selectedNumber() {
		// TODO Auto-generated method stub
		
	}


}
