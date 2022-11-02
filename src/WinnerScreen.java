import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinnerScreen extends JFrame{
    private JPanel panel1;
    private JButton newGameBtn;

    public WinnerScreen(SlidingPuzzle puzzle){
        setContentPane(panel1);
        setVisible(true);
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        newGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                puzzle.newGame();
            }
        });
    }
}
