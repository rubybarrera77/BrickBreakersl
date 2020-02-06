import java.awt.*;

public class Brick {

    int x, y, WIDTH = 50 , HEIGHT = 20;

    int r = (int)(Math.random()*256);
    int g = (int)(Math.random()*256);
    int b = (int)(Math.random()*256);

    Color color = new Color(r, g, b);
    public Color getColor(){
        return color;
    }

    public Brick(){
        x = 70;
        y = 70;
    }

    public Brick(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        g.setColor(getColor());
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

}