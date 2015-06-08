package com.github.glomadrian.velocimeterlibrary.painter.needle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.glomadrian.velocimeterlibrary.utils.DimensionUtils;

/**
 * @author Adrián García Lomas
 */
public class NeedlePainterImp implements NeedlePainter {
  protected Paint paint;
  private Context context;
  private int color;
  private int width;
  private int height;
  private int centerX;
  private int centerY;
  private int margin;
  private int startAngle = 160;
  private int radius;
  private float plusAngle = 0;
  private float max;
  private int strokeWidth;
  private float maxAngle = 222f;

  public NeedlePainterImp(int color, float max, Context context) {
    this.color = color;
    this.max = max;
    this.context = context;
    init();
  }

  public NeedlePainterImp(int color, float max, Context context, int startAngle,
      int maxAngle) {
    this.color = color;
    this.max = max;
    this.context = context;
    this.startAngle = startAngle;
    this.maxAngle = maxAngle;
    init();
  }

  private void init() {
    initSize();
    initPainter();
  }

  private void initSize() {
    radius = DimensionUtils.getSizeInPixels(40, context);
    margin = DimensionUtils.getSizeInPixels(15, context);
    strokeWidth = DimensionUtils.getSizeInPixels(2, context);
  }

  private void initPainter() {
    paint = new Paint();
    paint.setColor(color);
    paint.setStrokeWidth(strokeWidth);
  }

  @Override public void draw(Canvas canvas) {
    radius = ((width / 3) / 3) * 2;
    float toX = width / 2 + (float) Math.cos(Math.toRadians(plusAngle + startAngle)) * (radius);
    float toY = width / 2 + (float) Math.sin(Math.toRadians(plusAngle + startAngle)) * (radius);
    canvas.drawLine(centerX, centerY + margin, toX, toY, paint);
  }

  @Override public void setColor(int color) {
    this.color = color;
  }

  @Override public int getColor() {
    return color;
  }

  @Override public void onSizeChanged(int height, int width) {
    this.height = height;
    this.width = width;
    centerX = width / 2;
    centerY = height / 2;
  }

  //TODO remove magic string
  public void setValue(float value) {
    this.plusAngle = (maxAngle * value) / max;
  }
}
