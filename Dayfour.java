import java.util.Arrays;
import java.util.Scanner;


import java.io.File;
import java.io.FileNotFoundException;

public class Dayfour {

    private static boolean isValid (String input) {
       
        String [] duplicates = input.split(" ");

        for (int i = 0; i < duplicates.length; i++) {
            for (int j = 0; j < duplicates.length; j++) {
                if (duplicates[i].equals(duplicates[j]) && i != j) {
                    
                    return false;
                    
                }   
            }
        }

        return true;
    }

    /**
     * to find anagrams I want to do the following: get the string as input
     * convert it into a char array
     * sort it
     * transform it back into a string
     */

    private static boolean isValidWithAnagrams (String input) {
        //String test = "oiii ioii iioi iiio";
        String [] anagram = input.split(" ");
        char [] a;
        char [] b;
        String sorteda;
        String sortedb;

            for (int i = 0; i < anagram.length; i++) {
                System.out.println ("Debug: anagram[i] is: " + anagram[i]);
                a = anagram[i].toCharArray();
                Arrays.sort(a);
                sorteda = new String(a);

                for (int j = 0; j < anagram.length; j++) {

                    b = anagram[j].toCharArray();
                    Arrays.sort(b);
                    sortedb = new String(b);
                    
                    if(sorteda.equals(sortedb) && i != j) {
                        return false;

                    }
                }
            }

        return true;
    }

    private static int calcValid () {

       // int result = 0; 
        int result2 = 0;
       // boolean valid;
        boolean valid2;

        try {

            Scanner fileinput = extracted().useDelimiter("\n");

            while (fileinput.hasNext()) {

                //valid = isValid(fileinput.next());
                valid2 = isValidWithAnagrams(fileinput.next());
                if(valid2) {
                    result2 += 1;
                }

                /*if (valid) {
                    result += 1;
                }*/
               
            }

            fileinput.close();

        } catch(FileNotFoundException e) {

            System.out.println("File not found!");
            e.printStackTrace();

        }
       
        return result2;

    }

	private static Scanner extracted() throws FileNotFoundException {
		return new Scanner(new File("input.txt"));
	}

    public static void main(String[] args) {
        int result;
        result = calcValid();
        System.out.println(result);
        
        
    }
}