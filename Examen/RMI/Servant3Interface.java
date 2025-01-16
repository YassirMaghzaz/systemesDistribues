package Examen.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servant3Interface extends Remote{
    int calculReste(int m, int n) throws RemoteException;
}
