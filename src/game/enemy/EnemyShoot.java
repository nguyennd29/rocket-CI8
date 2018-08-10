package game.enemy;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;


public class EnemyShoot implements Attribute<Enemies> {

    public FrameCounter frameCounter;

    public EnemyShoot() {

        this.frameCounter = new FrameCounter(100);
    }

    @Override
    public void run(Enemies enemy) {
        if (this.frameCounter.run()) {
            for (double angle = 0.0; angle < 360; angle += 360 / 30) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(new Vector2D(4, 0).rotate(angle));
                GameObjectManager.instance.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }
    }
}

