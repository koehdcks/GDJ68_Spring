package com.iu.main.di;

public class Robot {
	private String name;
	
	private Arm arm; //로봇이 팔을 가지고 있기때문에 변수로 선언
	
	public Robot() {
		//this.arm = new Arm();
		//결합도가 높다(강하다)
	}
	public Robot(Arm arm) {
		this.arm = arm;
		//결합도가 낮다(약하다)
	}
	
	public String getName() {
		return name;
	}

	public Arm getArm() {
		return arm;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setArm(Arm arm) {
		this.arm = arm;
	}
	
}
