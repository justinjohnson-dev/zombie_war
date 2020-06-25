public class Teacher extends Survivor {
	
	static int i = 0;

    public Teacher() {
        super(50, 5, "survivor", "Teacher " + i++, weapon);
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}
