import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;

import java.awt.event.*;
import java.awt.*;


public class TitleScreen extends JPanel {

    public Container container;

    private JButton playButton;
    private JButton exitButton;

    private JLabel titleOne;
    private JLabel titleTwo;

    public TitleScreen(Container container) {

        this.setSize(700, 700);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(null);

        this.container = container;

        titleOne = new JLabel("CONNECT");
        titleOne.setFont(new Font("Serif", Font.BOLD, 36));
        titleOne.setForeground(Color.BLUE);
        titleOne.setBounds(200, 200, 300, 50);

        titleTwo = new JLabel("FIVE");
        titleTwo.setFont(new Font("Serif", Font.BOLD, 36));
        titleTwo.setForeground(Color.RED);
        titleTwo.setBounds(400, 200, 300, 50);

        this.add(titleOne);
        this.add(titleTwo);

        playButton = new JButton("Play");
        playButton.setBounds(200, 400, 300, 50);
        playButton.setFont(new Font("Serif", Font.BOLD, 20));
        playButton.setBackground(Color.GRAY);

        exitButton = new JButton("Exit");
        exitButton.setBounds(200, 475, 300, 50);
        exitButton.setFont(new Font("Serif", Font.BOLD, 20));
        exitButton.setBackground(Color.GRAY);
    
        this.add(playButton);
        this.add(exitButton);

        playListener pl = new playListener();
        exitListener el = new exitListener();
        playButton.addActionListener(pl);
        exitButton.addActionListener(el);

    }

    private void switchGame() {

        this.setVisible(false);
        container.gameScreen.fillBoard();
        container.gameScreen.setVisible(true);

    }
 
    private class playListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

           switchGame();

        }

    }

    private class exitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.exit(0);

        }

    }

    
}

