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

    private List<Star> stars;
    private List<Enemies> enemies;
    private BufferedImage backBuffered;
    public Player player;
    private Graphics graphics;
    private int timeIntervalStar = 0;
    private int timeIntervalEnemy = 0;
    private Background background;
    private EnemyFollow enemyFollow;
    public Random rd = new Random();


    public GameCanvas() {
        this.setSize(1024, 600);

        setupBackBuffered();
        setupBackground();
        setupCharacter();


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
        this.setupStar();
        this.setupPlayer();
        this.setupEnemy();
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    private void setupEnemy() {
        this.enemies = new ArrayList<>();
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

        this.stars.forEach(star -> {
            star.render(graphics);
        });
        this.player.render(graphics);

        this.enemies.forEach(enemy -> {
            enemy.render(graphics);
        });



        this.repaint();

    }





    public void runAll() {

        this.player.run();
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run(player.position));

    }

    private void createStar() {
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

    private void createEnemy() {
        if (this.timeIntervalEnemy == 170) {
            Enemies enemy = new Enemies();

            enemy.position.set(1024,this.rd.nextInt(600));
            enemy.width = 30;
            enemy.height = 30;
            enemy.velocity.set(this.rd.nextInt(5) + 1,this.rd.nextInt(2)+1);
            this.enemies.add(enemy);
            this.timeIntervalEnemy = 0;
        } else {
            this.timeIntervalEnemy += 1;
        }
    }






}
