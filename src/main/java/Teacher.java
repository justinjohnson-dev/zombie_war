public class Teacher extends Character {
	
	Weapon weapon;
	static int i = 0;

    public Teacher() {
        super(50, 5, "survivor", "Teacher " + i++);
        weapon = Weapon.generateWeapon();
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}
