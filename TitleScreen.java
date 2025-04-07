import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// JPanel to display Title screen
public class TitleScreen extends JPanel {

    // Container to hold refrence to container of program
    public Container container;

    // Define play and exit button using JButton
    private JButton playButton;
    private JButton exitButton;

    // Define Title using JLabel
    private JLabel titleOne;
    private JLabel titleTwo;

    public TitleScreen(Container container) {

        // Sets up JPanel
        this.setSize(700, 700);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(null);

        // Holds a refrence to the container that holds all JPanels and main JFrame, allowing each JPanel to control other JPanels
        // This is importatnt as we need to alter the visiblilty of different JPanels from inside of other JPanels.
        this.container = container;

        // Sets up "CONNECT" title
        titleOne = new JLabel("CONNECT");
        titleOne.setFont(new Font("Serif", Font.BOLD, 36));
        titleOne.setForeground(Color.BLUE);
        titleOne.setBounds(200, 200, 300, 50);

        // Sets up "FIVE" title
        titleTwo = new JLabel("FIVE");
        titleTwo.setFont(new Font("Serif", Font.BOLD, 36));
        titleTwo.setForeground(Color.RED);
        titleTwo.setBounds(400, 200, 300, 50);

        // Adds the titles to the JPanel
        this.add(titleOne);
        this.add(titleTwo);

        // Sets up the play button
        playButton = new JButton("Play");
        playButton.setBounds(200, 400, 300, 50);
        playButton.setFont(new Font("Serif", Font.BOLD, 20));
        playButton.setBackground(Color.GRAY);

        // Sets up the exit button
        exitButton = new JButton("Exit");
        exitButton.setBounds(200, 475, 300, 50);
        exitButton.setFont(new Font("Serif", Font.BOLD, 20));
        exitButton.setBackground(Color.GRAY);
        
        // Adds the buttons to the JPanel
        this.add(playButton);
        this.add(exitButton);

        // Adds button action listeners
        playListener pl = new playListener();
        exitListener el = new exitListener();
        playButton.addActionListener(pl);
        exitButton.addActionListener(el);

    }

    // Private method to switch from title screen to game screen
    private void switchGame() {

        this.setVisible(false); // Sets the title screen as invisiable
        container.gameScreen.fillBoard(); // resets the game board
        container.gameScreen.setVisible(true); // sets the game screen as visiable

    }
    
    // Action listener for play button
    private class playListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // If play button is clicked, switch to game screen
           switchGame();

        }

    }

    // Action listener for exit button
    private class exitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // If exit button is clicked, exit program
            System.exit(0);

        }

    }
    
}