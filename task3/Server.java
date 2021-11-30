import java.net.*;
import java.io.*;

public class Server{
    public static void main(String [] args){
        try{
            while(true){
                ServerSocket ss = new ServerSocket(8888);
                System.out.println("Server is running on port : 8888");

                Socket socket = ss.accept();

                ServerThread thread = new ServerThread(socket);
                thread.start();

                ss.close();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}