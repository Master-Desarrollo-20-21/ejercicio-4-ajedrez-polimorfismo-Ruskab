package ikab.dev.movements;

import ikab.dev.Board;
import ikab.dev.Movement;
import ikab.dev.Piece;
import ikab.dev.Position;

public class KnightMovement extends Movement {

    public KnightMovement(boolean isWhitePiece) {
        this.isWhitePiece = isWhitePiece;
    }

    @Override
    public void move(Board board, Position origin, Position destination) {
        assertValidMovement(board, origin, destination);

        if (isOverlapsWithRivalPiece(board, destination)) {
            Piece targetPiece = board.getFichaByPosition(origin);
            board.removePiece(targetPiece);
        }
        Piece originPiece = board.getFichaByPosition(origin);
        originPiece.setPosition(destination);
    }

    @Override
    public boolean isValidMovement(Board board, Position origin, Position destination) {
        if (!isValidDistance(origin, destination)) {
            return false;
        }
        if (isOverlapsWithRivalPiece(board, destination)) {
            return true;
        }
        return !board.isOverlapsWithSomePiece(destination);
    }

    private boolean isValidDistance(Position origin, Position destination) {
        return origin.getYDistance(destination) == 2 && origin.getXDistance(destination) == 1
                || origin.getYDistance(destination) == 1 && origin.getXDistance(destination) == 2;
    }

}
