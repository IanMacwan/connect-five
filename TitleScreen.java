import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class TitleScreen extends JPanel {

    public JFrame frame;
    public JPanel game;

    private JButton playButton;
    private JButton exitButton;

    private JLabel titleOne;
    private JLabel titleTwo;

    public TitleScreen(JFrame frame, JPanel game) {

        this.setSize(700, 700);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(null);

        this.frame = frame;
        this.game = game;

        titleOne = new JLabel("CONNECT");
        titleTwo = new JLabel("FIVE");







        playButton = new JButton("Play");
        playButton.setBounds(200, 400, 300, 50);
        playButton.setFont(new Font("Serif", Font.BOLD, 20));
        playButton.setBackground(Color.GRAY);

        exitButton = new JButton("Exit");
        exitButton.setBounds(200, 475, 300, 50);
        exitButton.setFont(new Font("Serif", Font.BOLD, 20));
        playButton.setBackground(Color.GRAY);
    
        this.add(playButton);
        this.add(exitButton);

        playListener pl = new playListener();
        exitListener el = new exitListener();
        playButton.addActionListener(pl);
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

