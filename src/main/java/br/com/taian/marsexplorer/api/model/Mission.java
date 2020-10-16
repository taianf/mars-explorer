package br.com.taian.marsexplorer.api.model;

import lombok.Data;

import java.util.List;

@Data
public class Mission {
    private Board board;
    private List<Probe> probes;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Probe> getProbes() {
        return probes;
    }

    public void setProbes(List<Probe> probes) {
        this.probes = probes;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "board=" + board +
                ", probes=" + probes +
                '}';
    }
}
