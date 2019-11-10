package maze;

public enum Directions {
    NORTH(-1, 0),
    EAST(0, 1),
    SOUTH(1, 0),
    WEST(0, -1);

    private int nextX, nextY;

    private Directions(int x, int y) {
        this.nextX = x;
        this.nextY = y;
    }

    public int getNextX() {
        return this.nextX;
    }

    public int getNextY() {
        return this.nextY;
    }
}
