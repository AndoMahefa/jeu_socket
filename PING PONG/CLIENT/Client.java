package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import box.*;
import windows.*;

public class Client extends Thread{
    Socket socket = null;
    Frame fr = null;
    String message_client = "";
    DataOutputStream out;

    public Client(String adress,int port){
        Table tb =  new Table();
        fr = new Frame(tb,this);
        try {
            this.socket = new Socket(adress, port);

            out = new DataOutputStream(this.socket.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Thread thread = new Thread(this);
            thread.start();
            while (!this.message_client.equals("Over"))
            {
                try
                {
                    this.message_client = br.readLine();
                    out.writeUTF("Client:"+this.message_client);
                }
                catch(IOException i)
                {
                    i.printStackTrace();
                }
            }
            // close the connection
                
                this.socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run(){
        try {
            
            DataInputStream input = new DataInputStream(this.socket.getInputStream());
            String message_server = "";

            while (!message_server.equals("Over"))
            {
                try
                {
                    message_server=input.readUTF();
                    message_server(message_server);
                    System.out.println(message_server);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }

        this.socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void message_server(String message_server)
    {
        if(message_server.equals("server_left"))
        {
            this.fr.getTb().getP1().setIncI1(-2);
        }
        else if(message_server.equals("server_right"))
        {
            this.fr.getTb().getP1().setIncI1(2);
        }
        else if(message_server.equals("server_frappe_ball"))
        {
            if(this.fr.getTb().getP1().getType()==1)
            {
                 if(this.fr.getTb().getBall().getType_P()==1)
                 {  
                    if(this.fr.getTb().getBall().getIncY()==0)
                    {
                        this.fr.getTb().getBall().setIncY(1);
                    }
                 }
            }
           
        }
    
        
        
    }
    public String getMessage_client() {
        return message_client;
    }
    public void setMessage_client(String message_client) {
        this.message_client = message_client;
    }
    public DataOutputStream getOut() {
        return out;
    }
    public void setOut(DataOutputStream out) {
        this.out = out;
    }
}
