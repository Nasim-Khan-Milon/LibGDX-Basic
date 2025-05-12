package com.nasim;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameWorld {
    private final FitViewport viewport;

    public GameWorld(FitViewport viewport) {
        this.viewport = viewport;
    }

    public void update() {
        
    }

    public void draw(SpriteBatch batch) {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(AssetLoader.background, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());


        batch.end();
    }
}
