package com.nasim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
    public static Texture background;
    public static Texture bucket;
    public static Texture droplet;
    public static Sound dropSound;
    public static Music music;

    public static void load() {
        background = new Texture("background.png");
        bucket = new Texture("bucket.png");
        droplet = new Texture("drop.png");
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
    }

    public static void dispose() {
        background.dispose();
        bucket.dispose();
        droplet.dispose();
        dropSound.dispose();
        music.dispose();
    }
}
