package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import javax.swing.*;
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

        Piece King = new King(PlayerColour);
        Coordinates whiteCoords = new Coordinates(0, 4);
        board.placePiece(whiteCoords, King);


        //Act
        List<Move> Moves = King.getAllowedMoves(whiteCoords, board);


        //Assert
        assertThat(Moves).;

    }

}
