import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemies {
    public BufferedImage image;

    public int width;
    public int height;

    public int x;
    public int y;

    public int velocityX;
    public int velocityY;



    public void run(){
        this.x -= velocityX;
        this.y -= velocityY;
    }

    public void render(Graphics graphics){

        graphics.fillOval(this.x,this.y,this.width,this.height);
        graphics.setColor(Color.RED);
    }

}
