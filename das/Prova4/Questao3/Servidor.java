import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
    Da classe Servidor é gerado o:
        Servidor_Stub.class
**/
public class Servidor extends UnicastRemoteObject implements InterfaceChat {

    private static final long serialVersionUID = 1L;

    // O Servidor atua como Registro guardando os usuários conectados
    private List<InterfaceChat> usuarios;

    // Inicia o Servidor com os registros de usuários vazio
    protected Servidor() throws RemoteException {
        usuarios = new ArrayList<InterfaceChat>();
    }

    @Override
    public String getId() throws RemoteException {
        return null;
    }

    // Método que retorna todos os usuários conectados
    @Override
    public String mostrarUsuario(String id) throws RemoteException {
        String resposta = "";
        for (InterfaceChat u : usuarios) {
            if (!u.getId().equalsIgnoreCase(id)) {
                resposta += u.getId() + "\n";
            }
        }

        return resposta;
    }

    // Método que adiciona um usuário conectado ao Registro
    @Override
    public synchronized void entrarChat(InterfaceChat ic) throws RemoteException {
        this.usuarios.add(ic);
    }

    // Método que enviar uma msg para um usuário específico
    @Override
    public boolean enviarMSG(String id, String message) throws RemoteException {
        for (InterfaceChat u : usuarios) {
            if (u.getId().equalsIgnoreCase(id)) {
                // Método invocado memotamente
                u.enviarMSG(null, id + ": " + message);
                return true;
            }
        }

        return false;
    }

    // Método que enviar msg para todos os usuário conectados menos ao que fez o pedido de envio
    @Override
    public void enviarMSGTodos(String id, String message) throws RemoteException {
        for (int i=0; i<usuarios.size(); i++) {
            if (!usuarios.get(i).getId().equalsIgnoreCase(id)) {
                // Método invocado memotamente
                usuarios.get(i).enviarMSG(null,id + ": " + message);
            }
        }
    }

    public static void main(String[] arg) throws RemoteException, MalformedURLException {
        // Iniciando e registrando o servidor
        Naming.rebind("ChatServidor", new Servidor());
    }
}
