public class Cars {
    private String plate;
    private int moves;

    public Cars(String id){
        plate = id;
    }

    public Cars(){

    }

    public void setPlate(String id){
        plate = id;
    }

    public String getPlate(){
        return plate;
    }


    public boolean equalsTo(Cars o) {
        if(plate.equals(o.getPlate())){
            return true;
        }else{
            return false;
        }
    }

    public void move(){
        moves++;
    }

    public int getMoves(){
        return moves;
    }
}
