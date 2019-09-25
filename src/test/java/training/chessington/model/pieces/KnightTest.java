package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {

    @Test
    public void whiteKnightCanMove(){
        //Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,1);
        board.placePiece(coords, knight);

        //Act
        List<Move> moves = knight.getAllowedMoves(coords,board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2,1)));
    }

    @Test
    public void blackKnightCanMove(){
        //Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0,1);
        board.placePiece(coords, knight);

        //Act
        List<Move> moves = knight.getAllowedMoves(coords,board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(2,1)));
    }

    @Test
    public void knightCannotGoOffBoard(){
        //Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0, 7);
        board.placePiece(coords, knight);
        List<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(coords, new Coordinates(2,6)));
        expectedMoves.add(new Move(coords, new Coordinates(1,5)));


        //Act
        List<Move> Moves = knight.getAllowedMoves(coords, board);


        //Assert
        for (Move move: expectedMoves){
            assertThat(Moves).contains(move);
        }
        assertThat(Moves.size()).isEqualTo(expectedMoves.size());

    }
}
