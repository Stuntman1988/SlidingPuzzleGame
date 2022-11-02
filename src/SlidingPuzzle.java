import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SlidingPuzzle extends JFrame implements ActionListener {

    private JPanel groundPanel;
    private JPanel gamePanel;
    private JPanel bottomPanel;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn10;
    private JButton btn11;
    private JButton btn12;
    private JButton btn13;
    private JButton btn14;
    private JButton btn15;
    private JButton btn16;
    private JButton newGame;
    private JButton cheatBtn;
    private final String blank = "";
    private final Dimension buttonSize = new Dimension(40, 100);

    List<String> texts = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15");
    List<JButton> buttons = Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12,
            btn13, btn14, btn15, btn16);

    private SlidingPuzzle() {
        newGame();
        setContentPane(groundPanel);
        setSize(675, 700);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn10.addActionListener(this);
        btn11.addActionListener(this);
        btn12.addActionListener(this);
        btn13.addActionListener(this);
        btn14.addActionListener(this);
        btn15.addActionListener(this);
        btn16.addActionListener(this);

        newGame.addActionListener(e -> newGame());
        cheatBtn.addActionListener(e -> cheatWay());

    }

    protected void newGame() {
        Collections.shuffle(texts);
        for (int i = 0; i < buttons.size() - 1; i++) {
            buttons.get(i).setText(texts.get(i));
            buttons.get(i).setBackground(Color.YELLOW);
            buttons.get(i).setPreferredSize(buttonSize);
        }
        btn16.setBackground(groundPanel.getBackground());
        btn16.setText("");
        btn16.setPreferredSize(buttonSize);
        if (!isSolvable()) {
            newGame();
        }
    }

    private boolean isSolvable() { /*https://ssaurel.medium.com/developing-a-15-puzzle-game-of-fifteen-in-java-dfe1359cc6e3*/
        int countInversions = 0;
        int[] buttonsInt = new int[15];
        for (int i = 0; i < 15; i++) {
            buttonsInt[i] = Integer.parseInt(String.valueOf(buttons.get(i).getText()));
        }
        for (int i = 0; i < buttonsInt.length; i++) {
            for (int j = 0; j < i; j++) {
                if (buttonsInt[j] > buttonsInt[i])
                    countInversions++;
            }
        }
        return countInversions % 2 == 0;
    }

    private void cheatWay() {
        newGame();
        btn1.setText("1");
        btn2.setText("2");
        btn3.setText("3");
        btn4.setText("4");
        btn5.setText("5");
        btn6.setText("6");
        btn7.setText("7");
        btn8.setText("8");
        btn9.setText("9");
        btn10.setText("10");
        btn11.setText("11");
        btn12.setText("12");
        btn13.setText("13");
        btn14.setText("14");
        btn15.setText("");
        btn16.setText("15");
        btn15.setBackground(groundPanel.getBackground());
        btn16.setBackground(Color.YELLOW);
    }

    private void winGame() {
        if (btn1.getText().equals("1") && btn2.getText().equals("2") && btn3.getText().equals("3") &&
                btn4.getText().equals("4") && btn5.getText().equals("5") && btn6.getText().equals("6") &&
                btn7.getText().equals("7") && btn8.getText().equals("8") && btn9.getText().equals("9") &&
                btn10.getText().equals("10") && btn11.getText().equals("11") && btn12.getText().equals("12") &&
                btn13.getText().equals("13") && btn14.getText().equals("14") && btn15.getText().equals("15") &&
                btn16.getText().equals("")) {
            btn16.setText("\u2714");
            btn16.setFont(new Font(btn16.getText(), Font.PLAIN, 50));
            btn16.setForeground(Color.green);
            new WinnerScreen(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            if (btn2.getText().equals("")) {
                btn2.setText(btn1.getText());
                btn1.setText(blank);
                btn1.setBackground(groundPanel.getBackground());
                btn2.setBackground(Color.yellow);
                winGame();
            } else if (btn5.getText().equals("")) {
                btn5.setText(btn1.getText());
                btn1.setText(blank);
                btn1.setBackground(groundPanel.getBackground());
                btn5.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn2) {
            if (btn1.getText().equals("")) {
                btn1.setText(btn2.getText());
                btn2.setText(blank);
                btn2.setBackground(groundPanel.getBackground());
                btn1.setBackground(Color.yellow);
                winGame();
            } else if (btn3.getText().equals("")) {
                btn3.setText(btn2.getText());
                btn2.setText(blank);
                btn2.setBackground(groundPanel.getBackground());
                btn3.setBackground(Color.yellow);
                winGame();
            } else if (btn6.getText().equals("")) {
                btn6.setText(btn2.getText());
                btn2.setText(blank);
                btn2.setBackground(groundPanel.getBackground());
                btn6.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn3) {
            if (btn2.getText().equals("")) {
                btn2.setText(btn3.getText());
                btn3.setText(blank);
                btn3.setBackground(groundPanel.getBackground());
                btn2.setBackground(Color.yellow);
                winGame();
            } else if (btn4.getText().equals("")) {
                btn4.setText(btn3.getText());
                btn3.setText(blank);
                btn3.setBackground(groundPanel.getBackground());
                btn4.setBackground(Color.yellow);
                winGame();
            } else if (btn7.getText().equals("")) {
                btn7.setText(btn3.getText());
                btn3.setText(blank);
                btn3.setBackground(groundPanel.getBackground());
                btn7.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn4) {
            if (btn3.getText().equals("")) {
                btn3.setText(btn4.getText());
                btn4.setText(blank);
                btn4.setBackground(groundPanel.getBackground());
                btn3.setBackground(Color.yellow);
                winGame();
            } else if (btn8.getText().equals("")) {
                btn8.setText(btn4.getText());
                btn4.setText(blank);
                btn4.setBackground(groundPanel.getBackground());
                btn8.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn5) {
            if (btn1.getText().equals("")) {
                btn1.setText(btn5.getText());
                btn5.setText(blank);
                btn5.setBackground(groundPanel.getBackground());
                btn1.setBackground(Color.yellow);
                winGame();
            } else if (btn6.getText().equals("")) {
                btn6.setText(btn5.getText());
                btn5.setText(blank);
                btn5.setBackground(groundPanel.getBackground());
                btn6.setBackground(Color.yellow);
                winGame();
            } else if (btn9.getText().equals("")) {
                btn9.setText(btn5.getText());
                btn5.setText(blank);
                btn5.setBackground(groundPanel.getBackground());
                btn9.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn6) {
            if (btn2.getText().equals("")) {
                btn2.setText(btn6.getText());
                btn6.setText(blank);
                btn6.setBackground(groundPanel.getBackground());
                btn2.setBackground(Color.yellow);
                winGame();
            } else if (btn5.getText().equals("")) {
                btn5.setText(btn6.getText());
                btn6.setText(blank);
                btn6.setBackground(groundPanel.getBackground());
                btn5.setBackground(Color.yellow);
                winGame();
            } else if (btn7.getText().equals("")) {
                btn7.setText(btn6.getText());
                btn6.setText(blank);
                btn6.setBackground(groundPanel.getBackground());
                btn7.setBackground(Color.yellow);
                winGame();
            } else if (btn10.getText().equals("")) {
                btn10.setText(btn6.getText());
                btn6.setText(blank);
                btn6.setBackground(groundPanel.getBackground());
                btn10.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn7) {
            if (btn3.getText().equals("")) {
                btn3.setText(btn7.getText());
                btn7.setText(blank);
                btn7.setBackground(groundPanel.getBackground());
                btn3.setBackground(Color.yellow);
                winGame();
            } else if (btn6.getText().equals("")) {
                btn6.setText(btn7.getText());
                btn7.setText(blank);
                btn7.setBackground(groundPanel.getBackground());
                btn6.setBackground(Color.yellow);
                winGame();
            } else if (btn8.getText().equals("")) {
                btn8.setText(btn7.getText());
                btn7.setText(blank);
                btn7.setBackground(groundPanel.getBackground());
                btn8.setBackground(Color.yellow);
                winGame();
            } else if (btn11.getText().equals("")) {
                btn11.setText(btn7.getText());
                btn7.setText(blank);
                btn7.setBackground(groundPanel.getBackground());
                btn11.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn8) {
            if (btn4.getText().equals("")) {
                btn4.setText(btn8.getText());
                btn8.setText(blank);
                btn8.setBackground(groundPanel.getBackground());
                btn4.setBackground(Color.yellow);
                winGame();
            } else if (btn7.getText().equals("")) {
                btn7.setText(btn8.getText());
                btn8.setText(blank);
                btn8.setBackground(groundPanel.getBackground());
                btn7.setBackground(Color.yellow);
                winGame();
            } else if (btn12.getText().equals("")) {
                btn12.setText(btn8.getText());
                btn8.setText(blank);
                btn8.setBackground(groundPanel.getBackground());
                btn12.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn9) {
            if (btn5.getText().equals("")) {
                btn5.setText(btn9.getText());
                btn9.setText(blank);
                btn9.setBackground(groundPanel.getBackground());
                btn5.setBackground(Color.yellow);
                winGame();
            } else if (btn10.getText().equals("")) {
                btn10.setText(btn9.getText());
                btn9.setText(blank);
                btn9.setBackground(groundPanel.getBackground());
                btn10.setBackground(Color.yellow);
                winGame();
            } else if (btn13.getText().equals("")) {
                btn13.setText(btn9.getText());
                btn9.setText(blank);
                btn9.setBackground(groundPanel.getBackground());
                btn13.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn10) {
            if (btn6.getText().equals("")) {
                btn6.setText(btn10.getText());
                btn10.setText(blank);
                btn10.setBackground(groundPanel.getBackground());
                btn6.setBackground(Color.yellow);
                winGame();
            } else if (btn9.getText().equals("")) {
                btn9.setText(btn10.getText());
                btn10.setText(blank);
                btn10.setBackground(groundPanel.getBackground());
                btn9.setBackground(Color.yellow);
                winGame();
            } else if (btn11.getText().equals("")) {
                btn11.setText(btn10.getText());
                btn10.setText(blank);
                btn10.setBackground(groundPanel.getBackground());
                btn11.setBackground(Color.yellow);
                winGame();
            } else if (btn14.getText().equals("")) {
                btn14.setText(btn10.getText());
                btn10.setText(blank);
                btn10.setBackground(groundPanel.getBackground());
                btn14.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn11) {
            if (btn7.getText().equals("")) {
                btn7.setText(btn11.getText());
                btn11.setText(blank);
                btn11.setBackground(groundPanel.getBackground());
                btn7.setBackground(Color.yellow);
                winGame();
            } else if (btn10.getText().equals("")) {
                btn10.setText(btn11.getText());
                btn11.setText(blank);
                btn11.setBackground(groundPanel.getBackground());
                btn10.setBackground(Color.yellow);
                winGame();
            } else if (btn12.getText().equals("")) {
                btn12.setText(btn11.getText());
                btn11.setText(blank);
                btn11.setBackground(groundPanel.getBackground());
                btn12.setBackground(Color.yellow);
                winGame();
            } else if (btn15.getText().equals("")) {
                btn15.setText(btn11.getText());
                btn11.setText(blank);
                btn11.setBackground(groundPanel.getBackground());
                btn15.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn12) {
            if (btn8.getText().equals("")) {
                btn8.setText(btn12.getText());
                btn12.setText(blank);
                btn12.setBackground(groundPanel.getBackground());
                btn8.setBackground(Color.yellow);
                winGame();
            } else if (btn11.getText().equals("")) {
                btn11.setText(btn12.getText());
                btn12.setText(blank);
                btn12.setBackground(groundPanel.getBackground());
                btn11.setBackground(Color.yellow);
                winGame();
            } else if (btn16.getText().equals("")) {
                btn16.setText(btn12.getText());
                btn12.setText(blank);
                btn12.setBackground(groundPanel.getBackground());
                btn16.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn13) {
            if (btn9.getText().equals("")) {
                btn9.setText(btn13.getText());
                btn13.setText(blank);
                btn13.setBackground(groundPanel.getBackground());
                btn9.setBackground(Color.yellow);
                winGame();
            } else if (btn14.getText().equals("")) {
                btn14.setText(btn13.getText());
                btn13.setText(blank);
                btn13.setBackground(groundPanel.getBackground());
                btn14.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn14) {
            if (btn10.getText().equals("")) {
                btn10.setText(btn14.getText());
                btn14.setText(blank);
                btn14.setBackground(groundPanel.getBackground());
                btn10.setBackground(Color.yellow);
                winGame();
            } else if (btn13.getText().equals("")) {
                btn13.setText(btn14.getText());
                btn14.setText(blank);
                btn14.setBackground(groundPanel.getBackground());
                btn13.setBackground(Color.yellow);
                winGame();
            } else if (btn15.getText().equals("")) {
                btn15.setText(btn14.getText());
                btn14.setText(blank);
                btn14.setBackground(groundPanel.getBackground());
                btn15.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn15) {
            if (btn11.getText().equals("")) {
                btn11.setText(btn15.getText());
                btn15.setText(blank);
                btn15.setBackground(groundPanel.getBackground());
                btn11.setBackground(Color.yellow);
                winGame();
            } else if (btn14.getText().equals("")) {
                btn14.setText(btn15.getText());
                btn15.setText(blank);
                btn15.setBackground(groundPanel.getBackground());
                btn14.setBackground(Color.yellow);
                winGame();
            } else if (btn16.getText().equals("")) {
                btn16.setText(btn15.getText());
                btn15.setText(blank);
                btn15.setBackground(groundPanel.getBackground());
                btn16.setBackground(Color.yellow);
                winGame();
            }
        } else if (e.getSource() == btn16) {
            if (btn12.getText().equals("")) {
                btn12.setText(btn16.getText());
                btn16.setText(blank);
                btn16.setBackground(groundPanel.getBackground());
                btn12.setBackground(Color.yellow);
                winGame();
            } else if (btn15.getText().equals("")) {
                btn15.setText(btn16.getText());
                btn16.setText(blank);
                btn16.setBackground(groundPanel.getBackground());
                btn15.setBackground(Color.yellow);
                winGame();
            }
        }
    }

    public static void main(String[] args) {
        new SlidingPuzzle();
    }
}