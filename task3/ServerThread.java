import java.net.Socket;

public class ServerThread extends Thread{

    private Socket socket;

    ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

                DataInputStream din = new DataInputStream((socket.getInputStream()));

                while (true){
                    String response = (String)din.readUTF();
                    if (response == "End game"){
                        dout.writeUTF("stop");
                        dout.flush();
                        dout.close();
                        break;
                    }else{
                        dout.writeUTF(response);
                        dout.flush();
                        dout.close();
                    }
                    
                }
    }
}
