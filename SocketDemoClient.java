package socketdemoclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;

public class SocketDemoClient {

    public static void main(String[] args) { // abrir conexão
       try
       {
        Socket s = new Socket("localhost", 10000);
        BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
        String str = "Hello world";
        while(true)
        {
            for(int i=0;i<str.length();i++)
            {
                byte b = (byte)str.charAt(i);
                bos.write(b);
                bos.flush();
                char ch = (char)bis.read();
                System.out.println("recebido do client " + ch);
            }
        }
       }
       catch(Exception e) // se der erro
       {
            e.printStackTrace();
       }
    }
    
}
