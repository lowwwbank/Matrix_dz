public class Matrix {
    public static void print(Complex[][] matrix) {
        for (Complex[] row : matrix) {
            System.out.print("[");
            for (Complex element : row) {
                System.out.print(element + "  ");
            }
            System.out.println("]");
        }
    }

    public static Complex[][] plus(Complex[][] A, Complex[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int secCols = A[0].length;
        int secRows = B.length;
        if (cols != secCols || rows != secRows) {
            throw new IllegalArgumentException("The first and the second matrices should have identical dimensions");
        }
        Complex[][] res = new Complex[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Complex sum = new Complex(0, 0);
                for (int k = 0; k < secCols; k++) {
                    sum = Complex.plus(A[i][j], B[i][j]);
                }
                res[i][j] = sum;
            }
        }

        return res;
    }

    public static Complex[][] minus(Complex[][] A, Complex[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int secCols = A[0].length;
        int secRows = B.length;
        if (cols != secCols || rows != secRows) {
            throw new IllegalArgumentException("The first and the second matrices should have identical dimensions");
        }
        Complex[][] res = new Complex[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Complex sum = new Complex(0, 0);
                for (int k = 0; k < secCols; k++) {
                    sum = Complex.minus(A[i][j], B[i][j]);
                }
                res[i][j] = sum;
            }
        }

        return res;
    }

    public static Complex[][] transpose(Complex[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        Complex[][] res = new Complex[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[j][i] = A[i][j];
            }
        }

        return res;
    }
    public static Complex[][] mult(Complex[][] A, Complex[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int secCols = A[0].length;
        int secRows = B.length;
        if (secRows != secCols) {
            throw new IllegalArgumentException("The first matrix should have the same cols quantity as the second matrix rows");
        }
        Complex[][] res = new Complex[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Complex ans = new Complex(0, 0);
                for (int k = 0; k < secCols; k++) {
                    ans = Complex.plus(ans, Complex.multiply(A[i][k], B[k][j]));
                }
                res[i][j] = ans;
            }
        }

        return res;
    }



    public static void main(String[] args) {
        Complex[][] A = {{new Complex(1, 2), new Complex(2, 4), new Complex(4, 1)},
                {new Complex(2, 2), new Complex(1, 4), new Complex(5, 3)},
                {new Complex(1, 6), new Complex(3, 7), new Complex(2, 6)}};
        Complex[][] B = {{new Complex(1, 3), new Complex(2, 5), new Complex(7, 8)},
                {new Complex(2, 8), new Complex(3, 2), new Complex(1, 6)},
                {new Complex(1, 3), new Complex(1, 1), new Complex(2, 2)}};

        System.out.println("Матрица A:");
        print(A);

        System.out.println("Матрица B:");
        print(B);

        System.out.println("Сложение матриц A и B:");
        print(plus(A, B));

        System.out.println("Вычитание B из A:");
        print(minus(A, B));

        System.out.println("Транспонирование матрицы A:");
        print(transpose(A));

        System.out.println("Умножение матриц A и B:");
        print(mult(A, B));

    }
}

