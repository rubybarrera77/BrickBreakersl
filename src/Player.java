import java.awt.*;

public class Player {
    int x, y;
    final int WIDTH = 150, HEIGHT = 20;
    double dx= 7;
    Board board;
    Ball ball;

    public Player(Board board){
        x = (board.getWidth()/2) - WIDTH/2;
        y = board.getHeight() - (HEIGHT + 30);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void moveRight(){
        x+=dx;
    }

    public void moveLeft(){
        x-=dx;
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public int getX(){
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public int getWIDTH(){
        return WIDTH;
    }

}