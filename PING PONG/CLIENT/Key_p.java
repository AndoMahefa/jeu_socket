package listener;
import java.awt.event.*;
import box.*;
import windows.*;

public class Key_p implements KeyListener
{
    Frame frame;
    public Key_p(Frame f)
    {
        this.frame=f;
    }

    
    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        try {
            if(frame.getTb().getP2().getType()==2)
            {
                 if(frame.getTb().getBall().getType_P()==2)
                 {
                     if(frame.getTb().getBall().getIncY()==0)
                     {
                         if(e.getKeyCode()==e.VK_UP)
                         {
                             frame.getTb().getBall().setIncY(-1);
                             frame.getSocket().setMessage_client("client_frappe_ball");
                             frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_client());
                         }
                         if(e.getKeyCode()==e.VK_LEFT)
                         {
                             frame.getTb().getP2().setIncI2(-2);
                             frame.getSocket().setMessage_client("client_left");
                             frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_client());
                             
                         }
                         if(e.getKeyCode()==e.VK_RIGHT)
                         {
                             frame.getTb().getP2().setIncI2(2);
                             frame.getSocket().setMessage_client("client_right");
                         frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_client());
                            
                         }
                     }
                 
                 }
                 else
                 {
                     if(e.getKeyCode()==e.VK_LEFT)
                     {
                         frame.getTb().getP2().setIncI2(-2);
                         frame.getSocket().setMessage_client("client_left");
                         frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_client());
                     }
                     if(e.getKeyCode()==e.VK_RIGHT)
                     {
                         frame.getTb().getP2().setIncI2(2);
                         frame.getSocket().setMessage_client("client_right");
                         frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_client());
                     }
                 }
                 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
     
        
    }
    

    public void keyReleased(KeyEvent e) {
        
    }
}
