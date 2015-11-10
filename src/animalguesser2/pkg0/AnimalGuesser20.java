
package animalguesser2.pkg0;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnimalGuesser20 {
    
    public static void main(String[] args) throws IOException {
        
        //define maximums
        int maxAnimals = 25; //rows
        int maxAttr = 10; //cols
        
        //define arrays
        String[] animals = new String[maxAnimals]; // name of animals
        String[] attributeNames = new String[maxAttr];
        boolean[][] attributes = new boolean[maxAnimals][maxAttr]; // aniamls attributes used to guess the animal
        boolean[] possibleAnimals = new boolean[maxAnimals]; // all possible animals the user is thinking of, if only one left it's solved!
        
        //define scanners
        FileReader dbReader = new FileReader("db.txt");
        Scanner dbScanner = new Scanner (dbReader);
        Scanner userInput = new Scanner (System.in);

        //read first line of data
        dbScanner.next(); //word animal
        for (int a=0; a < maxAttr; a++) {
            attributeNames[a]=dbScanner.next();
        }

        //read file into array
        int numAnimals = 0;
        while(dbScanner.hasNext()){
            animals[numAnimals] =  dbScanner.next(); //read column names
            //System.out.println("animal = " + animals[numAnimals]);
            for (int a = 0; a < maxAttr ; a++) {         
                attributes[numAnimals][a] = dbScanner.nextBoolean();
            }
            numAnimals++;
        }
        
        //show all data
        for (int i =0; i < numAnimals; i++) {
            //System.out.print(animals[i]);
            for (int j=0; j<maxAttr; j++) {
              //System.out.print(", "+attributeNames[j]+" = "+attributes[i][j]);
            }
            //System.out.println("");
        }
        
        //*****play game here******
        boolean solved = false;
        boolean solvable = true;
        String questionAsked = "";
        
        // stays here until the animal is guessed OR determined not solvable 
        //(e.g. five possibles animals left after all questions asked)
        
        while((! solved ) && (solvable)){
            
            for ( int q = 0; q < maxAttr; q ++){
                
                //set question to ask user
                if (q == 0){
                    questionAsked = "Does your animal have a backbone? ";
                }
                if (q == 1){
                    questionAsked = "Does your animal live on land? ";
                }
                if (q == 2){
                    questionAsked = "Can your animal give birth? ";
                }
                if (q == 3){
                    questionAsked = "Does your animal breathe through its lungs? ";
                }
                if (q == 4){
                    questionAsked = "Does your animal have four legs? ";
                }
                if (q == 5){
                    questionAsked = "Can your animal fly? ";
                }
                if (q == 6){
                    questionAsked = "Is your animal warm-blooded? ";
                }
                if (q == 7){
                    questionAsked = "Does your animal breath through its skin? ";
                }
                if (q == 8){
                    questionAsked = "Can your animal swim? ";
                }
                if (q == 9){
                    questionAsked = "Does your animal have scales? ";
                }
                
                //make sure the user typed a valid input
                boolean validInput = false;
                String userTyped = "";
                
                //keeps the user trapped here until they enter an acceptable input
                while(! validInput ){
                    System.out.print(questionAsked);
                    userTyped = userInput.next();
                    if (((userTyped.equalsIgnoreCase("yes") || (userTyped.equalsIgnoreCase("no"))))){
                        validInput = true;
                    }
                    else{
                        System.out.println("");
                        System.out.println("***Please type 'yes' or 'no'***");
                        System.out.println("");
                    }
                }
                
                //process input by looking at how many animals are still possible guesses
                //elminate some animals according to their answers to the questions
                //still have to do this part, basically last man standing thing
                
                
                

                
                
                
                
                //if still not solved after you ask all questions mark as unsolvable
                if (q==9) {
                    if (! solved) solvable=false;
                }
                
            }
        }
    }
 }
    
