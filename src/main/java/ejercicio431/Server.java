package ejercicio431;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Esta clase es la clase Servidor de un echo
 * @author Natalia Orjuela
 * @author Daniel Benavides
 *
 */
public class Server {
    /**
     *
     * @param args que son los argumentos que le ingresa a la clase main
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine="";
        while ((inputLine = in.readLine()) != null) {

            if (outputLine.equals("Respuesta de servidor: Bye."))
                break;
            String var=cuadrado(inputLine,outputLine);
            out.println(var);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static String cuadrado(String inputLine,String outputLine){
        int num=Integer.parseInt(inputLine);
        int result=num*num;
        System.out.println("mensaje recibido: "+result);
        outputLine="respuesta de servidor: "+result;
        return(outputLine);
    }
}