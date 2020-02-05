import java.awt.*;

public class Brick {

    int x, y, WIDTH = 50 , HEIGHT = 20;

    public Brick(){
        x = 70;
        y = 70;
    }

    public Brick(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }



}