import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {
    GameHandler gameHandler;
    Window(GameHandler gameHandler) {
        this.gameHandler = gameHandler;

        gameHandler.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameHandler.frame.setSize(800, 800);
        gameHandler.frame.getContentPane().setBackground(new Color(50, 50, 50));
        gameHandler.frame.setTitle("Tic Tac Toe");
        gameHandler.frame.setLayout(new BorderLayout());
        gameHandler.frame.setVisible(true);
        gameHandler.frame.setResizable(false);

        gameHandler.headingLabel.setBackground(new Color(99, 99, 99));
        gameHandler.headingLabel.setForeground(new Color(204, 204, 204));
        gameHandler.headingLabel.setFont(new Font("Ink Free", Font.BOLD, 75));
        gameHandler.headingLabel.setHorizontalAlignment(JLabel.CENTER);
        gameHandler.headingLabel.setText("Tic Tac Toe");
        gameHandler.headingLabel.setOpaque(true);

        gameHandler.textPanel.setLayout(new BorderLayout());
        gameHandler.textPanel.setBounds(0, 0, 800, 100);

        gameHandler.buttonPanel.setLayout(new GridLayout(3, 3));
        gameHandler.buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            gameHandler.buttons[i] = new JButton();
            gameHandler.buttonPanel.add(gameHandler.buttons[i]);
            gameHandler.buttons[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            gameHandler.buttons[i].setFocusable(false);
            gameHandler.buttons[i].addActionListener(this);
        }

        gameHandler.textPanel.add(gameHandler.headingLabel);
        gameHandler.frame.add(gameHandler.textPanel, BorderLayout.NORTH);
        gameHandler.frame.add(gameHandler.buttonPanel);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int i = 0; i < 9; i++) {
            if (actionEvent.getSource() == gameHandler.buttons[i]) {
                if (gameHandler.isPlayerTurn) {
                    if (gameHandler.buttons[i].getText() == "") {
                        gameHandler.buttons[i].setForeground(new Color(99, 99, 99));
                        gameHandler.buttons[i].setText("X");
                        gameHandler.isPlayerTurn = false;
                        gameHandler.headingLabel.setText("O turn");
                        gameHandler.turnsCompleted++;
                        gameHandler.matchCheck();
                    }
                } else {
                    if (gameHandler.buttons[i].getText() == "") {
                        gameHandler.buttons[i].setForeground(new Color(99, 99, 99));
                        gameHandler.buttons[i].setText("O");
                        gameHandler.isPlayerTurn = true;
                        gameHandler.headingLabel.setText("X turn");
                        gameHandler.turnsCompleted++;
                        gameHandler.matchCheck();
                    }
                }
            }
        }
    }
}