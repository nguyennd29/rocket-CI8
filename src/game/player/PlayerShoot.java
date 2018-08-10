package game.player;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;

public class PlayerShoot implements Attribute<Player> {


    private FrameCounter frameCounter;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(9);
    }

    @Override
    public void run(Player gameObject) {
        if(frameCounter.run()){
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(gameObject.velocity.copy()).multiply(2.5f);
            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();
        }

    }
}
