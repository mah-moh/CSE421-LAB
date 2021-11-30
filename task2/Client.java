import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String [] args){
        try{
            Socket socket = new Socket("127.0.0.1", 8888);

            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(dout, true);

            DataInputStream din = new DataInputStream(socket.getInputStream());
            InputStreamReader reader = new InputStreamReader(din);

            Scanner sc = new Scanner(System.in);

            socket.close();

            while(true) {
                System.out.println("Write here");
                String input = sc.nextLine();

                dout.writeUTF(input);
                dout.flush();
                String response = din.readUTF();
                if (response == "stop"){
                    break;
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }
}
