package gestion_threads.methode_thread;

public class ThreadDemo {
    public static void main(String[] args) {    
        ThreadExample t1 = new ThreadExample("Hello");
        t1.start();
        while (t1.isAlive()) {
            System.out.println("Thread 1 is still alive");
        }
    }
}
