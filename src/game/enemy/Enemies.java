package game.enemy;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;




public class Enemies extends GameObject {

//    public int width;
//    public int height;

    public Vector2D velocity;

    public EnemyShoot enemyShoot;

    public Enemies() {

        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyAttack();
        renderer = new ImageRenderer("resources/images/powerup_shield.png", 30, 30);

    }

    @Override
    public void run() {
        super.run();
        // this.velocity.x = (float)(2 * ((playerPosition.x - this.position.x) / Math.sqrt((playerPosition.x - this.position.x) * (playerPosition.x - this.position.x) + (playerPosition.y - this.position.y) * (playerPosition.y - this.position.y))));
        //   this.velocity.y = (float)(2 * ((playerPosition.y - this.position.y) / Math.sqrt((playerPosition.x - this.position.x) * (playerPosition.x - this.position.x) + (playerPosition.y - this.position.y) * (playerPosition.y - this.position.y))));
        this.velocity.set(-1, 0);
        this.position.addUp(velocity);
        this.enemyShoot.run(this);
    }
}



