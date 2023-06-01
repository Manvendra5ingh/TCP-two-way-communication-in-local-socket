import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket clientSocket = serverSocket.accept();

            // Get local socket details of the server
            InetAddress localAddress = serverSocket.getInetAddress();
            int localPort = serverSocket.getLocalPort();
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            output.println("Server Socket: " + localAddress + ":" + localPort);

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter response = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Client: " + message);
                response.println("Server received: " + message);
            }

            input.close();
            response.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
