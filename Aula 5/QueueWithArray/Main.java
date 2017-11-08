public class Main {
    public static void main(String[] args){
        QueueWithArray<String> queue = new QueueWithArray<>();
        try {
            for (int i = 0; i < 20; i++) {
                System.out.println("HHHEY");
                queue.enqueue(String.format("%d", i));
            }
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.enqueue("OLAA");

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(queue.front());

    }
}
