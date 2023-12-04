import java.text.DecimalFormat;

public class Complex {
    private double re;
    private double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex plus(Complex other) {
        return new Complex(this.re + other.re, this.im + other.im);
    }

    public Complex minus(Complex other) {
        return new Complex(this.re - other.re, this.im - other.im);
    }

    public Complex times(Complex other) {
        return new Complex(this.re * other.re - this.im * other.im, this.re * other.im + this.im * other.re);
    }

    public Complex div(Complex other) {
        return new Complex((other.re * this.re + other.im * this.im) / (this.re * this.re + this.im * this.im), (other.im * this.re - other.re * this.im) / (this.re * this.re + this.im * this.im));
    }

    public Complex conj() {
        return new Complex(this.re, -this.im);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        if(this.im > 0) {
            return "NumarComplex=" +
                    df.format(this.re) +
                    "+" + df.format(this.im) +
                    "*i" + ' ';
        }
        else {
            return "NumarComplex=" +
                    df.format(this.re) +
                    df.format(this.im) +
                    "*i" + ' ';
        }
    }

    public static boolean checkOk(String nr) {
        // numerele complexe pot fii si +-a +-b*i
        char[] num = nr.toCharArray();
        if (num[0] == '-'){
            char[] result = new char[num.length-1];
            for ( int i = 1; i<num.length ; i++){
                result[i-1] += num[i];
            }
            nr = new String(result);
        }
        String[] parts = nr.split("[+-]", 2);
        try {
            double real = Double.parseDouble(parts[0]);
            double imag = Double.parseDouble(parts[1].split("\\*", 2)[0]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Complex(String nr) {
        if (checkOk(nr)) {
            boolean s1 = false;
            char[] num = nr.toCharArray();
            if (num[0] == '-'){
                s1 = true;
                char[] result = new char[num.length-1];
                for ( int i = 1; i<num.length ; i++){
                    result[i-1] += num[i];
                }
                nr = new String(result);
            }
            boolean s2 = nr.contains("-");
            String[] parts = nr.split("[+-]", 2);
            double re = Double.parseDouble(parts[0]);
            double im = Double.parseDouble(parts[1].split("\\*", 2)[0]);
            if (s1)
                this.re = -re;
            else
                this.re = re;
            if (s2)
                this.im = -im;
            else
                this.im = im;
        }
    }
}