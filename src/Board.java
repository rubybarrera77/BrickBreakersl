import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    Game game;
    Player player;
    Ball ball;
    Brick brick;
    Brick[][] bricks = new Brick[7][15];

    public Board(Game game){
        this.game = game;
        setPreferredSize(new Dimension(1200, 700));
        setBackground(Color.BLUE);
    }
    
    public void setup(){
        player = new Player(this);
        ball = new Ball(this);
        for(int row = 0; row < 7; row++){
            for(int col = 0; col < 15; col++){
                bricks[row][col] = new Brick(getWidth()/6 + (col*60), row*30 + (getHeight()/6));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.paint(g);
        ball.paint(g);
        for(int row = 0; row < 7; row++){
            for(int col = 0; col < 15; col++){
                bricks[row][col].paint(g);
            }
        }
    }


}
