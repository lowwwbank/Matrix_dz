public class Complex {
    double re;
    double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex(double re) {
        this.re = re;
    }


    public static Complex plus(Complex x, Complex y) {
        return new Complex(x.re + y.re, x.im + y.im);
    }

    public static Complex minus(Complex x, Complex y) {
        return new Complex(x.re - y.re, x.im - y.im);
    }

    public static Complex multiply(Complex x, Complex y) {
        return new Complex(x.re * y.re - x.im * y.im, x.re * y.im + x.im * y.re);
    }

    @Override
    public String toString() {
        return re + " + " + im + "i";
    }
}
