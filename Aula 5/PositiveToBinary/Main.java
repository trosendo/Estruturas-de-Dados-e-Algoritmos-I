import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        System.out.print("Integer: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int numOriginal = num;
        Stack<Integer> stack = new MyStack<>();
        String numBin = "";

        while(true){
            if( num / 2 != 0 ){
                stack.push(num % 2);
                num /= 2;
            } else{
                stack.push(num % 2);
                while(!stack.empty()){
                    numBin += stack.pop();
                }
                break;
            }
        }
        System.out.printf("%d in binary is: %s", numOriginal, numBin);
    }
}
