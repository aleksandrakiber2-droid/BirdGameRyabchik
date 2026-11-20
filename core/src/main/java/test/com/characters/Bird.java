package test.com.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import test.com.MyGdxGame;

public class Bird {

    int x, y;
    int width, height;

    int speed;
    int jumpHeight;
    final int maxHeightOfJump = 200;
    boolean jump;

    int frameCounter;
    Texture[] framesArray;

    public Bird(int x, int y, int speed, int width, int height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
        frameCounter = 0;

        framesArray = new Texture[]{
            new Texture("bird0.png"),
            new Texture("bird1.png"),
            new Texture("bird2.png"),
            new Texture("bird1.png"),
        };
    }

    public void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }

    public void fly() {
        if (y >= jumpHeight) {
            jump = false;
        }

        if (jump) {
            y += speed;
        } else {
            y -= speed;
        }

        if (y < -height)
            y = -height;

    }

    public void draw(Batch batch) {
        int frameMultiplier = 10;
        batch.draw(framesArray[frameCounter / frameMultiplier], x, y, width, height);
        if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter = 0;
    }

    public boolean isInField() {
        return y > 0 && y + height < MyGdxGame.SCR_HEIGHT;
    }

    public void dispose() {
        for (Texture texture : framesArray) {
            texture.dispose();
        }
    }

}
