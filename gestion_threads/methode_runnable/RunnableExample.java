package gestion_threads.methode_runnable;


public class RunnableExample implements Runnable {
    private String message;

    public RunnableExample(String message){
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            System.out.println("Message " + i + " : " + message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted : " + e.getMessage());
            }
        }
    }
}
