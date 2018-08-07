package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EnemyCreate extends GameObject {
    public Random rd;
    public FrameCounter frameCounter;


    public EnemyCreate() {
        this.rd = new Random();
        this.frameCounter = new FrameCounter(600);

    }


    public void run() {

        if (frameCounter.run()) {
            Enemies enemy = new Enemies();

            enemy.position.set(1024, this.rd.nextInt(600));

            enemy.velocity.set(this.rd.nextInt(5) + 1, this.rd.nextInt(2) + 1);
            GameObjectManager.instance.add(enemy);
            frameCounter.reset();
        }


    }
}
