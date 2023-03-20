package src.boardgame;

public class BoardException extends RuntimeException {
    private static final long serialVersion =1L;

    public BoardException(String message) {
        super(message);
    }
}
