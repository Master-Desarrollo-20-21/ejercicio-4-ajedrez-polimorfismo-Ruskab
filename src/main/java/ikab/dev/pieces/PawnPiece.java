package ikab.dev.pieces;

import ikab.dev.Board;
import ikab.dev.Chess;
import ikab.dev.Piece;
import ikab.dev.Position;
import ikab.dev.movements.PawnMovement;

import java.util.ArrayList;
import java.util.List;

public class PawnPiece extends Piece {

    public static final int BLACK_PAWN_INITIAL_ROW = 7;
    public static final int WHITE_PAWN_INITIAL_ROW = 2;

    public PawnPiece(boolean isWhitePiece) {
        this.isWhite = isWhitePiece;
        this.movement = new PawnMovement(isWhitePiece);
        this.pieceType = PieceType.PAWN;
    }

    protected PawnPiece(boolean isWhitePiece, Position position) {
        this.isWhite = isWhitePiece;
        this.movement = new PawnMovement(isWhitePiece);
        this.position = position;
    }

    @Override
    public List<Piece> createPiecesInHisInitialPositions() {
        List<Piece> pieces = new ArrayList<>();
        int initialRow = isWhite ? WHITE_PAWN_INITIAL_ROW : BLACK_PAWN_INITIAL_ROW;
        for (int i = 1; i <= Board.BOARD_LIMIT; i++) {
            pieces.add(new PawnPiece(isWhite, new Position(i, initialRow)));
        }
        return pieces;
    }
}

