// Custom thread class
class Printer extends Thread {

    static int counter = 1;
    int remainder;
    static Object lock = new Object();
    Printer(int remainder) {
        this.remainder = remainder;
    }
    public void printer() {
        System.out.println(Thread.currentThread().getName() + " " + counter++);
    }

    @Override
    public void run() {
        // Code to be executed in the thread
        for (int i = 1; i <= 5; i++) {
            synchronized (lock) {
                while (counter % 2 != remainder)
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                printer();
                lock.notifyAll();
            }
        }
    }
}

public class Main {
    public static void main(String[] args)
    {
        Printer evenObject=new Printer(0);
        Printer oddObject=new Printer(1);
        // Create two threads
        Thread even=new Thread(evenObject,"Even Thread");
        Thread odd=new Thread(oddObject,"Odd Thread");
        // Start the threads
        even.start();
        odd.start();
    }

}



