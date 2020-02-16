package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JFrame implements ActionListener {
    private JFrame menuFrame;
    private JPanel menuPanel;
    private JLabel nameSnake;
    private JButton startButton;
    //private JButton recordButton;
    //private JButton demonstrationButton;
    private JButton exitButton;

    public MenuPanel(){
        menuFrame = new JFrame();
        menuPanel = new JPanel();
        nameSnake = new JLabel("SNAKE GAME");
        nameSnake.setHorizontalAlignment(SwingConstants.CENTER);
        menuPanel.setBackground(new Color(0xB9EA21));
        nameSnake.setForeground(new Color(0xEA3C1C));


        startButton = new JButton("START");
        startButton.addActionListener(this);

        //recordButton = new JButton("RECORD");
        //recordButton.addActionListener(this);

        //demonstrationButton = new JButton("DEMONSTRATION");
        //demonstrationButton.addActionListener(this);

        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);
        menuPanel.setLayout(new GridLayout(3,1));
        menuPanel.add(nameSnake);
        menuPanel.add(startButton);
        //menuPanel.add(recordButton);
        //menuPanel.add(demonstrationButton);
        menuPanel.add(exitButton);

        menuFrame.add(menuPanel, BorderLayout.CENTER);

        menuFrame.setPreferredSize(new Dimension(200, 240));
        menuFrame.setUndecorated(true);
        menuFrame.setResizable(false);
        menuFrame.setVisible(true);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exitButton)){
            System.out.println("exit");
            System.exit(0);
        }
        if (e.getSource().equals(startButton)){
            System.out.println("start");
            menuFrame.dispose();
            if (SnakeFrame.getSnJFrame()!=null){
                SnakeFrame.getSnJFrame().dispose();
            }
            SnakeFrame sn = new SnakeFrame();
        }
        /*if (e.getSource().equals(recordButton)){
            System.out.println("record");
        }
        if (e.getSource().equals(demonstrationButton)){
            System.out.println("demonstration");
        }*/
    }

    public JLabel getNameSnake() {
        return nameSnake;
    }

    public JButton getStartButton() {
        return startButton;
    }
}
