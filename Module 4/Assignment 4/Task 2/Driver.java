//Driver.java
//MATH 1231 - Assignment 4 - Task 2
//Adam Gallant T00632271
//
//Imports java.util for Scanner, and ArrayList
import java.util.*;

//The Driver class that build default values for the Boxs, and creates
//Boxes using the generic Box class. And then waits for user input to pull
//names and seating positions from the Boxes. 
public class Driver {

    public static void main (String[] args){
        //Create new scanner.
        Scanner scan = new Scanner (System.in);

        //Create ArrayLists for the defaultNames and default Seats to be used
        //to construct the appropriate Boxes.
        ArrayList<String> defaultNames = new ArrayList<String>();
        ArrayList<Integer> defaultSeats = new ArrayList<Integer>();

        //Creates an array of default names to be put into the names box, and 
        //adds them to the ArrayList.
        String[] namesString = {"Adam Gallant",
                                    "Donald Trump",
                                    "Bobo",
                                    "Bonzo",
                                    "Princess"};

        for(int i = 0; i < namesString.length; i++){
            defaultNames.add(namesString[i]);
        }

        //Adds default seating positions to the defaultSeats ArrayList.
        for(int i = 0; i <= 5; i++){
            defaultSeats.add(i);
        }
        
        //Constructs new Boxes, one for the defaultSeats, and one for the defaultNames.
        Box<String> names = new Box<String>(defaultNames);
        Box<Integer> seats = new Box<Integer>(defaultSeats);
     
        //Create an input variable to store user input from the scanner.
        String input = null;
        
        //A while loop that checks if  the user has entered an input
        //and then either draws a seating assignment, or resets the drawing pools.
        while(input == null){
        //Prompt the user for input,
        //'d' for draw and 'r' for reset.
        //If an input different from these is detected informs the user
        //that they need to enter an acceptable input.
            String initalPrompt = "Would you like to (d)raw seating from remaining names  and positions, or (r)eset drawing pools?";
            System.out.print(initalPrompt);
            String selection = scan.nextLine();
            switch (selection) {
                case "d":
                case "D":
                    //Tries to draw a seating arrangement and if it fails alerts the user of the pool(s) that are empty
                    try{
                        System.out.println(names.drawItem().toString() + " sitting in seat number " + seats.drawItem());
                        input = null;
                    }
                    catch (Exception e) {
                        System.out.println("Insufficient pool to draw from. Try reseting than trying again");
                        input = null;
                    }
                    break;
                case "r":
                case "R":
                    //Empties both boxes and then re-adds the default values to the boxes.
                    names.emptyBox();
                    seats.emptyBox();

                    for(int i = 0; i < namesString.length; i++){
                        names.add(namesString[i]);
                    }
            
                    for(int i = 1; i <= 5; i++){
                        seats.add(i);
                    }
                    System.out.println("Drawing pools have been reset!");
                    input = null;
                    break;
                default:
                    //Warns the user of an invalid user input and prompts them to try again.
                    System.out.println("INVALID SELECTION - "+initalPrompt);
                    input = null;
                    break;                    
            }
        }

        //Closes the scanner.
        scan.close();
    }
}