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
        // retirn true se s casa com u
        return isOpenParen(s) && isCloseParen(u);

    }

    public static void main(String[] args){

        System.out.print("Digite a expressão: ");

        try {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st=new StringTokenizer(bf.readLine(),"(){}[]",true);
            Stack<String> stack = new MyStack<>(st.countTokens());
            // implementar o algoritmo
            while(st.hasMoreTokens()){
                String s = st.nextToken();
                if(s.length() == 1) {
                    if (isOpenParen(s)) {
                        stack.push(s);
                    } else if (isCloseParen(s) && stack.size() > 0) {
                        if (stack.top().equals("(")) {
                            stack.pop();
                        }
                    } else{
                        System.out.println("Expressão mal balançeada!");
                        break;
                    }
                }
            }
            if(!stack.empty()){
                System.out.println("Expressão mal balançeada!");
            }
        }
        catch(IOException e) {}
    }
}
  
  