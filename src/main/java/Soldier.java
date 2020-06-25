public class Soldier extends Character {
	
	Weapon weapon;
	static int i = 0;

    public Soldier() {
        super(100, 10, "survivor", "Soldier " + i++);
        weapon = Weapon.generateWeapon();
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}
