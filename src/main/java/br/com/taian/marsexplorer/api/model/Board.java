package br.com.taian.marsexplorer.api.model;

import lombok.Data;

import java.util.List;

@Data
public class Board {
    private int x;
    private int y;
    private List<Position> probePositions;

    public List<Position> getProbePositions() {
        return probePositions;
    }

    public void setProbePositions(List<Position> probePositions) {
        this.probePositions = probePositions;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Board{" +
                "x=" + x +
                ", y=" + y +
                ", probePositions=" + probePositions +
                '}';
    }
}
