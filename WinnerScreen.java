import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// JPanel to display winner screen
public class WinnerScreen extends JPanel {

    // Container to hold refrence to container of program
    public Container container;

    // Define back to title button using JButton
    private JButton titleButton;

    // Define titles using JLabel
    private JLabel titleOne;
    private JLabel titleTwo;

    public WinnerScreen(Container container) {

        // Sets up JPanel
        this.setSize(700, 700);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(null);

        // Holds a refrence to the container that holds all JPanels and main JFrame, allowing each JPanel to control other JPanels
        // This is importatnt as we need to alter the visiblilty of different JPanels from inside of other JPanels
        this.container = container;

        // Sets up first title
        titleOne = new JLabel();
        titleOne.setFont(new Font("Serif", Font.BOLD, 36));

        // Sets up second title
        titleTwo = new JLabel("WINS!");
        titleTwo.setFont(new Font("Serif", Font.BOLD, 36));
        titleTwo.setForeground(Color.GRAY);

        if (container.gameScreen.isTie) {

            // If the game was a tie, set the text as "TIE!" and the color to gray
            titleOne.setText("TIE!");
            titleOne.setForeground(Color.GRAY);
            titleOne.setBounds(310, 200, 300, 50);


        } else if (container.gameScreen.currPlayer) {

            // If the blue won, set the text as blue and the color to blue
            // Keep in mind when disc is dropped, the turn will switch thus, the opposite is done here
            titleOne.setText("BLUE");
            titleOne.setForeground(Color.BLUE);
            titleOne.setBounds(245, 200, 300, 50);

            titleTwo.setBounds(355, 200, 300, 50);

        } else if (!(container.gameScreen.currPlayer)) {

            
            // If the red won, set the text as red and the color to red
            // Keep in mind when disc is dropped, the turn will switch thus, the opposite is done here
            titleOne.setText("RED");
            titleOne.setForeground(Color.RED);
            titleOne.setBounds(250, 200, 300, 50);

            titleTwo.setBounds(355, 200, 300, 50);

        }

        // Add titles to the JPanel
        this.add(titleOne);
        this.add(titleTwo);

        // Setup back to title button using JButton
        titleButton = new JButton("Back To Title");
        titleButton.setBounds(200, 400, 300, 50);
        titleButton.setFont(new Font("Serif", Font.BOLD, 20));
        titleButton.setBackground(Color.GRAY);

        // Add back to title button to JPanel
        this.add(titleButton);

        // Add action listener for back to title button
        titleListener tl = new titleListener();
        titleButton.addActionListener(tl);

    }

    // Private method to switch to title screen
    private void switchTitle() {

       this.setVisible(false); // Sets the winner screen as not visiable
       container.mainFrame.remove(this); // removes this instance of the winner screen from the mainFrame
       container.titleScreen.setVisible(true); // Sets the title screen to visiable

    }

    // Action listener for back to title button
    private class titleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // If back to title button is clicked, switch to the title screen
           switchTitle();

        }

    }
    
}