package game.player;

import base.Attribute;
import base.Vector2D;
import input.KeyboardInput;

import java.util.Random;

public class PlayerMove implements Attribute<Player> {
//    private Random random = new Random();
    private Vector2D defaultVelocity = new Vector2D(3.5f, 0);

    private void backToScreen(Vector2D position) {
        if (position.x > 1024) {
            position.x = 0;
            // this.y[0] = this.rd.nextInt(601);
        }
        if (position.x < 0) {
            position.x = 1024;
            //  this.y[0] = this.rd.nextInt(601);
        }
        if (position.y > 600) {
            position.y = 0;
            //  this.x[0] = this.rd.nextInt(1025);
        }
        if (position.y < 0) {
            position.y = 600;
            // this.x[0] = this.rd.nextInt(1025);
        }
    }

    @Override
    public void run(Player gameObject) {
        Vector2D velocity = this.defaultVelocity.copy();

        if (KeyboardInput.instance.isLeft) {
            gameObject.angle -= 4.0;
        }
        if (KeyboardInput.instance.isRight) {
            gameObject.angle += 4.0;
        }
        if (KeyboardInput.instance.isUp) {
            velocity = this.defaultVelocity.copy().multiply(2.0f);
        }

        gameObject.velocity.set(
                velocity.rotate(gameObject.angle)
        );

        gameObject.position.addUp(gameObject.velocity);

        this.backToScreen(gameObject.position);
    }

}
