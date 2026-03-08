package model.automata;

import model.CellularAutomaton;

import java.util.Random;

public class GameOfLifeAutomaton implements CellularAutomaton<GameOfLifeState> {

    private final int rows;
    private final int cols;

    /**
     * Constructeur avec nombre de colonnes et de lignes
     */
    public GameOfLifeAutomaton(int numberOfColumns, int numberOfRows) {
        this.cols = numberOfColumns;
        this.rows = numberOfRows;
    }

    @Override
    public int numberOfColumns() {
        return cols;
    }

    @Override
    public int numberOfRows() {
        return rows;
    }

    @Override
    public GameOfLifeState defaultState() {
        // État par défaut : cellule morte
        return GameOfLifeState.DEAD;
    }

    @Override
    public GameOfLifeState randomState(Random generator) {
        // Cellule vivante avec probabilité 0.5
        return generator.nextBoolean() ? GameOfLifeState.ALIVE : GameOfLifeState.DEAD;
    }
}
