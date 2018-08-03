import java.awt.*;

public class Background {
    public Vector2D position;
    public Renderer renderer;

    public  Background(){
        position=new Vector2D();

        renderer=new BackgroundRenderer();
    }
    public void render(Graphics graphics) {
        this.renderer.render(graphics,position);
    }
}
