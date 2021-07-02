//Parade.java
//MATH 1231 - Assignment 4 - Task 1
//Adam Gallant T00632271
//
//Imports java.util for Scanner, and ArrayList
import java.util.*;

//The Parade class that generates an ArrayList
//and allows users to add, remove and print the contents.
public class Parade
{
    //The main method
    public static void main ( String[] a){
        //Create new scanner.
        Scanner scan = new Scanner (System.in);

        //Create an ArrayList and populate it with default values.
        ArrayList<String> clowns  = new ArrayList<String>();
        String[] starterClowns = {"Adam Gallant",
                                    "Donald Trump",
                                    "Bobo",
                                    "Bonzo",
                                    "Princess"};

        for(int i = 0; i < starterClowns.length; i++){
            clowns.add(starterClowns[i]);
        }

        //Create an input variable to store user input from the scanner.
        String input = null;
        
        //A while loop that checks if  the user has entered an input
        //and then either adds a clown to the end, removes a clown from the start,
        //or prints the clowns in the parade to the screen.
        while(input == null){

            //Prompt the user for input,
            //a for add, r for remove, and p for print.
            //If an input different from these is detected informs the user
            //that they need to enter an acceptable input.
            try
            {
                System.out.print("Would you like to (a)dd or (r)emove a clown? Or (p)rint the clowns in the parade?" );
                String selection = scan.nextLine();
                switch (selection) {
                    case "a":
                    case "A":
                        System.out.println("Please enter a clown name: ");
                        String name = scan.nextLine();
                        clowns.add(name);
                        input = null;
                        break;
                    case "r":
                    case "R":
                        System.out.println("A clown has been removed!");
                        clowns.remove(0);
                        input = null;
                        break;
                    case "p":
                    case "P":
                        ListIterator<String> list = clowns.listIterator();
                        list = clowns.listIterator();
                        System.out.println("The parade includes the following clowns: ");
                        while (list.hasNext())
                            System.out.println(list.next());
                        input = null;
                        break;
                    default:
                        System.out.println("INVALID SELECTION - Would you like to (a)dd or (r)emove a clown? Or (p)rint the clowns in the parade?");
                        clowns.remove(0);
                        input = null;
                        break;                    
                }

            }
            catch(NoSuchElementException | IllegalStateException ex)
            {
                System.out.println("The scanner was not able to detect an input element.");
            }
        }

        scan.close();
    }
}

