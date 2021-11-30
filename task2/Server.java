import java.net.*;
import java.io.*;

public class Server{
    public static void main(String [] args){
        try{
            while(true){
                ServerSocket ss = new ServerSocket(8888);
                System.out.println("Server is running on port : 8888");

                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(dout, true);

                DataInputStream din = new DataInputStream(socket.getInputStream());
                InputStreamReader reader = new InputStreamReader(din);

                Socket socket = ss.accept();

                ss.close();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}