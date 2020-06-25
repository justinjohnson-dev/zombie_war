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
	
	public static Weapon generateWeapon() {
		Weapon weapon = null;
    	// get a random number that will dictate which weapon is given to the survivor
        int randomWeapon = getRandom(0,6);
        switch(randomWeapon) {
			case 0:
				return new Weapon("Shotgun", 65, 20);
			case 1:
				return new Weapon("Submachine Gun", 25, 40);
			case 2:
				return new Weapon("Assault Rifle", 50, 50);
			case 3:
				return new Weapon("Pistol", 20, 40);
			case 4:
				return new Weapon("Axe", 30, 60);
			case 5:
				return new Weapon("Crowbar", 20, 60);
			case 6:
				return new Weapon("Frying Pan", 25, 50);
        }

        return null;
	}
	
	// generate a random number within a set range
    public static int getRandom(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }
}