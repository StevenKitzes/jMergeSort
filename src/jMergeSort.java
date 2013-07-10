/**
 * Created with IntelliJ IDEA.
 * User: Steven Kitzes
 * Date: 7/9/13
 * Time: 7:20 AM
 * To change this template use File | Settings | File Templates.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//  This is a program I'm writing to teach myself the Merge Sort technique.
//      I chose to write it in Java because the university I'm applying to teaches
//      their computer science curriculum in Java, and I want to familiarize myself
//      with the language so I'll be ready when courses begin.
public class jMergeSort {

    //  The main method of the program begins here.
    public static void main(String[] args) {

        /*
        //  I wrote this block to get myself a beginner's familiarity with how
        //      console input is handled in Java.  It isn't really useful to
        //      the rest of the program.

        //  String variable to hold the expected user input.
        String input = "";

        //  According to the IDE I'm using, collecting console input in this way
        //      (using the BufferedReader class) requires that input be gathered
        //      within a try-catch block, so here it is!
        try {
            System.out.println("Let's try to enter some text:");
            //  Initialize a BufferedReader object to an InputStream object that reads
            //      input from console.
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

            //  Assign console input to the 'input' String variable
            input = bReader.readLine();
        } catch (IOException ioe) {
            System.out.println("FATAL ERROR:");
            ioe.printStackTrace();
        }   //  try-catch end

        if (input.equals("")) {
            System.out.println("No input was given.  Tragedy!");
        }
        else {
            System.out.println("User input: " + input);
        }
        */

        //  An array of Sortable objects, to be sorted.  Declaring an array
        //      in this way does not define any of the Sortable objects in
        //      the array I am declaring.  I'm just making space for them.
        Sortable[] sortables = new Sortable[10];

        //  Assign each array slot a new Sortable with no argument passed.
        for (int i = 0; i < sortables.length; i++) {
            sortables[i] = new Sortable();
        }

        //  Print values of all Sortable objects in the array.
        System.out.print("We have Sortable objects with values ");
        for (int i = 0; i < sortables.length; i++) {
            System.out.print(sortables[i].getValue() + ", ");
        }
        System.out.println("and that's all of 'em!");

        //  Check equivalence using overridden .equals() method.
        for( int i = 0; i < (sortables.length - 1); i++ ) {
            if(sortables[i].equals(sortables[i+1])) {
                System.out.println("sortables[" + i + "] equals sortables[" + (i+1) + "]!");
            }
            else {
                System.out.println("sortables[" + i + "] does not equal sortables[" + (i+1) + "]!");
            }
        }

        //  Create two Sortable objects with known equivalence to check that my
        //      overridden .equals() method works correctly.
        Sortable s1 = new Sortable(23);
        Sortable s2 = new Sortable(23);
        System.out.println(s1.equals(s2));
        System.out.println("s1's value is: "+s1.toString());


    }
}
