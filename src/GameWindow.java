import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        this.setSize(1024, 600);

        this.setupGameCanvas();

        this.event();

        this.setVisible(true);


    }


    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();

        this.add(gameCanvas);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();

    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.x[0] -= gameCanvas.player.velocityX;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.x[0] += gameCanvas.player.velocityX;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    gameCanvas.player.y[0] -= gameCanvas.player.velocityY;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameCanvas.player.y[0] += gameCanvas.player.velocityY;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();

                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
