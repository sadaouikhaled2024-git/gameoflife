package matrix;


public class MultiplicationMatrixInitializer implements MatrixInitializer<Integer> {

    private final Matrix<Integer> matrix1;
    private final Matrix<Integer> matrix2;


    public MultiplicationMatrixInitializer(Matrix<Integer> matrix1, Matrix<Integer> matrix2) {

        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    @Override
    public Integer initialValueAt(Coordinate coordinate) {
        int x = coordinate.x();
        int y = coordinate.y();
        return matrix1.get(x, y) * matrix2.get(x, y);
    }
}
