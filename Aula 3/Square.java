public class Square extends Shape{

    float l;
    float h;
    float area;
    float perimeter;

    public Square(){

    }

    public Square(float l, float h){
        if(l != 0 && h != 0){
            setSides(l, h);
            setArea();
            setPerimeter();
        }
    }

    public void setSides(float length, float height) {
        l = length;
        h = height;
    }

    public float getArea(){
        return area;
    }

    private void setArea(){
        area = l * h;
    }

    public float getPerimeter(){
        return perimeter;
    }

    private void setPerimeter(){
        perimeter = (l * 2) + (h * 2);
    }
}
