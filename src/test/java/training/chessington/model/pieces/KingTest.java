package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {

    @Test
    public void whiteKingsCanMoveOneSpaceAnyDirection(){
        //Arrange
        Board board = Board.empty();
        Piece whiteKing = new King(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(7,4);
        board.placePiece(whiteCoords, whiteKing);

        //Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);

        //Assert
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-1, 0)));


    }

    @Test
    public void blackKingsCanMoveOneSpaceAnyDirection(){
        //Arrange
        Board board = Board.empty();
        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(0,3);
        board.placePiece(blackCoords, blackKing);

        //Act
        List<Move> blackMoves = blackKing.getAllowedMoves(blackCoords, board);

        //Assert
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(1, 0)));

    }

    @Test
    public void kingsCannotGoOffBoard(){
        //Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0, 7);
        board.placePiece(coords, king);
        List<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(coords, new Coordinates(0,6)));
        expectedMoves.add(new Move(coords, new Coordinates(1,6)));
        expectedMoves.add(new Move(coords, new Coordinates(1,7)));


        //Act
        List<Move> moves = king.getAllowedMoves(coords, board);


        //Assert
        for (Move move: expectedMoves){
            assertThat(moves).contains(move);
        }
        assertThat(moves.size()).isEqualTo(expectedMoves.size());

    }

}
