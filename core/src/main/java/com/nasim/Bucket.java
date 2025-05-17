package com.nasim;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Bucket {
    private final Sprite sprite;
    private final Rectangle bounds;

    public Bucket() {
        sprite = new Sprite(AssetLoader.bucket);
        sprite.setSize(1, 1);
        sprite.setPosition(3.5f, 0); // Center-ish starting position
        bounds = new Rectangle();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Rectangle getBounds() {
        bounds.set(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        return bounds;
    }

    public void moveX(float amount) {
        sprite.translateX(amount);
    }

    public void setCenterX(float x) {
        sprite.setCenter(x, 0.5f);
    }

    public void clampPosition(float worldWidth) {
        float maxX = worldWidth - sprite.getWidth();
        if (sprite.getX() < 0) sprite.setX(0);
        if (sprite.getX() > maxX) sprite.setX(maxX);
    }
}
