package matrix;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a matrix, a rectangular array, with generic values in each cell.
 *
 * @param <T> The type of values stored in the matrix cells.
 */
public class ListMatrix<T> implements Matrix<T> {

  private final List<List<T>> matrix;
  private final int width;
  private final int height;

  /**
   * Creates a new {@link ListMatrix} with the specified width, height, and an initializer to set
   * values.
   *
   * @param width       The width of the {@link ListMatrix}.
   * @param height      The height of the {@link ListMatrix}.
   * @param initializer A matrix initializer to set values in the {@link ListMatrix}.
   */
  public ListMatrix(int width, int height, MatrixInitializer<T> initializer) {
    // TODO
    this.width = width;
    this.height = height;
    this.matrix = new ArrayList<>( height);
    this.initializeWith(initializer); // fills the matrix using initializer
  }

  public ListMatrix(int width, int height, T constant) {
    this(width, height, new ConstantMatrixInitializer<>(constant));
  }

  private void initializeWith(MatrixInitializer<T> initializer) {
    for (int i = 0; i <= height; i++) {
        List<T> row = new ArrayList<>(width);
        for (int j = 0; j <= width; j++) {
            row.add(initializer.initialValueAt(new  Coordinate(j, i)));
        }
        matrix.add(row);
    }
  }

  public int width() {
    return width;
  }

  public int height() {
    return height;
  }

  @Override
  public T get(int x, int y) {
    return this.matrix.get(y).get(x);
  }


  @Override
  public void set(int x, int y, T newValue) {
     matrix.get(y).set(x,newValue);
  }


  public Matrix<T> subMatrix(Coordinate corner, int width, int  height) {

      return new ListMatrix<>(width, height, new SubMatrixInitializer<>(this, corner));
  }

}
