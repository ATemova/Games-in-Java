import java.io.*;
import java.net.*;
import java.util.Scanner;

// Server class
class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String message;
            while (true) {
                message = in.readLine();
                if (message.equalsIgnoreCase("exit")) break;
                System.out.println("Client: " + message);
                System.out.print("Server: ");
                message = scanner.nextLine();
                out.println(message);
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Client class
class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String message;
            while (true) {
                System.out.print("Client: ");
                message = scanner.nextLine();
                out.println(message);
                if (message.equalsIgnoreCase("exit")) break;
                message = in.readLine();
                System.out.println("Server: " + message);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
