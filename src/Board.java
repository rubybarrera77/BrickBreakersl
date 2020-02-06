import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener{

    final int WIDTH = 1200;
    final int HEIGHT = 700;

    Game game;
    Player player;
    Ball ball;
    Brick brick;
    Brick[][] bricks = new Brick[7][15];
    Timer timer;

    public Board(Game game){
        this.game = game;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.PINK);
        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void setup(){
        player = new Player(this);
        ball = new Ball(this);
        for(int row = 0; row < 7; row++){
            for(int col = 0; col < 15; col++){
                bricks[row][col] = new Brick(getWidth()/7 + (col*60), row*30 + (getHeight()/5));
            }
        }
    }

    public void checkCollisions(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(game.isLeftPressed() && player.getX() > 0){
            player.moveLeft();
        }
        if(game.isRightPressed() && player.getX()+player.getWIDTH() < getWidth()){
            player.moveRight();
        }
        ball.checkCollisions(player);
        ball.move();
        repaint();
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