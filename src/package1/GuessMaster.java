//Tom Haklai 
//20347511

package package1;

import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
    private int totalCandidateEntities; //# of entities possible to add
    private Entity[] entities; // Store entities in array
    private int currentEntities; //Entities added in game

    //Initialize GuessMaster using a set candidate entities value
    public GuessMaster(int numberOfCandidateEntities) {
        this.totalCandidateEntities = numberOfCandidateEntities;
        entities = new Entity[numberOfCandidateEntities];
        this.currentEntities = 0;
    }

    //Add entities to the game
    public void addEntity(Entity entity) {
        if (currentEntities < totalCandidateEntities) {
            entities[currentEntities] = entity;
            currentEntities++;
        } else {
            System.out.println("Maximum number of entities reached.");
        }
    }
    
    //Takes user input for specific entity birth date 
    private void guessInput(Entity entity) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Birthday Guessing Game!");
        System.out.println("Guess the birth date of " + entity.getName() + "."); //Prompts user for their intial guess

        while (true) {
            String guess = getUserGuess(); //Get user input as string

            //If user wants to quit
            if (guess.equalsIgnoreCase("quit") || guess.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            
            try {
            	//Parse user input to Date object format
                Date userDate = new Date(guess);
                Date entityBirthday = entity.getBorn();
                
                displayResult(userDate, entityBirthday);
                if (userDate.equals(entityBirthday)) {//Exit loop if guess matches correct answer
                    break; 
                }
            } catch (NumberFormatException e) {
            	//If date format is invalid
                invalidInput();
            }
        }

        scanner.close();
    }
    

    //Prompt user input 
    private String getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess in the format MM/DD/YYYY: ");
        return scanner.nextLine();
    }
    
    //Return user result based on their guess
    private void displayResult(Date userDate, Date entityBirthday) {
        if (userDate.precedes(entityBirthday)) {
            System.out.println("Incorrect. Try a later date.");
        } else if (userDate.equals(entityBirthday)) {
            System.out.println("BINGO. You got it!");
        } else {
            System.out.println("Incorrect. Try an earlier date.");
        }
    }

    //Invalid user input
    private void invalidInput() {
        System.out.println("Invalid date format. Please enter the date in MM/DD/YYYY format.");
    }

    //Start game for individual entity
    public void playGame(Entity entity) {
        guessInput(entity);
    }

    //Start game using entity index in array
    public void playGame(int entityInd) {
        if (entityInd >= 0 && entityInd < currentEntities) {
            guessInput(entities[entityInd]);
        } else {
            System.out.println("Invalid entity index.");
        }
    }

    //Start game for randomly selected entity
    public void playGame() {
        Random random = new Random();
        int index = random.nextInt(currentEntities);
        guessInput(entities[index]);
    }

    //Main method
    public static void main(String[] args) {
        // Initializing entities
        Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
        Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
        Entity usa = new Entity("United States", new Date("July", 4, 1776));
        Entity gandhi = new Entity("Mahatma Gandhi", new Date("October", 2, 1869));
        Entity gump = new Entity("Forrest Gump", new Date("June", 6, 1944));
        Entity greg = new Entity("Greg Heffley", new Date("June", 27, 1999));
        Entity lebron = new Entity("LeBron James", new Date("December", 30, 1984));

        GuessMaster gm = new GuessMaster(7);
        gm.addEntity(trudeau);
        gm.addEntity(dion);
        gm.addEntity(usa);
        gm.addEntity(gandhi);
        gm.addEntity(gump);
        gm.addEntity(greg);
        gm.addEntity(lebron);

        // Start the game
        gm.playGame();
    }
}

