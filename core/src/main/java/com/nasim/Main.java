package com.nasim;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main extends Game {
    SpriteBatch spriteBatch;
    FitViewport viewport;

    GameWorld gameWorld;
    InputHandler inputHandler;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(16, 10);

        AssetLoader.load();
        AssetLoader.music.setLooping(true);
        AssetLoader.music.setVolume(0.5f);
        AssetLoader.music.play();

        Bucket bucket = new Bucket();
        gameWorld = new GameWorld(viewport, bucket);
        inputHandler = new InputHandler(viewport, bucket);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        inputHandler.handleInput();
        gameWorld.update();
        gameWorld.draw(spriteBatch);
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        AssetLoader.dispose();
    }
}
