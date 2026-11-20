package test.com.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import test.com.MyGdxGame;

public class MovingBackground {
    Texture texture;
    int x;
    public MovingBackground() {
        this.x = 0;
        texture = new Texture("game_bg.png");

    }

    public void draw(Batch batch) {
        batch.draw(texture, x,0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        batch.draw(texture, x +MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
    }

    public void move(){
        x -= 1;
        if (x < -MyGdxGame.SCR_WIDTH) {
            x = 0;
        }

    }

    void dispose() {
        texture.dispose();
    }
}
