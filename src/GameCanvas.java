import base.GameObjectManager;
import game.background.Background;
import game.enemy.EnemyCreate;
import game.enemyfollow.EnemyFollowCreate;
import game.player.Player;
import game.star.StarCreate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameCanvas extends JPanel {


    private BufferedImage backBuffered;
    public Player player;
    private Graphics graphics;

    public GameCanvas() {
        this.setSize(1024, 600);

        setupBackBuffered();

        setupCharacter();


        this.setVisible(true);
    }

    private void setupBackBuffered() {

        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new StarCreate());
        GameObjectManager.instance.add(new EnemyFollowCreate());
        GameObjectManager.instance.add(new EnemyCreate());

        this.setupPlayer();

    }


    private void setupPlayer() {

        this.player = new Player();
        this.player.position.set(200, 300);
        this.player.velocity.set(2.5f, 0);
        GameObjectManager.instance.add(player);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);

    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();

    }

    public void runAll() {

        GameObjectManager.instance.runAll();
    }


}
