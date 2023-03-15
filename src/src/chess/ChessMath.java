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

    private void placeNewPiece (char column, int row, ChessPiece piece){
        board.placePiece(piece,new ChessPosition(column,row).toPosition());
    }

    private void  initialSetup(){
        placeNewPiece('b',6 , new Rook(board, Color.WHITE));
        placeNewPiece('e',8 , new King(board, Color.BLACK));
        placeNewPiece('e',1 , new King(board, Color.WHITE));
    }
}
