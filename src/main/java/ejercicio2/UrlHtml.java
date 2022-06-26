package ejercicio2;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlHtml {
    public static void main(String[] args) throws Exception {
        System.out.println("Ingresar URL: ");
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String url =br.readLine();
        String result=System.getProperty("user.dir");

        String barra="\\";
        String barraNew = result.replace(barra,"/");
        barraNew=barraNew+"/HTML/resultado.html";
        FileWriter archivo =new FileWriter(barraNew);

        getHtml(url,archivo);
    }
    public static void getHtml(String url,FileWriter archivo) throws Exception {
        URL browser=new URL(url);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(browser.openStream()))){
            String entrada=null;
            while((entrada=br.readLine())!=null){
                archivo.write(entrada);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
