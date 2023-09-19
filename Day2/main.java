//Class that implements Runnable
class Runner implements Runnable {
    private int min = 1;
    private int max = 4;
    private int goal = 5;

    @Override
    public void run() {
        // Task logic goes here
        int i = 0;
        while (i <= goal) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("Unexcepted Error");
            }
            int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
            i += random;
            if (i >= goal) {
                System.out.println(Thread.currentThread().getName() + " finished the race!");
                break;
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {
        // Create an instance of Runner
        Runner runner = new Runner();
        // Create a Thread and pass the Runner instance
        Thread runner1 = new Thread(runner,"Runner1");
        Thread runner2 = new Thread(runner,"Runner2");
        Thread runner3 = new Thread(runner,"Runner3");
        // Start the threads
        runner1.start();
        runner2.start();
        runner3.start();

    }
}
