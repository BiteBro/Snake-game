package elements;

import java.awt.*;

public class SnakeBody {
    private int xCoor;
    private int yCoor;
    private int wight;
    private int height;

    public SnakeBody(int xCoor, int yCoor, int size) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.wight = size;
        this.height = size;
    }
    public void draw(Graphics g) {
        g.setColor(new Color(0x381C23));
        g.fillRect(xCoor * wight, yCoor * height, wight, height);
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnakeBody snakeBody = (SnakeBody) o;
        return xCoor == snakeBody.xCoor && yCoor == snakeBody.yCoor;
    }
}
