package Examen.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servant2 extends UnicastRemoteObject implements Servant2Interface {
    protected Servant2() throws RemoteException {
        super();
    }

    @Override
    public boolean inferieur(int x, int y) throws RemoteException {
        return x < y;
    }
}
