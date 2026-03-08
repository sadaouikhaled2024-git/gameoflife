package model.automata;

import javafx.scene.paint.Color;
import model.State;

import java.util.List;

/**
 * {@link GameOfLifeState} instances represent the possible states of a {@link GameOfLifeState}.
 */
public enum GameOfLifeState implements State<GameOfLifeState> {
    ALIVE, DEAD;


    @Override
    public Color getColor() {
        return this == ALIVE ? Color.RED : Color.WHITE;
    }

    @Override
    public GameOfLifeState next() {
        return this == ALIVE ? DEAD : ALIVE;
    }

    @Override
    public GameOfLifeState update(List<GameOfLifeState> neighbours) {
        int aliveCount = State.count(ALIVE, neighbours);

        // Applique les règles du Jeu de la Vie
        if (this == ALIVE) {
            return (aliveCount == 2 || aliveCount == 3) ? ALIVE : DEAD;
        } else {
            return (aliveCount == 3) ? ALIVE : DEAD;
        }
    }

}
