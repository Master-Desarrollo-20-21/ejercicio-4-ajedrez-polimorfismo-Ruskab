package ikab.dev.pieces;

import ikab.dev.Piece;
import ikab.dev.Position;
import ikab.dev.movements.KnightMovement;

import java.util.ArrayList;
import java.util.List;

public class KnightPiece extends Piece {

    public static final int BLACK_KNIGHT_INITIAL_ROW = 8;
    public static final int WHITE_KNIGHT_INITIAL_ROW = 1;

    public KnightPiece(boolean isWhitePiece) {
        this.isWhite = isWhitePiece;
        this.movement = new KnightMovement(isWhitePiece);
        this.pieceType = PieceType.KNIGHT;
    }

    protected KnightPiece(boolean isWhitePiece, Position position) {
        this.isWhite = isWhitePiece;
        this.movement = new KnightMovement(isWhitePiece);
        this.position = position;
    }

    @Override
    public List<Piece> createPiecesInHisInitialPositions() {
        List<Piece> pieces =new ArrayList<>();
        int initialRow = isWhite ? WHITE_KNIGHT_INITIAL_ROW : BLACK_KNIGHT_INITIAL_ROW;
        pieces.add(new KnightPiece(isWhite, new Position(initialRow, 2)));
        pieces.add(new KnightPiece(isWhite, new Position(initialRow, 7)));
        return pieces;
    }
}
