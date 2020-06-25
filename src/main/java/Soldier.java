public class Soldier extends Character {

	static int i = 0;

    public Soldier() {
        super(100, 10, "survivor", "Soldier " + i++);
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}