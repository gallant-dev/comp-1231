//Task.java
//MATH 1231 - Assignment 2
//Adam Gallant T00632271
//
//Represents a Task with the ability to get, set, and 
//compare.
public class Task implements Priority, Comparable<Task> {
    //Private variables
    Rank priorityRank;
    String description;

    //Constructor
    public Task (int rank, String string){
        //When creating a task with a int for the rank 
        //the index needed in the array to access the
        //correct constant is 1 less than the int given.
        priorityRank = RANKS[rank-1];
        description = string;
    }

    //Get the current priority for the task.
    public Rank getPriority(){
        return priorityRank;
    }

    //Set the current priority for the taks.
    public void setPriority(int rank){
        priorityRank = RANKS[rank-1];
    }

    //Override toString method.
    public String toString(){
        return "Priority: "+priorityRank.value+", "+description + " "+priorityRank.description;
    }

    //Implementation of the compareTo method from the 
    //Comparables interface.
    public int compareTo(Task other){
        if(this.priorityRank.value < other.priorityRank.value)
            return -1;
        if(this.priorityRank.value > other.priorityRank.value)
            return +1;
        return 0;
    }
}