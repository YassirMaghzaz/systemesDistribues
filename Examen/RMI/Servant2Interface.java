package Examen.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servant2Interface extends Remote{
    boolean inferieur(int x, int y) throws RemoteException;
}
