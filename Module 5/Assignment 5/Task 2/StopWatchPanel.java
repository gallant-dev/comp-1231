
//StopWatchPanel.java
//MATH 1231 - Assignment 5 - Task 2
//Adam Gallant T00632271
//
//Imports java.swing for the J components. 
//Imports java.awt.* and java.awt.event for ActionListener and Button Listener.
//Imports java.util.* for the Scanner.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.time.Duration;


//The public StopWatchPanel class that contains the the configuration for the appearance of the
//panel and it's sub components.
public class StopWatchPanel extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    //Private JComponents used.
    private JLabel timeLabel;   
    private JLabel timeValueLabel;
    private JPanel buttonPanel;
    private JButton startButton;
    private JButton resetButton;

    //Initializes Integer time counter, and the Timer with a 100 millisecond delay calling the MillisecondListener.
    private Integer time = 0;
    Timer timer = new Timer(100, new MillisecondListener());

    //Constructor for the StopWatchPanel.
    public StopWatchPanel(){
        //Set a BorderLayour with a horizontal margin of 0 and a vertical margin of 5. Also
        //sets the background colour and the window size.
        setLayout(new BorderLayout(0, 5));    
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(100, 200));

        //Text, Font and Colour settings for the timeLabel.
        timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        timeLabel.setForeground(Color.WHITE);

        //Text, Font and Colour settings for the timeValueLabel.
        timeValueLabel = new JLabel("00:00:0");
        timeValueLabel.setForeground(Color.WHITE);
        timeValueLabel.setFont(new Font("Helvetica", Font.BOLD, 24));
        timeValueLabel.setHorizontalAlignment(JLabel.CENTER);
        
        //Creates the panel for the JButtons, and sets a GridLayout.
        //Creates the Start and Rest buttons and sets the preferred size.
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3));
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100, 20));
        buttonPanel.add(startButton);
        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(100, 20));
        buttonPanel.add(resetButton);

        //Adds the Buttons to the panel for the buttons.
        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);

        //Add Components to their BorderLayout positions.
        add(timeLabel, BorderLayout.NORTH);
        add(timeValueLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        //Adds the ActionListener to the start button and sets its background colour.
        //Also adds the Mnemonics for the Start Button.
        ButtonListener buttonListener = new ButtonListener();
        startButton.addActionListener(buttonListener);
        startButton.setBackground(Color.GRAY);
        startButton.setMnemonic(KeyEvent.VK_S);

        //Adds the ActionListener to the reset button and sets its background colour.
        //Also adds the Mnemonics for the Reset Button.
        resetButton.addActionListener(buttonListener);
        resetButton.setBackground(Color.GRAY);
        resetButton.setMnemonic(KeyEvent.VK_R);
    }

    

    //ButtonListener class that Stops and Starts the timer if the Start Button is pressed, and
    //resets the timer if the Reset button is pressed.
    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            if(event.getSource() == startButton){
                if(!timer.isRunning()){
                    startButton.setText("Stop");
                    timer.start();
                }
                else
                {
                    startButton.setText("Start");
                    timer.stop();
                }
            }
            else if (event.getSource() == resetButton){
                timer.stop();
                time = 0;
                timeValueLabel.setText("0 : 0 : 0");       
            }else{
                return;
            }
        }
    }

    //MillisecondListener adds 100 milliseconds to the time counter when it is called,
    //converts the millisecond counter to a Duration and then uses that Duration to convert to a
    //usable clock format and sets the timeValueLabel with it.
    public class MillisecondListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            time += 100;
            Duration duration = Duration.ofMillis(time);
            timeValueLabel.setText(duration.toHours()+" : "+duration.toMinutesPart()+" : "+duration.toSecondsPart()+"."+duration.toMillisPart()/100);
        }
    }
}