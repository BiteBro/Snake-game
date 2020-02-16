package panels;

import javax.swing.*;
import java.awt.*;

public class RecordScorePanel extends JPanel {
    private static final int WIGHT = 40;
    private static final int HEIGHT = 100;
    private JLabel score;
    private JLabel recordScore;

    public RecordScorePanel() {
        super();
        score = new JLabel();
        score.setText(" RECORD: ");
        score.setFont(new Font("Serif", Font.PLAIN, 20));

        recordScore = new JLabel();
        recordScore.setText("0 ");
        recordScore.setFont(new Font("Serif", Font.PLAIN, 20));
        recordScore.setHorizontalAlignment(SwingConstants.RIGHT);

        setPreferredSize(new Dimension(HEIGHT, WIGHT));
        this.setBackground(new Color(0xC7CBD7));
        this.setLayout(new GridLayout(1, 2));

        this.add(score);
        this.add(recordScore);
    }

    public JLabel getRecordScore() {
        return recordScore;
    }

    public void setRecordScore(String recordScore) {
        this.recordScore.setText(recordScore);
    }
}
