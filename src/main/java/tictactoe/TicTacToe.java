package tictactoe;

public class TicTacToe {
    private final static char EMPTY_POSITION = '-';
    private final static char X_PLAYER = 'X';
    private final static char O_PLAYER = 'O';
    private char currentPlayer;
    private final char[][] board = new char[][]{
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION},
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION},
            {EMPTY_POSITION,EMPTY_POSITION,EMPTY_POSITION}};


    public String play(final int x, final int y) throws RuntimeException{
        checkAxisPosition(x, y);
        nextPlayer();
        placePiece(x - 1, y - 1);
        if (winFrom(x - 1, y - 1)){
            return "Player " + currentPlayer + " is the winner";
        }
        return "No winner yet";
    }

    private void checkAxisPosition(final int x, final int y) throws RuntimeException{
        if ( !(x >= 1 && x <= 3) || !(y >= 1 && y <= 3)){
            throw new RuntimeException("Position selected outside the board");
        }
    }

    private void placePiece(final int x, final int y) throws RuntimeException{
        if (board[x][y] != EMPTY_POSITION){
            throw new RuntimeException("Position is occupied");
        }
        board[x][y] = currentPlayer;
    }

    public char nextPlayer(){
        currentPlayer = X_PLAYER == currentPlayer ? O_PLAYER: X_PLAYER;
        return currentPlayer;
    }

    private boolean winFrom(int x, int y){
        int totalPlayer = 3 * currentPlayer;
        int horizontalLine = board[x][0] + board[x][1] + board[x][2];
        if (horizontalLine == totalPlayer){
            return true;
        }
        return false;
    }

}
