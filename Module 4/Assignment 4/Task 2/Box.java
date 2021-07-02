//Box.java
//MATH 1231 - Assignment 4 - Task 2
//Adam Gallant T00632271
//
//Imports java.util for Scanner, and ArrayList
import java.util.*;
//Imports java.util.concurrent.ThreadLocalRandom for
//generating random ints with ThreadLocalRandom.
import java.util.concurrent.ThreadLocalRandom;

public class Box<T> {
    private ArrayList<T> box = new ArrayList<T>();

    //Constructor
    public Box(ArrayList<T> aList){
        for(int i = 0; i < aList.size(); i++){
            this.box.add(aList.get(i));
        }
    }

    //Adds an item to the Box.
    public void add(T item){
        box.add(item);
    }

    //Returns a true value of the size of the box is 0.
    public boolean isEmtpy(){
        switch(box.size()){
            case 0:
                return true;
            default:
                return false;
        }
    }

    //Draws an itme from the Box and then removes it from the Box so further pairings
    //can be done without double booking.
    public T drawItem(){
        if(isEmtpy()){
            return null;
        }
        else {
            int randomInt = ThreadLocalRandom.current().nextInt(0, box.size());
            T itemDrawn = box.get(randomInt);
            box.remove(randomInt);
            return itemDrawn;
        }
    }

    //Empties the Box
    public void emptyBox(){
        box.clear();
    }

    //Returns a String of the contents of the box with line breaks after each item
    //except the last.
    public String toString(){
        ListIterator<T> it = box.listIterator();
        it = box.listIterator();
        String string = "";

        while (it.hasNext()){
                //Insert a linebreak at the end of each line
                //except the last.
                String lineEnding = "\n";
                if(it.nextIndex() == box.size()-1){
                    lineEnding = "";
                }

                //Appends the next item and the lineEnding to the
                //end of the current string.
                string += it.next()+lineEnding;
        }

        return string;
    }
}