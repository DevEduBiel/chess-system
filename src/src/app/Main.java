package src.app;


import src.chess.ChessException;
import src.chess.ChessMath;
import src.chess.ChessPiece;
import src.chess.ChessPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMath chessMath = new ChessMath();
        List<ChessPiece> captured = new ArrayList<>();


        while (!chessMath.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.setChessMath(chessMath);
                UI.setCaptured(captured);
                UI.printMath(chessMath, captured);
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
                if (capturedPiece!= null){
                    captured.add(capturedPiece);
                }
                if(chessMath.getPromoted() != null){
                    System.out.print("Enter piece for promotion (B/N/R/Q)");
                    String type = sc.nextLine().toUpperCase();
                    while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
                        System.out.print("Invalid value! piece for promotion (B/N/R/Q)");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMath.replacePromotedPiece(type);
                }
            }catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMath(chessMath,captured);
    }
}
