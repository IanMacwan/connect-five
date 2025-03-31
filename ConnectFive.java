import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;


public class ConnectFive extends JPanel implements MouseListener {
    
    private char[][] board;
    private boolean currPlayer; // true is R, and false is B
    public boolean gameOver;
    public String playerRed;
    public String playerBlue;

    public boolean isOn = true;
    public JFrame frame;

    private final int ROW = 6;
    private final int COL = 7;
    private final int SPACE = 100;
    

    public ConnectFive(JFrame frame) {

        // Set up Jpanel.
        this.setSize((ROW*100), COL * 100);
        this.setBackground(Color.BLACK);
        this.setVisible(false);
        this.setLayout(null);

        this.frame = frame;

        // Initialize the board and current player. Red will always go first.
        board = new char[ROW][COL];
        currPlayer = true;
        // Asks for user input for player names.
        playerRed = "name1"; // JOptionPane.showInputDialog(this, "Red PLayer Name?: ");
        playerBlue = "name2"; // JOptionPane.showInputDialog(this, "Blue PLayer Name?: ");
        gameOver = false;

        fillBoard();

        this.addMouseListener(this);

        JLabel redName = new JLabel(this.playerRed);
        JLabel blueName = new JLabel(this.playerBlue);

        redName.setFont(new Font("Serif", Font.BOLD, 20));
        blueName.setFont(new Font("Serif", Font.BOLD, 20));

        redName.setForeground(Color.RED);
        blueName.setForeground(Color.BLUE);

        redName.setBounds(80, 32, 200, 20);
        blueName.setBounds(80, 62, 200, 20);

        this.add(redName);
        this.add(blueName);

    }

    // Private method to initialize gameboard by filling it with empty spaces.
    private void fillBoard() {

        // Fills the board with empty spaces
        for (int i = 0; i < ROW; i++) {

            for (int j = 0; j < COL; j++) {

                board[i][j] = ' ';

            }

        }

        // Adds randon blocked spaces in the board
        Random rand = new Random();
        int rand_spaces = rand.nextInt(6);
        for (int i = 0; i < rand_spaces; i++) {

            board[rand.nextInt(ROW)][rand.nextInt(COL)] = 'X';

        }

    }

    private void dropDisc(int x) {

        for (int i = ROW - 1; i >= 0; i--) {

            if (this.board[i][x] == ' ') {

                this.board[i][x] = currPlayer ? 'R' : 'B';
                break;

            }

        }

    } 


    // Method to paint the game screen.
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.fillOval(50, 30, 20, 20);

        g2d.setColor(Color.BLUE);
        g2d.fillOval(50, 60, 20, 20);
        

        for (int y = 100; y < (ROW * SPACE) + 100; y += SPACE) {

            for (int x = 0; x < (COL * SPACE); x += SPACE) {

                // Draws grid
                g2d.setColor(Color.WHITE);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(x, y, SPACE, SPACE);

                // Drwas red disc
                if (board[(y - 100)/100][x/100] == 'R') {

                    g2d.setColor(Color.RED);
                    g2d.setStroke(new BasicStroke(5));
                    g2d.drawOval(x+5, y+5, 90, 90);

                } 

                // Draws blue disc
                if (board[(y - 100)/100][x/100] == 'B') {

                    g2d.setColor(Color.BLUE);
                    g2d.setStroke(new BasicStroke(5));
                    g2d.drawOval(x+5, y+5, 90, 90);

                } 

                // Draws blocked spaces
                if (board[(y - 100)/100][x/100] == 'X') {

                    g2d.setColor(Color.GRAY);
                    g2d.setStroke(new BasicStroke(5));
                    g2d.drawOval(x+5, y+5, 90, 90);

                } 



            }

        }

    }

    // Private method to check if a connect five has happened.
    private boolean checkWin() {

        // Check horizontal connection five
        for (int i = 0; i < ROW; i++) {

            for (int j = 0; j < COL -  4; j++) {

                if (board[i][j] != ' ' &&
                    board[i][j] != 'X' &&
                    board[i][j] == board[i][j + 1] &&
                    board[i][j] == board[i][j + 2] &&
                    board[i][j] == board[i][j + 3] &&
                    board[i][j] == board[i][j + 4] 
                ) { return true; }

            }

        }

        // Check vertical connect five
        for (int i = 0; i < ROW - 4; i++) {

            for (int j = 0; j < COL; j++) {

                if (board[i][j] != ' ' &&
                    board[i][j] != 'X' &&
                    board[i][j] == board[i + 1][j] &&
                    board[i][j] == board[i + 2][j] &&
                    board[i][j] == board[i + 3][j] &&
                    board[i][j] == board[i + 4][j]  
                ) { return true; }

            }

        }

        // Check diagonal connect four 
        for (int i = 4; i < ROW; i++) {

            for (int j = 0; j < COL - 4; j++) {

                if (board[i][j] != ' ' &&
                    board[i][j] != 'X' &&
                    board[i][j] == board[i - 1][j + 1] &&
                    board[i][j] == board[i - 2][j + 2] &&
                    board[i][j] == board[i - 3][j + 3] &&
                    board[i][j] == board[i - 4][j + 4]  
                ) { return true; }

            }

        }

        // If there is not a connect five in any direction, change player turn and return false.
        currPlayer = !(currPlayer);
        return false;
    }


    @Override
    public void mouseClicked(MouseEvent e) { 
        
        int x = e.getX();

        if (x >= 0 && x <= 99) { dropDisc(0); }

        if (x >= 100 && x <= 199) { dropDisc(1); }

        if (x >= 200 && x <= 299) { dropDisc(2); }

        if (x >= 300 && x <= 399) { dropDisc(3); }

        if (x >= 400 && x <= 499) { dropDisc(4); }

        if (x >= 500 && x <= 599) { dropDisc(5); }

        if (x >= 600 && x <= 700) { 
            dropDisc(6);
        }

        if (checkWin()) {
            System.out.println("WIN" + currPlayer);
            this.setVisible(false);
            frame.remove(this);
        } 
        repaint();
    } 

    @Override
    public void mousePressed(MouseEvent e) {  } // Do nothing

    @Override
    public void mouseReleased(MouseEvent e) {  } // Do nothing

    @Override
    public void mouseEntered(MouseEvent e) {  } // Do nothing

    @Override
    public void mouseExited(MouseEvent e) {  } // Do nothing

    
    
    

    
}
