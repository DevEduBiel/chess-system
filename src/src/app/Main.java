package src.app;


import src.chess.ChessException;
import src.chess.ChessMath;
import src.chess.ChessPiece;
import src.chess.ChessPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMath chessMath = new ChessMath();

        while (true) {
            try {
                UI.clearScreen();
                UI.printMath(chessMath);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean [][] possibleMoves =chessMath.possibleMove(source);
                UI.clearScreen();
                UI.printBoard(chessMath.getPieces(),possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMath.performChessMove(source,target);
            }catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
