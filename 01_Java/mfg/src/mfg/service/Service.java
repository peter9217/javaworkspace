package mfg.service;
import java.util.Random;


import mfg.dto.Citi;

public class Service {
	
	public Citi[] member = new Citi[10];
	public Service() {}
	public boolean addMember(String name, String jp) {
		for(int i=0; i<member.length; i++) {
			
			if(member[i] == null) {
				
				member[i] = new Citi(name, jp);
				return true;
			}
			
		}
		return false;
	}
	
	
	public Citi[] Random(Citi[] member) {
		 int ran = ((int) Math.random())*((int)(member.length));
		 Citi[] mem = member.clone();
		return mem;
	}
	
	public void Shot(String[] mem, int m) {
		member[m].setLife(-1);
		
		
	}
	
	
	

}
