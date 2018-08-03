import java.util.ArrayList;
import java.util.List;

public class EnemyAttack implements EnemyShoot {

    public int timeIntervalBullet=0;

    public List<BulletEnemy> bulletEnemies=new ArrayList<>();

    @Override
    public void run(Enemies enemy) {
        if (this.timeIntervalBullet == 100) {
            for (double angle = 0.0; angle < 360; angle += 360 / 50) {
                BulletEnemy bulletEnemy = new BulletEnemy();

                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(new Vector2D(2, 0).rotate(angle));
                this.bulletEnemies.add(bulletEnemy);
            }
            this.timeIntervalBullet = 0;
        } else {
            this.timeIntervalBullet += 1;

        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }
}

