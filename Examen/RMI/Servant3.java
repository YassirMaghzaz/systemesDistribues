package Examen.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servant3 extends UnicastRemoteObject implements Servant3Interface{
    private Servant1Interface servant1;
    private Servant2Interface servant2;

    protected Servant3(Servant1Interface servant1, Servant2Interface servant2) throws RemoteException{
        super();
        this.servant1 = servant1;
        this.servant2 = servant2;
    }

    @Override
    public int calculReste(int m, int n) throws RemoteException {
        if (servant2.inferieur(m, n)) {
            return m;
        } else {
            return calculReste(servant1.soustraction(m, n), n);
        }
    }
}
