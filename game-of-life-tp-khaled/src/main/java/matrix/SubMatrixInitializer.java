package matrix;

public class SubMatrixInitializer<T> implements MatrixInitializer<T>{
    private final Matrix<T> Matrix;
    private final Coordinate corner;
    public SubMatrixInitializer(Matrix<T> Matrix, Coordinate corner) {
        this.Matrix = Matrix;
        this.corner = corner;
    }


    @Override
    public T initialValueAt(Coordinate coordinate) {
        int x = corner.x() + coordinate.x();
        int y = corner.y() + coordinate.y();
        return Matrix.get(x, y);
    }
}
