public class Child extends Character {

	static int i = 0;

    public Child() {
        super(20, 2, "survivor", "Child " + i++);
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}