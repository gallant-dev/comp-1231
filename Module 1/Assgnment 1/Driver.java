//Driver.java
//MATH 1231 - Assignment 1
//Adam Gallant T00632271
//
//Represents a Driver that creates and returns
//details about shapes.
public class Driver
{
    public static void main(String[] args)
    {
        //Creates one of each of the defined shape types.

        Sphere sphere = new Sphere("Sphere", 1);
        Cube cube = new Cube("Cube", 2);
        Cylinder cylinder = new Cylinder("Cylinder", 3, 10);
        Shape[] shapes = new Shape[] {sphere, cube, cylinder};
        
        //Print information about the created shapes.
        for(int i = 0; i < shapes.length; i++){
            System.out.println(shapes[i].toString());
        };
    }
}