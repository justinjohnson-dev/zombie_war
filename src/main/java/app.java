public class app {
    public static void main(String[] args) {
        app obj = new app();
        obj.run();
    }

    private void run() {
    	// generate the two character arrays
    	Character[] zombies = generateCharacters("zombie");
    	Character[] survivors = generateCharacters("survivor");
    	// test to make sure the characters are in the array
    	System.out.println(" ");
        for (Character c : zombies) {
        	System.out.println(c);
        }
        System.out.println(" ");
        for (Character c : survivors) {
        	System.out.println(c);
        }
    }
    
    // generate an array of characters between 5 and 20 elements in length
    private Character[] generateCharacters(String charType) {
    	Character[] characters = new Character[getRandom(5, 20)];
    	System.out.println(charType + " array length: " + characters.length);
    	if (charType.contentEquals("zombie")) {
    		// generate the random zombies that will fill the array
    		characters[0] = new Tank();
    		characters[1] = new Tank();
    		characters[2] = new CommonInfect();
    	} else if (charType.contentEquals("survivor")) {
    		// generate the random survivors that will fill the array
    		characters[0] = new Child();
    		characters[1] = new Child();
    		characters[2] = new Teacher();
    		characters[3] = new Soldier();
    		characters[4] = new Soldier();
    	} else {
    		// the type passed to the function was neither zombies nor survivors
    		System.out.println(charType + " is an invalid character type.");
    	}
    	return characters;
    }
    
    // I figured it would be easier and cleaner to have a function to get the random numbers
    // than it would have been to use Math.random() everywhere.
    private int getRandom(int min, int max) {
    	return (int)(Math.random() * (max - min + 1) + min); 
    }
}