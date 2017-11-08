public class Fraction {
    int numerator;
    int denominator;
    boolean positive = true;

    Fraction(){
        setNumerator(1);
        try {
            setDenominator(1);
        } catch (Exception e) {}
    }
    Fraction(int n){
        setNumerator(1);
        try {
            setDenominator(Math.abs(n));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(n < 0){
            positive = !positive;
        }
    }
    Fraction(int num, int denom) {
        setNumerator(Math.abs(num));
        try {
            setDenominator(Math.abs(denom));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(num < 0 ) {
            positive = !positive;
        }
        if(denom < 0){
            positive = !positive;
        }

    }

    private int getNumerator(){
        return numerator;
    }

    private int getDenominator(){
        return denominator;
    }

    private void setNumerator(int num){
        numerator = num;
    }

    private void setDenominator(int num) throws Exception{
        if(num == 0) {
            throw new Exception("Can't divide by zero!");
        }else {
            denominator = num;
        }
    }

    public String toString() {
        this.reduce();
        if (denominator != 1) {
            return ((positive ? "+" : "-") + numerator + "/" + denominator);
        }else{
            return ((positive ? "+" : "-") + numerator);
        }
    }

    private void reduce(){
        int gcd = gcd(numerator, denominator);
        setNumerator(numerator / gcd);
        try {
            setDenominator(denominator / gcd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    private int gcd(int n1, int n2){
        int remainder = n1 % n2;
        int tempNumerator = n2;
        int lastRemainder;
        while(remainder != 0){
            lastRemainder = remainder;
            remainder = tempNumerator % remainder;
            tempNumerator = lastRemainder;
        }
        int gcd = tempNumerator; //Maximo Divisor Comum
        return gcd;
    }

    Fraction sum(Fraction f2){
        Fraction f = new Fraction();
        int numerator = f2.getNumerator();
        int denominator = f2.getDenominator();
        if(denominator == this.denominator){
            f.setNumerator(numerator + this.numerator);
            try {
                f.setDenominator(denominator);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else{
            try {
                f.setDenominator(this.denominator * denominator);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            f.setNumerator((this.numerator * denominator) + (numerator * this.denominator));
        }
        return f;
    }

    Fraction product(Fraction f2){
        int numerator = f2.getNumerator();
        int denominator = f2.getDenominator();
        Fraction f = new Fraction(this.numerator * numerator,this.denominator * denominator);
        return f;
    }

    Fraction div(Fraction f2){
        int numerator = f2.getNumerator();
        int denominator = f2.getDenominator();
        Fraction f = new Fraction(this.numerator * denominator, this.denominator * numerator);
        return f;
    }
}
