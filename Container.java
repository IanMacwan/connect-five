import javax.swing.*;

public class Container {
    
    public JFrame mainFrame;
    public ConnectFive gameScreen;
    public TitleScreen titleScreen;

    public Container() {

        mainFrame = new JFrame();
        mainFrame.setSize(700, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        gameScreen = new ConnectFive(this);
        titleScreen = new TitleScreen(this);


        mainFrame.add(titleScreen); 
        mainFrame.add(gameScreen);

    }

}
