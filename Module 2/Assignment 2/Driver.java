//Driver.java
//MATH 1231 - Assignment 2
//Adam Gallant T00632271
//
//Represents a Driver that creates a list of tasks
//and prints them.
public class Driver {

    public static void main(String[] args)
    {
        //An array of new tasks.
        TaskList tasks = new TaskList(); 

        //Prints the the tasks.
        System.out.println(tasks.toString());
    }
}