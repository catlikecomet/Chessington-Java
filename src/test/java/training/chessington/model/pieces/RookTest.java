package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {

    @Test
    public void whiteRookCanMove(){
        //Arrange
        Board board = Board.empty();
        Piece whiteRook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7,0);
        board.placePiece(coords,whiteRook);

        //Act
        List<Move> moves = whiteRook.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-7,0)));
        assertThat(moves).contains(new Move(coords,coords.plus(0,7)));
    }

    @Test
    public void blackRookCanMove(){
        //Arrange
        Board board = Board.empty();
        Piece blackRook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0,7);
        board.placePiece(coords,blackRook);

        //Act
        List<Move> moves = blackRook.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(7,0)));
        assertThat(moves).contains(new Move(coords,coords.plus(0,-7)));
    }

    @Test
    public void rookCannotGoOffBoard(){
        //Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0,7);
        board.placePiece(coords, rook);
        List<Move> expectedMoves = new ArrayList<>();
        expectedMoves.add(new Move(coords, new Coordinates(4,7)));

        //Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        //Assert
        for (Move move: expectedMoves){
            assertThat(moves).contains(move);
        }
        assertThat(moves.size()).isEqualTo(expectedMoves.size());

    }

    @Test
    public void rookCannotGoThroughFriendly(){
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(7,0);
        board.placePiece(rookCoords,rook);

        Piece friendly = new Pawn(PlayerColour.WHITE);
        Coordinates friendlyCoords = new Coordinates(6,0);
        board.placePiece(friendlyCoords, friendly);

        Piece friendlySide = new Pawn(PlayerColour.WHITE);
        Coordinates sideCoords = new Coordinates(7,2);
        board.placePiece(sideCoords, friendlySide);


        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);

        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(0,1)));
    }
}
