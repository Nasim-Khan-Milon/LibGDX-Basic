package com.nasim;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main extends ApplicationAdapter {
    SpriteBatch spriteBatch;
    FitViewport viewport;



    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8, 5);

        AssetLoader.load();
        AssetLoader.music.setLooping(true);
        AssetLoader.music.setVolume(0.5f);
        AssetLoader.music.play();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        AssetLoader.dispose();
    }
}
