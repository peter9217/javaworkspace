package edu.kh.game.service;

import edu.kh.game.dto.Floor;
import edu.kh.game.dto.Item;
import edu.kh.game.dto.Player;
import edu.kh.game.dto.Zombie;
import edu.kh.game.view.GameView;

public class Service {
	
	Floor floor = new Floor("1", 1);
	Item dsf = new Item("asd", 1, 80);
	Player asd = new Player("ㅁㄴㅇ", 1, 1, 1, 1, 7, "ㅁ1","ㅁ2","ㅁ3","ㅁ4",dsf);
	Zombie zom = new Zombie("qkr", 2, 1);
	public void died() {
		
		if(asd.getHp() == 0) {
			System.out.println("당신은 죽었습니다.");
		}
	}
	
	public int random() {
		int random = (int)(Math.random()*100)+1;
		
		return random;
	}
	
	public void attack() {
		
		if (random()+(asd.getItem5().getEvasion())>50) {
			zom.setHp(0);
			System.out.println("재빠르게 회피하고 좀비를 처리했습니다.");
			if(asd.getItem5()!=null) {
				asd.getItem5().setEvasion(asd.getItem5().getEvasion()-1);
				broken(asd.getItem5());
			}
			
		}else {
			System.out.println("공격을 당했지만 좀비를 처리했습니다.");
			asd.setHp(asd.getHp()-zom.getPower());		
		}
		died();
	}
	
	public void run() {
		if(asd.getStamina()==3 ) {
			System.out.println("도망에 성공하였습니다.");
			asd.setStamina(2);
		} else if(asd.getStamina()==2) {
			asd.setStamina(1);
			if(random()>25) {
				System.out.println("도망에 성공하였습니다.");
				
			} else{
				System.out.println("도망에 실패하였습니다.");
				
				asd.setHp(asd.getHp()-1);
				asd.setStamina(asd.getStamina()-1);
			}
			
		} else if (asd.getStamina()==1){
			asd.setStamina(0);
			if(random()>50) {
				System.out.println("도망에 성공하였습니다.");
				
			} else{
				System.out.println("도망에 실패하였습니다.");
				
				asd.setHp(asd.getHp()-1);
				asd.setStamina(asd.getStamina()-1);
			}
		}
		else {
			System.out.println("스태미너가 부족하여 도망칠 수 없습니다.");
		}
	}
	
	
	public void broken(Item i) {
		i.setStatus(i.getStatus()-1);
		if(i.getStatus()==0) {
			System.out.printf("방어구가 깨졌습니다.");
			asd.setItem5(null);
		}
	}
	
	public void eat(int i) {
		
	}
	
}
