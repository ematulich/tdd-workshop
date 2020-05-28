package tictactoe;

public class TicTacToe {
    private final static char EMPTY_POSITION = '-';
    private final static char X_PLAYER = 'X';
    private final char[][] board = new char[][]{
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION},
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION},
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION}};


    public void play(final int x, final int y) throws RuntimeException{
        checkAxisPosition(x, y);
        placePiece(x - 1, y - 1);
    }

    public void checkAxisPosition(final int x, final int y) throws RuntimeException{
        if ( !(x >= 1 && x <= 3) || !(y >= 1 && y <= 3)){
            throw new RuntimeException("Position selected outside the board");
        }
    }

    public void placePiece(final int x, final int y) throws RuntimeException{
        if (board[x][y] != EMPTY_POSITION){
            throw new RuntimeException("Position is occupied");
        }
        board[x][y] = 'X';
    }

    public char nextPlayer(){
        return X_PLAYER;
    }

}
