package panels;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private static final int WIGHT = 40;
    private static final int HEIGHT = 100;
    private JLabel scoreName;
    private JLabel digitScore;

    public InfoPanel() {
        super();
        scoreName = new JLabel();
        scoreName.setText(" SCORE: ");
        scoreName.setFont(new Font("Serif", Font.PLAIN, 20));

        digitScore = new JLabel();
        digitScore.setText("0 ");
        digitScore.setFont(new Font("Serif", Font.PLAIN, 20));
        digitScore.setHorizontalAlignment(SwingConstants.RIGHT);

        setPreferredSize(new Dimension(HEIGHT, WIGHT));
        this.setBackground(new Color(0xC7CBD7));
        this.setLayout(new GridLayout(1, 2));

        this.add(scoreName);
        this.add(digitScore);
    }

    public JLabel getDigitScore() {
        return digitScore;
    }

//    public void setDigitScore(JLabel digitScore) {
//        this.digitScore = digitScore;
//    }
}
