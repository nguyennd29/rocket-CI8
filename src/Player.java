import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Player {
    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;
    public PlayerShoot playerShoot;


    public double angle;
    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.playerShoot = new PlayerAttack();

        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8));


    }
    public void run(){
        this.position.addUp(velocity);
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.backToScreen();
        this.playerShoot.run(this);

    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics,this.position);
        ((PlayerAttack)this.playerShoot).bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));

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

