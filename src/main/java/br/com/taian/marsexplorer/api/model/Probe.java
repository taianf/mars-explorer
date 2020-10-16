package br.com.taian.marsexplorer.api.model;

import lombok.Data;

@Data
public class Probe {
    private Position start;
    private String moves;

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "Probe{" +
                "start=" + start +
                ", moves='" + moves + '\'' +
                '}';
    }

    public Position getEndPosition(Board board) {
        char[] movements = getMoves().toCharArray();
        Position currentPosition = getStart();
        for (char movement : movements) {
            currentPosition = moveProbe(currentPosition, movement, board);
        }
        return currentPosition;
    }

    private Position moveProbe(Position position, char move, Board board) {
        switch (move) {
            case 'M':
                return position.move(board);
            case 'L':
                return position.turnLeft();
            case 'R':
                return position.turnRight();
            default:
                return position;
        }
    }

}
