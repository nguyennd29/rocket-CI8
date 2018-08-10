package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public EnemyFollow(){
        this.velocity=new Vector2D();
        this.renderer = new ImageRenderer("resources/images/powerup_time_slow.png",40,40);
       this.boxCollider =new BoxCollider(40,40);
    }
    @Override
    public void run() {
        super.run();
        update();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x-20,this.position.y-20);
    }


    public void update(){

      this.velocity.set(GameObjectManager.instance.findPlayer().position.subtract(this.position).normalized().multiply(1.4f));
    }
}
