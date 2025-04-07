import javax.swing.*;

// Container class to hold all JPanels and JFrame
// This container class is used to make it easier to access individual JPanels and alter things such as their visiability
// To add, this container class also allows us to changes what components are show on the main Framwe
public class Container {
    
    // Define mainFrame JFrame, along with gameScreen, and titleScreen
    public JFrame mainFrame;
    public ConnectFive gameScreen;
    public TitleScreen titleScreen;

    public Container() {

        // Setup JFrame to hold all JPanels
        mainFrame = new JFrame();
        mainFrame.setSize(700, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        // Create new game screen and title screen JPanels
        gameScreen = new ConnectFive(this);
        titleScreen = new TitleScreen(this);

        // add game screen and title screen JPanels to mainFrame
        mainFrame.add(titleScreen); 
        mainFrame.add(gameScreen);

        // Paint the JFrame
        mainFrame.repaint();
    }

}