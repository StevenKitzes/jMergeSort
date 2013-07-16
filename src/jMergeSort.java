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

        sortables = mergeSort(sortables);

        Sortable[] oddList = new Sortable[11];
        for (int i = 0; i < oddList.length; i++) {
            oddList[i] = new Sortable();
        }
        oddList = mergeSort(oddList);

    }

    public static Sortable[] mergeSort(Sortable[] list) {
        int length = list.length;
        System.out.println("- - - - -\nList was passed into mergeSort() with length: "+length);
        System.out.print("Contents: ");
        for( int i = 0; i < length; i++ ) {
            System.out.print((i==0?"":", ")+list[i].getValue());
        }
        System.out.println(".");

        if(length <= 1) {
            return list;
        }

        int halfLength = (int)length / 2;
        Sortable[] half1 = new Sortable[halfLength];
        Sortable[] half2 = new Sortable[length - halfLength];

        for( int i = 0; i < length; i++ ) {
            if( i < halfLength ) {
                half1[i] = list[i];
            }
            else {
                half2[i-halfLength] = list[i];
            }
        }

        half1 = mergeSort(half1);
        half2 = mergeSort(half2);

        int stepper1 = 0, stepper2 = 0;

        for( int i = 0; i < length; i++ ) {
            if( stepper1 == half1.length ) {
                list[i] = half2[stepper2];
                stepper2++;
            }
            else if( stepper2 == half2.length) {
                list[i] = half1[stepper1];
                stepper1++;
            }
            else if( half1[stepper1].getValue() < half2[stepper2].getValue() ) {
                list[i] = half1[stepper1];
                stepper1++;
            }
            else {
                list[i] = half2[stepper2];
                stepper2++;
            }
        }

        System.out.print("Returning list: ");
        for( int i = 0; i < length; i++ ) {
            System.out.print((i==0?"":", ")+list[i].getValue());
        }
        System.out.println(".");
        return list;
    }
}
