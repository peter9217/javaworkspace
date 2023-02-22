package edu.kh.polymorphism.ex1.service;

import edu.kh.polymorphism.ex1.dto.Car;
import edu.kh.polymorphism.ex1.dto.LightCar;
import edu.kh.polymorphism.ex1.dto.Truck;

public class CarService {
	// 다형성 : 객체가 다양한 형태를 지님
	// - 상속을 이용한 기술로 부모 타입의 참조 변수 하나로 여러 타입의 자식
	//   객체를 참조할 수 있다.
	
	public void ex1() {
		
		// 부모 참조 변수 = 부모 객체
		Car c1 = new Car();
		
		
		// 업캐스팅 : 자식 객체 -> 부모객체로 변함
		// 자식 객체 내부에 있는 부모 객체를 참조하도록 변함
		//부모 참조 변수 = 자식 객체
		Car c2 = new Truck();
		
		// 부모 참조 변수 = 자식 객체
		Car c3 = new LightCar();
		
		// Truck 객체가 car로 부터 상속 받은 메서드 사용
		c2.setWheel(10);
		c2.setSeat(3);
		c2.setFuel("경유");
		
		// c2의 자료형이 Car
		// -> Truck 객체를 참조하더라도 Car 부분만 볼 수 있음.
		//c2.setWeight(2.5); // c2로는 Car를 제외한 Truck에 접근 불가능하여 에러
		
	}
	

}
