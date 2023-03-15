package src.chess;

import src.boardgame.Board;
import src.boardgame.Position;
import src.chess.pieces.Color;
import src.chess.pieces.King;
import src.chess.pieces.Rook;

public class ChessMath {
    private Board board;

    public ChessMath() {
        board = new Board(8,8);
        initialSetup();
    }
    public ChessPiece[][] getPieces(){
        ChessPiece [][] mat = new  ChessPiece[board.getRows()][board.getRows()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getRows(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return  mat;
    }

    private void  initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE),new Position(2,1));
        board.placePiece(new King(board, Color.BLACK),new Position(0,4));
        board.placePiece(new King(board, Color.WHITE),new Position(7,4));
    }
}
