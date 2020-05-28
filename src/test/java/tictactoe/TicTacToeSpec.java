package tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TicTacToe game;

    @Before
    public final void beforeSetUp(){
        game = new TicTacToe();
    }


    @Test
    public void whenXAxisIsOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        game.play(4, 2);
    }

    @Test
    public void whenYAxisIsOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        game.play(1, 5);
    }

    @Test
    public void whenSelectedPositionOccupiedThenRuntimeException(){
        game.play(1, 1);
        exception.expect(RuntimeException.class);
        game.play(1, 1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenXPlayer(){
        char nextPlayer = game.nextPlayer();
        assertEquals('X', nextPlayer);
    }

    @Test
    public void givenLastTurnWasXPlayerWhenNextPlayerThenOPlayer(){
        game.play(1, 1);
        char nextPlayer = game.nextPlayer();
        assertEquals('O', nextPlayer);
    }

    /**
     * Test 6 es un falso positivo, no hay que hacer nada para cubrir este test
     * por ende debe ser eliminado
     */
/*    @Test
    public void givenLastTurnWasOPlayerWhenNextPlayerThenXPlayer(){
        game.play(1, 1);
        game.play(1, 2);
        String nextPlayer = game.nextPlayer();
        assertEquals("X", nextPlayer);
    }*/

    @Test
    public void whenPlayOnceThenNoWinner(){
        String result = game.play(1,1);
        assertEquals("No winner yet", result);
    }

    @Test
    public void whenPlayAndHorizontalLineFilledThenWinner(){
        /**
         * x - x -x
         * O - O -
         * - -   -
         */
        game.play(1,1);
        game.play(2,1);
        game.play(1,2);
        game.play(2,2);
        String result = game.play(1,3);
        assertEquals("Player X is the winner", result);
    }

    @Test
    public void whenPlayAndVerticalLineFilledThenWinner(){
        /**
         * O - X - X
         * O - X -
         * O -   -
         */
        game.play(1,2);
        game.play(1,1);
        game.play(1,3);
        game.play(2,1);
        game.play(2,2);
        String result = game.play(3,1);
        assertEquals("Player O is the winner", result);
    }

    @Test
    public void whenPlayAndMainDiagonalLineFilledThenWinner(){
        /**
         * X - O - O
         *   - X -
         *   -   - X
         */
        game.play(1,1);
        game.play(1,2);
        game.play(2,2);
        game.play(1,3);
        String result = game.play(3,3);
        assertEquals("Player X is the winner", result);
    }

    @Test
    public void whenPlayAndSecondaryDiagonalLineFilledThenWinner(){
        /**
         * 0 - O - x
         *   - X -
         * X -   -
         */
        game.play(1,3);
        game.play(1,1);
        game.play(2,2);
        game.play(1,2);
        String result = game.play(3,1);
        assertEquals("Player X is the winner", result);
    }

}
