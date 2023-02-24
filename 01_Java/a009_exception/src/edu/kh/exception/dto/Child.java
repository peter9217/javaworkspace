package edu.kh.exception.dto;

import java.io.EOFException;

public class Child extends Parent {
	
	@Override
	public void test() throws EOFException{
		System.out.println("부모 test()");
	}

}
