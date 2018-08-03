import java.awt.*;

public class Background {
    public Vector2D position;
    public void render(Graphics graphics) {
        this.position=new Vector2D();
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int)position.x, (int)position.y, 1024, 600);
    }
}
