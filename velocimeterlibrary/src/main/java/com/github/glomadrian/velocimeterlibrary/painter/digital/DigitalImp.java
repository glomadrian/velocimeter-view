package com.github.glomadrian.velocimeterlibrary.painter.digital;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.github.glomadrian.velocimeterlibrary.utils.DimensionUtils;

/**
 * @author Adrián García Lomas
 */
public class DigitalImp implements Digital {

  private float value;
  private Typeface typeface;
  protected Paint digitPaint;
  protected Paint textPaint;
  private Context context;
  private float textSize;
  private int marginTop;
  private int color;
  private float centerX;
  private float centerY;
  private float correction;
  private String units;

  public DigitalImp(int color, Context context, int marginTop, int textSize, String units) {
    this.context = context;
    this.color = color;
    this.marginTop = marginTop;
    this.textSize = textSize;
    this.units = units;
    initTypeFace();
    initPainter();
    initValues();
  }

  private void initPainter() {
    digitPaint = new Paint();
    digitPaint.setAntiAlias(true);
    digitPaint.setTextSize(textSize);
    digitPaint.setColor(color);
    digitPaint.setTypeface(typeface);
    digitPaint.setTextAlign(Paint.Align.CENTER);
    textPaint = new TextPaint();
    textPaint.setAntiAlias(true);
    textPaint.setTextSize(textSize / 3);
    textPaint.setColor(color);
    textPaint.setTypeface(typeface);
    textPaint.setTextAlign(Paint.Align.CENTER);
  }

  private void initValues() {
    correction = DimensionUtils.getSizeInPixels(10, context);
  }

  private void initTypeFace() {
    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/digit.TTF");
  }

  @Override public void setValue(float value) {
    this.value = value;
  }

  @Override public void draw(Canvas canvas) {
    canvas.drawText(String.format("%.0f", value), centerX - correction, (centerY) + marginTop,
        digitPaint);
    canvas.drawText(units, centerX + textSize * 1.2f - correction, (centerY) + marginTop,
        textPaint);
  }

  @Override public void setColor(int color) {
    this.color = color;
  }

  @Override public int getColor() {
    return this.color;
  }

  @Override public void onSizeChanged(int height, int width) {
    this.centerX = width / 2;
    this.centerY = height / 2;
  }
}
