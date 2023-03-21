package src.chess.pieces;

import src.boardgame.Board;
import src.boardgame.Position;
import src.chess.ChessMath;
import src.chess.ChessPiece;

public class King extends ChessPiece {

    private ChessMath chessMath;
    public King(Board board, src.chess.pieces.Color color, ChessMath chessMath) {
        super(board, color);
        this.chessMath = chessMath;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRockCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //above
        p.setValues(position.getRow()-1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //bellow
        p.setValues(position.getRow()+1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //left
        p.setValues(position.getRow(), position.getColumn()-1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //right
        p.setValues(position.getRow(), position.getColumn()+1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //nw
        p.setValues(position.getRow()-1, position.getColumn()-1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //ne
        p.setValues(position.getRow()-1, position.getColumn()+1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //sw
        p.setValues(position.getRow()+1, position.getColumn()-1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //se
        p.setValues(position.getRow()+1, position.getColumn()+1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        // #specialmve castling
        if (getMoveCount()== 0 && !chessMath.getCheck()){
            // #specialmve castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn()+3);
            if(testRockCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getColumn()+1);
                Position p2 = new Position(position.getRow(), position.getColumn()+2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getColumn()+2] = true;
                }
            }
            // #specialmve castling queenside rook
            Position posT2 = new Position(position.getRow(), position.getColumn()-4);
            if(testRockCastling(posT2)){
                Position p1 = new Position(position.getRow(), position.getColumn()-1);
                Position p2 = new Position(position.getRow(), position.getColumn()-2);
                Position p3 = new Position(position.getRow(), position.getColumn()-3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null&& getBoard().piece(p3) == null){
                    mat[position.getRow()][position.getColumn()-2] = true;
                }
            }
        }

        return mat;
    }
}
