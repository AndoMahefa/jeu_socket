package box;
import javax.swing.JPanel;
import java.awt.*;
import box.*;

public class Ball extends JPanel
{
    int x;
    int y;
    int incX;
    int incY;
    int score1;
    int score2;
    int type_P;
    int width=10;
    int height=10;

    
    Ball()
    {
         incX=0;
         incY=0;
         x=215;
         y=20; 
        
    }
    
    public void paint (Graphics g)
    {        
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
        y=y+getIncY();
        x=x+getIncX();
        try
        {
            Thread.sleep(3);
        }
        catch (Exception e)
        {}
        if(type_P==1)
        {
            if(x>385)
            {
                incY=1;
                incX=-1;

            }
            else if(x<0)
            {
                incY=1;
                incX=1;
            }
        }
        if(type_P==2)
        {
            if(x>385)
            {
                incY=-1;
                incX=-1;
            }
            else if(x<0)
            {
                incY=-1;
                incX=1;
            }
        } 
        
       
        repaint();
    }
    
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getIncX() {
        return incX;
    }
    public int getIncY() {
        return incY;
    }
    public int getType_P() {
        return type_P;
    }
   
    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setIncX(int incX) {
        this.incX = incX;
    }
    public void setIncY(int incY) {
        this.incY = incY;
    }

    public int getScore1() {
        return score1;
    }
    public int getScore2() {
        return score2;
    }
    public void setScore1(int score1) {
        this.score1 = score1;
    }
    public void setScore2(int score2) {
        this.score2 = score2;
    }
}
