import java.util.ArrayList;
import java.util.List;

public class app {
	
    public static void main(String[] args) {
        app obj = new app();
        obj.run();
    }
    
    /***********
     * RUN
     ***********/
    private void run() {
        // generate the two character Lists
        List<Character> survivors = generateCharacters("survivor");
        List<Character> zombies = generateCharacters("zombie");

//        System.out.println("We have " + survivors.size() + " survivors trying to make it to safety.");
//        System.out.println("But there are " + zombies.size() + " zombies waiting for them.");

        System.out.println(fight(zombies, survivors));
    }
    
    /*********************
     * GENERATE CHARACTERS
     *********************/
    // generate an array of characters between 5 and 20 elements in length and fill with random characters
    private List<Character> generateCharacters(String charType) {
        List<Character> characters = new ArrayList<Character>();
        
        if (charType.contentEquals("zombie")) {
            // initialize counter variables
        	int tankCount = 0;
        	int commonCount = 0;
            // generate the random zombies that will fill the array
            for (int i=0; i<getRandom(5,20); i++) {
                // get a random number that will dictate which character type is put into the array
                int randomZombie = getRandom(0, 4);
                if (randomZombie >= 0 && randomZombie <= 3) {
                    characters.add(new CommonInfect());
                    commonCount++;
                } else if (randomZombie == 4) {
                    characters.add(new Tank());
                    tankCount++;
                } else {
                	System.out.println("ERROR: The random number was not between 0 and 3");
                } // end if/else statement for getting the zombie types
            } // end for loop for populating the zombie array
            int zombieSize = commonCount + tankCount;
            System.out.println("But there are " + zombieSize + " zombies waiting for them (" + commonCount + " common infected, " + tankCount + " tanks)");
            
        } else if (charType.contentEquals("survivor")) {
            // initialize counter variables
        	int childCount = 0;
        	int teacherCount = 0;
        	int soldierCount = 0;
            // generate the random survivors that will fill the array
            for(int i=0; i<getRandom(5,20); i++) {
                // get a random number that will dictate which character type is put into the array
                int randomSurvivor = getRandom(0,2);
                switch(randomSurvivor) {
                    case 0:
                        characters.add(new Child());
                        childCount++;
                        break;
                    case 1:
                        characters.add(new Teacher());
                        teacherCount++;
                        break;
                    case 2:
                        characters.add(new Soldier());
                        soldierCount++;
                        break;
                    default:
                        System.out.println("The random character was neither 0, 1, nor 2");
                } // end switch statement for getting the survivor types
            } // end for loop for populating the survivor array
            int survivorSize = childCount + teacherCount + soldierCount;
            System.out.println("We have " + survivorSize + " survivors trying to make it to safety (" + childCount + " children, " + teacherCount + " teachers, " + soldierCount + " soldiers)");
        } else {
            // the type passed to the function was neither zombies nor survivors
            System.out.println(charType + " is an invalid character type.");
        }
        
        return characters;
    }
    
    /*************
     * GET RANDOM
     *************/
    // generate a random number within a set range
    private int getRandom(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }
    
