//MainTaskOne.java
//MATH 1231 - Assignment 3 - Task 1
//Adam Gallant T00632271
//
//Imports java.util for Scanner, and 
//java.util.stream for IntStream
import java.util.*;
import java.util.stream.*;

//The class that collects
//10 input integers and displays
//the total and average to the user.
public class MainTaskOne
{
    //The main method
    public static void main ( String[] a){
        //Create new scanner.
        Scanner scan = new Scanner (System.in);
        
        //Create a new array of length 10 to
        //assign user input values in.
        int[] inputs = new int[10];
        
        //A counter int to count
        //when enough inputs have been filled to
        //fill the array.
        int count = 0;
        
        //A while loop that checks if  the counter has reached
        //the length of the input array.
        while(count < inputs.length){

            //Prompt the user for an integer,
            //if it's not an integer catch the exception
            //and prompt the user to enter an integer.
            try
            {
                System.out.print("Enter an integer: ");
                inputs[count]  = Integer.parseInt(scan.nextLine());
                count++;
            }
            catch(NumberFormatException | InputMismatchException ex)
            {
                System.out.println("Input was not an integer. Please enter an integer...");
            }
        }
        
        //Print the sum of the integers and the average. 
        System.out.println("The total sum is "+ IntStream.of(inputs).sum());
        System.out.println("The average is "+ IntStream.of(inputs).sum()/inputs.length);
        scan.close();
    }
}

