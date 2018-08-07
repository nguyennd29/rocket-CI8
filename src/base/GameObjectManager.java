package base;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    static public GameObjectManager instance = new GameObjectManager();


    public List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList=new ArrayList<>();
    }

    public void runAll(){
        this.list.forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics){
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }


    public void add(GameObject gameObject){
        this.tempList.add(gameObject);
    }
}