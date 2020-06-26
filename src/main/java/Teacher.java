public class Teacher extends Character {

	static int i = 0;

    public Teacher() {
        super(50, 5, "survivor", "Teacher " + i++);
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}