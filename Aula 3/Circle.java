public class Circle extends Shape {

    float radius;
    float area;

    public Circle(float radius){
        if(radius != 0) {
            setRadius(radius);
            setArea();
        }
    }

    public Circle(){

    }

    public void setRadius(float radius){
        this.radius = radius;
    }

    private void setArea(){
        area = (float) Math.PI * radius * radius;
    }

    public float getArea(){
        return area;
    }

}
