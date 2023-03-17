package src.chess.pieces;

import src.boardgame.Board;
import src.boardgame.Position;
import src.chess.ChessPiece;

public class Pawn extends ChessPiece {
    public Pawn(Board board, src.chess.pieces.Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);
        if (getColor() == src.chess.pieces.Color.WHITE){
            p.setValues(position.getRow()-1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow()-2, position.getColumn());
            Position p2 = new Position(position.getRow()-1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)&& getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)&&getMoveCount() ==0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow()-1, position.getColumn()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow()-1, position.getColumn()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }else {
            p.setValues(position.getRow()+1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow()+2, position.getColumn());
            Position p2 = new Position(position.getRow()-1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)&& getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)&&getMoveCount() ==0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow()+1, position.getColumn()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow()+1, position.getColumn()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
}
