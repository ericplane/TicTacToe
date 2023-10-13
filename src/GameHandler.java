import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameHandler {
    JFrame frame;
    JPanel textPanel;
    JPanel buttonPanel;
    JLabel headingLabel;
    JButton[] buttons;
    int turnsCompleted;
    Random random;
    boolean isPlayerTurn;

    GameHandler() {
        this.frame = new JFrame();
        this.textPanel = new JPanel();
        this.buttonPanel = new JPanel();
        this.headingLabel = new JLabel();
        this.buttons = new JButton[9];
        this.turnsCompleted = 0;
        this.random = new Random();

        Window window = new Window(this);

        startGame();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        try {
            this.headingLabel.setText("Loading....");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int whoseTurn = random.nextInt(100);
        if (whoseTurn % 2 == 0) {
            this.isPlayerTurn = true;
            headingLabel.setText("X turn");
        } else {
            this.isPlayerTurn = false;
            this.headingLabel.setText("O turn");
        }
    }

    public void gameOver(String s) {
        turnsCompleted = 0;
        Object[] option={"Restart","Exit"};
        int n = JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        frame.dispose();
        if (n == 0) {
            new GameHandler();
        }
    }

    public void matchCheck() {
        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        else if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        else if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        else if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        else if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        else if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        else if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        else if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(6, 7, 8);
        }
        else if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        else if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        else if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        else if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        else if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        else if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        else if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
            oWins(3, 4, 5);
        } else if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        else if(turnsCompleted == 9) {
            headingLabel.setText("Match Tie");
            gameOver("Match Tie");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        buttons[x1].setBackground(Color.RED);
        buttons[x2].setBackground(Color.RED);
        buttons[x3].setBackground(Color.RED);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        headingLabel.setText("X wins");
        gameOver("X Wins");
    }
    public void oWins(int x1, int x2, int x3) {
        buttons[x1].setBackground(Color.RED);
        buttons[x2].setBackground(Color.RED);
        buttons[x3].setBackground(Color.RED);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        headingLabel.setText("O Wins");
        gameOver("O Wins");
    }
}
