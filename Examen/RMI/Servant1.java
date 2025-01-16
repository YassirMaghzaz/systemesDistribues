package Examen.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servant1 extends UnicastRemoteObject implements Servant1Interface{
    protected Servant1() throws RemoteException {
        super();
    }

    @Override
    public int soustraction(int x, int y) throws RemoteException {
        return x - y;
    }
}
