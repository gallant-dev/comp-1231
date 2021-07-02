//Cube.java
//MATH 1231 - Assignment 1
//Adam Gallant T00632271
//
//Imports the math utilities for calculating
//surface area and volume.
import java.lang.Math;


//Represents a Cube, with
//width variables and methods.
public class Cube extends Shape
{
    private double width;

    //The constructor method sets up
    //the Square with the specified values.
    public Cube(String newName, double newWidth){
        super(newName);

        width = newWidth;
    }

    //The two string returns the shape
    //data.
    public String toString(){
        return "Name: " + this.getName() +
         ", Width: " + this.getWidth()+
         ", Surface Area: " + this.calculateSurfaceArea() +
         ", Volume: " + this.calculateVolume();
    }

    //Calculates the surface area.
    public double calculateSurfaceArea(){
        return Math.round(Math.pow(width, 2) * 6);  
    }

    //Calculates the volume.
    public double calculateVolume(){
        return Math.round(Math.pow(width, 3));
    }

    //The mutator sets the width to a
    //new value.
    public void setWidth(double newWidth){
        width = newWidth;
    }

    //The accessor returns the current
    //value of the width.
    public double getWidth(){
        return width;
    }   
}