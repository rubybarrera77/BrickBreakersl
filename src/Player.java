import java.awt.*;

public class Player {
    int x, y;
    int WIDTH = 200, HEIGHT = 20;

    public Player(Board board){
        x = (board.getWidth()/2) - WIDTH/2;
        y = board.getHeight() - (HEIGHT + 50);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

}
