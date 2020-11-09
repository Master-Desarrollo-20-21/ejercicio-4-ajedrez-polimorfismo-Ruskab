package ikab.dev.movements;

import ikab.dev.Board;
import ikab.dev.Movement;
import ikab.dev.Piece;
import ikab.dev.Position;


public class PawnMovement extends Movement {

    public static final int BLACK_PAWN_INITIAL_ROW = 7;
    public static final int WHITE_PAWN_INITIAL_ROW = 2;

    public PawnMovement(boolean isWhitePiece) {
        this.isWhitePiece = isWhitePiece;
    }

    @Override
    public void move(Board board, Position origin, Position destination) {
        assertValidMovement(board, origin, destination);

        if (isCanKillRivalPiece(board, origin, destination)) {
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
            return isCanKillRivalPiece(board, origin, destination);
        }
        return !board.isOverlapsWithSomePiece(destination);
    }

    private boolean isCanKillRivalPiece(Board board, Position origin, Position destination) {
        Piece targetPiece = board.getFichaByPosition(destination);
        if (isWhitePiece) {
            return origin.getX() + 1 == targetPiece.getPosition()
                    .getX() && origin.getY() + 1 == targetPiece.getPosition()
                    .getY()
                    || origin.getX() - 1 == targetPiece.getPosition()
                    .getX() && origin.getY() + 1 == targetPiece.getPosition().getY();

        } else {
            return origin.getX() + 1 == targetPiece.getPosition()
                    .getX() && origin.getY() - 1 == targetPiece.getPosition().getY()
                    || origin.getX() - 1 == targetPiece.getPosition()
                    .getX() && origin.getY() - 1 == targetPiece.getPosition().getY();
        }
    }


    private boolean isValidDistance(Position origin, Position destination) {
        if (isPawnInitialPosition(origin)) {
            return origin.getYDistance(destination) > 0 && origin.getYDistance(destination) <= 2;
        }
        return origin.getYDistance(destination) == 1;
    }

    private boolean isPawnInitialPosition(Position origin) {
        return isWhitePiece && origin.getY() == WHITE_PAWN_INITIAL_ROW || !isWhitePiece && origin.getY() == BLACK_PAWN_INITIAL_ROW;
    }

}
