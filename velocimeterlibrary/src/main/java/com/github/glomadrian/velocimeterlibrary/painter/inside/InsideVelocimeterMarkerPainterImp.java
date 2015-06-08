package com.github.glomadrian.velocimeterlibrary.painter.inside;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import com.github.glomadrian.velocimeterlibrary.utils.DimensionUtils;

/**
 * @author Adrián García Lomas
 */
public class InsideVelocimeterMarkerPainterImp implements InsideVelocimeterMarkerPainter {

  private Context context;
  private Paint paint;
  private RectF circle;
  private int width;
  private int height;
  private float startAngle = 160;
  private float finishAngle = 222;
  private int strokeWidth;
  private int externalStrokeWidth;
  private int blurMargin;
  private int margin;
  private int lineWidth;
  private int lineSpace;
  private int color;

  public InsideVelocimeterMarkerPainterImp(int color, Context context) {
    this.context = context;
    this.color = color;
    initSize();
    initPainter();
  }

  private void initSize() {
    this.blurMargin = DimensionUtils.getSizeInPixels(15, context);
    this.externalStrokeWidth = DimensionUtils.getSizeInPixels(20, context);
    this.strokeWidth = DimensionUtils.getSizeInPixels(12, context);
    this.margin = DimensionUtils.getSizeInPixels(9, context);
    this.lineSpace = DimensionUtils.getSizeInPixels(30, context);
    this.lineWidth = DimensionUtils.getSizeInPixels(2, context);
  }

  private void initPainter() {
    paint = new Paint();
    paint.setAntiAlias(true);
    paint.setStrokeWidth(strokeWidth);
    paint.setColor(color);
    paint.setStyle(Paint.Style.STROKE);
    paint.setPathEffect(new DashPathEffect(new float[] { lineWidth, lineSpace }, 0));
  }

  private void initCircle() {
    int pading = externalStrokeWidth + (strokeWidth / 2) + margin + blurMargin;
    circle = new RectF();
    circle.set(pading, pading, width - pading, height - pading);
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
