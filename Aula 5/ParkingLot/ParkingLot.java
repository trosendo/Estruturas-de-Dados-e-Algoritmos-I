public class ParkingLot {
    Stack<Cars> parkLeft;
    Stack<Cars> parkRight;
    private final int maxSize = 10;
    boolean leftFull = false;
    boolean rightFull = false;
    private int parkedCars = 0;
    boolean removedFromLeft = false;
    boolean removedFromRight = false;

    public ParkingLot(){
        parkLeft = new MyStack<>(maxSize);
        parkRight = new MyStack<>(maxSize);
    }

    public void parkCar(Cars in){
        if(parkedCars < (maxSize+1)) {
            if (((parkLeft.size() != maxSize) && parkRight.empty()) || (parkRight.size() == maxSize && parkLeft.empty())) {
                parkLeft.push(in);
                parkedCars++;
            } else if ((parkLeft.empty() && (parkRight.size() != maxSize)) || (parkLeft.size() == maxSize && parkRight.empty())) {
                parkRight.push(in);
                parkedCars++;
            } else if (parkLeft.size() != maxSize && parkRight.size() != maxSize){
                System.out.println("HEEEEEEY");
                parkLeft.push(in);
                parkedCars++;
            }
        }else{
            System.out.println("Max amount of cars parked!");
        }
        if(parkRight.size() == maxSize){
            rightFull = true;
        }else{
            rightFull = false;
        }
        if(parkLeft.size() == maxSize){
            leftFull = true;
        }else{
            leftFull = false;
        }
    }

    public Cars removeCar(Cars out) {
        Cars toRemove = new Cars();
        if (contains(out)) {
            if (leftFull) {
                for (int i = 0; i < maxSize + 1; i++) {
                    if (i == 0 && !parkRight.empty()) {
                        toRemove = parkRight.pop();
                        //noinspection Duplicates
                        if (toRemove.equalsTo(out)) {
                            rightFull = false;
                            removedFromRight = true;
                            parkedCars--;
                            return toRemove;
                        }
                        parkRight.push(toRemove);
                    } else {
                        toRemove = parkLeft.pop();
                        leftFull = false;
                        if (toRemove.equalsTo(out)) {
                            removedFromLeft = true;
                            parkedCars--;
                            return toRemove;
                        } else {
                            parkRight.push(toRemove);
                            toRemove.move();
                        }
                    }
                }
            } else if (rightFull) {
                for (int j = 0; j < maxSize + 1; j++) {
                    if (j == 0 && !parkLeft.empty()) {
                        toRemove = parkLeft.pop();
                        //noinspection Duplicates
                        if (toRemove.equalsTo(out)) {
                            leftFull = false;
                            removedFromLeft = true;
                            parkedCars--;
                            return toRemove;
                        }
                        parkLeft.push(toRemove);
                    } else {
                        toRemove = parkRight.pop();
                        rightFull = false;
                        if (toRemove.equalsTo(out)) {
                            removedFromRight = true;
                            parkedCars--;
                            return toRemove;
                        }
                        parkLeft.push(toRemove);
                        toRemove.move();
                    }
                }
            }else if(removedFromLeft){
                for(int c = 0; c < maxSize; c++){
                    toRemove = parkRight.pop();
                    if (toRemove.equalsTo(out)) {
                        removedFromRight = true;
                        parkedCars--;
                        return toRemove;
                    }
                    parkLeft.push(toRemove);
                    toRemove.move();
                }
            }
        } else {
            toRemove.setPlate("CAR NOT  FOUND");
        }
        return toRemove;
    }

    public String toString(){
        String output = "Left:\n";
        for(int i = 0; i<maxSize; i++){
            if(parkLeft.elementAt(i) != null)
                output += " - " + parkLeft.elementAt(i).getPlate() + "\n";
            else
                break;
        }
        output += "Right: \n";
        for(int i = 0; i<maxSize; i++){
            if(parkRight.elementAt(i) != null)
                output += " - " + parkRight.elementAt(i).getPlate() + "\n";
            else
                break;
        }
        return output;
    }

    private boolean contains(Cars car){
        for(int i = 0; i<maxSize; i++){
            if(parkLeft.elementAt(i) != null) {
                if (car.equalsTo(parkLeft.elementAt(i))) {
                    return true;
                }
            }else{
                break;
            }
        }
        for(int i = 0; i<maxSize; i++) {
            if (parkRight.elementAt(i) != null) {
                if (car.equalsTo(parkRight.elementAt(i))) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
