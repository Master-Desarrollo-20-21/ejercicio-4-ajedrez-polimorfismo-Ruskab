package ikab.dev;

public class PlayerMovement {

    private final Piece piece;
    private final Position destination;

    public PlayerMovement(Piece piece, Position destination) {
        this.piece = piece;
        this.destination = destination;
    }

    public void makePlayerMovement(Board board) {
        piece.getMovement().move(board, piece.getPosition(), destination);
    }

    public boolean isValidPlayerMovement(Board board) {
        return this.getPiece().getMovement().isValidMovement(board, this.getPiece().getPosition(), this.getDestination());
    }

    public Piece getPiece() {
        return piece;
    }

    public Position getDestination() {
        return destination;
    }

}
