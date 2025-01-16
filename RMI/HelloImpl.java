package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface {
    protected  HelloImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
}
