import javax.swing.*;
import java.awt.*;

public class Container {
    
    public JFrame mainFrame;
    public ConnectFive gameScreen;
    public TitleScreen titleScreen;
    public WinnerScreen winnerScreen;

    public Container() {

        mainFrame = new JFrame();
        mainFrame.setSize(700, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        gameScreen = new ConnectFive(this);
        titleScreen = new TitleScreen(this);
        winnerScreen = new WinnerScreen(this);


        mainFrame.add(titleScreen); 
        mainFrame.add(winnerScreen);
        mainFrame.add(gameScreen);

    }

}
