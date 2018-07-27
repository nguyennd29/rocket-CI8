import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemies {
    public BufferedImage image;

    public int width;
    public int height;

    public int x;
    public int y;

    public double velocityX;
    public double velocityY;



    public void run(int playerX,int playerY){
        velocityX = 2*(double)((playerX-this.x)/Math.sqrt((playerX-this.x)*(playerX-this.x)+(playerY-this.y)*(playerY-this.y)));
        velocityY = 2*(double)((playerY-this.y)/Math.sqrt((playerX-this.x)*(playerX-this.x)+(playerY-this.y)*(playerY-this.y)));

        this.x += velocityX;
        this.y += velocityY;
    }

    public void render(Graphics graphics){

        graphics.fillOval(this.x,this.y,this.width,this.height);
        graphics.setColor(Color.RED);
    }

}
