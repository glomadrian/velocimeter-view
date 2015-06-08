package com.github.glomadrian.velocimeterlibrary.painter.bottom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.github.glomadrian.velocimeterlibrary.utils.DimensionUtils;

/**
 * @author Adrián García Lomas
 */
public class BottomVelocimeterPainterImp implements BottomVelocimeterPainter {

  private Paint paint;
  private RectF circle;
  private Context context;
  private int width;
  private int height;
  private float startAngle = 30.5f;
  private float finishAngle = 120;
  private int strokeWidth;
  private int blurMargin;
  private int color;

  public BottomVelocimeterPainterImp(int color, int margin, Context context) {
    this.blurMargin = margin;
    this.context = context;
    this.color = color;
    initSize();
    initPainter();
  }

  private void initSize() {
    this.strokeWidth = DimensionUtils.getSizeInPixels(20, context);
  }

  private void initPainter() {
    paint = new Paint();
    paint.setAntiAlias(true);
    paint.setStrokeWidth(strokeWidth);
    paint.setColor(color);
    paint.setStyle(Paint.Style.STROKE);
  }

  private void initCircle() {
    int padding = strokeWidth / 2 + blurMargin;
    circle = new RectF();
    circle.set(padding, padding, width - padding, height - padding);
  }

  @Override public void draw(Canvas canvas) {
    canvas.drawArc(circle, startAngle, finishAngle, false, paint);
  }

  @Override public void setColor(int color) {
    this.color = color;
  }

  @Override public int getColor() {
    return color;
  }

  @Override public void onSizeChanged(int height, int width) {
    this.width = width;
    this.height = height;
    initCircle();
  }
}
