package kh.dto;

public class Kit extends Item{
	private Kit() {
		super();
	}
	
	private Kit(String name, int get, int heal) {
		super.setName(name);
		super.setGet(get);
		super.setHeal(heal);
	}
	
	
	
}
