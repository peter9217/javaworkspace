package edu.kh.game.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Player implements Serializable{
   
   private String name;
   private int hp;
   private int defense;
   private int power;
   private int stamina;
   private int floor;
   
   
   public Player() {
      super();
   }

   public Player(String name, int hp, int defense, int power, int stamina, int floor) {
      super();
      this.name = name;
      this.hp = hp;
      this.defense = defense;
      this.power = power;
      this.stamina = stamina;
      this.floor = floor;
   }
   
   

   public Player(String[] item) {
      super();
   }

   public String getName() {
      return name;
   }


   public void setName(String name) {
      this.name = name;
   }


   public int getHp() {
      return hp;
   }


   public void setHp(int hp) {
      this.hp = hp;
   }


   public int getDefense() {
      return defense;
   }


   public void setDefense(int defense) {
      this.defense = defense;
   }


   public int getPower() {
      return power;
   }


   public void setPower(int power) {
      this.power = power;
   }


   public int getStamina() {
      return stamina;
   }


   public void setStamina(int stamina) {
      this.stamina = stamina;
   }


   public int getFloor() {
      return floor;
   }
   
   public void setFloor(int floor) {
	   this.floor = floor;
   }

@Override
public int hashCode() {
	return Objects.hash(defense, floor, hp, name, power, stamina);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Player other = (Player) obj;
	return defense == other.defense && floor == other.floor && hp == other.hp && Objects.equals(name, other.name)
			&& power == other.power && stamina == other.stamina;
}


   
   


  


}