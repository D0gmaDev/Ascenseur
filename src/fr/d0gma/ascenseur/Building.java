package fr.d0gma.ascenseur;

import java.util.Arrays;

public class Building {

    private final Boolean[]   floors;
    private final int         currentFloor;
    private final SolvingPath currentPath;

    public Building(int maxFloors, int startFloor) {
        this.floors = new Boolean[maxFloors + 1];
        this.currentFloor = startFloor;
        this.currentPath = new SolvingPath(startFloor);

        Arrays.fill(this.floors, false);
    }

    private Building(Boolean[] floors, int currentFloor, SolvingPath currentPath) {
        this.floors = floors;
        this.currentFloor = currentFloor;
        this.currentPath = currentPath;
    }

    public boolean isSolved() {
        return this.currentFloor == 0 && Arrays.stream(this.floors).allMatch(state -> state);
    }

    private int getNewPosition(int move) {
        return this.currentFloor + move;
    }

    public boolean isMoveAllowed(int move) {
        int position = getNewPosition(move);
        return position >= 0 && position < this.floors.length && !this.floors[position];
    }

    public Building tryWithMove(int move) {
        int position = getNewPosition(move);
        Boolean[] newFloors = this.floors.clone();
        newFloors[position] = true;
        return new Building(newFloors, position, currentPath.setNewFloor(position));
    }

    public Boolean[] getFloors() {
        return floors;
    }

    public SolvingPath getCurrentPath() {
        return currentPath;
    }
}
