package com.nasim;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bucket {
    private final Sprite sprite;

    public Bucket() {
        sprite = new Sprite(AssetLoader.bucket);
        sprite.setSize(1, 1);
        sprite.setPosition(3.5f, 0); // Center-ish starting position
    }

    public Sprite getSprite() {
        return sprite;
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
