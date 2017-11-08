import java.io.*;
import java.util.StringTokenizer;
public class ParentMatchEsqueleto{


    public static boolean isOpenParen(String s){
        //retorna true se for parentesis a abrir
        return s.equals("(");

    }
    public static boolean isCloseParen(String s){
        //retorna true se for parenesis a fechar
        return s.equals(")");
    }

    public static boolean marrie(String s, String u){
        // return true se s casa com u
        return isOpenParen(s) && isCloseParen(u);

    }

    public static void main(String[] args){

        System.out.println("Digite a expressão;");

        try {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st=new StringTokenizer(bf.readLine(),"(){}[]",true);
            
            // implementar o algoritmo
            while(st.hasMoreTokens()){
                System.out.println(st.nextToken());
            }
        }
        catch(IOException e) {}
    }
}
  
  