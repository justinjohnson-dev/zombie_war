public class app {
    public static void main(String[] args) {
        app obj = new app();
        obj.run();
    }

    private void run() {
        Child childSurvivor = new Child(20, 2, "survivor");
        Teacher teacherSurvivor = new Teacher(50, 5, "survivor");
        Soldier soldierSurvivor = new Soldier(100, 10, "survivor");

        // Lets decide which path to take - create individual classes for each character type
        // or just create a new character object
        Character child = new Character(20, 2, "survivor");


        System.out.println(childSurvivor);
        childSurvivor.setHealth(15);

        System.out.println(" ");
        System.out.println("Child character after health dropped by 5");
        System.out.println(childSurvivor);

        System.out.println(" ");
        System.out.println("Character class with child object attacking");
        child.attack();
    }
}
