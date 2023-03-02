package kh.dto;

public class Item {
	private String name = "";
	private int get = 0;
	private int heal = 0;
	
	public void Item() {};
	public void Item(String name, int get, int heal) {
		this.name = name;
		this.get = get;
		this.heal = heal; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGet() {
		return get;
	}
	public void setGet(int get) {
		this.get = get;
	}
	public int getHeal() {
		return heal;
	}
	public void setHeal(int heal) {
		this.heal = heal;
	}
	
}
