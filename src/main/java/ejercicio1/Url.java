package ejercicio1;

import java.net.MalformedURLException;
import java.net.URL;

public class Url {

    public static void main(String[] args) throws MalformedURLException {
        URL miUrl = new URL("https://campusvirtual.escuelaing.edu.co:80/moodle/course/view.php?id=2660#arsw");
        System.out.println("Protocol: "+ getProtocol(miUrl));
        System.out.println("Authority: "+getAuthority(miUrl));
        System.out.println("Host: "+getHost(miUrl));
        System.out.println("Port: "+getPort(miUrl));
        System.out.println("Path: "+getPath(miUrl));
        System.out.println("Query: "+getQuery(miUrl));
        System.out.println("File: "+getFile(miUrl));
        System.out.println("Ref: "+ getRef(miUrl));

    }

    public static String getProtocol(URL miUrl){
        return(miUrl.getProtocol());
    }
    public static String getAuthority(URL miUrl){
        return(miUrl.getAuthority());
    }
    public static String getHost(URL miUrl){
        return(miUrl.getHost());
    }
    public static int getPort(URL miUrl){
        return(miUrl.getPort());
    }
    public static String getPath(URL miUrl){
        return(miUrl.getPath());
    }
    public static String getQuery(URL miUrl){
        return(miUrl.getQuery());
    }
    public static String getFile(URL miUrl){
        return(miUrl.getFile());
    }
    public static String getRef(URL miUrl){
        return(miUrl.getRef());
    }

}
