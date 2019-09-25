package training.chessington.model.pieces;

import sun.misc.ClassFileTransformer;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }

    protected boolean offboard (Board board, Coordinates from, int rowDiff, int colDiff){

        if (from.getRow() + rowDiff < 0 || from.getRow() + rowDiff >= 8 || from.getCol() + colDiff < 0 || from.getCol() + colDiff >=8){
            return true;
        }
        return false;
    }
    protected boolean friendly (Board board, PlayerColour colour, Coordinates from, int rowDiff, int colDiff){
        Coordinates friend = new Coordinates(from.getRow() + rowDiff, from.getCol() + colDiff);


        if (board.get(friend) != null && colour.equals(board.get(friend).getColour())) {
            return true;
        }
        return false;
    }
    protected boolean opponent (Board board, PlayerColour colour, Coordinates from, int rowDiff, int colDiff){
        Coordinates enemy = new Coordinates(from.getRow() + rowDiff, from.getCol() + colDiff);


        if (board.get(enemy) != null && !colour.equals(board.get(enemy).getColour())) {
            return true;
        }
        return false;
    }
    protected Coordinates move(Board board, PlayerColour colour, Coordinates from, int indexC, int indexR){
        if (!offboard(board, from, indexR - from.getRow(),indexC - from.getCol()) && !friendly(board, colour, from, indexR - from.getRow(), indexC - from.getCol()) && !opponent(board, colour, from, indexR - from.getRow(), indexC - from.getCol() + 1)){
            Coordinates Rook = new Coordinates(indexR, indexC);
            return Rook;

        }
        else {
            return null;
        }
    }

    protected List<Move> getMovesInDirection(Coordinates from, Board board, int rowDiff, int colDiff){
        Coordinates nextCoordinates = from;
        int changeR = rowDiff;
        int changeC = colDiff;
        List<Move> moves = new ArrayList<>();
        while(!offboard(board, nextCoordinates, rowDiff, colDiff) && !friendly(board, getColour(), nextCoordinates,  rowDiff, colDiff) && !opponent(board, getColour(), nextCoordinates, rowDiff - changeR,colDiff - changeC )){
            moves.add(new Move(from, nextCoordinates.plus(rowDiff,colDiff)));
            nextCoordinates=nextCoordinates.plus(rowDiff, colDiff);
        }
        return moves;
    }

}


