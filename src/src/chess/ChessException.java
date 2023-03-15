package src.chess;

import src.boardgame.BoarException;

public class ChessException extends BoarException {
    private static final long serialVersionUID =1L;

    public ChessException(String message){
        super(message);
    }
    
}
