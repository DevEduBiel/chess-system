package src.chess;

import src.boardgame.Board;
import src.boardgame.Piece;
import src.boardgame.Position;
import src.chess.pieces.Color;

public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p!= null && p.getColor()!= color;
    }
}
