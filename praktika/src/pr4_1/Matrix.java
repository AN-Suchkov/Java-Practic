package pr4_1;

public class Matrix {
    private double[][] data;
    private int rows;
    private int cols;

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }
        double[][] resultData = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultData[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(resultData);
    }

    public Matrix multiply(double scalar) {
        double[][] resultData = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultData[i][j] = this.data[i][j] * scalar;
            }
        }
        return new Matrix(resultData);
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.2f ", data[i][j]);
            }
            System.out.println();
        }
    }
}
