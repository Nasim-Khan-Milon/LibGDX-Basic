package com.nasim;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Droplet {
    private final Sprite sprite;
    private final Rectangle bounds;

    public Droplet(float x, float y) {
        sprite = new Sprite(AssetLoader.droplet);
        sprite.setSize(1.5f, 1.5f);
        sprite.setPosition(x, y);
        bounds = new Rectangle();
    }

    public void update(float delta) {
        sprite.translateY(-2f * delta);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Rectangle getBounds() {
        bounds.set(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        return bounds;
    }

    public boolean isOffScreen() {
        return sprite.getY() + sprite.getHeight() < 0;
    }
}
