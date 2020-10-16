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
}
