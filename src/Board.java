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
    Brick[][] bricks = new Brick[10][18];
    Timer timer;

    public Board(Game game){
        this.game = game;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void setup(){
        player = new Player(this);
        ball = new Ball(this);
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 18; col++){
                bricks[row][col] = new Brick(getWidth()/15 + (col*60), row*30 + (getHeight()/10));
            }
        }
    }

    public void checkCollisions(){
        for(int i = 0; i < bricks.length; i++){
            for(int j = 0; j < bricks[0].length; j++){
                if(bricks[i][j] != null){
                    if(ball.getBounds().intersects(bricks[i][j].getBounds())){
                        ball.setDy(ball.getDy() * -1);
                        bricks[i][j] = null;
                    }
                }

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(game.isLeftPressed() && player.getX() > 0){
            player.moveLeft();
        }
        if(game.isRightPressed() && player.getX()+player.getWIDTH() < getWidth()){
            player.moveRight();
        }
        checkCollisions();
        ball.checkCollisions(player);
        ball.move();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.paint(g);
        ball.paint(g);
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 18; col++){
                if(bricks[row][col] != null){
                    bricks[row][col].paint(g);
                }
            }
        }

    }
}