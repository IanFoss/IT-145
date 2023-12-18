import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	//ArrayLists store animals that go through the intake process
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
        
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);  	
    	
    	//Program adds test cases to dog and monkey array list
    	initializeMonkeyList();
    	initializeDogList();
    	
    	//Menu loops until q is entered
    	while (true) {
    		displayMenu();
    		String menuChoice = scanner.nextLine();
    		switch(menuChoice) {
    			case "1":	//Adds new dog to array list
    				intakeNewDog(scanner);
    				continue;
    			case "2":	//Adds new monkey to array list
    				intakeNewMonkey(scanner);
    				continue;
    			case "3":	//Allows user to reserve available animals
    				reserveAnimal(scanner);
    				continue;
    			case "4":	//Prints all dog's names, service countries, and availability
    				printAnimals(4);
    				continue;
    			case "5":	//Prints all monkey's names, service countries, and availability
    				printAnimals(5);
    				continue;
    			case "6":	//Prints all animals available for reservation and their country
    				printAnimals(6);
    				continue;    		
    			case "q":	//Exits program
    				break;
    			default:	//Input validation - user must select a menu option
    				System.out.println("-----------------------------");
    				System.out.println("Please make a valid selection");
    				System.out.println("-----------------------------");    				
    				continue;
    		}
    		System.out.println("Goodbye");
    		break;
    	}
    }
    
    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    
    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dogTest1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", "yes", "United States");
        Dog dogTest2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", "yes", "United States");
        Dog dogTest3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", "no", "Canada");

        dogList.add(dogTest1);
        dogList.add(dogTest2);
        dogList.add(dogTest3);
    }

    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
    	Monkey monkeyTest1 = new Monkey("Ian", "Male", "31", "155", "05-12-2019", "United States", "Phase V", "yes", "United States", "5", "5", "5", "Macaque");
    	Monkey monkeyTest2 = new Monkey("Joe", "Male", "31", "155", "05-12-2019", "United States", "in service", "no", "United States", "5", "5", "5", "Macaque");
    	monkeyList.add(monkeyTest1);
    	monkeyList.add(monkeyTest2);
    }
    
    //Method to intake new dog
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
    	//Checks and disallows duplicate names
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        //Obtains user input to use for Dog constructor
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();      
        
    	System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        
        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scanner.nextLine();
        
        System.out.println("What is the dog's acquisition country?");
        String acquisitionCountry = scanner.nextLine();
        
        System.out.println("What is the dog's training status?");
        String dogTrainingStatus = scanner.nextLine();
        
        //Input validation allowing only the eight training statuses
        while (!dogTrainingStatus.equals("intake") && !dogTrainingStatus.equals("Phase I") && 
        	   !dogTrainingStatus.equals("Phase II") && !dogTrainingStatus.equals("Phase III") &&
        	   !dogTrainingStatus.equals("Phase IV") && !dogTrainingStatus.equals("Phase V") &&
        	   !dogTrainingStatus.equals("in service") && !dogTrainingStatus.equals("farm")) {
        	
        		System.out.println("Please choose a valid training status.");
        		dogTrainingStatus = scanner.nextLine();
        }
        System.out.println("Is the dog currently reserved?");
        String reservationStatus = scanner.nextLine();
        //Loops until user enters "yes" or "no" for reservation status
        while (!reservationStatus.equalsIgnoreCase("yes") && !reservationStatus.equalsIgnoreCase("no")) {
        	System.out.println("Please enter \"yes\" or \"no\".");
        	reservationStatus = scanner.nextLine();
        }
        System.out.println("In what country is the dog in service?");
        String serviceCountry = scanner.nextLine();
        
        //Instantiates new Dog object with user input for the constructor
        //Adds the new Dog object to the array list
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, dogTrainingStatus, 
        							  reservationStatus, serviceCountry);
        dogList.add(newDog);
        System.out.println("Intake complete.");
    }
    

    //Monkey intake process. Adds monkey and details to array list.
    public static void intakeNewMonkey(Scanner scanner) {  	 
    	System.out.println("What is the monkey's name?");
    	String name = scanner.nextLine();
    	//Checks and disallows duplicate names
    	for(Monkey monkey : monkeyList) {
    		if(monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
           	}
        }
    	//Gets user input for the Monkey constructor
    	System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();
        
        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine();
        
        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();
        
        System.out.println("What is the monkey's acquisition date?");
        String acquisitionDate = scanner.nextLine();
        
        System.out.println("What is the monkey's acquisition country?");
        String acquisitionCountry = scanner.nextLine();
        
        System.out.println("What is the monkey's training status?");
        String monkeyTrainingStatus = scanner.nextLine();
        
        //Input validation allowing only the eight training statuses
        while (!monkeyTrainingStatus.equals("intake") && !monkeyTrainingStatus.equals("Phase I") && 
        	   !monkeyTrainingStatus.equals("Phase II") && !monkeyTrainingStatus.equals("Phase III") &&
        	   !monkeyTrainingStatus.equals("Phase IV") && !monkeyTrainingStatus.equals("Phase V") &&
        	   !monkeyTrainingStatus.equals("in service") && !monkeyTrainingStatus.equals("farm")) {
        	
        		System.out.println("Please choose a valid training status.");
        		monkeyTrainingStatus = scanner.nextLine();
        }
        System.out.println("Is the monkey currently reserved?");
        String reservationStatus = scanner.nextLine();
        
        //Loops until user enters "yes" or "no" for reservation status
        while (!reservationStatus.equalsIgnoreCase("yes") && !reservationStatus.equalsIgnoreCase("no")) {
        	System.out.println("Please enter \"yes\" or \"no\".");
        	reservationStatus = scanner.nextLine();
        }
        
        System.out.println("In what country is the monkey in service?");
        String serviceCountry = scanner.nextLine();
        
        System.out.println("How long is the monkey's tail?");
        String tailLength = scanner.nextLine();
        
        System.out.println("How tall is the monkey?");
        String height = scanner.nextLine();
        
        System.out.println("What is the body length for the monkey?");
        String bodyLength = scanner.nextLine();
        
        System.out.println("What species is the monkey?");
        String monkeySpecies = scanner.nextLine();
        
        //Input validation loops until acceptable species is entered
        while (!monkeySpecies.equalsIgnoreCase("Capuchin") && !monkeySpecies.equalsIgnoreCase("Guenon")&&
        	   !monkeySpecies.equalsIgnoreCase("Macaque") && !monkeySpecies.equalsIgnoreCase("Marmoset") &&
        	   !monkeySpecies.equalsIgnoreCase("Squirrel monkey")&& !monkeySpecies.equalsIgnoreCase("Tamarin")) {
        	System.out.println("That species is not eligible for training.\nPlease choose another.");
        	monkeySpecies = scanner.nextLine();
        }
        
        //New Monkey object created with user input user for constructor
        //New Monkey added to array list
        Monkey newMonkey = new Monkey(name, gender, age, weight, acquisitionDate, acquisitionCountry, monkeyTrainingStatus, 
        							  reservationStatus, serviceCountry, tailLength, height, bodyLength, monkeySpecies);
        monkeyList.add(newMonkey);
        System.out.println("Intake complete.");
    }

    	//Method to reserve animal
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("What type of animal would you like to reserve?");
            String animalType = scanner.nextLine();
            boolean animalReserved = false;
            
            //User must enter Dog or Monkey animal type
            while (!animalType.equalsIgnoreCase("Dog") && !animalType.equalsIgnoreCase("Monkey")) {
            	System.out.println("Please enter \"Dog\" or \"Monkey\".");
            	animalType = scanner.nextLine();
            }
            System.out.println("In what country will your animal be in service?");
            String countryName = scanner.nextLine();
            
            //Dog reservation branch
            if (animalType.equalsIgnoreCase("Dog")) {
            	
            	//If no dogs have been added, sends user back to menu
            	if (dogList.size() == 0) {
        			System.out.println("There are no dogs available.");
        		}
            	
            	//Iterates through dog array list
            	for (Dog dog : dogList) {
            		
            		//Displays first dog available in user's country
            		//Outputs message if no dogs available, then sends user back to menu
            		if (dog.getInServiceLocation().equalsIgnoreCase(countryName)
            			&& dog.getReserved().equalsIgnoreCase("no")) {
            			System.out.println(dog.getName() + " is available for reservation.");
            			System.out.println("Do you want to reserve " + dog.getName() + "?");
            			String reserveChoice = scanner.nextLine().toLowerCase();
            			
            			//Loops until user enters yes or no to reserve animal
	            		while (true) {	
            				switch (reserveChoice) {
	            				case "yes":
	            					System.out.println(dog.getName() + " has been reserved.");
	            					dog.setReserved("yes");
	            					animalReserved = true;
	            					break;
	            				case "no":
	            					System.out.println("Returning to menu.");
	            					animalReserved = true;
	            					break;
	            				default:
	            					System.out.println("Please enter \"yes\" or \"no\".");
	                    			System.out.println(dog.getName() + " is available for reservation.");
	                    			System.out.println("Do you want to reserve " + dog.getName() + "?");
	                    			reserveChoice = scanner.nextLine().toLowerCase();
	            					continue;
	            			}
            				break;
	            		}
            		}
            		//Starts next iteration if dog is already reserved
            		else if (dog.getInServiceLocation().equalsIgnoreCase(countryName) &&
            				 dog.getReserved().equalsIgnoreCase("yes")) {
            			continue;
            		}
            		//Used to exit loop if user reserves an animal or declines to reserve
            		if (animalReserved == true) {
            			break;
            		}
            	}
            	//Variable remains false if no dogs are available
            	//Prints feedback to user and returns to menu
            	if (animalReserved == false) {
            		System.out.println("There are no dogs available in that country.");
            	}
            }
            //Monkey reservation branch
            if (animalType.equalsIgnoreCase("Monkey")) {
            	//If no monkeys have been added, sends user back to menu
            	if (monkeyList.size() == 0) {
        			System.out.println("There are no monkeys available.");
        		}
           	//Iterates through monkey array list
            	for (Monkey monkey : monkeyList) {
            		//Displays first monkey available in user's country
            		//Outputs message if no monkey is available, then sends user back to menu
            		if (monkey.getInServiceLocation().equalsIgnoreCase(countryName)
            			&& monkey.getReserved().equalsIgnoreCase("no")) {
            			System.out.println(monkey.getName() + " is available for reservation.");
            			System.out.println("Do you want to reserve " + monkey.getName() + "?");
            			String reserveChoice = scanner.nextLine().toLowerCase();
            			//Loops until user enters yes or no 
	            		while (true) {	
            				switch (reserveChoice) {
	            				case "yes":
	            					System.out.println(monkey.getName() + " has been reserved.");
	            					monkey.setReserved("yes");
	            					animalReserved = true;
	            					break;
	            				case "no":
	            					System.out.println("Returning to menu.");
	            					animalReserved = true;
	            					break;
	            				default:
	            					System.out.println("Please enter \"yes\" or \"no\".");
	                    			System.out.println(monkey.getName() + " is available for reservation.");
	                    			System.out.println("Do you want to reserve " + monkey.getName() + "?");
	                    			reserveChoice = scanner.nextLine().toLowerCase();
	            					continue;
	            			}
            				break;
	            		}
            		}
            		//Starts next iteration if monkey is already reserved
            		else if (monkey.getInServiceLocation().equalsIgnoreCase(countryName) &&
            				 monkey.getReserved().equalsIgnoreCase("yes")) {
            			continue;
            		}
            		//Exits the loop if animal is reserved or user declines to reserve animal
	            	if (animalReserved == true) {
	            		break;
	            	}
            	}
            	//variable remains false if no monkey are available
            	//outputs message to user and returns to main menu
            	if (animalReserved == false) {
            		System.out.println("There are no monkeys available in that country.");
            	}
            }
        }
        //Method that prints animals depending on menu option selected
        public static void printAnimals(int option) {
        	//Main menu option 4 - prints all dogs, their country, and the reservation status
        	if (option == 4) {
        		System.out.println("--------");
        		System.out.println("All dogs");
        		System.out.println("--------");
	        	for (int i = 0; i < dogList.size(); ++i) {
	            	System.out.println(dogList.get(i).getName() + ":");
	            	System.out.println("   Training status: " + dogList.get(i).getTrainingStatus());
	            	System.out.println("   Acquisition country: " + dogList.get(i).getAcquisitionLocation());
	            	System.out.println("   Currently reserved: " + dogList.get(i).getReserved());
	            	System.out.println("");
	            }
        	}
        	//Main menu option 5 - prints all monkey, their country, and the reservation status
	        if (option == 5) {
	        	System.out.println("-----------");
	        	System.out.println("All monkeys");
	        	System.out.println("-----------");
	        	for (Monkey monkey : monkeyList) {
	        		System.out.println(monkey.getName() + ":");
	        		System.out.println("   Training status: " + monkey.getTrainingStatus());
	        		System.out.println("   Acquisition country: " + monkey.getAcquisitionLocation());
	        		System.out.println("   Currently reserved: " + monkey.getReserved());
	        		System.out.println("");
	        	}
	        }
	        //Main menu option 6 - prints all animals that are in service and not yet reserved, with their respective countries
	        if (option == 6) {
	        	//Iterates through dog array list to print dogs that meet criteria
	        	System.out.println("-----------------------------");
	        	System.out.println("Dogs in service and available");
	        	System.out.println("-----------------------------");
	        	for (Dog dog : dogList) {
	        		if (dog.getTrainingStatus().equalsIgnoreCase("in service") &&
	        			dog.getReserved().equalsIgnoreCase("no")) {
	        			System.out.println(dog.getName() + " - " + dog.getInServiceLocation());
	        		}
	        	}
	        	//Iterates through monkey array list to print monkey that meet criteria
	        	System.out.println("--------------------------------");
	        	System.out.println("Monkeys in service and available");
	        	System.out.println("--------------------------------");
	        	for (Monkey monkey : monkeyList) {
	        		if (monkey.getTrainingStatus().equalsIgnoreCase("in service") &&
	        			monkey.getReserved().equalsIgnoreCase("no")) {
	        			System.out.println(monkey.getName() + " - " + monkey.getInServiceLocation());
	        		}
	        	}
	        }
	    }
}
