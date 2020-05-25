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
        String nextPlayer = game.nextPlayer();
        assertEquals("X", nextPlayer);
    }


}
