package com.github.glomadrian.velocimeterlibrary.painter.inside;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.github.glomadrian.velocimeterlibrary.utils.DimensionUtils;

/**
 * @author Adrián García Lomas
 */
public class InsideVelocimeterPainterImp implements InsideVelocimeterPainter {

  private Context context;
  private Paint paint;
  private RectF circle;
  private int width;
  private int height;
  private float startAngle = 160;
  private float finishAngle = 222;
  private int color;
  private int strokeWidth;
  private int externalStrokeWidth;
  private int blurMargin;
  private int margin;

  public InsideVelocimeterPainterImp(int color, Context context) {
    this.context = context;
    this.color = color;
    initSize();
    initPainter();
  }

  private void initSize() {
    this.blurMargin = DimensionUtils.getSizeInPixels(15, context);
    this.externalStrokeWidth = DimensionUtils.getSizeInPixels(20, context);
    this.strokeWidth = DimensionUtils.getSizeInPixels(1, context);
    this.margin = DimensionUtils.getSizeInPixels(9, context);
  }

  private void initPainter() {
    paint = new Paint();
    paint.setAntiAlias(true);
    paint.setStrokeWidth(strokeWidth);
    paint.setColor(color);
    paint.setStyle(Paint.Style.STROKE);
  }

  private void initCircle() {
    int padding = externalStrokeWidth + margin + blurMargin;
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
