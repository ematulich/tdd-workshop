package tictactoe;

public class TicTacToe {
    private final static String EMPTY_POSITION = "-";
    private final static String X_PLAYER = "X";
    private final static String O_PLAYER = "O";
    private String currentPlayer;
    private final String[][] board = new String[][]{
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION},
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION},
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION}};


    public void play(final int x, final int y) throws RuntimeException{
        checkAxisPosition(x, y);
        nextPlayer();
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
        board[x][y] = currentPlayer;
    }

    public String nextPlayer(){
        currentPlayer = X_PLAYER.equals(currentPlayer)? O_PLAYER: X_PLAYER;
        return currentPlayer;
    }

}
