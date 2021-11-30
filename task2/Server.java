import java.net.*;
import java.io.*;

public class Server{
    public static void main(String [] args){
        try{
            while(true){
                ServerSocket ss = new ServerSocket(8888);
                System.out.println("Server is running on port : 8888");

                Socket socket = ss.accept();

                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(dout, true);

                DataInputStream din = new DataInputStream(socket.getInputStream());
                InputStreamReader reader = new InputStreamReader(din);

                while (true){
                    String response = (String)din.readUTF();
                    if (response == "End game"){
                        dout.writeUTF("stop");
                        dout.flush();
                        break;
                    }else{
                        dout.writeUTF(response);
                        dout.flush();
                    }
                    System.out.println(response);
                    break;
                    
                }

                ss.close();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}