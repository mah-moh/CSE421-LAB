import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String [] args){
        try{
            Socket socket = new Socket("127.0.0.1", 8888);

            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(dout, true);

            DataInputStream din = new DataInputStream(socket.getInputStream());
            InputStreamReader reader = new InputStreamReader(din);
            
            socket.close();

        }catch(Exception e){
            System.out.println(e);
        }

    }
}
