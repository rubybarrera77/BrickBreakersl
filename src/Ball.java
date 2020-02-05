import java.awt.*;

public class Ball {

    int x, y;
    final int DIAMETER = 30;
    double dx = 5, dy = 5;

    Board board;

    public Ball(Board board){
        x = (board.getWidth()/2) - DIAMETER/2;
        y = board.getHeight() - (DIAMETER + 100);
    }

    public void move(){

        //LEFT AND RIGHT
        if(x < 0){
            dx*=-1;
        }
        if(y + DIAMETER >= board.getHeight()){
            dy*=-1;
        }

        /*if(y <= 0 || y + DIAMETER >= board.getHeight()) {
            dy*=-1;
        }
        if(x >= board.getWIDTH()){
            dx*=-1;
        }*/

        x+=dx;
        y+=dy;
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }


}