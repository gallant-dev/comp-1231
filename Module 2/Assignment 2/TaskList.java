//TaskList.java
//MATH 1231 - Assignment 2
//Adam Gallant T00632271
//
//Imports the requried utility classes for
//sorting arrays.
import java.util.Arrays;
import java.util.Collections;

//Represents a TaskList with the ability to get, set, and 
//compare.
public class TaskList {
    //Private list of tasks
    private Task[] taskList;

    //Constructor
    public TaskList ()
    {
        taskList = new Task[]{
            new Task(4, "Send email to engineering department."),
            new Task(1, "Look at pictures of cats on the internet."),
            new Task(6, "Call 911 for neighbour collapsed on the floor."),
            new Task(2, "Try the new Poppa Johns that opened up."),
            new Task(3, "Trim the back hedge."),
            new Task(6, "Use the washroom."),
            new Task(5, "Take out garbage.")
        };

        //Sorts the tasks by priority with the highest priority first.
        Arrays.sort(taskList, Collections.reverseOrder());
    }

    //Override toString method.
    public String toString(){
        String taskString = "";
        //Prints the tasks in their current order.
        for(int i = 0; i < taskList.length; i++){
            taskString +=taskList[i].toString()+"\n";
        };
        
        return taskString;
    }
}