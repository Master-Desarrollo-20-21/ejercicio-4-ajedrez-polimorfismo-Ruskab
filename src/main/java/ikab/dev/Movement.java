package ikab.dev;

public abstract class Movement {

    protected boolean isWhitePiece;

    public abstract void move(Board board, Position origin, Position destination);

    public abstract boolean isValidMovement(Board board, Position origin, Position destination);

    protected void assertValidMovement(Board board, Position origin, Position destination) {
        assert board.contains(origin);
        assert board.contains(destination);
        assert isValidMovement(board, origin, destination);
    }

    protected boolean isOverlapsWithRivalPiece(Board board, Position destination) {
        if (board.isOverlapsWithSomePiece(destination)) {
            return false;
        }
        return isWhitePiece && !board.getFichaByPosition(destination).isWhite() ||
                !isWhitePiece && !board.getFichaByPosition(destination).isWhite();
    }


}
