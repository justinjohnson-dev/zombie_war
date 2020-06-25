public class Child extends Character {
	
	Weapon weapon;
	static int i = 0;

    public Child() {
        super(20, 2, "survivor", "Child " + i++);
        weapon = Weapon.generateWeapon();
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}
