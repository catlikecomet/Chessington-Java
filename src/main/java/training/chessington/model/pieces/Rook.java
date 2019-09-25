package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();

        for (int index = from.getRow() + 1; index  < 8; index ++ ){
            if (!offboard(board, from, index,0) && !friendly(board, colour, from, index, 0)){
                Coordinates Rook = new Coordinates(from.getRow()+index, from.getCol());
                Move move = new Move(from,Rook);
                moves.add(move);
            }else {
                break;
            }
        }
        for (int index = from.getRow() - 1; index  > 0; index -- ){
            if (!offboard(board, from, index,0) && !friendly(board, colour, from, index, 0)){
                Coordinates Rook = new Coordinates(from.getRow() - index, from.getCol());
                Move move = new Move(from,Rook);
                moves.add(move);
            }else {
                break;
            }
        }
        for (int index = from.getCol() + 1; index  < 8; index ++ ){
            if (!offboard(board, from, index,0) && !friendly(board, colour, from, index, 0)){
                Coordinates Rook = new Coordinates(from.getRow(), from.getCol()+ index);
                Move move = new Move(from,Rook);
                moves.add(move);
            }else {
                break;
            }
        }
        for (int index = from.getCol() - 1; index  > 0; index -- ){
            if (!offboard(board, from, index,0) && !friendly(board, colour, from, index, 0)){
                Coordinates Rook = new Coordinates(from.getRow(), from.getCol()+ index);
                Move move = new Move(from,Rook);
                moves.add(move);
            }else {
                break;
            }
        }

        return moves;
    }
}
