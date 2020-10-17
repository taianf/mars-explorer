package br.com.taian.marsexplorer.api.model;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Mission {
    private Board board;
    private List<Probe> probes;

    public List<Probe> getProbes() {
        return probes;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "board=" + board +
                ", probes=" + probes +
                '}';
    }

    public List<Position> getMissionResult() {
        board.setProbePositions(getProbes().stream().map(Probe::getStart).collect(Collectors.toList()));
        int maxLength = getProbes().stream().map(probe -> probe.getMoves().length()).mapToInt(value -> value).max().orElse(0);
        for (int movementNumber = 0; movementNumber < maxLength; movementNumber++) {
            for (Probe probe : getProbes()) {
                probe.getNextPosition(board, movementNumber);
            }
        }
        return getProbes().stream().map(Probe::getPositionTracker).collect(Collectors.toList());
    }

}
