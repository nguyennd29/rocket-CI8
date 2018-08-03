import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyCreate implements EnemyCreate_itf {
    Random rd = new Random();
    int timeIntervalEnemy=0;
    List<Enemies> enemies=new ArrayList<>();

    @Override
    public void create() {

        if (timeIntervalEnemy >= 400) {
            Enemies enemy = new Enemies();

            enemy.position.set(1024, this.rd.nextInt(600));

            enemy.velocity.set(this.rd.nextInt(5) + 1, this.rd.nextInt(2) + 1);
            enemies.add(enemy);
            timeIntervalEnemy = 0;
        } else {
            timeIntervalEnemy += 1;
        }

    }
}
