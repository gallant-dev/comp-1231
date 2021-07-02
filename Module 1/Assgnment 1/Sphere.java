//Sphere.java
//MATH 1231 - Assignment 1
//Adam Gallant T00632271
//
//Imports the math utilities for calculating
//surface area and volume.
import java.lang.Math;

//Represents a Sphere, with
//radius, variables and methods.
public class Sphere extends Shape
{
    private double radius;

    //The constructor method sets up
    //the Sphere with the specified value.
    public Sphere(String newName, double newRadius){
        super(newName);

        radius = newRadius;
    }

    //The two string returns the shape
    //data.
    public String toString(){
        return "Name: " + this.getName() +
         ", Radius: " + this.getRadius() +
         ", Surface Area: " + this.calculateSurfaceArea() +
         ", Volume: " + this.calculateVolume();
    }

    //Calculates the surface area.
    public double calculateSurfaceArea(){
        return Math.round(4 * Math.PI * Math.pow(radius, 2));  
    }

    //Calculates the volume.
    public double calculateVolume(){
        return Math.round(4/3 * Math.PI * Math.pow(radius, 3));
    }

    //The mutator sets the radius to a
    //new value.
    public void setRadius(double newRadius){
        radius = newRadius;
    }

    //The accessor returns the current
    //value of the radius.
    public double getRadius(){
        return radius;
    }   
}