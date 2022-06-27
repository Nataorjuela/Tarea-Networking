package ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * Esta clase es la clase Cliente de un echo
 * @author Natalia orjuela
 * @author Daniel Benavides
 *
 */
public class ServerClient {
    /**
     *
     * @param args que son los argumentos que le ingresa a la clase main
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "+ "the connection to: localhost.");
            System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;
        System.out.println("Ingresar número: ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}