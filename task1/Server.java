import java.net.*;
import java.io.*;
import java.util.Date;

public class Server{
    public static void main(String [] args){
        try{
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Server is running on port : 8888");

            Socket socket = ss.accept();

            String date = new Date().toString();

            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(date);
            dout.flush();
            dout.close();

            ss.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}