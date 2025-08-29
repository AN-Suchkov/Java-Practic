package pr20;

public class MatrixTest {
    public static void main(String[] args) {
        Integer[][] data1 = { { 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 } };
        Integer[][] data2 = { { 18, 16, 14 }, { 12, 10, 8 }, { 6, 4, 2 } };

        Matrix<Integer> matrix1 = new Matrix<>(3, 3, data1);
        Matrix<Integer> matrix2 = new Matrix<>(3, 3, data2);

        System.out.println("Матрица 1:");
        matrix1.printMatrix();

        System.out.println("Матрица 2:");
        matrix2.printMatrix();

        System.out.println("Сумма матриц:");
        matrix1.add(matrix2).printMatrix();

        System.out.println("Произведение матриц:");
        matrix1.multiply(matrix2).printMatrix();
    }
}