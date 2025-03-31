import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class WinnerScreen extends JPanel {

    public JFrame frame;
    public JPanel game;
    private JButton playAgainButton;
    private JButton exitButton;


    public WinnerScreen(JFrame frame, JPanel game) {

        this.setSize(700, 700);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(null);

        this.frame = frame;
        this.game = game;


        playAgainButton = new JButton("Play");
        playAgainButton.setBounds(100, 100, 200, 50);

        exitButton = new JButton("Exit");
        exitButton.setBounds(100, 200, 200, 50);

    
        this.add(playAgainButton);
        this.add(exitButton);

        playListener pl = new playListener();
        exitListener el = new exitListener();
        playAgainButton.addActionListener(pl);
        exitButton.addActionListener(el);

    }

    private void switchGame() {

        this.setVisible(false);
        frame.remove(this);
        game.setVisible(true);

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



