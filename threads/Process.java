package threads;
public class Process extends Thread 
{ 
    private static String nomGlobal= ""; 
    private String nomLocal; 
    Process ( String s ) { nomLocal = s; } 
    public void run() 
    { 
        nomGlobal = nomGlobal + nomLocal;
        //System.out.println(nomGlobal); 
    } 
    public static void main(String args[]) 
    { 
        Thread T1 = new Process( "Toto" ); 
        Thread T2 = new Process( "Titi" ); 
        T1.start(); T2.start(); 
        System.out.println( nomGlobal );
        System.out.println( nomGlobal );
        System.out.println( nomGlobal );
        
    }
}