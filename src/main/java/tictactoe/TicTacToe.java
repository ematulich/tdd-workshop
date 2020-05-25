package tictactoe;

public class TicTacToe {


    public void play(int x, int y) throws RuntimeException{
       if ( x < 1 || x > 3){
           throw new RuntimeException("Position selected outside the board");
       }
    }

}
