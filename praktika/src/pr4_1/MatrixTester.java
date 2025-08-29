package pr4_1;

public class MatrixTester {
    public static void main(String[] args) {
        double[][] matrixData1 = {
                {1.5, 2.0, 3.5},
                {4.0, 5.5, 6.0}
        };

        double[][] matrixData2 = {
                {2.5, 3.0, 1.5},
                {0.5, 1.0, 4.0}
        };

        Matrix matrix1 = new Matrix(matrixData1);
        Matrix matrix2 = new Matrix(matrixData2);

        System.out.println("Matrix 1:");
        matrix1.print();

        System.out.println("\nMatrix 2:");
        matrix2.print();

        Matrix sumMatrix = matrix1.add(matrix2);
        System.out.println("\nSum of Matrix 1 and Matrix 2:");
        sumMatrix.print();

        double scalar = 2.0;
        Matrix scaledMatrix = matrix1.multiply(scalar);
        System.out.println("\nMatrix 1 multiplied by " + scalar + ":");
        scaledMatrix.print();
    }
}
