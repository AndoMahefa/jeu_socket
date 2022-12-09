package box;
import javax.swing.*;
import java.awt.*; 
import box.*;

public class Player extends JPanel
{
    int width=50;
    int height=10;

    int i1;
    int j1; 
    int i2;
    int j2;

    int incI1;
    int incI2;

    int type;
    Color color;
    
    Player(int type)
    {
        this.type=type;
        i1=200;
        i2=200;
        incI1=0;
        incI2=0;
    }
    public void paint(Graphics g)
    {
        draw();
        g.setColor(this.color);     
        if(this.type==1)
        {
            g.fillRect(getI1(), j1,width,height); 
            i1=i1+getIncI1();
            setI1(i1); 
            if(i1<0)
            {
                i1=0;
            } 
            else if(i1>350)
            {
                i1=350;
            }
           
        }
        if(this.type==2)
        {
            g.fillRect(getI2(), j2,width,height);  
            i2=i2+getIncI2(); 
            setI2(i2);
            if(i2<0)
            {
                i2=0;
            } 
            else if(i2>350)
            {
                i2=350;
            }
            
        } 
             
    }
    public void draw()
    {
        if(this.type==1)
        {
           j1=10;
           this.color=Color.BLACK.CYAN;
        }
        if(this.type==2)
        {
            j2=580; 
            this.color=Color.BLUE;
        }
    }

    public int getType() {
        return type;
    }
    public int getI1() {
        
        return i1;
    }
    public int getJ1() {
        return j1;
    }
   
    public int getI2() {
        return i2;
    }
    public int getJ2() {
        return j2;
    }
   
    public int getIncI1() {
        return incI1;
    }
    public int getIncI2() {
        return incI2;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }
    public void setI2(int i2) {
        this.i2 = i2;
    }
   

    public void setIncI1(int incI1) {
        this.incI1 = incI1;
    }
    public void setIncI2(int incI2) {
        this.incI2 = incI2;
    }

    public int getWidth() {
       return width;
    }
    public int getHeight() {
        return height;
    }    
}
