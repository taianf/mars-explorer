package br.com.taian.marsexplorer.api.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Position {
    private final int x;
    private final int y;
    private final String direction;

    public Position(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", direction='" + direction + '\'' +
                '}';
    }

    public Position move(Board board) {
        switch (getDirection()) {
            case "N":
                return moveNorth(board);
            case "S":
                return moveSouth();
            case "E":
                return moveEast(board);
            case "W":
                return moveWest();
            default:
                return this;
        }
    }

    private Position moveWest() {
        int newX = getX() - 1;
        if (newX >= 0) {
            return new Position(newX, getY(), getDirection());
        }
        return this;
    }

    private Position moveEast(Board board) {
        int newX = getX() + 1;
        if (newX <= board.getX()) {
            return new Position(newX, getY(), getDirection());
        }
        return this;
    }

    private Position moveSouth() {
        int newY = getY() - 1;
        if (newY >= 0) {
            return new Position(getX(), newY, getDirection());
        }
        return this;
    }

    private Position moveNorth(Board board) {
        int newY = getY() + 1;
        if (newY <= board.getY()) {
            return new Position(getX(), newY, getDirection());
        }
        return this;
    }

    public Position turnLeft() {
        switch (getDirection()) {
            case "N":
                return new Position(getX(), getY(), "W");
            case "S":
                return new Position(getX(), getY(), "E");
            case "E":
                return new Position(getX(), getY(), "N");
            case "W":
                return new Position(getX(), getY(), "S");
            default:
                return this;
        }
    }

    public Position turnRight() {
        switch (getDirection()) {
            case "N":
                return new Position(getX(), getY(), "E");
            case "S":
                return new Position(getX(), getY(), "W");
            case "E":
                return new Position(getX(), getY(), "S");
            case "W":
                return new Position(getX(), getY(), "N");
            default:
                return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }
}
