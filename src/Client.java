import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public final static int PORT = 25696;

    public static void main(String[] args) {
        try {


            Socket socket = new Socket("localhost", PORT);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter wr = new PrintWriter(socket.getOutputStream(), true);

            while (true) {

                System.out.print("> ");
                String readLine = keyboard.readLine();


                if (readLine.equalsIgnoreCase("exit")) {
                    break;
                }


                wr.println(readLine);


                String read = input.readLine();
                System.out.println("Response: " + read);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
