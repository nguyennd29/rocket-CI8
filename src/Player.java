import java.awt.*;



public class Player {

    public int x []= new int[3];
    public int y []= new int[3];

    public int velocityX;
    public int velocityY;


   // public void move() {



    public void render(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.fillPolygon(this.x,this.y,3);
    }
}
