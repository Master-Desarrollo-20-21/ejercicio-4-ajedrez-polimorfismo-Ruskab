package ikab.dev.pieces;

import ikab.dev.Piece;
import ikab.dev.Position;
import ikab.dev.movements.KingMovement;

import java.util.ArrayList;
import java.util.List;

public class KingPiece extends Piece {

    public KingPiece(boolean isWhite) {
        this.pieceType = PieceType.KING;
        this.isWhite = isWhite;
        this.movement = new KingMovement(isWhite);
        if (isWhite) {
            this.position = new Position(1, 5);
        } else {
            this.position = new Position(8, 5);
        }
    }

    @Override
    public List<Piece> createPiecesInHisInitialPositions() {
        List<Piece> pieces =new ArrayList<>();
        pieces.add(new KingPiece(isWhite));
        return pieces;
    }
}
