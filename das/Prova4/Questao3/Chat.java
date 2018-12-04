import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;

/**
    Da classe Chat é gerado o:
        Chat_Stub.class
**/
public class Chat extends UnicastRemoteObject implements InterfaceChat, Runnable
{
    private static final long serialVersionUID = 1L;
    // Guardando instancia do servidor registrado
    private InterfaceChat servidor;
    private String id;


    protected Chat(InterfaceChat ic, String id) throws RemoteException
    {
        this.servidor = ic;
        this.id = id;
        servidor.entrarChat(this);
    }


    @Override
    public String getId() throws RemoteException {
        return id;
    }

    @Override
    public String mostrarUsuario(String id) throws RemoteException {
        return null;
    }

    @Override
    public void entrarChat(InterfaceChat ic) throws RemoteException {
    }

    // Método invocado remotamente pelo Servidor
    @Override
    public boolean enviarMSG(String id, String message) throws RemoteException {
        System.out.println("\n\nNova mensagem do " + message);
        return true;
    }

    @Override
    public void enviarMSGTodos(String id, String message) throws RemoteException {
    }


    public void run() {
        System.out.println("Conectado com sucesso ao Chat Servidor");
        System.out.println("Agora você está online no Chat\n");
        Scanner sc = new Scanner(System.in);
        String msg = "", uId = "";
        int menu = -1;
        String usuarios;

        do {
            System.out.println("Digite a opção desejada:");
            System.out.println("1- Mandar msg para um usuário");
            System.out.println("2- Mandar msg para todos os usuários");
            System.out.println("0- Sair");
            System.out.print("Opção: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    try {
                        // Chamando método remotamente no servidor
                        usuarios = servidor.mostrarUsuario(id);
                        System.out.println(usuarios);
                        System.out.print("\nDigite o nome do usuário: ");
                        uId = sc.nextLine();
                        System.out.print("Digite a mensagem: ");
                        msg = sc.nextLine();
                        try {
                            // Chamando método remotamente no servidor
                            if (servidor.enviarMSG(uId, msg)) {
                                System.out.println("Mensagem enviada com sucesso!");
                            } else {
                                System.out.println("Usuário não encontrado");
                            }
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.print("Digite a mensagem: ");
                    msg = sc.nextLine();
                    try {
                        // Chamando método remotamente no servidor
                        servidor.enviarMSGTodos(id, msg);
                        System.out.println("Mensagem enviada com sucesso!");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;

                case 0:
                    System.out.println("Saindo do chat com sucesso...");
                    break;

                default:
                    System.out.println("Opção inválida...");
            }
        } while(menu != 0);
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        Scanner sc = new Scanner(System.in);
        String nome = "";

        System.out.println("Bem vindo ao Chat de DAS\n");
        System.out.println("Informe seu nome para começar: ");
        nome = sc.nextLine();

        // Buscando Servidor registrado
        InterfaceChat ic = (InterfaceChat) Naming.lookup("rmi://localhost/ChatServidor");
        // Criando novo Chat dentro do Servidor
        new Thread(new Chat(ic, nome)).start();
    }
}
