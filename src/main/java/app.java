import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args) {
        app obj = new app();
        obj.run();
    }

    private void run() {
        // generate the two character arrays
        Character[] zombies = generateCharacters("zombie");
        Character[] survivors = generateCharacters("survivor");

        System.out.println("We have " + survivors.length + " survivors trying to make it to safety.");
        System.out.println("But there are " + zombies.length + " zombies waiting for them.");

        String warWinner = fight(zombies, survivors);
        System.out.println(warWinner);
    }

    // generate an array of characters between 5 and 20 elements in length
    private Character[] generateCharacters(String charType) {
        Character[] characters = new Character[getRandom(5, 20)];
        if (charType.contentEquals("zombie")) {
            // initialize counter variables
            int tankCount = 0;
            int commonCount = 0;
            // generate the random zombies that will fill the array
            for (int i = 0; i < characters.length; i++) {
                // get a random number that will dictate which character type is put into the array
                int randomZombie = getRandom(0, 1);
                switch (randomZombie) {
                    case 0:
                        characters[i] = new CommonInfect();
                        commonCount++;
                        break;
                    case 1:
                        characters[i] = new Tank();
                        tankCount++;
                        break;
                    default:
                        System.out.println("The random character was neither 0 nor 1");
                } // end switch statement for getting the zombie types
            } // end for loop for populating the zombie array
        } else if (charType.contentEquals("survivor")) {
            // initialize counter variables
            int childCount = 0;
            int teacherCount = 0;
            int soldierCount = 0;
            // generate the random survivors that will fill the array
            for (int i = 0; i < characters.length; i++) {
                // get a random number that will dictate which character type is put into the array
                int randomSurvivor = getRandom(0, 2);
                switch (randomSurvivor) {
                    case 0:
                        characters[i] = new Child();
                        childCount++;
                        break;
                    case 1:
                        characters[i] = new Teacher();
                        teacherCount++;
                        break;
                    case 2:
                        characters[i] = new Soldier();
                        soldierCount++;
                        break;
                    default:
                        System.out.println("The random character was neither 0, 1, nor 2");
                } // end switch statement for getting the survivor types
            } // end for loop for populating the survivor array
        } else {
            // the type passed to the function was neither zombies nor survivors
            System.out.println(charType + " is an invalid character type.");
        }
        return characters;
    }

    // I figured it would be easier and cleaner to have a function to get the random numbers
    // than it would have been to use Math.random() everywhere.
    private int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    private String fight(Character[] zombies, Character[] survivors) {
        List<Character> zombie_list = convertArrayToList(zombies);
        List<Character> survivor_list = convertArrayToList(survivors);

        // grabbing size of list so we can handle our break condition for our while loop
        int numberOfHealthyZombies = zombie_list.size();
        int numberOfHealthySurvivors = survivor_list.size();

        // while loop to keep looping until list one list of characters health are all 0
        while (numberOfHealthySurvivors >= 0 && numberOfHealthyZombies >= 0) {
            int iterator = 0;

            Character zombie = zombie_list.get(iterator);
            Character survivor = survivor_list.get(iterator);

            if (zombie.getHealth() >= 0 || survivor.getHealth() >= 0) {
                System.out.println(numberOfHealthyZombies);
                System.out.println(numberOfHealthySurvivors);

                for (int i = 0; i < zombie_list.size(); i++) {
                    Character zombieAttacked = zombie_list.get(i);
                    survivor.attack();
                    zombieAttacked.setHealth(zombieAttacked.getHealth() - survivor.getAttack());
                }

                for (int j = 0; j < survivor_list.size(); j++) {
                    Character survivorAttacked = survivor_list.get(j);
                    zombie.attack();
                    survivorAttacked.setHealth(survivorAttacked.getHealth() - zombie.getAttack());
                }

                numberOfHealthyZombies--;
                numberOfHealthySurvivors--;
            }

            iterator++;
        }

        if (numberOfHealthySurvivors > numberOfHealthyZombies) {
            return "Survivors won!!";
        } else {
            return "Zombies won!!";
        }
    }

    // Generic function to convert an Array to List
    // Helper function retrieved from: https://www.geeksforgeeks.org/program-to-convert-array-to-list-in-java/
    public static <T> List<T> convertArrayToList(T array[]) {

        // Create an empty List
        List<T> list = new ArrayList<>();

        // Iterate through the array
        for (T t : array) {
            // Add each element into the list
            list.add(t);
        }

        // Return the converted List
        return list;
    }
}