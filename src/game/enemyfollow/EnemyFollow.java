package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject {

    public Vector2D velocity;

    public EnemyFollow(){
        this.velocity=new Vector2D();
        this.renderer = new ImageRenderer("resources/images/powerup_time_slow.png",20,20);
    }
    @Override
    public void run() {
        super.run();
        update();
        this.position.addUp(this.velocity);
    }


    public void update(){
        Vector2D playerPosition = new Vector2D();
        playerPosition.set(GameObjectManager.instance.list.get(4).position);

      this.velocity.set(playerPosition.subtract(this.position).normalized().multiply(1.4f));
    }
}
