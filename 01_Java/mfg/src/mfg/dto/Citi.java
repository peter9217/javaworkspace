package mfg.dto;

public  class Citi {
	
	public String name;
	private int team = 0;
	public int life = 1;
	public String jp;
	public void Citi() {}
	
	public Citi(String name, String jp) {
		this.jp = jp;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public String getJp() {
		return jp;
	}

	public void setJp(String jp) {
		this.jp = jp;
	}
	
	
}
