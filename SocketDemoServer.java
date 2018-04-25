package socketdemoserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemoServer {
    
    public static void main(String[] args) {
        try 
        {        
            ServerSocket ss = new ServerSocket(10000); // escolher a porta
            while(true)
            {
                Socket s = ss.accept();
                BufferedInputStream bis = new BufferedInputStream (s.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream (s.getOutputStream());
                while(true)
                {
                    int ch = bis.read();
                    System.out.println("recebido no servidor " + (char)ch);
                    bos.write((byte)ch); // este servidor apenas devolve informações para o cliente
                    bos.flush(); // "empurrar" os dados para o cliente
                }
            } // faça para sempre
        }
        catch(Exception e) // se der erro
        {
            e.printStackTrace();
        }
        
    }
    
}
