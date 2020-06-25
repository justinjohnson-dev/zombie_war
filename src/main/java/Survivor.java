public class Survivor extends Character {
	
	protected Weapon weapon;

	public Survivor(int health, int attack, String type, String name, Weapon weapon) {
		super(health, attack, type, name);
		this.weapon = generateWeapon("Shotgun", 50, 15);
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Weapon generateWeapon(String type, int damage, int accuracy) {
		Weapon weapon = new Weapon(type, damage, accuracy);
		return weapon;
	}
}