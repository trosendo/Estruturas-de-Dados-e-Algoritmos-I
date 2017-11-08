import java.util.Collection;

public abstract class Shape implements Comparable<Shape>{

    public Shape(){

    }

    public abstract float getArea();

    @Override
    public int compareTo(Shape o) {
        if (this.getArea() > o.getArea())
            return 1;
        else if (this.getArea() == o.getArea())
            return 0;
        else
            return -1;

    }

    public String toString(){
        return String.format("I am a %s and my Area is: %f", this.getClass(), this.getArea());
    }

    public static float totalArea(Shape arr[]){
        float total = 0;
        for(int i = 0; i < arr.length; i++)
            total += arr[i].getArea();

        return total;
    }

    public static float totalArea2(Collection<? extends Shape> col){
        float total = 0;
        for (Shape s : col)
            total += s.getArea();

        return total;
    }
}
