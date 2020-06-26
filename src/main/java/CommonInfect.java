public class CommonInfect extends Character {

	static int i = 0;

    public CommonInfect() {
        super(30, 5, "zombie", "CommonInfect " + i++);
    }

    @Override
    public String toString() {
        return (super.toString());
    }
}