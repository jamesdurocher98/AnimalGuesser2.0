
package animalguesser2.pkg0;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnimalGuesser20 {

    
    
    public static void main(String[] args) throws IOException {
    
        int maxAnimals = 25; //cols
        int maxAttr = 6; //rows
        
        String[] animals = new String[maxAnimals];
        String[] attributeNames = new String[maxAttr];
        boolean[][] attributes = new boolean[maxAnimals][maxAttr];
        
        FileReader dbReader = new FileReader("db.txt");
        Scanner dbScanner = new Scanner (dbReader);
        Scanner userInput = new Scanner (System.in);

        //read attribute names
        dbScanner.next(); //word animal
        for (int a=0; a < maxAttr; a++) {
            attributeNames[a]=dbScanner.next();
        }

        int numAnimals = 0;

        while(dbScanner.hasNext()){
            
            animals[numAnimals] =  dbScanner.next();
            
            for (int a = 0; a < maxAttr ; a++) {         
                attributes[numAnimals][a] = dbScanner.nextBoolean();
            }
            numAnimals++;
        }
        //play game here
        boolean solved = false;
        boolean solvable = true;
        String questionAsked = "";
        
        while((! solved ) && (solvable)){
            //q - question 
            for ( int q = 0; q < maxAttr; q ++){
                
                if (q == 0){
                    System.out.println("Does your animal have a backbone? ");
                }
                if (q == 1){
                    System.out.println("Does your animal live on land? ");
                }
                if (q == 2){
                    System.out.println("Can your animal give birth? ");
                }
                if (q == 3){
                    System.out.println("Does your animal breathe through its lungs? ");
                }
                if (q == 4){
                    System.out.println("Does your animal have four legs? ");
                }
                if (q == 5){
                    System.out.println("Can your animal fly? ");
                }
                
                //make sure the user typed a valid input
                boolean validInput = false;
                String userTyped = "";
                
                while(! validInput ){
                    //keeps the user 'trapped' until they enter an acceptable input
                    userTyped = userInput.next();
                    if (((userTyped.equalsIgnoreCase("yes") || (userTyped.equalsIgnoreCase("no"))))){
                        validInput = true;
                    }
                    else{
                        System.out.println("\nSorry, you must answer 'yes' or 'no'");
                    }
                }
            }
        }
    }
 }
    
