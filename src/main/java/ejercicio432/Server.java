package ejercicio432;

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
    public static String funcion="coseno";
    public static String[] parte = null;
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
            String resultado="calculando..";

            if (outputLine.equals("Respuesta de servidor: Bye."))
                break;
            else if(inputLine.contains("pi")){
                Double pi=3.141592;
                parte = inputLine.split("/");
                String pos = "";
                pos = parte[1];
                Double a =Double.parseDouble(pos);
                Double resultado2 = pi/a;
                out.println(resultado2);

            }
            else if(inputLine.contains(":")){
                if(outputLine.equals("fun:sin" )){
                    funcion="seno";


                }
                else if (outputLine.equals("fun:cos")){
                    funcion="coseno";

                }
                else if (outputLine.equals("fun:tan")){
                    funcion="tangente";
                }

            }
            else{
                if (funcion.equals("coseno")){
                    Double result=coseno(inputLine);
                    resultado = "resultado : "+result;
                }
                else if (funcion.equals("seno")){
                    Double result=seno(inputLine);
                    resultado = "resultado : "+result;
                }
                else if (funcion.equals("tangente")){
                    Double result=tangente(inputLine);
                    resultado = "resultado : "+result;
                }

            }
            out.println(resultado);



















        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static Double coseno(String inputLine){
        Double radianes=Double.parseDouble(inputLine);
        Double result=Math.cos(radianes);
        return(result);
    }
    public static Double seno(String inputLine){
        Double radianes=Double.parseDouble(inputLine);
        Double result=Math.sin(radianes);
        return(result);
    }
    public static Double tangente(String inputLine){
        Double radianes=Double.parseDouble(inputLine);
        Double result=Math.tan(radianes);
        return(result);
    }
}
