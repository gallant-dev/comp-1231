
//MainTaskTwo.java
//MATH 1231 - Assignment 3 - Task 2
//Adam Gallant T00632271
//
//Import the java.io to read and write to files
//using BufferedReader, FileReader, and FileWriter.
import java.io.*;
import java.util.*;

//The class that reads
//book titles from a input file and
//writes them to an ouput file.
public class MainTaskTwo {

    //The main method run by the program.
    public static void main (String[] args){
        //The name of the input and output files.
        String inputFileName = "bookTitles.inp";
        String outputFileName = "uniqueTitles.out";

        //A string to hold the line references.
        String line;

        //Attempts to create use file writer to write the output file.
        //If unsuccessful it warns the user that there was difficulty writing the file.
        try
        {
            FileWriter out = new FileWriter(outputFileName);
            
            //Attemps to read the input file, if an exception is thrown it
            //warns the user that there was difficulty reading the file.
            try
            {
                BufferedReader in = new BufferedReader(new FileReader(inputFileName));

                //Reads the first line.
                line = in.readLine();
                
                List<String> titles = new ArrayList<>();

                //Adds the book titles found to the
                //titles list, while their are lines to add.
                while(line != null)
                {
                    titles.add(line);

                    //Assigns the next line value in the input file to the
                    //line string.
                    line = in.readLine();
                }

                //Use a LinkedHashSet to remove the duplicates and
                //retain order.
                Set<String> uniqueTitles = new LinkedHashSet<>(titles);

                //Clear the existing contents of the lines list.
                //add the Set to 
                titles.clear();
                titles.addAll(uniqueTitles);

                //Displays the unique titles to the user and
                //writes them to the output file.
                for(int i = 0; i < titles.size(); i++)
                {
                    //Insert a linebreak at the end of each line
                    //except the last.
                    String lineEnding = "\n";
                    if(i == titles.size()-1){
                        lineEnding = "";
                    }

                    //Write to output file and display to user.
                    out.write(titles.get(i)+lineEnding);
                    System.out.println(titles.get(i));
                }

                //Closes the input file.
                in.close();
                System.out.println("Output Complete! "+titles.size()+" unique titles.");
            }
            catch (IOException ex)
            {
                System.out.println("Difficulty reading "+inputFileName);
            }

            //Closes the output file.
            out.close();
        }
        catch (IOException ex)
        {
            System.out.println("Difficulty writing "+outputFileName);
        }

    }  
}