import java.net.MalformedURLException;
import java.rmi.*;

public interface InterfaceChat extends Remote
{
    String getId() throws RemoteException;
    String mostrarUsuario(String id) throws RemoteException;
    void entrarChat(InterfaceChat ic) throws RemoteException;
    boolean enviarMSG(String id, String message) throws RemoteException;
    void enviarMSGTodos(String id, String message) throws RemoteException;
}
