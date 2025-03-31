import javax.swing.*;
import java.awt.*;

public class Runner {
    public static void main(String[] args) {
       
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(700, 700);

        ConnectFive mainGame = new ConnectFive(mainFrame);
        TitleScreen titleScrren = new TitleScreen(mainFrame, mainGame);
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);


        mainFrame.add(titleScrren);
        mainFrame.add(mainGame);

    }
}
