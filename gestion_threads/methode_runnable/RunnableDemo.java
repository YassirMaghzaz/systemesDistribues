package gestion_threads.methode_runnable;

public class RunnableDemo {
    public static void main(String[] args) {
        RunnableExample r1 = new RunnableExample("Hello");
        Thread t1 = new Thread(r1);
        
        System.out.println("Starting The Main Thread...");
        
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread has been interrupted : " + e.getMessage());
        }

        System.out.println("Main thread is done :)");
    }
}
