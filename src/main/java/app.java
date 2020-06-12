import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args) {
        app obj = new app();
        obj.run();
    }

    private void run() {
    	// generate the two character arrays
    	List<Character> zombies = generateCharacters("zombie");
    	List<Character> survivors = generateCharacters("survivor");
    	
    	System.out.println("We have " + survivors.size() + " survivors trying to make it to safety.");
    	System.out.println("But there are " + zombies.size() + " zombies waiting for them.");
    }
    
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
    			int randomZombie = getRandom(0, 1);
    			switch (randomZombie) {
    			case 0:
    				characters.add(new CommonInfect());
    				commonCount++;
    				break;
    			case 1:
    				characters.add(new Tank());
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
    	} else {
    		// the type passed to the function was neither zombies nor survivors
    		System.out.println(charType + " is an invalid character type.");
    	}
    	return characters;
    }
    
    // generate a random number within a set range
    private int getRandom(int min, int max) {
    	return (int)(Math.random() * (max - min + 1) + min); 
    }
}