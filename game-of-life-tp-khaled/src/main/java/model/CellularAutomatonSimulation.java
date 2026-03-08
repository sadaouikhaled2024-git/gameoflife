package model;

import controller.Simulation;
import matrix.Coordinate;
import matrix.ListMatrix;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;



/**
 * {@link CellularAutomatonSimulation} instances run <i>The Game of Life</i>.
 *
 *  @param <S> The type of state used in the simulation.
 */
public class CellularAutomatonSimulation<S extends State<S>>
        implements Simulation {

    private final ListMatrix<Cell<S>> grid;
    private final Cell<Integer> generationNumber = new Cell<>(0);
    private final CellularAutomaton<S> automaton;
    private final Random generator;

    /**
     * Creates a new {@link CellularAutomatonSimulation} instance for a given automaton.
     *
     * @param automaton  A description of the {@link CellularAutomaton}.
     * @param generator  The {@link Random} instance used for random state generation.
     */
    public CellularAutomatonSimulation(CellularAutomaton<S> automaton, Random generator) {
        this.automaton = automaton;
        this.grid = new ListMatrix<>(
                automaton.numberOfColumns(),
                automaton.numberOfRows(),
                new ConstantCellInitializer<>(automaton.defaultState())
        );
        this.generator = generator;
    }


    @Override
    public int numberOfColumns() {
        return automaton.numberOfColumns();
    }


    @Override
    public int numberOfRows() {
        return automaton.numberOfRows();
    }

    /**
     * Returns the {@link Cell} at the specified coordinate.
     *
     * @param coordinate The coordinate of the cell to retrieve.
     * @return The cell at the specified coordinate.
     */
    public Cell<S> at(Coordinate coordinate) {
        return grid.get(coordinate);
    }

    @Override
    public void updateToNextGeneration() {
        ListMatrix<S> nextMatrix = nextGenerationMatrix();
        for (Coordinate coord : grid.coordinates()) { // Utilise grid.coordinates()
            grid.get(coord).set(nextMatrix.get(coord));
        }
        generationNumber.set(generationNumber.get() + 1);
    }



    /** Computes the {@link ListMatrix} of states obtained after a single step of updates
     * of the simulation.
     *
     * @return the states of each cell after one generation
     */

    private ListMatrix<S> nextGenerationMatrix() {
        ListMatrix<S> next = new ListMatrix<>(numberOfColumns(), numberOfRows(), automaton.defaultState());

        for (Coordinate coord : grid.coordinates()) {
            List<S> neighbours = new ArrayList<>();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) continue; // ignore self
                    Coordinate neighbourCoord = wrap(new Coordinate(coord.x() + dx, coord.y() + dy));
                    neighbours.add(grid.get(neighbourCoord).get());
                }
            }
            next.set(coord, grid.get(coord).get().update(neighbours));
        }
        return next;
    }

    private Coordinate wrap(Coordinate c) {
        int x = (c.x() % numberOfColumns() + numberOfColumns()) % numberOfColumns();
        int y = (c.y() % numberOfRows() + numberOfRows()) % numberOfRows();
        return new Coordinate(x, y);
    }


    @Override
    public void next(Coordinate coordinate) {
        Cell<S> cell = grid.get(coordinate);
        cell.set(cell.get().next());
    }

    @Override
    public void copy(Coordinate source, Coordinate destination) {
        grid.get(destination).set(grid.get(source).get());
    }

    @Override
    public Color getColor(Coordinate coordinate) {
        return grid.get(coordinate).get().getColor();
    }

    @Override
    public void setChangeListener(Coordinate coordinate, Runnable listener) {
        this.at(coordinate).addOnChangeListener(
                (oldValue, newValue) -> listener.run()
        );
    }

    @Override
    public void setGenerationNumberChangeListener(OnChangeListener<Integer> listener){
        this.generationNumber.addOnChangeListener(listener);
    }


    @Override
    public void clear() {
        for (Coordinate coord : grid.coordinates()) {
            grid.get(coord).set(automaton.defaultState());
        }
        generationNumber.set(0);
    }


    @Override
    public void reset() {
        for (Coordinate coord : grid.coordinates()) {
            grid.get(coord).set(automaton.randomState(generator));
        }
        generationNumber.set(0);
    }

    @Override
    public Iterator<Coordinate> iterator() {
        return this.grid.coordinates().iterator();
    }
}