    /**********
     * FIGHT
     **********/
    private String fight(List<Character> zombie_list, List<Character> survivor_list) {
        // grabbing size of list so we can handle our break condition for our while loop
        int numberOfHealthyZombies = zombie_list.size();
        int numberOfHealthySurvivors = survivor_list.size();
        
        // Separate iterators for zombie and survivor lists
        int zIterator = 0;
        int sIterator = 0;

        // while loop to keep looping until list one list of characters health are all 0
        while (numberOfHealthySurvivors > 0 && numberOfHealthyZombies > 0) {

            Character zombie = zombie_list.get(zIterator);
            // Check is zombie is still alive, and select next zombie if dead
            while (zombie.getHealth() <= 0) {
            	zIterator++;
            	if (zIterator >= zombie_list.size()) {
            		zIterator = 0;
            	}
            	zombie = zombie_list.get(zIterator);
            }
            
            Character survivor = survivor_list.get(sIterator);
            // Check is survivor is still alive, and select next survivor if dead
            while (survivor.getHealth() <= 0) {
            	sIterator++;
            	if (sIterator >= survivor_list.size()) {
            		sIterator = 0;
            	}
            	survivor = survivor_list.get(sIterator); 
            }
            
            if (zombie.getHealth() > 0 || survivor.getHealth() > 0) {
            	// Survivor attacks
                for (int i = 0; i < zombie_list.size(); i++) {
                	// make sure the zombie is alive before allowing the survivor to attack
                	if (zombie_list.get(i).getHealth() > 0) {
                		attack(survivor, zombie_list.get(i));
                		if (zombie_list.get(i).getHealth() <= 0) {
                			System.out.println(survivor.getName() + " killed " + zombie_list.get(i).getName() + " With a " + survivor.getWeapon().type);
                		}
                	}
                }
                
                // Zombie attacks
                for (int i = 0; i < survivor_list.size(); i++) {
                	// make sure the survivor is alive before allowing the zombie to attack
                	if (survivor_list.get(i).getHealth() > 0) {
                		attack(zombie, survivor_list.get(i));
                		if (survivor_list.get(i).getHealth() <= 0) {
                			System.out.println(zombie.getName() + " killed " + survivor_list.get(i).getName() + " With a " + zombie.getWeapon().type);
                		}
                	}
                }
                
                numberOfHealthySurvivors = 0;
                numberOfHealthyZombies = 0;
                
                // Tally living survivors
                for (int i = 0; i < survivor_list.size(); i++) {
                	if (survivor_list.get(i).getHealth() > 0) {
                		numberOfHealthySurvivors++;
                	}
                }
                
                // Tally living zombies
                for (int j = 0; j < zombie_list.size(); j++) {
                	if (zombie_list.get(j).getHealth() > 0) {
                		numberOfHealthyZombies++;
                	}
                }
            }
            
            // Check if index out of bounds, reset iterator
            zIterator++;
            if (zIterator >= zombie_list.size()) {
            	zIterator = 0;
            }
            sIterator++;
            if (sIterator >= survivor_list.size()) {
            	sIterator = 0;
            }
        }

        if (numberOfHealthySurvivors > numberOfHealthyZombies) {
            int survivorCounter = 0;
            for (int i = 0; i < survivor_list.size(); i++) {
                Character survivor = survivor_list.get(i);
                if (survivor.getHealth() > 0) {
                    survivorCounter++;
                }
            }
            return "It seems " + survivorCounter +  " survivors have made it to safety.";
        } else {
            int zombieCounter = 0;
            for (int i = 0; i < zombie_list.size(); i++) {
                Character zombie = zombie_list.get(i);
                if (zombie.getHealth() > 0) {
                    zombieCounter++;
                }
            }
            return "ZOMBIES WIN! There are " + zombieCounter +  " zombie(s) left.";
        }
    }
    
    /**********
     * ATTACK
     **********/
    private void attack(Character attacker, Character victim) {
    	// check if the victim is still alive;
    	if (victim.getHealth() > 0) {
	    	// make sure the victim's health will not go below 0 when attacked
            attacker.setWeapon();
            int weaponAccuracy = attacker.getWeapon().accuracy;

            // getting the accuracy of the weapon as a whole number (0-10)
            int accuracyAsWholeNumber = weaponAccuracy / 10;
            // generating random number between (0-10)
            int randomNumber = getRandom(0, 10);

            // if the random number <= the accuracy whole number we will attack
            // EX. if the weapon accuracy was 50% -> the whole number would be 5 -> if randomNumber was between 0-5 we
            // would attack, if randomNumber was between 6-10 we would miss
            if (randomNumber < accuracyAsWholeNumber) {
                if (victim.getHealth() - attacker.getWeapon().damage < 0) {
                    victim.setHealth(0);
                } else { // the victim's health will not go below 0 when attacked
                    victim.setHealth(victim.getHealth() - attacker.getWeapon().damage);
                }
            } else {
                System.out.println("Attack missed!");
            }

	    }
    }
}