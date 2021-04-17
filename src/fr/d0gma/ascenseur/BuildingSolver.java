package fr.d0gma.ascenseur;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildingSolver {

    private final int               floors;
    private final int[]             movementRules;
    private final List<SolvingPath> solutions = new ArrayList<>();

    private int  tries;
    private long time;

    public BuildingSolver(int floors, int... movementRules) {
        this.floors = floors;
        this.movementRules = movementRules;
    }

    /**
     * Main method of the program
     *
     * @return all the valid paths for the given rules and floor number
     */
    public List<SolvingPath> solveBuildingPath() {

        this.solutions.clear();
        this.tries = 0;

        long start = System.currentTimeMillis();

        Building building = new Building(floors, 0);
        solveFromPosition(building);

        this.time = System.currentTimeMillis() - start;

        return this.solutions;
    }

    /**
     * Method to be used recursively to find a valid path
     *
     * @param building the building to be tested, then manipulated
     */
    private void solveFromPosition(Building building) {

        this.tries++;

        if (building.isSolved()) {
            this.solutions.add(building.getCurrentPath());
            return;
        }

        Arrays.stream(this.movementRules).filter(building::isMoveAllowed).mapToObj(building::tryWithMove).forEach(this::solveFromPosition);
    }

    public int getTriesNumber() {
        return this.tries;
    }

    public long getTime() {
        return time;
    }

    public List<SolvingPath> getSolutions() {
        return solutions;
    }

    /**
     * Creates the formatted summary of the previous operation (number of solutions, time elapsed, number of tries)
     *
     * @return The formatted String to be printed
     */
    public String getFormattedResult() {
        return String.format(" \nBuilding solver: %s solutions in %s (%s tries)", getSolutions().size(), new SimpleDateFormat("ss's' SSS'ms'").format(getTime()), getTriesNumber());
    }
}
