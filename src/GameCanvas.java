import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameCanvas extends JPanel {

    private BufferedImage starImage;
    private BufferedImage playerImage;
    private BufferedImage backBuffered;
    public int positionXStar = 1024;
    public int positionYStar = 200;

    public int positionXStarRandom = 1024;
    public int positionYStarRandom = 300;

    public int positionXPlayer = 600;
    public int positionYPlayer = 200;

    public int enemyReachBounderXFlag =0;
    public int enemyReachBounderYFlag =0;
    private Graphics graphics;
    public GameCanvas() {
        this.setSize(1024, 600);

        this.backBuffered = new BufferedImage(1024,600,BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
        //load anh
        try {  //chong crash khi gap loi~
            this.starImage = ImageIO.read(new File("resources/images/star.png"));
        } catch (IOException e) {

        }

        try {  //chong crash khi gap loi~
            this.playerImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {

        }



        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);

        }

    public void renderAll(){

        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0,0,1024,600);
        this.graphics.drawImage(this.starImage,this.positionXStar,this.positionYStar,10,10,null);
        this.graphics.drawImage(this.playerImage,this.positionXPlayer,this.positionYPlayer,20,20,null);

        this.repaint();

    }
}
