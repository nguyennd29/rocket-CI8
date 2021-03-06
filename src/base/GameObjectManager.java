package base;

import game.enemy.Enemies;
import game.enemyfollow.EnemyFollow;
import game.player.BulletPlayer;
import game.player.Player;
import game.star.Star;
import physic.BoxCollider;
import physic.PhysicBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    static public GameObjectManager instance = new GameObjectManager();


    public List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void runAll() {
        this.list.stream().filter(gameObject -> gameObject.isAlive).forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list.stream().filter(gameObject -> gameObject.isAlive).forEach(gameObject -> gameObject.render(graphics));
    }


    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public Player findPlayer() {
//        for (GameObject gameObject:this.list) {
//            if(gameObject instanceof Player)
//                return (Player)gameObject;
//        }

        return (Player) this.list.stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }

//    public GameObject checkCollisionKillEnemyFollow(GameObject bulletPlayer) {
//        return  this.list
//                .stream()
//                .filter(gameObject -> gameObject.isAlive)
//                .filter(gameObject -> gameObject instanceof EnemyFollow)
//                .filter(gameObject -> {
//                    BoxCollider other = ((EnemyFollow) gameObject).boxCollider;
//                    return ((BulletPlayer)bulletPlayer).boxCollider.checkCollision(other);
//                })
//                .findFirst()
//                .orElse(null);
//    }
//    public GameObject checkCollisionKillEnemy(GameObject bulletPlayer) {
//        return  this.list
//                .stream()
//                .filter(gameObject -> gameObject.isAlive)
//                .filter(gameObject -> gameObject instanceof Enemies)
//                .filter(gameObject -> {
//                    BoxCollider other = ((Enemies) gameObject).boxCollider;
//                    return ((BulletPlayer)bulletPlayer).boxCollider.checkCollision(other);
//                })
//                .findFirst()
//                .orElse(null);
//    }
//
//    public GameObject checkCollisionKillStar(GameObject bulletPlayer) {
//        return  this.list
//                .stream()
//                .filter(gameObject -> gameObject.isAlive)
//                .filter(gameObject -> gameObject instanceof Star)
//                .filter(gameObject -> {
//                    BoxCollider other = ((Star) gameObject).boxCollider;
//                    return ((BulletPlayer)bulletPlayer).boxCollider.checkCollision(other);
//                })
//                .findFirst()
//                .orElse(null);
//    }



    public <T extends GameObject & PhysicBody> T checkCollision(BoxCollider boxCollider, Class<T> cls){
        return (T) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> {
                    BoxCollider other =((T) gameObject).getBoxCollider();
                    return boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T recycle(Class<T> cls){
        T object = (T) this.list
                .stream()
                .filter(gameObject -> !gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .findFirst()
                .orElse(null);
        if (object !=null){
            object.isAlive = true;
            return object;
        }else {
            try {
                object = cls.newInstance();
                this.add(object);
                return object;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
