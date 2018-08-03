import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameCanvas extends JPanel {


    private BufferedImage backBuffered;
    public Player player;
    private Graphics graphics;
    private Background background;

    private EnemyFollowCreate_itf enemyFollowCreate;
    private EnemyCreate_itf enemyCreate;
    private StarCreate_itf starCreate;

    public Random rd = new Random();


    public GameCanvas() {
        this.setSize(1024, 600);

        setupBackBuffered();
        setupBackground();
        setupCharacter();

        enemyCreate = new EnemyCreate();
        enemyFollowCreate=new EnemyFollowCreate();
        starCreate=new StarCreate();

        this.setVisible(true);
    }
    private void setupBackground(){
        this.background = new Background();
    }
    private void setupBackBuffered() {

        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        //this.setupStar();
        this.setupPlayer();
        //this.setupEnemy();
       // this.setupEnemyFollow();
    }


    private void setupPlayer() {

        this.player = new Player();
        this.player.position.set(200,300);
        this.player.velocity.set(6.5f,0);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);

    }

    public void renderAll() {

        this.background.render(graphics);

        ((StarCreate)starCreate).stars.forEach(star -> {
            star.render(graphics);
        });
        this.player.render(graphics);

        ((EnemyCreate)this.enemyCreate).enemies.forEach(enemy -> {
            enemy.render(graphics);
        });

        ((EnemyFollowCreate)this.enemyFollowCreate).enemyFollows.forEach(
                enemyFollow -> enemyFollow.render(graphics));


        this.repaint();

    }





    public void runAll() {

        this.player.run();
        this.starCreate.create();
        ((StarCreate)starCreate).stars.forEach(star -> star.run());
        this.enemyCreate.create();
        ((EnemyCreate)this.enemyCreate).enemies.forEach(enemy -> enemy.run(player.position));

        this.enemyFollowCreate.create();
        ((EnemyFollowCreate)this.enemyFollowCreate).enemyFollows.forEach(enemyFollow -> {
            enemyFollow.update(player.position);
            enemyFollow.run();
        });

    }










}
