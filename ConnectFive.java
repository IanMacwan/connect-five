import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;

// Main JPanel that displays the game
public class ConnectFive extends JPanel implements MouseListener {
    
    private char[][] board; // Gameboard is stored in a 2D char array
    public boolean currPlayer; // Boolean to hold the current player, true is red, and false is blue

    public boolean isTie = false; // Boolean to tell if the game is a tie

    private int mouseX; // Variable to hold te current mouse position used to draw floating connect four peice

    public Container container; // Container to hold refrence to container of program

    // Finals to hold the row, column, and space lenghts
    private final int ROW = 6;
    private final int COL = 7;
    private final int SPACE = 100;


 
    public ConnectFive(Container container) {

        // Set up Jpanel. Starts as not visible
        this.setSize((ROW*100), COL * 100);
        this.setBackground(Color.BLACK);
        this.setVisible(false);
        this.setLayout(null);

        // Holds a refrence to the container that holds all JPanels, allowing each JPanel to control other JPanels
        // This is importatnt as we need to alter the visiblilty of different JPanels from inside of other JPanels.
        this.container = container;

        // Initialize the board and current player. Red will always go first
        board = new char[ROW][COL];
        currPlayer = true;

        // Adds the mouse listener, keep in mind that this JPanel implenets the mouse listener thus, we can simply pass in this as an arg
        this.addMouseListener(this);

        // Adds the mouse motion listener to draw the floating connect four peice. Another private class is made that implements 
        CursorLocationListener cll = new CursorLocationListener();
        this.addMouseMotionListener(cll);

    }

    // public method to initialize gameboard by filling it with empty spaces
    // This method also adds up to 6 random spaces that are blocked on the board
    // This method is called to reset the board, thus it is public so that the TitleScreen class can call it.
    public void fillBoard() {

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

        // Sets tie as false, to reset the player
        this.isTie = false;
        this.currPlayer = true; // Sets the player to red

    }

    // Private method to drop disc, takes in the column number
    private void dropDisc(int x) {

        for (int i = ROW - 1; i >= 0; i--) {

            // Drops disc in the lowest available space
            if (this.board[i][x] == ' ') {

                this.board[i][x] = currPlayer ? 'R' : 'B'; 
                currPlayer = !(currPlayer); // If a valid disc has been placed, switch player turn
                break;

            }

        }

    } 


    // Method to paint the game screen.
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g; // Type cast graphics to 2D graphics

        // Sets the color based on the current player
        if (currPlayer) {
            g2d.setColor(Color.RED);
        } else {
            g2d.setColor(Color.BLUE);
        }

        // Draws the floating connect four peice 
        g2d.setStroke(new BasicStroke(5));
        g2d.drawOval(mouseX - 45, 0, 90, 90);

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

        // Check horizontal connect five
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

        // Check diagonal forward connect five 
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

        // Check diagonal backward connect five 
        for (int i = 0; i < ROW - 4; i++) {

            for (int j = 0; j < COL - 4; j++) {
                
                if (board[i][j] != ' ' &&
                    board[i][j] != 'X' &&
                    board[i][j] == board[i + 1][j + 1] &&
                    board[i][j] == board[i + 2][j + 2] &&
                    board[i][j] == board[i + 3][j + 3] &&
                    board[i][j] == board[i + 4][j + 4]  
                ) { return true; }
            }
        }

        // If there is not a connect five in any direction, return false
        return false;
    }

    // Private method to check if a tie has happened
    private boolean checkTie() {
        
        for (int i = 0; i < ROW; i++) {

            for (int j = 0; j < COL; j++) {

                if (board[i][j] == ' ') { return false; }

            }

        }

        // If there is a tie, then set is Tie to true, such that the WinnerScreen can display correct text
        isTie = true;
        return true;
    }

    // When mouse is clicked, the disc will be dropped in the correct column
    @Override
    public void mouseClicked(MouseEvent e) { 
        
        int x = e.getX();

        if (x >= 0 && x <= 99) { dropDisc(0); }

        if (x >= 100 && x <= 199) { dropDisc(1); }

        if (x >= 200 && x <= 299) { dropDisc(2); }

        if (x >= 300 && x <= 399) { dropDisc(3); }

        if (x >= 400 && x <= 499) { dropDisc(4); }

        if (x >= 500 && x <= 599) { dropDisc(5); }

        if (x >= 600 && x <= 700) { dropDisc(6); }

        if (checkWin()) {

            // If a win has occurred, the game window will be set to not visiable
            this.setVisible(false);
            // Add a new instance of a winner screen to the mainFrame
            // This is done by refrencing the container and accessing the mainFrame where all JPanels are drawn
            container.mainFrame.add(new WinnerScreen(container));

        } else if (checkTie()) {

            // If a tie has occurred, the game window will be set to not visiable
            this.setVisible(false);
            // Also add a new instance of a winner screen to the mainFrame
            container.mainFrame.add(new WinnerScreen(container));

        }

        // Everytime we drop a disc we want to repaint the game screen
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
    

    // Cursor location listerner class that implements mouse motion listener to draw floating conenct four peice
    private class CursorLocationListener implements MouseMotionListener {

        // When the mouse is moved update the mouseX variable and repaint.
        @Override
        public void mouseMoved(MouseEvent e) {

            mouseX = e.getX();
            repaint();

        }

        @Override
        public void mouseDragged(MouseEvent e) {  } // Do nothing

    }
    
}
