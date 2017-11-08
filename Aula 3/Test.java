import java.util.ArrayList;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        Shape arr1[] = new Shape[3];
        Shape arr2[] = new Circle[3];
        Shape arr3[] = new Square[3];

        arr1[0] = new Circle(5);
        arr1[1] = new Square(1, 5);
        arr1[2] = new Circle(1.5f);

        arr2[0] = new Circle(1);
        arr2[1] = new Circle(2);
        arr2[2] = new Circle(3);

        arr3[0] = new Square(1, 3);
        arr3[1] = new Square(2, 2);
        arr3[2] = new Square(3, 3);


        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i].toString() + "\n" + arr2[i].toString() + "\n" + arr3[i].toString());
        }
        System.out.println(Shape.totalArea(arr1) + Shape.totalArea(arr2) + Shape.totalArea(arr3));

        Collection<Shape> col1 = new ArrayList<>();
        Collection<Circle> col2 = new ArrayList<>();
        Collection<Square> col3 = new ArrayList<>();
        col1.add(new Circle(2));
        col2.add(new Circle(6));
        col3.add(new Square(6, 2));
        col3.add(new Square(1, 4));

        System.out.println(biggest(arr1).toString());
    }

    private static Shape biggest(Shape arr[]){
        Shape biggest = arr[0];
        for(Shape s : arr){
            int temp = biggest.compareTo(s);
            if(temp == -1)
                biggest = s;
        }
        return biggest;
    }
}
