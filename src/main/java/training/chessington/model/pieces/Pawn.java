package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();
        if (getColour() == PlayerColour.WHITE && !offboard (board, from, -1) && !pieceInFront(board, from, -1)) {


            if (from.getRow() == 6 && !pieceInFront(board, from, -2)) {
                Coordinates white = new Coordinates(from.getRow() - 2, from.getCol());
                Move move = new Move(from, white);
                moves.add(move);

            }

            Coordinates white = new Coordinates(from.getRow() - 1, from.getCol());
            Move move = new Move(from, white);
            moves.add(move);


        } else if (getColour() == PlayerColour.BLACK && !offboard (board, from, 1) && !pieceInFront(board, from, 1)) {


            if (from.getRow() == 1 && !pieceInFront(board, from, 2)) {
                Coordinates black = new Coordinates(from.getRow() + 2, from.getCol());
                Move move = new Move(from, black);
                moves.add(move);
            }


            Coordinates black = new Coordinates(from.getRow() + 1, from.getCol());
            Move move = new Move(from, black);
            moves.add(move);


        }
        if (capturePiece(board, from, 1, 1)){
            Coordinates capture = new Coordinates(from.getRow() + 1, from.getCol() +1);
            Move move = new Move(from, capture);
            moves.add(move);
        }
        if (capturePiece(board, from, -1, -1)){
            Coordinates capture = new Coordinates(from.getRow() - 1, from.getCol() - 1);
            Move move = new Move(from, capture);
            moves.add(move);
        }
        if(capturePiece(board, from, 1, -1)){
            Coordinates capture = new Coordinates(from.getRow() + 1, from.getCol() - 1);
            Move move = new Move(from, capture);
            moves.add(move);
        }
        if(capturePiece(board,from, -1, 1)){
            Coordinates capture = new Coordinates(from.getRow() - 1, from.getCol() +1);
            Move move = new Move(from, capture);
            moves.add(move);

        }
        return moves;

    }

    private boolean pieceInFront(Board board, Coordinates from, int rowDiff) {
        Coordinates piece = new Coordinates(from.getRow() + rowDiff, from.getCol());
        if (board.get(piece) == null) {
            return false;
        }
        return true;
    }

    private boolean offboard (Board board, Coordinates from, int rowDiff){

            if (from.getRow() + rowDiff < 0 || from.getRow() + rowDiff >= 8){
                return true;
        }
            return false;
    }

    private boolean capturePiece (Board board, Coordinates from, int rowDiff, int colDiff) {
        Coordinates capture = new Coordinates(from.getRow() + rowDiff, from.getCol() + colDiff);
        if (board.get(capture)==null || board.get(capture).getColour() == getColour()) {
            return false;

        }
            return true;

    }
}
