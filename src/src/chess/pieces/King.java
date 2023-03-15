package src.chess.pieces;

import src.boardgame.Board;
import src.chess.ChessPiece;

public class King extends ChessPiece {
    public King(Board board, src.chess.pieces.Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
}
