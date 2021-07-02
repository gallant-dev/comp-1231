//Priority.java
//MATH 1231 - Assignment 2
//Adam Gallant T00632271
//
//Represents a interface for priorities.
public interface Priority {
    static final Rank RANKS[] = new Rank[]{
        new Rank(1, "Lowest Possible Priority"),
        new Rank(2, "Can be done within a year."),
        new Rank(3, "Can be done within a month."),
        new Rank(4, "Can be done within a week."),
        new Rank(5, "Can be done within a day."),
        new Rank(6, "Must be done now.")
    }; 
    //Interface functions for setting and getting priorities.
    void setPriority(int rank);
    Rank getPriority();
}
