import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Receive and display server socket details
            String serverSocket = input.readLine();
            System.out.println(serverSocket);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String message;
            while ((message = consoleInput.readLine()) != null) {
                output.println(message);
                System.out.println("Server: " + input.readLine());
            }

            input.close();
            output.close();
            consoleInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
