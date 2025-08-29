package pr20;

import java.util.Arrays;

public class Matrix<T extends Number> {
    private final int rows;
    private final int cols;
    private final T[][] matrix;

    public Matrix(int rows, int cols, T[][] data) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = data;
    }

    public Matrix<T> add(Matrix<T> other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices should have the same dimensions for addition.");
        }

        T[][] result = Arrays.copyOf(this.matrix, rows);
        for (int i = 0; i < rows; i++) {
            result[i] = Arrays.copyOf(this.matrix[i], cols);
            for (int j = 0; j < cols; j++) {
                result[i][j] = addElements(this.matrix[i][j], other.matrix[i][j]);
            }
        }
        return new Matrix<>(rows, cols, result);
    }

    public Matrix<T> multiply(Matrix<T> other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Для сложения матрицы должны иметь одинаковые размеры.");
        }

        T[][] result = (T[][]) new Number[this.rows][other.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                result[i][j] = multiplyElements(i, j, other);
            }
        }
        return new Matrix<>(this.rows, other.cols, result);
    }

    private <T extends Number> T addElements(T a, T b) {
        double sum = a.doubleValue() + b.doubleValue();

        if (a instanceof Integer) return (T) Integer.valueOf((int) sum);
        else if (a instanceof Double) return (T) Double.valueOf(sum);
        else if (a instanceof Float) return (T) Float.valueOf((float) sum);
        else if (a instanceof Long) return (T) Long.valueOf((long) sum);
        else if (a instanceof Short) return (T) Short.valueOf((short) sum);
        else if (a instanceof Byte) return (T) Byte.valueOf((byte) sum);
        throw new IllegalArgumentException("Неподдерживаемый тип числа");
    }

    private T multiplyElements(int row, int col, Matrix<T> other) {
        double sum = 0;
        for (int i = 0; i < this.cols; i++) {
            sum += ((Number) this.matrix[row][i]).doubleValue() * ((Number) other.matrix[i][col]).doubleValue();
        }
        return (T) ((Number) sum);
    }

    public void printMatrix() {
        for (T[] row : this.matrix) {
            for (T element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}