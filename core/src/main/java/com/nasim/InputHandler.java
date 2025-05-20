package com.nasim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class InputHandler {
    private final FitViewport viewport;
    private final Bucket bucket;
    private final Vector2 touchPos = new Vector2();

    public InputHandler(FitViewport viewport, Bucket bucket) {
        this.viewport = viewport;
        this.bucket = bucket;
    }

    public void handleInput() {
        float delta = Gdx.graphics.getDeltaTime();
        final float speed = 4f;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            bucket.moveX(-speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            bucket.moveX(speed * delta);
        }

        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            viewport.unproject(touchPos);
            bucket.setCenterX(touchPos.x);
        }
    }
}
