package mfg.service;
import java.util.Random;
import java.util.Arrays;


import mfg.dto.Citi;

public class MfService {
	//
	
	// 멤버 배열 추가
	public Citi[] member = new Citi[10];
	public MfService() {}
	
	// 배열에서 멤버 특정하기
	
	
	// 멤버 추가
	public boolean addMem(String name) {
		for(int i=0; i<member.length; i++) {
			
			if(member[i] == null) {
				
				member[i] = new Citi(name);
				return true;
			}
			
		}
		return false;
	}
	
	
	//샷
	public boolean Shot(String mem, String target) {
		for(Citi m : member) {
			if (m.equals(target)) {
				
				m.setLife(-1);
				
				return true;
			}
			
			
		}
		return false;
		
		
		
	}
	
	// 멤버랜덤
	public Citi[] Random(Citi[] member) {
		 int ran = ((int) Math.random())*((int)(member.length));
		 Citi[] mem = member.clone();
		return mem;
	}
	
	
	

}
