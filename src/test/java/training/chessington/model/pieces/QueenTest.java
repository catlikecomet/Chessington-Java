package training.chessington.model.pieces;

import org.junit.Assert;
import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class QueenTest {

    @Test
    public void whiteQueenCanMove(){
        //Arrange
        Board board = Board.empty();
        Piece whiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,3);
        board.placePiece(coords, whiteQueen);

        //Act
        List<Move> moves = whiteQueen.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-2,-2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2,0)));
    }

    @Test
    public void blackQueenCanMove(){
        //Arrange
        Board board = Board.empty();
        Piece blackQueen = new Queen(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0,3);
        board.placePiece(coords, blackQueen);

        //Act
        List<Move> moves = blackQueen.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(3,3)));
        assertThat(moves).contains(new Move(coords, coords.plus(3,0)));
    }

    @Test
    public void queenCannotGoOffBoard(){
        //Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5,7);
        board.placePiece(coords, queen);
        List<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(coords, new Coordinates(5,4)));

        //Act
        List<Move> moves = queen.getAllowedMoves(coords,board);

        //Assert
        for(Move move: expectedMoves){
            assertThat(moves).contains(move);
        }

    }

    @Test
    public void queenCannotGoThroughFriendly(){
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(7, 3);
        board.placePiece(queenCoords, queen);

        Piece friendDiagonal = new Pawn(PlayerColour.WHITE);
        Coordinates diagCoords = new Coordinates(5,1);
        board.placePiece(diagCoords, friendDiagonal);

        Piece friendNextTo = new Pawn(PlayerColour.WHITE);
        Coordinates nextCoords = new Coordinates(7,4);
        board.placePiece(nextCoords, friendNextTo);

        //Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);

        //Assert
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(-1,-1)));
    }
}
