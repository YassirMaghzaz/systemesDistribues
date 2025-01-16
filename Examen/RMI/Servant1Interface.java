package Examen.RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servant1Interface extends Remote{
    int soustraction(int x, int y) throws RemoteException;
}
