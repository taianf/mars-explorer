package br.com.taian.marsexplorer.api.model;

import lombok.Data;

@Data
public class Position {
    private int x;
    private int y;
    private String direction;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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
                moveNorth(board);
                break;
            case "S":
                moveSouth();
                break;
            case "E":
                moveEast(board);
                break;
            case "W":
                moveWest();
                break;
            default:
                break;
        }
        return this;
    }

    private void moveWest() {
        int newX = getX() - 1;
        if (newX >= 0) {
            setX(newX);
        }
    }

    private void moveEast(Board board) {
        int newX = getX() + 1;
        if (newX <= board.getX()) {
            setX(newX);
        }
    }

    private void moveSouth() {
        int newY = getY() - 1;
        if (newY >= 0) {
            setY(newY);
        }
    }

    private void moveNorth(Board board) {
        int newY = getY() + 1;
        if (newY <= board.getY()) {
            setY(newY);
        }
    }


    public Position turnLeft() {
        switch (getDirection()) {
            case "N":
                setDirection("W");
                break;
            case "S":
                setDirection("E");
                break;
            case "E":
                setDirection("N");
                break;
            case "W":
                setDirection("S");
                break;
            default:
                break;
        }
        return this;
    }

    public Position turnRight() {
        switch (getDirection()) {
            case "N":
                setDirection("E");
                break;
            case "S":
                setDirection("W");
                break;
            case "E":
                setDirection("S");
                break;
            case "W":
                setDirection("N");
                break;
            default:
                break;
        }
        return this;
    }
}
