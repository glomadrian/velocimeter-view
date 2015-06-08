package com.github.glomadrian.velocimeterlibrary.painter;

import android.graphics.Canvas;

/**
 * Painter delegate the onDraw method in canvas to draw method here, each painter paints something
 * of the view
 *
 * @author Adrián García Lomas
 */
public interface Painter {

    void draw(Canvas canvas);

    void setColor(int color);

    int getColor();

    void onSizeChanged(int height, int width);
}
