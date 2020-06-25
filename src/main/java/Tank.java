public class Tank extends Character {

	static int i = 0;

    public Tank() {
        super(150, 20, "zombie", "Tank " + i++);
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}