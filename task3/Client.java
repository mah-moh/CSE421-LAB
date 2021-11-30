import java.io.DataOutputStream;

public class Client {
    public static void main(String [] args){
        try{
            Socket socket = new Socket("127.0.0.1", 8888);

            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

            DataInputStream din = new DataInputStream((socket.getInputStream()));

            Scanner sc = new Scanner(System.in);

            socket.close();

            while(true) {
                System.out.println("Write here");
                String input = sc.nextLine();

                dout.writeUTF(input);
                dout.flush();
                dout.close();

                String response = (String)din.readUTF();
                if (response == "stop"){
                    break;
                }else{
                    System.out.println("Response from server: "+ response);
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }
}
