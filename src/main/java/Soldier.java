public class Soldier extends Survivor {
	
	static int i = 0;

    public Soldier() {
        super(100, 10, "survivor", "Soldier " + i++, weapon);
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}
