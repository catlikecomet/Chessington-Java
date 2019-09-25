package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();

        if (!offboard(board,from,-1,-1) && !friendly(board, colour, from, -1,-1)){
            Coordinates kingMoves = new Coordinates(from.getRow() -1, from.getCol() -1);
            Move move = new Move(from,kingMoves);
            moves.add(move);
        }
        if (!offboard(board,from,-1,1) && !friendly(board, colour, from, -1,1)) {
            Coordinates kingMoves = new Coordinates(from.getRow() - 1, from.getCol() +1);
            Move move = new Move(from, kingMoves);
            moves.add(move);
        }
        if (!offboard(board,from,-1,0) && !friendly(board, colour, from, -1,0)) {
            Coordinates kingMoves = new Coordinates(from.getRow() - 1, from.getCol());
            Move move = new Move(from, kingMoves);
            moves.add(move);
        }
        if (!offboard(board,from,1,-1) && !friendly(board, colour, from, 1,-1)) {
            Coordinates kingMoves = new Coordinates(from.getRow() + 1, from.getCol() - 1);
            Move move = new Move(from, kingMoves);
            moves.add(move);
        }
        if (!offboard(board,from,1,1) && !friendly(board, colour, from, 1,1)) {
            Coordinates kingMoves = new Coordinates(from.getRow() + 1, from.getCol() + 1);
            Move move = new Move(from, kingMoves);
            moves.add(move);
        }
        if (!offboard(board,from,1,0) && !friendly(board, colour, from, 1,0)) {
            Coordinates kingMoves = new Coordinates(from.getRow() + 1, from.getCol());
            Move move = new Move(from, kingMoves);
            moves.add(move);
        }
        if (!offboard(board,from,0,1) && !friendly(board, colour, from, 0,1)) {
            Coordinates kingMoves = new Coordinates(from.getRow(), from.getCol() + 1);
            Move move = new Move(from, kingMoves);
            moves.add(move);
        }
        if (!offboard(board,from,0,-1) && !friendly(board, colour, from, 0,-1)) {
            Coordinates kingMoves = new Coordinates(from.getRow(), from.getCol() - 1);
            Move move = new Move(from, kingMoves);
            moves.add(move);
        }
        return moves;
    }
}
