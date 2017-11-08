public class Teste {
    public static void main(String[] args){
        Fraction fraction = new Fraction();
        Fraction fraction1 = new Fraction();
        try{
            fraction = new Fraction(5, 11);
            fraction1 = new Fraction(6, 13);
            System.out.println("Fraction 0 : " + fraction.toString());
            System.out.println("Fraction 1 : " + fraction1.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Fraction div = fraction.div(fraction1);
        System.out.println("Div : " + div.toString());
    }
}
