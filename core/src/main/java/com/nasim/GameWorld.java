package com.nasim;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameWorld {
    private final FitViewport viewport;
    private final Bucket bucket;
    private final Array<Droplet> droplets;
    private float dropTimer = 0f;

    public GameWorld(FitViewport viewport, Bucket bucket) {
        this.viewport = viewport;
        this.bucket = bucket;
        this.droplets = new Array<>();
    }

    public void update() {
        float delta = com.badlogic.gdx.Gdx.graphics.getDeltaTime();

        bucket.clampPosition(viewport.getWorldWidth());

        for (int i = droplets.size - 1; i >= 0; i--) {
            Droplet drop = droplets.get(i);
            drop.update(delta);

            if (drop.isOffScreen()) {
                droplets.removeIndex(i);
            } else if (drop.getBounds().overlaps(bucket.getBounds())) {
                droplets.removeIndex(i);
                AssetLoader.dropSound.play();
            }
        }

        dropTimer += delta;
        if (dropTimer > 1f) {
            dropTimer = 0;
            spawnDroplet();
        }
    }

    public void draw(SpriteBatch batch) {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(AssetLoader.background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        bucket.getSprite().draw(batch);

        for (Droplet drop : droplets) {
            drop.getSprite().draw(batch);
        }

        batch.end();
    }

    private void spawnDroplet() {
        float worldWidth = viewport.getWorldWidth();
        float x = MathUtils.random(0f, worldWidth - 1);
        float y = viewport.getWorldHeight();
        droplets.add(new Droplet(x, y));
    }
}
