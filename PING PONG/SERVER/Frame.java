package windows;
import javax.swing .*;
import box.*;
import listener.*;
import socket.*;

public class Frame  extends JFrame 
{
    Table tb;
    Server socket;
    public Frame(Table tb, Server socket)
    {
        this.setVisible(true);
        this.setTitle("PING PONG");
        this.tb = tb;
        this.socket = socket;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(500,700);
        this.add(tb);
        this.addKeyListener(new Key_p(this));
        
    }
    public Table getTb() {
        return tb;
    }
    public void setTb(Table tb) {
        this.tb = tb;
    }
    public Server getSocket() {
        return socket;
    }
    public void setSocket(Server socket) {
        this.socket = socket;
    }
    
}