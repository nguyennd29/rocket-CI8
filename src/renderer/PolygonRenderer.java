package renderer;

import base.Vector2D;

import java.awt.*;
import java.util.Arrays;

public class PolygonRenderer implements Renderer {

    private java.util.List<Vector2D> vertices;
    private Polygon polygon;
    public double angle;

    private Color color;

    public PolygonRenderer(Color color,Vector2D... vertices) {
        this.polygon = new Polygon();
        this.color=color;
        this.vertices= Arrays.asList(vertices);
    }

    private void updateTriangle(Vector2D position) {
        this.polygon.reset();
        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
                .multiply(1.0f / (float) this.vertices.size())
                .rotate(this.angle);

        Vector2D translate = position.subtract(center);

        this.vertices
                .stream()
                .map(vector2D -> vector2D.rotate(angle))
                .map(vector2D -> vector2D.add(translate))
                .forEach(vector2D -> polygon.addPoint((int) vector2D.x, (int) vector2D.y));

    }

    @Override
    public void render(Graphics graphics,Vector2D position) {
        graphics.setColor(Color.GREEN);
        this.updateTriangle(position);
        graphics.fillPolygon(this.polygon);
       // this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}
