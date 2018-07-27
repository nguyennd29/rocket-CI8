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
    private BufferedImage playerImage;
    private BufferedImage backBuffered;

    public int positionXPlayer = 600;
    public int positionYPlayer = 200;

//    public int enemyReachBounderXFlag = 0;
//    public int enemyReachBounderYFlag = 0;
    private Graphics graphics;

    private int timeIntervalStar = 0;

    Random rd = new Random();

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
        // this.starImage = this.loadImage("resources/images/star.png");
        this.setupStar();
        this.playerImage = this.loadImage("resources/images/circle.png");

    }

    private void setupStar() {
        this.stars = new ArrayList<>();


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
        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 20, 20, null);

        this.repaint();

    }

    public void runAll() {
        this.createStar();
        this.playerMove();
        this.stars.forEach(star -> star.run());

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
        if (this.timeIntervalStar == 30) {
            Star star = new Star();
            star.x = 1024;
            star.y = this.rd.nextInt(600);
            star.image = this.loadImage("resources/images/star.png");
            star.width = 5;
            star.height = 5;
            star.velocityX = this.rd.nextInt(3) + 1;
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            this.timeIntervalStar += 1;
        }
    }

    private void playerMove() {
        if (this.positionXPlayer > 1024) {
            this.positionXPlayer = 0;
            this.positionYPlayer = this.rd.nextInt(601);
        }
        if (this.positionXPlayer < 0) {
            this.positionXPlayer = 1024;
            this.positionYPlayer = this.rd.nextInt(601);
        }
        if (this.positionYPlayer > 600) {
            this.positionYPlayer = 0;
            this.positionXPlayer = this.rd.nextInt(1025);
        }
        if (this.positionYPlayer < 0) {
            this.positionYPlayer = 600;
            this.positionXPlayer = this.rd.nextInt(1025);
        }
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
}
