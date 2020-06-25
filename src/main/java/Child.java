public class Child extends Survivor {
	
	static int i = 0;

    public Child() {
        super(20, 2, "survivor", "Child " + i++, weapon);
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}
