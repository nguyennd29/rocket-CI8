import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Enemies {

//    public int width;
//    public int height;

    public Vector2D position;
    public Vector2D velocity;

    public EnemyShoot enemyShoot;
    public Renderer renderer;

    public Enemies(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyAttack();
        renderer=new ImageRenderer("resources/images/powerup_shield.png",30,30);

    }

    public void run(Vector2D playerPosition) {
       // this.velocity.x = (float)(2 * ((playerPosition.x - this.position.x) / Math.sqrt((playerPosition.x - this.position.x) * (playerPosition.x - this.position.x) + (playerPosition.y - this.position.y) * (playerPosition.y - this.position.y))));
     //   this.velocity.y = (float)(2 * ((playerPosition.y - this.position.y) / Math.sqrt((playerPosition.x - this.position.x) * (playerPosition.x - this.position.x) + (playerPosition.y - this.position.y) * (playerPosition.y - this.position.y))));
        this.velocity.set(-1,0);
        this.position.addUp(velocity);
        this.enemyShoot.run(this);
    }



    public void render(Graphics graphics) {
//        graphics.setColor(Color.RED);
//        graphics.fillOval((int)this.position.x-width/2, (int)this.position.y-height/2, this.width, this.height);
        this.renderer.render(graphics,position);
        ((EnemyAttack)this.enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }

}
