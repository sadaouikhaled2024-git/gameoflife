package matrix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElementWiseMatrixTest {

    @Test
    public void testElementWiseAddition() {
        ListMatrix<Integer> matrix1 = new ListMatrix<>(2, 2, new ConstantMatrixInitializer<>(2));
        ListMatrix<Integer> matrix2 = new ListMatrix<>(2, 2, new ConstantMatrixInitializer<>(3));

        // Initialize result matrix with AdditionMatrixInitializer
        ListMatrix<Integer> result = new ListMatrix<>(2, 2, new AdditionMatrixInitializer(matrix1, matrix2));

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                assertEquals(5, result.get(x, y)); // 2 + 3 = 5
            }
        }
    }

    @Test
    public void testElementWiseMultiplication() {
        ListMatrix<Integer> matrix1 = new ListMatrix<>(2, 2, new ConstantMatrixInitializer<>(2));
        ListMatrix<Integer> matrix2 = new ListMatrix<>(2, 2, new ConstantMatrixInitializer<>(3));

        // Initialize result matrix with MultiplicationMatrixInitializer
        ListMatrix<Integer> result = new ListMatrix<>(2, 2, new MultiplicationMatrixInitializer(matrix1, matrix2));

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                assertEquals(6, result.get(x, y)); // 2 * 3 = 6
            }
        }
    }
}
