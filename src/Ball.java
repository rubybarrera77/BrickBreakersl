import java.awt.*;

public class Ball {

    int x, y;
    final int DIAMETER = 30;
    final int SPEED = 5;

    double dx = SPEED, dy = SPEED;

    Board board;

    public Ball(Board board){
        x = (board.getWidth()/2) - DIAMETER/2;
        y = board.getHeight() - (DIAMETER + 100);

        this.board = board;
    }

    public void move(){
        if(x < 0){
            dx*=-1;
        }
        if(x+ DIAMETER >= board.getWidth()){
            dx*=-1;
        }
        if(y <= 0){
            dy*=-1;
        }

        x+=dx;
        y+=dy;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    public void checkCollisions(Player p){
        if(getBounds().intersects(p.getBounds())){
            double player = p.getBounds().getX();
            double ballx = x;

            if(x + (DIAMETER/2) < player){
                ballx = x + DIAMETER;
            } else if (x + (DIAMETER/2) > player + p.getBounds().getWidth()){
                ballx = x;
            } else {
                ballx = x + DIAMETER;

                if(x < board.getHeight()/2){
                    dy*=-1;
                }
                if(x > (board.getHeight()/2)){
                    dy*=-1;
                }
            }
        }

        if(y + DIAMETER >= board.getHeight()){
            board.setLives(board.getLives()-1);
            p.setX(board.getWidth()/4);
            setX((board.getWidth()/2) - DIAMETER/2);
            dy*=-1;
        }

    }


    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public int getDiam(){
        return DIAMETER;
    }
}