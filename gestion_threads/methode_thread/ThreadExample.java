package gestion_threads.methode_thread;

public class ThreadExample extends Thread{
    private String message;

    public ThreadExample(String message){
        this.message = message;
    }

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(message + " - " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted : " + e.getMessage());
            }
        }
    }
}
