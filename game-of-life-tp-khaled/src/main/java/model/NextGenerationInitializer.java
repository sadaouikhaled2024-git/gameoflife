package model;

import matrix.Coordinate;
import matrix.MatrixInitializer;
import matrix.ListMatrix;
import controller.Simulation;
import java.util.ArrayList;
import java.util.List;

public class NextGenerationInitializer<S extends State<S>> implements MatrixInitializer<S> {

    private final CellularAutomatonSimulation<S> simulation;

    /** Create a {@link MatrixInitializer} to compute the next generation in
     * a 2D cellular automaton.
     *
     * @param simulation the {@link Simulation} representing the cellular automaton.
     */
    public NextGenerationInitializer(CellularAutomatonSimulation<S> simulation) {
        this.simulation = simulation;
    }

    @Override
    public S initialValueAt(Coordinate coordinate) {
        List<S> neighbours = new ArrayList<>();

        int rows = simulation.numberOfRows();
        int cols = simulation.numberOfColumns();

        // Parcourt les 8 voisins
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; // ignore la cellule elle-même
                Coordinate neighbourCoord = wrap(new Coordinate(coordinate.x() + dx, coordinate.y() + dy));
                neighbours.add(simulation.at(neighbourCoord).get());
            }
        }

        // Retourne le nouvel état de la cellule
        return simulation.at(coordinate).get().update(neighbours);
    }

    /** Computes the grid {@link Coordinate} for an arbitrary {@link Coordinate}, even outside
     * the grid. Wrap-around on edges.
     *
     * @param coordinate a {@link Coordinate} that may be outside the grid.
     * @return a corresponding {@link Coordinate}, that is inside the grid.
     */
    Coordinate wrap(Coordinate coordinate) {
        int wrappedX = modulo(coordinate.x(), simulation.numberOfColumns());
        int wrappedY = modulo(coordinate.y(), simulation.numberOfRows());
        return new Coordinate(wrappedX, wrappedY);
    }

    /** The non-negative remainder of n divided by d.
     *
     * @param n an arbitrary integer.
     * @param d a non-zero integer.
     * @return the remainder of {@code n/d}, between {@code 0} and {@code d-1}.
     */
    static int modulo(int n, int d) {
        int result = n % d;
        return n < 0 ? result + d : result;
    }
}
