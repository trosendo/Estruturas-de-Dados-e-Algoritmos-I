public class Main {
    public static void main(String[]args){
        Cars c1 = new Cars("00-00-AA");
        Cars c2 = new Cars("11-11-BB");
        Cars c3 = new Cars("22-22-CC");
        Cars c4 = new Cars("33-33-DD");
        Cars c5 = new Cars("44-44-EE");

        Cars c6 = new Cars("01-00-AA");
        Cars c7 = new Cars("12-11-BB");
        Cars c8 = new Cars("23-22-CC");
        Cars c9 = new Cars("34-33-DD");
        Cars c10= new Cars("45-44-EE");

        Cars c11= new Cars("10-00-AA");
        Cars c12= new Cars("11-22-RR");

        ParkingLot park = new ParkingLot();

        park.parkCar(c1);
        park.parkCar(c2);
        park.parkCar(c3);
        park.parkCar(c4);
        park.parkCar(c5);
        park.parkCar(c6);
        park.parkCar(c7);
        park.parkCar(c8);
        park.parkCar(c9);
        park.parkCar(c10);
        park.parkCar(c11);

        System.out.println(park.toString());

        Cars car = park.removeCar(c1);
        System.out.println("Car Removed: " + car.getPlate() + "\nIt was moved " + car.getMoves() + " times.");

        park.parkCar(c12);

        car = park.removeCar(c11);
        System.out.println("Car Removed: " + car.getPlate() + "\nIt was moved " + car.getMoves() + " times.");
    }
}
