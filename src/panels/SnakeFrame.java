package panels;

import logic.GameLogic;

import javax.swing.*;
import java.awt.*;

public class SnakeFrame extends JFrame {
    private static JFrame snJFrame ;
    private GameLogic gmPanel;
    private InfoPanel infPanel;
    private RecordScorePanel recordScorePanel;

    public SnakeFrame() {

        snJFrame = new JFrame("SNAKE");
        //snJFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon/Snake.png"));
        gmPanel = new GameLogic();

        recordScorePanel = gmPanel.getRecordScorePanel();
        infPanel = gmPanel.getInfPanel();

        snJFrame.add(recordScorePanel, BorderLayout.NORTH);
        snJFrame.add(gmPanel, BorderLayout.CENTER);
        snJFrame.add(infPanel, BorderLayout.SOUTH);
        snJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snJFrame.setResizable(false);
        snJFrame.setVisible(true);
        snJFrame.pack();
        snJFrame.setLocationRelativeTo(null);
    }

    public static JFrame getSnJFrame() {
        return snJFrame;
    }
}
