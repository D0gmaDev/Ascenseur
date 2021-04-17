package fr.d0gma.ascenseur;

/**
 * @author D0gma_
 */
public class Main {

    public static void main(String[] args) {

        BuildingSolver buildingSolver = new BuildingSolver(20, 2, 3, 5, -4, -11); //creates a solver matching the settings
        buildingSolver.solveBuildingPath().forEach(System.out::println); //solve and print all the results

        System.out.println(buildingSolver.getFormattedResult()); //print the summary of the operation

    }

}
