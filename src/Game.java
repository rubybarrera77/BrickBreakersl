import javax.swing.*;

public class Game extends JFrame {

    Board board;

    public Game(){
        setTitle("Brick Breaker");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new Board(this);
        add(board);
        pack();

        setLocationRelativeTo(null);
        board.setup();
    }


    public static void main(String[] args){
        new Game();
    }
}