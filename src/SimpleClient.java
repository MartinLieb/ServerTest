import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String[] args) {

        try {

            // Opretter en ny socket og tilslutter til serveren på localhost på port 1
            Socket socket = new Socket("localhost", 1);

            DataInputStream in = new DataInputStream
                    (socket.getInputStream());
            DataOutputStream out = new DataOutputStream
                    (socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String text;

            while (true) {
                System.out.println("Skriv en besked: ");
                text = scanner.next();

                // Send tallet til serveren
                out.writeUTF(text);
                out.flush();
                System.out.println("Besked der kommer tilbage fra sereveren: " + in.readUTF());

                if(text == null) { break; }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}