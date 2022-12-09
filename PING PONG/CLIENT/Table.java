package box;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;
import box.*;

import java.awt.*; 

public class Table extends JPanel
{
    int width;
    int height;
    Player p1=new Player(1);
    Player p2=new Player(2);
    Ball ball=new Ball();
    public Table()
    { 
      width=400;
      height=600;
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, width,height);


        g.setColor(Color.WHITE);
        g.setFont(new FontUIResource("ARIAL", Font.CENTER_BASELINE, 20));
        g.drawString(""+ball.getScore1(), 10, 250);

        g.setColor(Color.WHITE);
        g.setFont(new FontUIResource("ARIAL", Font.CENTER_BASELINE, 20));
        g.drawString(""+ball.getScore2(), 10, 360);

        
        g.setColor(Color.WHITE);
        g.drawLine(0, (height/2) ,width, (height/2));

        p1.paint(g);
        p2.paint(g);

        ball.paint(g);
        check();
        score();
        repaint();
        
    }   

    public void check()
    {
        int p1_X=p1.getI1();
        int p2_X=p2.getI2();
        int width_p=p1.width;
        int height_p1=p1.height;
        int height_p2=p2.height;
        int width_b=ball.width;
    
            if(ball.y==p1.getJ1()+height_p1)
            {
                if((ball.x+width_b)>=(p1_X-5) && (ball.x+width_b)<=(p1_X+width_p))
                {
                    ball.incY=0;
                    ball.incX=0;
                    ball.x=p1_X+15;
                    ball.type_P=1;
                }
            }
           
            if(ball.y==p2.getJ2()-height_p2)
            {
                if((ball.x+width_b)>=(p2_X-5) && (ball.x+width_b)<=(p2_X+width_p))
                {
                    ball.incY=0;
                    ball.incX=0;
                    ball.x=p2_X+15;
                    ball.type_P=2;
                }
            }
            
            
        
    }
    public void score()
    {
        int p1_X=p1.getI1();
        int p2_X=p2.getI2();
        int height_p1=p1.height;
        int height_p2=p2.height;
        if(ball.y==0)
        {
            ball.x=p1_X+15; // position ball rehefa maty
            ball.y=p1.getJ1()+height_p1; // position ball rehefa maty
            ball.incY=0;
            ball.score2++; // increment score 
            ball.setScore2(ball.score2);
            System.out.println("P2"+" "+ball.score2);
        }
        
        if(ball.y==580)
        {
            ball.x=p2_X+15; // position ball rehefa maty
            ball.y=p2.getJ2()-height_p2; // position ball rehefa maty
            ball.incY=0;
            ball.score1++; // increment score
            ball.setScore1(ball.score1);
            System.out.println("P1"+" "+ball.score1);
        }
    }
    public Player getP1() {
        return p1;
    }
   
    public Player getP2() {
        return p2;
    }
    public Ball getBall() {
        return ball;
    }
}
