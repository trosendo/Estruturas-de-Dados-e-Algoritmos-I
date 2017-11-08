import java.util.ArrayList;

public class BusStop {
    IQueue<String> stop;
    ArrayList<Integer> avg = new ArrayList<>();

    public BusStop(){
        stop = new QueueArray<>(40);
    }

    public BusStop(int n){
        stop = new QueueArray<>(n);
    }

    public void action(String str) throws Exception{
        String[] activity = decode(str);
        if(activity[0].equals("B")){ //Bus arrives
            int sitsTaken = 0;
            if(!stop.empty()){
                //System.out.println("HEEEY");
                int freeSits = Integer.parseInt(activity[2]);
                for(int i = 0; i < freeSits; i++){  //while (freeSits > 0 && !stop.empty()) {
                    if(!stop.empty()) {
                        setAvg(stop.front().substring(0, 4), activity[1]);
                        stop.dequeue();
                        sitsTaken++;
                    }
                }
            }
            System.out.printf("-> %sh%s, %d/%s lugares livres ocupados, ficam %d pessoas na paragem\n",
                    activity[1].substring(0,2), activity[1].substring(2,4), sitsTaken, activity[2], stop.size());
        }else{ //People arrive
            int size = stop.size();
            for(int i = 0; i < Integer.parseInt(activity[2]); i++){
                try {
                    stop.enqueue(String.format("%s_%d", activity[1], size + i));
                }catch(OverflowQueueException e){
                    System.out.printf("-> %sh%s, %s pessoas chegaram, %d estão na fila\n",
                            activity[1].substring(0,2), activity[1].substring(2,4), activity[2], stop.size());
                    System.out.println(e.getMessage());
                    break;
                }
                //System.out.println(stop.front());
            }
        }
    }

    private String[] decode(String str){
        String[] arr = new String[3];
        arr[0] = str.substring(0, 1);
        arr[1] = str.substring(1, 5);
        arr[2] = str.substring(5, str.length());
        return arr;
    }

    private void setAvg(String arrival, String departure){
        int arrivalH = Integer.parseInt(arrival.substring(0, 2));
        int arrivalM = Integer.parseInt(arrival.substring(2, 4));

        int departureH = Integer.parseInt(departure.substring(0, 2));
        int departureM = Integer.parseInt(departure.substring(2, 4));

        int arrivalTime = arrivalH * 60 + arrivalM;
        int departureTime = departureH * 60 + departureM;

        avg.add(departureTime - arrivalTime);
        //System.out.println("Time diff: " + (departureTime - arrivalTime));
    }

    public int getAvg(){ //Return average wait time in minutes
        int sum = 0;
        int size = avg.size(); //System.out.println(size);
        for(int i = 0; i < avg.size(); i++){
            sum += avg.get(i);
        }
        return sum/size;
    }


}
