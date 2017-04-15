package track.lessons.lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by franck on 04.04.17.
 */
public class Server {

    public static final int PORT = 19000;
    private boolean work = true;

    Server() {
        while (work) {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                Socket socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("error");
                System.exit(0);
            }
        }
    }

    class SingleClient extends Thread {
        SingleClient(Socket socket) {
            SocketAddress socketAddress = socket.getRemoteSocketAddress();
            System.out.println();

        }
    }

}
