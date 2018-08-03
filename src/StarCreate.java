import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarCreate implements StarCreate_itf {
    Random rd = new Random();
    int timeIntervalStar = 0;
    List<Star> stars = new ArrayList<>();

    @Override
    public void create() {
        if (this.timeIntervalStar == 40) {
            Star star = new Star();
            star.position.set(1024, this.rd.nextInt(600));
            star.velocity.set(this.rd.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            this.timeIntervalStar += 1;
        }


    }
}
