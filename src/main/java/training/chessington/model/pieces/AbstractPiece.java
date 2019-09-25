package training.chessington.model.pieces;

import sun.misc.ClassFileTransformer;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.PlayerColour;

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

    protected boolean offboard (Board board,Coordinates from, int rowDiff, int colDiff){

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
    protected boolean oponent (Board board, PlayerColour colour, Coordinates from, int rowDiff, int colDiff){
        Coordinates enimy = new Coordinates(from.getRow() + rowDiff, from.getCol() + colDiff);


        if (board.get(enimy) != null && !colour.equals(board.get(enimy).getColour())) {
            return true;
        }
        return false;
    }
}


