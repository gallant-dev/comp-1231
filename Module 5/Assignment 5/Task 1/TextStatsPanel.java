//TextStatsPanel.java
//MATH 1231 - Assignment 5 - Task 1
//Adam Gallant T00632271
//
//Imports java.swing for BorderFactory and all the J components. 
//Imports java.awt.* and java.awt.event for ActionListener and Button Listener.
//Imports java.util.* for the Scanner.
//Imports java.text.NumberFormat to round Double to 2 decimal places.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.NumberFormat;


//The public TextStatsPanel class that contains the the configuration for the appearance of the
//panel and it's sub components.
public class TextStatsPanel extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    //Private JComponents used.
    private JLabel textAreaLabel;   
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JPanel statDisplayPanel;
    private JLabel letterCount;
    private JLabel wordCount;
    private JLabel averageWordLength;
    private JButton analyse;

    //Constructor for the TextStatsPanel.
    public TextStatsPanel(){
        //Set a BorderLayour with a horizontal margin of 0 and a vertical margin of 5. Also
        //sets the background colour and the window size.
        setLayout(new BorderLayout(0,5));    
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(500, 400));

        //Text, Font and Colour settings for the textAreaLabel.
        textAreaLabel = new JLabel("Enter the text to Analyse: ");
        textAreaLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        textAreaLabel.setForeground(Color.WHITE);

        //Creates a new JTextArea, sets the lines to wrap, and adds it to a 
        //JScrollPane.
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        scrollPane = new JScrollPane(textArea);
        
        //Creates the Analyse JButton.
        analyse = new JButton("Analyse");

        //Creates a new JPanel to group the stats for display. And then adds
        //the stat displays to it, with an empty border for styling.
        statDisplayPanel = new JPanel();
        letterCount = new JLabel("Letter Count: ");
        wordCount = new JLabel("Word Count: ");
        averageWordLength = new JLabel("Average Word Length: ");
        statDisplayPanel.setLayout(new BoxLayout(statDisplayPanel, BoxLayout.PAGE_AXIS));
        statDisplayPanel.add(letterCount);
        statDisplayPanel.add(wordCount);
        statDisplayPanel.add(averageWordLength);
        statDisplayPanel.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 8));

        //Add Components to their BorderLayout positions.
        add(textAreaLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(statDisplayPanel, BorderLayout.EAST);
        add(analyse, BorderLayout.SOUTH);

        //Adds the ActionListener to the bbutton and sets its background colour.
        analyse.addActionListener(new ButtonListener());
        analyse.setBackground(Color.GRAY);
    }

    //ButtonListener class that updates the stat labaels with the calculations.
    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            //Creates a two digit numberFormat for rounding Doubles.
            NumberFormat twoDigit = NumberFormat.getInstance();
            twoDigit.setMaximumFractionDigits(2);

            //Get's the entered text from the JTextArea.
            String text = textArea.getText();

            //Updates the labels with the calculated values.
            letterCount.setText("Letter Count: " + CountLetters(text));
            wordCount.setText("Word Count: " + CountWords(text));
            averageWordLength.setText("Average Word Length: " + twoDigit.format(AverageWordLength(text)));
        }
    }

    //Calculates the words by splitting the String on empty spaces. And then
    //counting the number of Strings created. Returns Integer.
    public static Integer CountWords(String string){
        //Generates a new scanner for parsing through the string data.
        Scanner scanner = new Scanner(string);
        //Initializes words array and count Integer.
        String[] words = {};
        Integer count = 0;

        //Tries to count the words after splitting the String. If
        //it throws an exception if the length of the array is greater than
        // 0 it sets the count to the length of the array, otherwise it sets 
        //the count to 0.
        try{
            while(scanner.hasNext()){
                String text = scanner.next();
    
                words = text.split(" ");
    
                count += words.length;
            }
        }
        catch(NoSuchElementException ex ){
            if(words.length > 0){
                count = words.length;
            }
            else{
                count = 0;
            }
        }

        //Closes the Scanner.
        scanner.close();

        //Returns the word count.
        return count;
    }

    //Counts the number of Letters in the String by removing characters that aren't
    //letters from the string and then counting the length of the string.
    public static Integer CountLetters(String string){
        //Creates a new Scanner and sets the intial count Integer to 0;
        Scanner scanner = new Scanner(string);
        Integer count = 0;

        //Tries to go through the string and remove anything that isn't a letter.
        //if it thrrows an exception because there is element it sets the count to 0.
        try{
            while(scanner.hasNext()){
                String text = scanner.next();
                
                String letters = text.replaceAll("[^a-zA-Z]", "");
    
                count += letters.length();
            }
        }
        catch(NoSuchElementException ex ){
            count = 0;
        }

        //Closes the scanner.
        scanner.close();
        //Returns the count as an Integer.
        return count;
    }

    //Calculates the AverageWordLength by taking in a string.
    //And then using the Count Words method and the Count Letters method to get the number of letters and words.
    //Then it divides the total number of letters by the total number of words to get the average word length.
    public static Double AverageWordLength(String string){
        Double wordCount = Double.valueOf(CountWords(string));
        Double letters = Double.valueOf(CountLetters(string));
        return letters/wordCount;
    }
}