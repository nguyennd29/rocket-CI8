package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;

import java.awt.*;

public class Background extends GameObject {

    public  Background(){
        renderer=new BackgroundRenderer(Color.BLACK,1024,600);
    }

    @Override
    public void run() {
        super.run();
    }
}
