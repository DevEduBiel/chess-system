package src.chess;

import src.boardgame.Board;

public class ChessMath {
    private Board board;

    public ChessMath() {
        board = new Board(8,8);
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
}
