package ikab.dev;

import ikab.dev.io.ConsoleWritter;
import ikab.dev.pieces.KingPiece;
import ikab.dev.pieces.KnightPiece;
import ikab.dev.pieces.PawnPiece;
import ikab.dev.pieces.PieceType;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int BOARD_LIMIT = 8;
    private List<Piece> pieces = new ArrayList<>();
    private ConsoleWritter consoleWritter;

    public Board() {
        pieces.addAll(new KingPiece(true).createPiecesInHisInitialPositions());
        pieces.addAll(new KingPiece(false).createPiecesInHisInitialPositions());
        pieces.addAll(new KnightPiece(true).createPiecesInHisInitialPositions());
        pieces.addAll(new KnightPiece(false).createPiecesInHisInitialPositions());
        pieces.addAll(new PawnPiece(false).createPiecesInHisInitialPositions());
        consoleWritter = new ConsoleWritter();
    }

    public boolean containsPiece(PieceType pieceType, boolean isWhite) {
        for (Piece piece : pieces) {
            if (pieceType.equals(piece.getPieceType()) && isWhite == piece.isWhite()) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Position position) {
        return position.getX() > 0 && position.getY() > 0
                && position.getX() <= BOARD_LIMIT && position.getY() <= BOARD_LIMIT;
    }

    public Piece getFichaByPosition(Position position) {
        for (Piece piece : this.getPieces()) {
            if (piece.getPosition().isOverlaps(position)) {
                return piece;
            }
        }
        throw new IllegalArgumentException("Given position don't has piece");
    }

    public boolean isOverlapsWithSomePiece(Position position) {
        for (Piece piece : this.getPieces()) {
            if (piece.getPosition().isOverlaps(position)) {
                return true;
            }
        }
        return false;
    }

    public void removePiece(Piece piece) {
        this.getPieces().remove(piece);
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }

    public void print() {
        //TODO print board status : pieces and his positions
        consoleWritter.printBoard(this);
    }

}

