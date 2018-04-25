package socketdemoserverthreaded;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemoServerThreaded {

   
    public static void main(String[] args) {
        try
        {
            ServerSocket ss = new ServerSocket(10000);
            while(true)
            {
                Socket s = ss.accept();
                Service servico = new Service(s);
                servico.start();
                while(true)
                {
                    
                }
            } // faça para sempre
        }
        catch(Exception e) // se der erro
        {
            e.printStackTrace();
        }
    }
    
    private static class Service extends Thread
    {
        Socket socket = null;
        Service(Socket s)
        {
            socket = s;
        } // construtor
        public void run()
        {
            try
            {
                BufferedInputStream bis = new BufferedInputStream (socket.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream (socket.getOutputStream());
                while(true)
                {
                    int ch = bis.read();
                    bos.write((byte)ch); // este servidor apenas devolve informações para o cliente
                    bos.flush(); // "empurrar" os dados para o cliente
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();        
            }
        }
    }
    
}
