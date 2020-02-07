import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener{

    final int WIDTH = 1100;
    final int HEIGHT = 700;

    int score = 0;
    int lives = 3;

    Game game;
    Player player;
    Ball ball;
    Brick brick;
    Brick[][] bricks = new Brick[15][18];
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
        for(int row = 0; row < 15; row++){
            for(int col = 0; col < 18; col++){
                bricks[row][col] = new Brick(17 + (col*60), row*30 + 100); //100-17 = 83
            }
        }
    }

    public void checkCollisions(){
        for(int i = 0; i < bricks.length; i++){
            for(int j = 0; j < bricks[0].length; j++){
                if(bricks[i][j] != null){
                    if(ball.getBounds().intersects(bricks[i][j].getBounds())){
                        setScore(getScore() + 1);
                        ball.setDy(ball.getDy() * -1);
                        bricks[i][j] = null;
                    }
                }

            }
        }
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        String text = " ";
        if(Gamestates.isMENU()){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 72));
            text = "Brick Breaker";
            printSimpleString(text, 0, getWidth()/2, (getHeight()/2) -50, g);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            printSimpleString("Press ENTER to play!", 0, getWidth()/2, (getHeight()/2) +50, g);
        }

        if(Gamestates.isLOSE()){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 72));
            printSimpleString("You Lost", 0, getWidth()/2, (getHeight()/2) -50, g);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            printSimpleString("Press ENTER to play!", 0, getWidth()/2, (getHeight()/2) +50, g);
        }

        if(Gamestates.isPLAY()){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            printSimpleString("Score: " + (Integer.toString(score)), 50, 950, 50, g);
            printSimpleString("Lives: " + (Integer.toString(lives)), 50, 90, 50, g);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            printSimpleString("Break Breaker", 50, getWidth()/2, 60, g);
            player.paint(g);
            ball.paint(g);
            for(int row = 0; row < 15; row++){
                for(int col = 0; col < 18; col++){
                    if(bricks[row][col] != null){
                        bricks[row][col].paint(g);
                    }
                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Gamestates.isPLAY() && !Gamestates.isPAUSE()){
            if(game.isLeftPressed() && player.getX() > 0){
                player.moveLeft();
            }
            if(game.isRightPressed() && player.getX()+player.getWIDTH() < getWidth()){
                player.moveRight();
            }
            checkCollisions();
            ball.checkCollisions(player);
            ball.move();
        }

        if (game.isEnterPressed()) {
            Gamestates.setPLAY(true);
            Gamestates.setMENU(false);
        }

        if(lives == 0){
            Gamestates.setLOSE(true);
            Gamestates.setPLAY(false);
            lives = 3;
            score = 0;
            if (game.isEnterPressed()){
                Gamestates.setLOSE(false);
                Gamestates.setPLAY(true);
                Gamestates.setMENU(false);
            }
        }

        if (game.ispPressed()){
            if(Gamestates.isPAUSE()){
                Gamestates.setPAUSE(false);
            } else{
                Gamestates.setPAUSE(true);
            }
        }

        repaint();
    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g){
        int stringLen = (int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        int start = width/2 - stringLen/2;
        g.drawString(s, start+XPos, YPos);

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}