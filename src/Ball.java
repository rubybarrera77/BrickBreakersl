import java.awt.*;

public class Ball {

    int x, y;
    final int DIAMETER = 30;
    double speed, dx = 5, dy;

    public Ball(Board board){
        x = (board.getWidth()/2) - DIAMETER/2;
        y = board.getHeight() - (DIAMETER + 100);
    }

    public void moveRight(){
        x += dx;
    }

    public void moveLeft(){
        x -= dx;
    }
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
}
