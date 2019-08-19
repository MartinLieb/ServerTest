import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {


        try {
            // Server, der lytter på port 1
            ServerSocket server = new ServerSocket(1);

            System.out.println("Serveren kører fint!");

            // Fyrer op under op serveren
            Socket socket = server.accept();

            System.out.println("Serveren har modtaget en forbindelse fra " + socket.getRemoteSocketAddress().toString());

            while (true) {

                DataInputStream in = new DataInputStream
                        (socket.getInputStream());
                DataOutputStream out = new DataOutputStream
                        (socket.getOutputStream());

                String text = in.readUTF();
                System.out.println(text);
                out.writeUTF(text);
                out.flush();

                if(text == null) { break; }
            }


        } catch (IOException e) {
            System.out.println("Serveren er fucked!");


            e.printStackTrace();

        }


    }

}