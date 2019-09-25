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
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(1, 0)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(0,1)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-1, 0)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(0, -1)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(1, 1)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-1, -1)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(-1, 1)));
        assertThat(whiteMoves).contains(new Move(whiteCoords, whiteCoords.plus(1, -1)));

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
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(0,1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-1, 0)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(0, -1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(1, 1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-1, -1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-1, 1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(1, -1)));

    }

    @Test
    public void kingsCannotGoOffTopBoard(){
        //Arrange
        Board board = Board.empty();

        Piece whiteKing = new King(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(0, 4);
        board.placePiece(whiteCoords, whiteKing);

        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(0,3);
        board.placePiece(blackCoords, blackKing);

        //Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackKing.getAllowedMoves(blackCoords, board);

        //Assert
        assertThat(whiteMoves).isEmpty();
        assertThat(blackMoves).isEmpty();

    }

    @Test
    public void kingsCannotGoOffBottomBoard(){
        //Arrange
        Board board = Board.empty();

        Piece whiteKing = new King(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(7, 4);
        board.placePiece(whiteCoords, whiteKing);

        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(7,3);
        board.placePiece(blackCoords, blackKing);

        //Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackKing.getAllowedMoves(blackCoords, board);

        //Assert
        assertThat(whiteMoves).isEmpty();
        assertThat(blackMoves).isEmpty();
    }

    @Test
    public void kingsCannotGoOffLeftSideBoard(){
        //Arrange
        Board board = Board.empty();

        Piece whiteKing = new King(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(7,0);
        board.placePiece(whiteCoords, whiteKing);

        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(0, 0);
        board.placePiece(blackCoords, blackKing);

        //Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackKing.getAllowedMoves(blackCoords, board);

        //Assert
        assertThat(whiteMoves).isEmpty();
        assertThat(blackMoves).isEmpty();
    }
    @Test
    public void kingsCannotGoOffRightSideBoard(){
        //Arrange
        Board board = Board.empty();

        Piece whiteKing = new King(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(7,7);
        board.placePiece(whiteCoords, whiteKing);

        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(0, 7);
        board.placePiece(blackCoords, blackKing);

        //Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackKing.getAllowedMoves(blackCoords, board);

        //Assert
        assertThat(whiteMoves).isEmpty();
        assertThat(blackMoves).isEmpty();
    }

    @Test
    public void kingsCannotGoOffBoardDiagonally(){
        //Arrange
        Board board = Board.empty();

        Piece whiteKing = new King(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(4,0);
        board.placePiece(whiteCoords, whiteKing);

        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(3, 0);
        board.placePiece(blackCoords, blackKing);

        //Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);
        List<Move> blackMoves = blackKing.getAllowedMoves(blackCoords, board);

        //Assert
        assertThat(whiteMoves).isEmpty();
        assertThat(blackMoves).isEmpty();

    }

    @Test
    public void kingsCanCaptureInDiagonalOneSpace(){
        //Arrange
        Board board = Board.empty();

        Piece whiteKing = new King(PlayerColour.WHITE);
        Piece blackEnemyPiece = new Rook(PlayerColour.BLACK);
        Coordinates whiteKingCoords = new Coordinates(7,4);
        board.placePiece(whiteKingCoords,whiteKing);

        Coordinates whiteEnemyCoords = whiteKingCoords.plus(-1,1);
        board.placePiece(whiteEnemyCoords,blackEnemyPiece);

        Piece blackKing = new King(PlayerColour.BLACK);
        Piece whiteEnemyPiece = new Rook(PlayerColour.WHITE);
        Coordinates blackKingCoords = new Coordinates(0,3);
        board.placePiece(blackKingCoords,blackKing);

        Coordinates blackEnemyCoords = blackKingCoords.plus(1,1);
        board.placePiece(blackEnemyCoords,blackEnemyPiece);

        //Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteKingCoords,board);
        List<Move> blackMoves = blackKing.getAllowedMoves(blackKingCoords,board);

        //Assert
        assertThat(whiteMoves).contains(new Move(whiteKingCoords,whiteEnemyCoords));
        assertThat(blackMoves).contains(new Move(blackKingCoords,blackEnemyCoords));

    }

}
