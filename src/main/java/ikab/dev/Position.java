package ikab.dev;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        assert x < Board.BOARD_LIMIT && y < Board.BOARD_LIMIT;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getYDistance(Position other) {
        return Math.abs(this.getX() - other.getX());
    }

    public int getXDistance(Position other) {
        return Math.abs(this.getX() - other.getX());
    }

    public boolean isOverlaps(Position other) {
        return this.getX() == other.getX() && this.getY() == other.getY();
    }

}
