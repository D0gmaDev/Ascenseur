package fr.d0gma.ascenseur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SolvingPath {

    private final List<Integer> path;

    public SolvingPath(int startFloor) {
        this.path = new ArrayList<>();
        this.path.add(startFloor);
    }

    private SolvingPath(List<Integer> path, int newFloor) {
        this.path = new ArrayList<>(path);
        this.path.add(newFloor);
    }

    public SolvingPath setNewFloor(int floor) {
        return new SolvingPath(this.path, floor);
    }

    @Override
    public String toString() {
        return "{" + path.stream().map(String::valueOf).collect(Collectors.joining(">")) + "}";
    }
}
