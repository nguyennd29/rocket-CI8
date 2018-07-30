import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Enemies {


    public int width;
    public int height;

    public Vector2D position;
    public Vector2D velocity;

    public int timeIntervalBullet;
    public int bulletAngle=0;
    private List<BulletEnemy> bulletEnemies;

    public Enemies(){
        this.bulletEnemies = new ArrayList<>();
        this.position = new Vector2D();
        this.velocity = new Vector2D();
    }

    public void run(Vector2D playerPosition) {
        this.velocity.x = (float)(2 * ((playerPosition.x - this.position.x) / Math.sqrt((playerPosition.x - this.position.x) * (playerPosition.x - this.position.x) + (playerPosition.y - this.position.y) * (playerPosition.y - this.position.y))));
        this.velocity.y = (float)(2 * ((playerPosition.y - this.position.y) / Math.sqrt((playerPosition.x - this.position.x) * (playerPosition.x - this.position.x) + (playerPosition.y - this.position.y) * (playerPosition.y - this.position.y))));

        this.position.addUp(velocity);
        this.shoot();
    }

    private void shoot() {
        if (this.timeIntervalBullet == 2) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            try {
                bulletEnemy.image = ImageIO.read(new File("resources/images/circle.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bulletEnemy.position.set(this.position);
            bulletEnemy.velocity.set(new Vector2D(4,0).rotate(bulletAngle));
            this.bulletEnemies.add(bulletEnemy);
            this.timeIntervalBullet = 0;
        } else {
            this.timeIntervalBullet += 1;
            this.bulletAngle+=10;
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillOval((int)this.position.x, (int)this.position.y, this.width, this.height);

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }

}
