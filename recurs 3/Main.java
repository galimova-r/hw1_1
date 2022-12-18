interface ICall {
    public double calc(double x);
}

public class Main {

    public static double bisect(ICall f, double a, double b, double fa, double fb, double eps) {
        double c, fc;
        c = 0.5 * (a + b);
        if (Math.abs(a - b) < eps) return c;
        fc = f.calc(c);
        if (fc * fa < 0)
            return bisect(f, a, c, fa, fc, eps);
        else
            return bisect(f, c, b, fc, fb, eps);
    }

    public static void main(String[] args) {
        ICall func = new ICall() {
            public double calc(double x) {
                return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
            }
        };

        System.out.println("x=" + bisect(func, 0.0, 10.0, func.calc(0.0), func.calc(10.0), 1.0e-6));

    }
}