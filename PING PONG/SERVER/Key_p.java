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
            if(frame.getTb().getP1().getType()==1)
            {
                 if(frame.getTb().getBall().getType_P()==1)
                 {
                     if(frame.getTb().getBall().getIncY()==0)
                     {
                         if(e.getKeyCode()==e.VK_S)
                         {
                             frame.getTb().getBall().setIncY(1);
                             frame.getSocket().setMessage_server("server_frappe_ball");
                             frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_server());
                         }
                
                         if(e.getKeyCode()==e.VK_Q)
                         {
                             frame.getTb().getP1().setIncI1(-2);
                             frame.getSocket().setMessage_server("server_left");
                             frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_server());
                            
                         }
                         if(e.getKeyCode()==e.VK_D)
                         {
                             frame.getTb().getP1().setIncI1(2);
                             frame.getSocket().setMessage_server("server_right");
                             frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_server());
                            
                         }
                         
                     }
                 
                     
                 }
                 else
                 {
                     if(e.getKeyCode()==e.VK_Q)
                     {
                         frame.getTb().getP1().setIncI1(-2);
                         frame.getSocket().setMessage_server("server_left");
                         frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_server());
     
                     }
                     if(e.getKeyCode()==e.VK_D)
                     {
                         frame.getTb().getP1().setIncI1(2);
                         frame.getSocket().setMessage_server("server_right");
                         frame.getSocket().getOut().writeUTF(frame.getSocket().getMessage_server());
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
