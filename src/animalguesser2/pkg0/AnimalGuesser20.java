
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
        
    }
 }
    
