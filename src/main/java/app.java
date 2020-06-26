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
            // Check if zombie is still alive, and select next zombie if dead
            while (zombie.getHealth() <= 0) {
            	zIterator++;
            	if (zIterator >= zombie_list.size()) {
            		zIterator = 0;
            		
            		//TESTING
            		System.out.println("!!!!! all zombies are dead");
            	}
            	zombie = zombie_list.get(zIterator);
            	
            	// TESTING
            	System.out.println("                    zombie " + zombie.getName() + " is chosen to attack.");
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

            
            
            /*
             * THE FOLLOWING CODE IS THE PROBLEM 
             * 
             * if you switch the order of zombie attacks and survivor attacks, you'll see that whichever runs second
             * allows dead ones to attack some of the time
             */
            
            
            
            survivor.setWeapon();
            if (zombie.getHealth() > 0 || survivor.getHealth() > 0) {                
                // Zombie attacks
                for (int i = 0; i < survivor_list.size(); i++) {
                	// make sure the survivor is alive before allowing the zombie to attack
                	if (survivor_list.get(i).getHealth() > 0) {
                		zombieAttack(zombie, survivor_list.get(i));
                		
                		// TESTING
                		System.out.println("                    " + zombie.getName() + " is attacking.");
                		
                		if (survivor_list.get(i).getHealth() <= 0) {
                			System.out.println(zombie.getName() + " killed " + survivor_list.get(i).getName());
                		}
                	}
                }
            	// Survivor attacks
                for (int i = 0; i < zombie_list.size(); i++) {
                	// make sure the zombie is alive before allowing the survivor to attack
                	if (zombie_list.get(i).getHealth() > 0) {
                		survivorAttack(survivor, zombie_list.get(i));
                		
                		// TESTING
                		System.out.println("                    " + survivor.getName() + " is attacking.");
                		
                		if (zombie_list.get(i).getHealth() <= 0) {
                			System.out.println(survivor.getName() + " killed " + zombie_list.get(i).getName() + " with a " + survivor.getWeapon().type);
                		}
                	}
                }
            
                
                
                
                
                /*
                 *  THE ABOVE CODE IS THE PROBLEM
                 */
                
                
                
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

        }
        
        // Display which "team" wins
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
    
    /******************
     * SURVIVOR ATTACK
     ******************/
    private void survivorAttack(Character survivor, Character zombie) {
    	// check if the victim is still alive;
    	if (zombie.getHealth() > 0) {
            int weaponAccuracy = survivor.getWeapon().accuracy;

            // getting the accuracy of the weapon as a whole number (0-10)
            int accuracyAsWholeNumber = weaponAccuracy / 10;
            // generating random number between (1-10)
            int randomNumber = getRandom(1, 10);

            // if the random number <= the accuracy whole number we will attack
            // EX. if the weapon accuracy was 50% -> the whole number would be 5 -> if randomNumber was between 1-5 we
            // would attack, if randomNumber was between 6-10 we would miss
            if (randomNumber < Math.round(accuracyAsWholeNumber)) {
    	    	// make sure the victim's health will not go below 0 when attacked
                if (zombie.getHealth() - survivor.getWeapon().damage <= 0) {
                    zombie.setHealth(0);
                    
                    // TESTING
                    zombie.setName(zombie.getName() + " IS DEAD!");
                    
                } else { // the victim doesn't die from the attack
                    zombie.setHealth(zombie.getHealth() - survivor.getWeapon().damage);
                }
            } else {
                System.out.println(survivor.getName() + "'s Attack on " + zombie.getName() + " missed!");
            }
	    }
    }
    
    /******************
     * ZOMBIE ATTACK
     ******************/
    private void zombieAttack(Character zombie, Character survivor) {
    	// check if the victim is still alive;
    	if (survivor.getHealth() > 0) {
	    	// make sure the victim's health will not go below 0 when attacked
	        if (survivor.getHealth() - zombie.getAttack() < 0) {
	        	survivor.setHealth(0);
                
                // TESTING
                survivor.setName(survivor.getName() + " IS DEAD!");
                
	        } else { // the victim's health will not go below 0 when attacked
	        	survivor.setHealth(survivor.getHealth() - zombie.getAttack());
	        }
	    }
    }
}