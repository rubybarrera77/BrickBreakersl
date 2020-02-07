import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    Board board;
    boolean rightPressed, leftPressed, enterPressed, pPressed;

    public Game(){
        setTitle("Brick Breaker");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new Board(this);
        add(board);
        addKeyListener(this);
        pack();

        board.setup();
        setLocationRelativeTo(null);
    }


    public static void main(String[] args){
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            enterPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_P){
            pPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            enterPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_P){
            pPressed = false;
        }
    }

    public boolean isLeftPressed(){
        return leftPressed;
    }

    public boolean isRightPressed(){
        return rightPressed;
    }

    public boolean isEnterPressed(){
        return enterPressed;
    }

    public boolean ispPressed(){
        return pPressed;
    }
}