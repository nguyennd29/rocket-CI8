import java.awt.*;

public class BackgroundRenderer implements Renderer {
    public BackgroundRenderer() {
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int)position.x, (int)position.y, 1024, 600);

    }
}
