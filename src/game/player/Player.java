package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.PolygonRenderer;

import java.awt.*;


public class Player extends GameObject {
    public Vector2D velocity;
    public PlayerShoot playerShoot;


    public double angle;
    public Player() {
        this.velocity = new Vector2D();
        this.playerShoot = new PlayerAttack();

        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8));


    }
    public void run() {
        super.run();
        this.position.addUp(velocity);
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.backToScreen();
        this.playerShoot.run(this);

    }


        private void backToScreen() {
        if (this.position.x > 1024) {
            this.position.x = 0;
            // this.y[0] = this.rd.nextInt(601);
        }
        if (this.position.x < 0) {
            this.position.x = 1024;
            //  this.y[0] = this.rd.nextInt(601);
        }
        if (this.position.y > 600) {
            this.position.y = 0;
            //  this.x[0] = this.rd.nextInt(1025);
        }
        if (this.position.y < 0) {
            this.position.y = 600;
            // this.x[0] = this.rd.nextInt(1025);
        }
    }
}

