import java.io.BufferedReader;
import java.io.DataInputStream;
import java.net.Socket;

public class Client {
    public static void main(String [] args){
        try{
            Socket socket = new Socket("127.0.0.1", 8888);

            DataInputStream dis = new DataInputStream((socket.getInputStream()));
            String str = (String)dis.readUTF();
            System.out.println("Response: " + str);
            
            socket.close();

        }catch(Exception e){
            System.out.println(e);
        }

    }
}
