package tictactoe;

public class TicTacToe {
    private final static char EMPTY_POSITION = '-';
    private final static char X_PLAYER = 'X';
    private final static char O_PLAYER = 'O';
    private final byte BOARD_SIZE = 3;
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
        if(draw()){
            return "The result is a draw";
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

    private boolean winFrom(int x, int y) {
        int playerTotal = currentPlayer * BOARD_SIZE;
        int horizontal, vertical, mainDiagonal, secondaryDiagonal;
        horizontal = vertical = mainDiagonal = secondaryDiagonal = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            horizontal += board[x][i];
            vertical += board[i][y];
            mainDiagonal += board[i][i];
            secondaryDiagonal += board[i][BOARD_SIZE - i - 1];
        }

        if (playerTotal == mainDiagonal
                || playerTotal == secondaryDiagonal
                || playerTotal == horizontal
                || playerTotal == vertical) {
            return true;
        }
        return false;
    }

    private boolean draw(){
        for(int i = 0; i< BOARD_SIZE; i++){
            for(int j = 0; j< BOARD_SIZE; j++){
                if (board[i][j] == EMPTY_POSITION){
                    return false;
                }
            }
        }
        return true;
    }

}
