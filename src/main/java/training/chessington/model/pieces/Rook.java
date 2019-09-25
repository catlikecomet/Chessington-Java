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

        moves.addAll(getMovesInDirection(from, board, 1,0));
        moves.addAll(getMovesInDirection(from, board, -1,0));
        moves.addAll(getMovesInDirection(from, board, 0,1));
        moves.addAll(getMovesInDirection(from, board, 0,-1));

        for (int indexR = from.getRow() + 1; indexR  < 8; indexR ++ ){
            int indexC = from.getCol();
            if (!offboard(board, from, indexR - from.getRow(),0) && !friendly(board, colour, from, indexR - from.getRow(), 0) && !oponent(board, colour, from, indexR - from.getRow() -1, 0)){
                Coordinates Rook = new Coordinates(indexR, from.getCol());
                Move move = new Move(from,Rook);
                moves.add(move);
            }else {
                break;
            }
        }
        for (int indexR = from.getRow() - 1; indexR  >= 0; indexR -- ){
            int indexC = from.getCol();
            Coordinates result = move(board,colour ,from, indexR,indexC);
            if (result != null){

            }
            else {
                break;
            }
        }
        for (int indexC = from.getCol() + 1; indexC  < 8; indexC ++ ){
            int indexR = from.getRow();
            if (!offboard(board, from, 0,indexC - from.getCol()) && !friendly(board, colour, from, 0, indexC - from.getCol()) && !oponent(board, colour, from, 0, indexC - from.getCol() - 1)){

            }else {
                break;
            }
        }
        for (int indexC = from.getCol() - 1; indexC  >= 0; indexC -- ){
            int indexR = from.getRow();
            if (!offboard(board, from, 0,indexC - from.getCol()) && !friendly(board, colour, from, 0, indexC - from.getCol()) && !oponent(board, colour, from, 0, indexC - from.getCol() + 1)){
                Coordinates Rook = new Coordinates(from.getRow(), indexC);
                Move move = new Move(from,Rook);
                moves.add(move);
            }else {
                break;
            }
        }

        return moves;
    }
}
