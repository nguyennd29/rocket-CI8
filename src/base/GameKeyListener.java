package base;

import game.player.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ((Player) (GameObjectManager.instance.list.get(4))).angle -= 20.0;

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ((Player) (GameObjectManager.instance.list.get(4))).angle += 20.0;
        }

        ((Player) (GameObjectManager.instance.list.get(4))).velocity.set(new Vector2D(2.5f, 0).rotate(((Player) (GameObjectManager.instance.list.get(4))).angle));


        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //  gameCanvas.player.y[0] -= gameCanvas.player.velocityY;
            ((Player) (GameObjectManager.instance.list.get(4))).velocity.multiply(3.0f);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            // gameCanvas.player.y[0] += gameCanvas.player.velocityY;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ((Player) (GameObjectManager.instance.list.get(4))).velocity.multiply(1/3.0f);
        }
    }
}
