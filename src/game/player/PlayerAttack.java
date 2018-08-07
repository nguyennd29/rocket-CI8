package game.player;

import base.FrameCounter;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;

public class PlayerAttack implements PlayerShoot{


    private FrameCounter frameCounter;

    public PlayerAttack() {
        this.frameCounter = new FrameCounter(9);
    }

    @Override
    public void run(Player player) {
        if(frameCounter.run()){
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy()).multiply(2.5f);
            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();
        }

       // this.gameObjectManager.forEach(bulletPlayer -> bulletPlayer.run());
    }
}
