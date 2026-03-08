package model;

import matrix.Coordinate;
import matrix.ListMatrix;
import matrix.MatrixInitializer;

/**
 *  An initializer for {@link ListMatrix} of {@link Cell}s, where each cell is initialized to the
 *  same value.
 *
 * @param <T> the type of content of each cell
 */
public class ConstantCellInitializer<T> implements MatrixInitializer<Cell<T>> {

    // La valeur par défaut pour chaque cellule
    private final T defaultValue;

    /** Make a new {@link MatrixInitializer} with cells containing a {@link Cell} with the same value.
     *
     * @param defaultValue the value stored in each cell.
     */
    public ConstantCellInitializer(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public Cell<T> initialValueAt(Coordinate coordinate) {
        // Crée une nouvelle cellule contenant la valeur par défaut
        return new Cell<>(defaultValue);
    }
}
