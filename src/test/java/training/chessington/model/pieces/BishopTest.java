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
        assertThat(moves).contains(new Move(coords, coords.plus(-1,1)));
        assertThat(moves). contains(new Move(coords, coords.plus(-1,-1)));
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
        assertThat(moves).contains(new Move(coords, coords.plus(1,1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1,-1)));
    }

    @Test
    public void bishopCannotGoOffBoard(){
        //Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5,0);
        board.placePiece(coords, bishop);
        List<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(coords, new Coordinates(3,2)));

        //Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        //Assert
        for (Move move: expectedMoves){
            assertThat(moves).contains(move);
        }
    }

    @Test
    public void bishopCannotGoThroughFriendly(){
        //Arrange
        Board board = Board.empty();

        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates bishopCoords = new Coordinates(7,2);
        board.placePiece(bishopCoords, bishop);

        Piece friendlyRight = new Pawn(PlayerColour.WHITE);
        Coordinates friendlyCoords = new Coordinates(6,3);
        board.placePiece(friendlyCoords, friendlyRight);

        Piece friendlyLeft = new Pawn(PlayerColour.WHITE);
        Coordinates otherCoords = new Coordinates(5,0);
        board.placePiece(otherCoords,friendlyLeft);

        //Act
        List<Move> bishopMoves = bishop.getAllowedMoves(bishopCoords, board);

        //Assert
        assertThat(bishopMoves).contains(new Move(bishopCoords, bishopCoords.plus(-1,-1)));


    }

}
