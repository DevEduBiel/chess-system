package src.chess.pieces;

import src.boardgame.Board;
import src.chess.ChessPiece;

public class Rook extends ChessPiece {


    public Rook(Board board, src.chess.pieces.Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[getBoard().getRows()][getBoard().getColumns()];
    }
}
