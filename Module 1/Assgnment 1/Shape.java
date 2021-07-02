//Shape.java
//MATH 1231 - Assignment 1
//Adam Gallant T00632271
//
//Represents a generic shape, with
//more specific shapes can be built off of.
abstract class Shape
{
    private String name;

    //The constructor sets up the shape,
    //with the specified name.
    public Shape(String newName){
        name = newName;
    }

    //The name mutator.
    public void setName(String newName){
        name = newName;
    }

    //The name accessor.
    public String getName(){
        return name;
    }

    //Abstract method calculate
    //Suraface Area.
    abstract double calculateSurfaceArea();

    //Abstract method calculate
    //Volume.
    abstract double calculateVolume();

}