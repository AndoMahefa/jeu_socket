package socket;
import java.io.*;
import java.net.*;
import box.*;
import listener.*;
import socket.*;
import windows.*;
import box.*;
public class Server extends Thread{
    Socket socket = null;
    Frame fr = null;
    String message_server = "";
    DataOutputStream out;
    public Server(int port){
        Table tb =  new Table();
        fr = new Frame(tb,this);
        try {
            ServerSocket ss = new ServerSocket(port);
            this.socket = ss.accept();
            System.out.println(socket+" Connecter");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
            Thread thread = new Thread(this);
            thread.start();
            while (!message_server.equals("Over"))
            {
                try
                {
                    this.message_server=br.readLine();
                    out.writeUTF("Server:"+message_server);
                }
                catch(IOException i)
                {
                   i.printStackTrace();
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }   
    public void run(){
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String message_client = "";
            while (!message_client.equals("Over"))
            {
                try
                {
                    message_client=input.readUTF();
                    message_client(message_client);
                    System.out.println(message_client);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            input.close();
            this.socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void message_client(String message_client)
    {
        if(message_client.equals("client_left"))
        {
            this.fr.getTb().getP2().setIncI2(-2);
        }
        else if(message_client.equals("client_right"))
        {
            this.fr.getTb().getP2().setIncI2(2);
        }
        else if(message_client.equals("client_frappe_ball"))
        {
            if(this.fr.getTb().getP2().getType()==2)
            {
                 if(this.fr.getTb().getBall().getType_P()==2)
                 {  
                    if(this.fr.getTb().getBall().getIncY()==0)
                    {
                        this.fr.getTb().getBall().setIncY(-1);
                    }
                 }
            }
            
        }
        
       
    }
    public String getMessage_server() {
        return message_server;
    }
    public void setMessage_server(String message_server) {
        this.message_server = message_server;
    }
    public DataOutputStream getOut() {
        return out;
    }
    public void setOut(DataOutputStream out) {
        this.out = out;
    }

}
