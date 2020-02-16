package logic;

import elements.SnakeBody;
import elements.SnakeFood;
import panels.InfoPanel;
import panels.MenuPanel;
import panels.RecordScorePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic extends JPanel implements Runnable, KeyListener {
    private InfoPanel infPanel = new InfoPanel();
    private RecordScorePanel recordScorePanel = new RecordScorePanel();
    private RecordScore wrs = new RecordScore();

    //размер игрового поля
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    //статус игры и направления движения
    private Thread thread;
    private boolean running = false;
    private boolean right = true;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;

    //параметры змейки
    private SnakeBody b;
    private ArrayList<SnakeBody> snake;
    private int xCoor = 10;
    private int yCoor = 10;
    private int size = 10;
    private int snakeLenght = 3;
    private int ticks = 0;
    private int score = 0;
    private int snakeSpeed = 1000000;

    private SnakeFood food;
    Random rnd = new Random();

    public GameLogic() {
        recordScorePanel.setRecordScore(wrs.getS());
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        snake = new ArrayList<SnakeBody>();
        start();
    }

    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() throws IOException {
        System.out.println("Game Over");
        if (wrs.getS().compareTo(String.valueOf(score)) < 0){
            wrs.writeScore(""+score);
        }

        MenuPanel mp = new MenuPanel();
        mp.getNameSnake().setText("+ GAME OVER +");
        mp.getStartButton().setText("RESTART");
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tick() throws IOException {
        // задаем начало змейки
        if (snake.size() == 0) {
            b = new SnakeBody(xCoor, yCoor, size);
            snake.add(b);
            food = new SnakeFood(/*rnd.nextInt(38) + 1, rnd.nextInt(38) + 1*/30, 30, size);
        }
        ticks++;
        //направление движения и проверка на выход за границы поля
        if (ticks > snakeSpeed) {
            if (right) {
                xCoor++;
                if (xCoor >= (WIDTH / size)) stop();
            }
            if (left) {
                xCoor--;
                if (xCoor < (0)) stop();
            }
            if (up) {
                yCoor--;
                if (yCoor < (0)) stop();
            }
            if (down) {
                yCoor++;
                if (yCoor >= (HEIGHT / size)) stop();
            }
            //сброс счетчика
            ticks = 0;
            if (food.compareTo(b) > 0) {
                score += 100;
                snakeLenght++;
                if (snakeSpeed > 100000) {
                    snakeSpeed -= 20000;
                }
                food = new SnakeFood(rnd.nextInt(38) + 1, rnd.nextInt(38) + 1, size);
                //вывод показаний очков, скорости и длины змейки
                //System.out.println(score + "  " + snakeSpeed + "  " + snakeLenght);
                infPanel.getDigitScore().setText(String.valueOf(score));
            }
            //добавление элемента змейки
            b = new SnakeBody(xCoor, yCoor, size);
            //завершение игры при попадании змейки на саму себя
            if (snake.contains(b)) {
                stop();
            }
            snake.add(b);
            //вывод координат
            //System.out.println("xC: " + xCoor + "  yC: " + yCoor);
        }
        //удаление элемента змейки с конца
        if (snake.size() > snakeLenght) {
            snake.remove(0);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(new Color(0x1BB406));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        food.draw(g);
        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                tick();
            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT && !left) {
            left = false;
            right = true;
            up = false;
            down = false;
        }
        if (key == KeyEvent.VK_LEFT && !right) {
            right = false;
            left = true;
            up = false;
            down = false;
        }
        if (key == KeyEvent.VK_UP && !down) {
            down = false;
            up = true;
            right = false;
            left = false;
        }
        if (key == KeyEvent.VK_DOWN && !up) {
            up = false;
            down = true;
            right = false;
            left = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public InfoPanel getInfPanel() {
        return infPanel;
    }

    public RecordScorePanel getRecordScorePanel() {
        return recordScorePanel;
    }
}
