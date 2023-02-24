package mfg.service;

import java.util.Random;
import java.util.Arrays;

import mfg.dto.Citi;
import mfg.dto.Mafi;

public class MfService {
	//

	// 멤버 배열 추가
	public Citi[] member = new Citi[10];

	public MfService() {
		member[0] = new Citi("asd");
		member[1] = new Citi("qwe");
		member[2] = new Citi("zxc");
		member[3] = new Citi("123");
		member[0].setShot(1);
	}

	// 배열에서 멤버 특정하기

	// 멤버 추가
	public boolean addMem(String name) {
		for (int i = 0; i < member.length; i++) {

			if (member[i] == null) {

				member[i] = new Citi(name);
				return true;
			}

		}
		return false;
	}

	// 샷
	public boolean Shot(String mem, String target) {
		for(Citi m : member) {
			if(m.getName().equals(null)) {
				break;
			}
			if(m.getName().equals(target)) {
				if(m.getLife()==0) {
					System.out.println("대상의 체력이 이미 0입니다.");
					break;
				}
				if(m.getProtect()==true) {
					System.out.println("대상은 보호를 받고 있습니다.");
				}
			}
			if(m.getName().equals(mem)) {
				if(m.getShot()==0) {
					System.out.println(m.getName() + "은 공격기회가 없습니다.");
					break;
				}
				if (m.getShot()==1) {
					
				}
					
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
