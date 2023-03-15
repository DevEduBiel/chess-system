package src.app;


import src.chess.ChessMath;
import src.chess.ChessPiece;
import src.chess.ChessPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMath chessMath = new ChessMath();

        while (true) {
            UI.printBoard(chessMath.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(sc);
            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMath.performChessMove(source,target);

        }
    }
}
