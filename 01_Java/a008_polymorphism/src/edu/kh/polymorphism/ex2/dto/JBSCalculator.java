package edu.kh.polymorphism.ex2.dto;

// 각자 계산기 구현하기
public class JBSCalculator extends Person implements Calculator, KH{

	@Override
	public int plus(int a, int b) {
		
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		
		return a-b;
	}

	@Override
	public int multiple(int a, int b) {
		
		return a*b;
	}

	@Override
	public int divide(int a, int b) {
		
		return a/b;
	}
	
	@Override
	public double divide2(int a, int b) {
		
		return a/(double)b;
	}

	@Override
	public double areaOfCircle(double r) {
		
		return r*r*PI;
	}

	@Override
	public int square(int a, int x) {
		
		return (int)Math.pow(a, x); 
	}

	@Override
	public void lesson() {
		// TODO Auto-generated method stub
		
	}
	

}
