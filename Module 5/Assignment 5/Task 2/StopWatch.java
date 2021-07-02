//StopWatch.java
//MATH 1231 - Assignment 5 - Task 2
//Adam Gallant T00632271
//
//Imports java.swing.BorderFactory for empty borders to make the application nicer looking, and java.swing.JFrame
//for to use JFrame.
import javax.swing.BorderFactory;
import javax.swing.JFrame;

//Public TextStats class containing the main method, that creates the TextStatsPanel and sets overall settings.
public class StopWatch{
    public static void main(String[] args){
        //Creates JFrame with the title Stop Watch, and sets Default Close operation to EXIT_ON_CLOSE.
        JFrame frame  = new JFrame("Stop Watch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creates a new StopWatchPanel and sets the empty border to a width of 5.
        StopWatchPanel panel = new StopWatchPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //Adds the panel to the JFrame, packs it, and sets it to be visible.
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}