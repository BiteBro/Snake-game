package elements;

import java.awt.*;

public class SnakeFood implements Comparable{
    private int xCoor;
    private int yCoor;
    private int wight;
    private int height;

    public SnakeFood(int xCoor, int yCoor, int size) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.wight = size;
        this.height = size;
    }
    public void draw(Graphics g){
        g.setColor(new Color(0xD7CA7F));
        g.fillRect(xCoor * wight, yCoor * height, wight, height);
    }

    @Override
    public int compareTo(Object o) {
        if (this.xCoor == ((SnakeBody)o).getxCoor() && this.yCoor == ((SnakeBody)o).getyCoor()){
            return 1;
        }
        return 0;
    }
}
