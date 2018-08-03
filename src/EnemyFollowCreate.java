import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyFollowCreate implements EnemyFollowCreate_itf {
    Random rd = new Random();
    int timeIntervalEnemyFollow;
    List<EnemyFollow> enemyFollows = new ArrayList<>();

    @Override
    public void create() {

        if (this.timeIntervalEnemyFollow == 300) {
            EnemyFollow enemyFollow = new EnemyFollow();

            enemyFollow.position.set(1024, this.rd.nextInt(600));

            enemyFollow.velocity.set(this.rd.nextInt(5) + 1, this.rd.nextInt(2) + 1);
            this.enemyFollows.add(enemyFollow);
            this.timeIntervalEnemyFollow = 0;
        } else {
            this.timeIntervalEnemyFollow += 1;
        }


    }
}
