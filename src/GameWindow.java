import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        this.setSize(1024, 600);

        this.gameCanvas = new GameCanvas();
        this.add(gameCanvas);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    gameCanvas.positionXPlayer-=10;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    gameCanvas.positionXPlayer+=10;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    gameCanvas.positionYPlayer-=10;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    gameCanvas.positionYPlayer+=10;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        this.setVisible(true);

    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                Random rd = new Random();
                if(this.gameCanvas.positionXPlayer>1024) {
                    this.gameCanvas.positionXPlayer=0;
                    this.gameCanvas.positionYPlayer = rd.nextInt(601);
                }
                if(this.gameCanvas.positionXPlayer<0) {
                    this.gameCanvas.positionXPlayer=1024;
                    this.gameCanvas.positionYPlayer = rd.nextInt(601);
                }
                if(this.gameCanvas.positionYPlayer>600) {
                    this.gameCanvas.positionYPlayer=0;
                    this.gameCanvas.positionXPlayer = rd.nextInt(1025);
                }
                if(this.gameCanvas.positionYPlayer<0) {
                    this.gameCanvas.positionYPlayer=600;
                    this.gameCanvas.positionXPlayer = rd.nextInt(1025);
                }



                if(this.gameCanvas.positionXStar>=1024) {
                    this.gameCanvas.enemyReachBounderXFlag=1;
                }
                if(this.gameCanvas.positionXStar<=0) {
                    this.gameCanvas.enemyReachBounderXFlag=0;
                }
                if(this.gameCanvas.positionYStar>=600) {
                    this.gameCanvas.enemyReachBounderYFlag=1;
                }
                if(this.gameCanvas.positionYStar<=0) {
                    this.gameCanvas.enemyReachBounderYFlag=0;
                }

                if(this.gameCanvas.enemyReachBounderXFlag==0)
                    this.gameCanvas.positionXStar+=5;
                else this.gameCanvas.positionXStar-=5;

                if(this.gameCanvas.enemyReachBounderYFlag==0)
                    this.gameCanvas.positionYStar+=7;
                else this.gameCanvas.positionYStar-=7;

                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
