package gestion_threads.methode_thread;

public class ThreadDemo {
    public static void main(String[] args) {    
        ThreadExample t1 = new ThreadExample("Hello");
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
