public class Matrix {
    private Complex[][] matrix;

    public Matrix(Complex[][] matrix) {
        this.matrix = matrix;
    }
    public Matrix(int row, int col) {
        matrix = new Complex[row][col];
    }

    public Complex getElement(int row, int col) {
        return matrix[row][col];
    }
    public void setElement(int row, int col, Complex complex) {
        matrix[row][col] = complex;
    }
    public void setMatrix(Complex[][] matrix) {
        this.matrix = matrix;
    }
    public int getCols() {
        return matrix[0].length;
    }
    public int getRows() {
        return matrix.length;
    }

    public static void print(Matrix matrix) {
        for (int row = 0; row < matrix.getRows(); row++) {
            System.out.print("[");
            for (int col = 0; col < matrix.getRows(); col++) {
                System.out.print(matrix.getElement(row, col) + "  ");
            }
            System.out.println("]");
        }
    }

    public static Matrix plus(Matrix A, Matrix B) {
        int rows = A.getRows();
        int cols = B.getCols();
        int secCols = A.getCols();
        int secRows = B.getRows();
        if (cols != secCols || rows != secRows) {
            throw new IllegalArgumentException("The first and the second matrices should have identical dimensions");
        }
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Complex sum = new Complex(0, 0);
                for (int k = 0; k < secCols; k++) {
                    sum = Complex.plus(A.getElement(i, j), B.getElement(i, j));
                }
                res.setElement(i, j, sum);
            }
        }

        return res;
    }

    public static Matrix minus(Matrix A, Matrix B) {
        int rows = A.getRows();
        int cols = B.getCols();
        int secCols = A.getCols();
        int secRows = B.getRows();
        if (cols != secCols || rows != secRows) {
            throw new IllegalArgumentException("The first and the second matrices should have identical dimensions");
        }
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Complex sum = new Complex(0, 0);
                for (int k = 0; k < secCols; k++) {
                    sum = Complex.minus(A.getElement(i, j), B.getElement(i, j));
                }
                res.setElement(i, j, sum);
            }
        }

        return res;
    }

    public static Matrix transpose(Matrix A) {
        int rows = A.getRows();
        int cols = A.getCols();

        Matrix res = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.setElement(j, i, A.getElement(i, j));
            }
        }

        return res;
    }
    public static Matrix mult(Matrix A, Matrix B) {
        int rows = A.getRows();
        int cols = B.getCols();
        int secCols = A.getCols();
        int secRows = B.getRows();
        if (secRows != secCols) {
            throw new IllegalArgumentException("The first matrix should have the same cols quantity as the second matrix rows");
        }
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Complex ans = new Complex(0, 0);
                for (int k = 0; k < secCols; k++) {
                    ans = Complex.plus(ans, Complex.multiply(A.getElement(i, k), B.getElement(k,j)));
                }
                res.setElement(i, j, ans);
            }
        }

        return res;
    }



    public static void main(String[] args) {
        Complex[][] C1 = {{new Complex(1, 2), new Complex(2, 4), new Complex(4, 1)},
                {new Complex(2, 6), new Complex(1, 4), new Complex(5, 3)},
                {new Complex(1, 6), new Complex(3, 7), new Complex(2, 6)}};
        Complex[][] C2 = {{new Complex(1, 3), new Complex(2, 5), new Complex(7, 8)},
                {new Complex(2, 8), new Complex(3, 2), new Complex(1, 6)},
                {new Complex(1, 3), new Complex(1, 1), new Complex(2, 2)}};
        Matrix A = new Matrix(C1);
        Matrix B = new Matrix(C2);
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

