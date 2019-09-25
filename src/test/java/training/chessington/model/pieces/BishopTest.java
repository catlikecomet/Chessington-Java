package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {

    @Test
    public void whiteBishopCanMove(){
        //Arrange
        Board board = Board.empty();
        Piece whiteBishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,2);
        board.placePiece(coords,whiteBishop);

        //Act
        List<Move> moves = whiteBishop.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-7,7)));
        assertThat(moves). contains(new Move(coords, coords.plus(-2,-2)));
    }

    @Test
    public void blackRookCanMove(){
        //Arrange
        Board board = Board.empty();
        Piece blackBishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0,5);
        board.placePiece(coords, blackBishop);

        //Act
        List<Move> moves = blackBishop.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(7,-7)));
        assertThat(moves).contains(new Move(coords, coords.plus(2,2)));
    }

}
