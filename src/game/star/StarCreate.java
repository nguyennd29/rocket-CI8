package game.star;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class StarCreate extends GameObject {
    public Random rd;
    public FrameCounter frameCounter;


    public StarCreate() {
        this.rd = new Random();
        this.frameCounter = new FrameCounter(100);

    }

    public void run() {
        if (this.frameCounter.run()) {
            Star star = new Star();
            star.position.set(1024, this.rd.nextInt(600));
            star.velocity.set(this.rd.nextInt(3) + 1, 0);
            GameObjectManager.instance.add(star);
            this.frameCounter.reset();
        }



    }
}
