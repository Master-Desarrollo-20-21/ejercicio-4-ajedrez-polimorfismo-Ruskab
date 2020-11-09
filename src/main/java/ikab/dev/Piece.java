package ikab.dev;

import ikab.dev.pieces.PieceType;

import java.util.List;

public abstract class Piece {

    protected Position position;
    protected Movement movement;
    protected boolean isWhite;
    protected PieceType pieceType;

    public abstract List<Piece> createPiecesInHisInitialPositions();

    public PieceType getPieceType() {
        return pieceType;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Movement getMovement() {
        return movement;
    }

    public boolean isWhite() {
        return isWhite;
    }

}
