public class Weapon {
	
	protected String type;
	protected int damage;
	protected int accuracy;
	
	public Weapon(String type, int damage, int accuracy) {
		this.type = type;
		this.damage = damage;
		this.accuracy = accuracy;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
}