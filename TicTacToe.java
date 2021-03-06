
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author rad85000
 * @author dim26
 */
public class TicTacToe {
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel panel;
    JPanel ttt;
    JButton[] buttons = new JButton[9];
    JButton clear = new JButton("New Game");
    boolean player;

    public static void main(String[] args) {
        new TicTacToe();
    }

    TicTacToe() {
        player = true;
        panel = new JPanel();
        ttt = new JPanel();
        ttt.setLayout(new GridLayout(3, 3));
        panel.setLayout(new FlowLayout());
        frame.add(ttt, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.SOUTH);
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("_");
            ActionListener buttonListener = new ButtonListener();
            buttons[i].addActionListener(buttonListener);
            buttons[i].setFont(new Font("Courier", Font.PLAIN, 48));
            ttt.add(buttons[i]);
        }

        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    buttons[i].setText("_");
                }
                player = true;
            }
        });
        panel.add(clear);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            String currentText = source.getText();
            if (currentText.equals("_")) {
                if (player)
                    source.setText("X");
                else
                    source.setText("0");

                player = !player;
            }
        }
    }
}
