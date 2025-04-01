import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;

import java.awt.event.*;
import java.awt.*;


public class WinnerScreen extends JPanel {

    public Container container;

    private JButton titleButton;

    private JLabel titleOne;
    private JLabel titleTwo;

    public WinnerScreen(Container container) {

        this.setSize(700, 700);
        this.setBackground(Color.BLACK);
        this.setVisible(false);
        this.setLayout(null);

        this.container = container;

        if (container.gameScreen.currPlayer) {

            titleOne = new JLabel("RED PLAYER");
            titleOne.setFont(new Font("Serif", Font.BOLD, 36));
            titleOne.setForeground(Color.RED);
            titleOne.setBounds(200, 200, 300, 50);

        } else {

            titleOne = new JLabel("BLUE PLAYER");
            titleOne.setFont(new Font("Serif", Font.BOLD, 36));
            titleOne.setForeground(Color.BLUE);
            titleOne.setBounds(200, 200, 300, 50);
        
        }

        titleTwo = new JLabel("WINS!");
        titleTwo.setFont(new Font("Serif", Font.BOLD, 36));
        titleTwo.setForeground(Color.GRAY);
        titleTwo.setBounds(400, 200, 300, 50);

        this.add(titleOne);
        this.add(titleTwo);

        titleButton = new JButton("Back To Title");
        titleButton.setBounds(200, 400, 300, 50);
        titleButton.setFont(new Font("Serif", Font.BOLD, 20));
        titleButton.setBackground(Color.GRAY);

    
        this.add(titleButton);

        titleListener tl = new titleListener();
        titleButton.addActionListener(tl);

    }

    private void switchGame() {

       this.setVisible(false);
       container.titleScreen.setVisible(true);

    }
 
    private class titleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

           switchGame();

        }

    }
    
}
