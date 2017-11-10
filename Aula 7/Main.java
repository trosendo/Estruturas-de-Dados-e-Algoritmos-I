public class Main {
    public static void main(String[]args){
        LinkedList<Integer> l = new LinkedList<>();
        l.add(0, 1);
        l.add(1, 2);
        l.add(2, 3);
        l.add(3, 4);
        l.add(4, 5);
        l.add(5, 6);
        l.add(1, 55);
        l.add(4, 12);
        l.removeElement(12);
        System.out.println(l.toString());

    }
}
