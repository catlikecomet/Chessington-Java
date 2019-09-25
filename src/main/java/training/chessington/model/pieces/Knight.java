package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();

        if (!offboard(board,from,2,1) && !friendly(board, colour, from, 2,1)){
            Coordinates knightMoves = new Coordinates(from.getRow() +2, from.getCol() +1);
            Move move = new Move(from,knightMoves);
            moves.add(move);
        }
        if (!offboard(board,from,1,2) && !friendly(board, colour, from, 1,2)) {
            Coordinates knightMoves = new Coordinates(from.getRow() +1, from.getCol() +2);
            Move move = new Move(from, knightMoves);
            moves.add(move);
        }
        if (!offboard(board,from,2,-1) && !friendly(board, colour, from, 2,-1)) {
            Coordinates knightMoves = new Coordinates(from.getRow() +2, from.getCol() -1);
            Move move = new Move(from, knightMoves);
            moves.add(move);
        }
        if (!offboard(board,from,1,-2) && !friendly(board, colour, from, 1,-2)) {
            Coordinates knightMoves = new Coordinates(from.getRow() +1, from.getCol() -2);
            Move move = new Move(from, knightMoves);
            moves.add(move);
        }
        if (!offboard(board,from,-2,1) && !friendly(board, colour, from, -2,1)) {
            Coordinates knightMoves = new Coordinates(from.getRow() -2, from.getCol() +1);
            Move move = new Move(from, knightMoves);
            moves.add(move);
        }
        if (!offboard(board,from,-1,+2) && !friendly(board, colour, from, -1,+2)) {
            Coordinates knightMoves = new Coordinates(from.getRow() -1, from.getCol()+2);
            Move move = new Move(from, knightMoves);
            moves.add(move);
        }
        if (!offboard(board,from,-2,-1) && !friendly(board, colour, from, -2,-1)) {
            Coordinates knightMoves = new Coordinates(from.getRow()-2, from.getCol()-1);
            Move move = new Move(from, knightMoves);
            moves.add(move);
        }
        if (!offboard(board,from,-1,-2) && !friendly(board, colour, from, -1,-2)) {
            Coordinates knightMoves = new Coordinates(from.getRow()-1, from.getCol()-2);
            Move move = new Move(from, knightMoves);
            moves.add(move);
        }
        return moves;
    }
}
