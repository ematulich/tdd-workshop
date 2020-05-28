package tictactoe;

public class TicTacToe {
    private final static char EMPTY_POSITION = '-';
    private final char[][] board = new char[][]{
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION},
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION},
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION}};


    public void play(int x, int y) throws RuntimeException{
        if ( x < 1 || x > 3){
            throw new RuntimeException("Position selected outside the board");
        }
        if ( y < 1 || y > 3){
            throw new RuntimeException("Position selected outside the board");
        }
        int realX = x - 1;
        int realY = y - 1;
        if (board[realX][realY] != EMPTY_POSITION){
            throw new RuntimeException("Position is occupied");
        }
        board[realX][realY] = 'X';
    }

}
