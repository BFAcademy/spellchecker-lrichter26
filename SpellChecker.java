import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SpellChecker
   {
      private List<String> dictionary = new ArrayList();
      
      // WRITE Your Methods HERE!
      public void printFirst(int x) {
         for (int i = 0; i < x; i++) {
            System.out.println(dictionary.get(i));
         }
      }
      public boolean spellcheck(String in) {
         for (String word : dictionary) {
            if (word.equals(in)) {
               return true;
            }
         }
         return false;
      }
      public void printStartsWith(String in) {
         for (String word : dictionary) {
            if (word.startsWith(in)) {
               System.out.println(word);
            }
         }
      }




      public SpellChecker() {
        // Let's use java.nio method readAllLines!
        try {
        List<String> lines = Files.readAllLines(Paths.get("dictionary.txt"));
        for (String word : lines) {
         if (word.length() == 4) {
            dictionary.add(word);
         }
         
        }
      }
      catch (Exception e) {}
        
        /* The old java.io.* Scan/File method of reading in files, replaced by java.nio above 
        // create File object
        File dictionaryFile = new File("dictionary.txt");
     
        //Create Scanner object to read File
        Scanner scan = new Scanner(dictionaryFile);
     
        // Reading each line of the file
        // and saving it in the array
        int i = 0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            dictionary[i] = line;
            i++;
        }
        scan.close();
    
     */
        
      }  // end of constructor
   }