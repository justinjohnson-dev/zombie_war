public class app {
    public static void main(String[] args) {
        app obj = new app();
        obj.run();
    }

    private void run() {
        Child childSurvivor = new Child();
        Child secondChild = new Child();
        Teacher teacherSurvivor = new Teacher();
        Teacher secondTeacher = new Teacher();
        Teacher thirdTeacher = new Teacher();
        Soldier soldierSurvivor = new Soldier();
        Tank tankZombie = new Tank();
        CommonInfect commonInfectZombie = new CommonInfect();

        System.out.println("Child character stats at creation");
        System.out.println(childSurvivor);
        childSurvivor.setHealth(15);
        System.out.println(" ");
        
        System.out.println("Child character stats after health dropped by 5");
        System.out.println(childSurvivor);
        System.out.println(" ");
        
        // show that the names are incrementing
        System.out.println(secondChild);
        System.out.println(secondTeacher);
        System.out.println(thirdTeacher);
        
        System.out.println(" ");
        System.out.println("Tank attacking");
        tankZombie.attack();
    }
}
