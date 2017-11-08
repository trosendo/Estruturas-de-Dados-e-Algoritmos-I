public class Tester {
    public static void main(String[] args){
        FilaDeEspera_<String> list = new FilaDeEspera_<>();
        list.add("Hey");
        list.add("How");
        list.add("Are");
        list.add("You");

        System.out.println(list.places());
        System.out.println(list.toString());
    }
}
