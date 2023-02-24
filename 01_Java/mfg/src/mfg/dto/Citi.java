package mfg.dto;

public  class Citi {
	
	private String name;
	private String team;
	private int life = 1;
	private boolean protect = false;
	private int shot = 0;
	public Citi() {}
	
	public Citi(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public boolean getProtect() {
		return protect;
	}
	
	public void setProtect(boolean protect) {
		this.protect = protect;
	}

	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}
	
	
}
