package game.star;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class Star extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public Star(){
        this.velocity=new Vector2D();
        this.boxCollider=new BoxCollider(50,50);
        this.renderer = new ImageRenderer("resources/images/star.png",50,50);
    }
    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x-25,this.position.y-25);
        this.position.subtractBy(this.velocity);
    }


}
