package br.com.taian.marsexplorer.api.model;

import lombok.Data;

import java.util.List;

@Data
public class Probe {
    private Position start;
    private String moves;
    private Position positionTracker;

    public Position getPositionTracker() {
        return positionTracker;
    }

    @Override
    public String toString() {
        int moveTracker = 0;
        return "Probe{" +
                "moveTracker=" + moveTracker +
                ", start=" + start +
                ", moves='" + moves + '\'' +
                ", positionTracker=" + positionTracker +
                '}';
    }

    public Position getStart() {
        return start;
    }

    public String getMoves() {
        return moves;
    }

    public void getNextPosition(Board board, int movementNumber) {
        if (positionTracker == null) {
            positionTracker = getStart();
        }
        char[] movements = getMoves().toCharArray();
        if (movementNumber > movements.length - 1) {
            return;
        }
        char nextMovement = movements[movementNumber];
        positionTracker = moveProbe(positionTracker, nextMovement, board);
    }

    private Position moveProbe(Position position, char move, Board board) {
        List<Position> probePositions = board.getProbePositions();
        switch (move) {
            case 'M':
                return moveForward(position, board, probePositions);
            case 'L':
                return goLeft(position, probePositions);
            case 'R':
                return goRight(position, probePositions);
            default:
                return position;
        }
    }

    private Position goRight(Position position, List<Position> probePositions) {
        Position newPosition = position.turnRight();
        probePositions.remove(position);
        probePositions.add(newPosition);
        return newPosition;
    }

    private Position goLeft(Position position, List<Position> probePositions) {
        Position newPosition = position.turnLeft();
        probePositions.remove(position);
        probePositions.add(newPosition);
        return newPosition;
    }

    private Position moveForward(Position position, Board board, List<Position> probePositions) {
        Position newPosition = position.move(board);
        if (probePositions.contains(newPosition)) {
            return position;
        } else {
            probePositions.remove(position);
            probePositions.add(newPosition);
            return newPosition;
        }
    }

}
