package matrix;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@link Iterator} for generating 2D {@link Coordinate}s within a specified width and
 * height range.
 */
class CoordinateIterator implements Iterator<Coordinate> {
    private final int width;
    private final int height;
    private int currentX = 0;
    private int currentY = 0;

    /**
     * Creates a new {@link CoordinateIterator} with the specified width and height.
     *
     * @param width  The width of the coordinate range.
     * @param height The height of the coordinate range.
     */
    public CoordinateIterator(int width, int height) {

        this.width = width;
        this.height = height;
    }

    /**
     * Checks if there are more {@link Coordinate}s to iterate over.
     *
     * @return true if there are more {@link Coordinate}s; otherwise, false.
     */
    @Override
    public boolean hasNext() {

        return currentX < width && currentY < height;
    }

    /**
     * Returns the next {@link Coordinate} in the iteration.
     *
     * @return The next {@link Coordinate} in the iteration.
     * @throws NoSuchElementException if there are no more {@link Coordinate}s to iterate over.
     */
    @Override
    public Coordinate next() {
        if  (!hasNext()) {
            throw new NoSuchElementException();
        }
        Coordinate coordinate = new Coordinate(currentX, currentY);
        currentX++;
        if  (currentX == width) {
            currentX = 0;
            currentY++;
        }

        return coordinate;
    }
}
