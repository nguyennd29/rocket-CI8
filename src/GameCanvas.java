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

    public Random rd = new Random();


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

        player = new Player();
        player.x[0] = 500;
        player.y[0] = 500;
        player.velocityX = 20;
        player.velocityY = 20;

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);

    }

    public void renderAll() {

        this.renderBackground();

        this.stars.forEach(star -> {
            star.render(graphics);
        });

        this.enemies.forEach(enemy -> {
            enemy.render(graphics);
        });

        this.player.render(graphics);

        this.repaint();

    }

    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    private BufferedImage loadImage(String path) {
        try {  //chong crash khi gap loi~
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }

    public void runAll() {
        this.playerMove();
        this.updatePlayer();
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run(player.x[0], player.y[0]));

//        if (this.positionXStar >= 1024) {
//            this.enemyReachBounderXFlag = 1;
//        }
//        if (this.positionXStar <= 0) {
//            this.enemyReachBounderXFlag = 0;
//        }
//        if (this.positionYStar >= 600) {
//            this.enemyReachBounderYFlag = 1;
//        }
//        if (this.positionYStar <= 0) {
//            this.enemyReachBounderYFlag = 0;
//        }
//
//        if (this.enemyReachBounderXFlag == 0)
//            this.positionXStar += 5;
//        else this.positionXStar -= 5;
//
//        if (this.enemyReachBounderYFlag == 0)
//            this.positionYStar += 7;
//        else this.positionYStar -= 7;
    }

    private void createStar() {
        if (this.timeIntervalStar == 40) {
            Star star = new Star();
            star.x = 1024;
            star.y = this.rd.nextInt(600);
            star.image = this.loadImage("resources/images/star.png");
            star.width = 20;
            star.height = 20;
            star.velocityX = this.rd.nextInt(3) + 1;
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            this.timeIntervalStar += 1;
        }
    }

    private void createEnemy() {
        if (this.timeIntervalEnemy == 70) {
            Enemies enemy = new Enemies();
            enemy.x = 1024;
            enemy.y = this.rd.nextInt(600);
            enemy.width = 30;
            enemy.height = 30;
            enemy.velocityX = this.rd.nextInt(5) + 1;
            enemy.velocityY = this.rd.nextInt(2) + 1;
            this.enemies.add(enemy);
            this.timeIntervalEnemy = 0;
        } else {
            this.timeIntervalEnemy += 1;
        }
    }

    public void playerMove() {
        if (this.player.x[0] > 1024) {
            this.player.x[0] = 0;
            // this.y[0] = this.rd.nextInt(601);
        }
        if (this.player.x[0] < 0) {
            this.player.x[0] = 1024;
            //  this.y[0] = this.rd.nextInt(601);
        }
        if (this.player.y[0] > 600) {
            this.player.y[0] = 0;
            //  this.x[0] = this.rd.nextInt(1025);
        }
        if (this.player.y[0] < 0) {
            this.player.y[0] = 600;
            // this.x[0] = this.rd.nextInt(1025);
        }
    }

    public void updatePlayer() {

        this.player.x[1] = this.player.x[0] + 10;
        this.player.y[1] = this.player.y[0];

        this.player.x[2] = this.player.x[0] + 5;
        this.player.y[2] = this.player.y[0] + 10;
    }


}
