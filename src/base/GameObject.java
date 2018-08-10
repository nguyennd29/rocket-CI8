package base;

import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
    public Vector2D position;

    public Renderer renderer;

    public boolean isAlive;

    public List<Attribute> attributes;

    public GameObject() {
        this.position = new Vector2D();
        this.attributes=new ArrayList<>();
        this.isAlive=true;
    }
    public void render(Graphics graphics){
        if(this.renderer != null)
            this.renderer.render(graphics,this.position);
    }
    public void run(){
        this.attributes.forEach(attribute -> attribute.run(this));
    }
}
