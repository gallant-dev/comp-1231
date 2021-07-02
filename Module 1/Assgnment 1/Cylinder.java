//Cylinder.java
//MATH 1231 - Assignment 1
//Adam Gallant T00632271
//
//Imports the math utilities for calculating
//surface area and volume.
import java.lang.Math;

//Represents a Cylinder, with
//radius and height, variables and methods.
public class Cylinder extends Shape
{
    private double radius;
    private double height;

    //The constructor method sets up
    //the Cylinder with the specified value.
    public Cylinder(String newName, double newRadius, double newHeight){
        super(newName);

        radius = newRadius;
        height = newHeight;
    }

    
    //The two string returns the shape
    //data.
    public String toString(){
        return "Name: " + this.getName() +
         ", Radius: " + this.getRadius() +
          ", Height: " + this.getHeight()+
          ", Surface Area: " + this.calculateSurfaceArea() +
          ", Volume: " + this.calculateVolume();
    }

    //Calculates the surface area.
    public double calculateSurfaceArea(){
        return Math.round(2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2));  
    }

    //Calculates the volume.
    public double calculateVolume(){
        return Math.round(Math.PI * Math.pow(radius, 2) * height);
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
    
    //The mutator sets the height to a
    //new value.
    public void setHeight(double newHeight){
        height = newHeight;
    }

    //The accessor returns the current
    //value of the height.
    public double getHeight(){
        return height;
    }   
}