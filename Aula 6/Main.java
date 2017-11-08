public class Main {

    public static void main(String[] args) {
        try {
            BusStop stop = new BusStop();
            stop.action("P080020");
            stop.action("P083010");
            stop.action("B090010");
            stop.action("B093015");
            stop.action("B093515");
            stop.action("P094020");
            stop.action("P094519");
            stop.action("B095015");
            stop.action("B095515");
            stop.action("B100015");
            stop.action("P100550");
            System.out.printf("Average waiting time: %s minutes", stop.getAvg());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
