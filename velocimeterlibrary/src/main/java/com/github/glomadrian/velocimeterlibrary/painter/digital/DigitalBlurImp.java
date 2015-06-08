package com.github.glomadrian.velocimeterlibrary.painter.digital;

import android.content.Context;
import android.graphics.BlurMaskFilter;

/**
 * @author Adrián García Lomas
 */
public class DigitalBlurImp extends DigitalImp {

  public DigitalBlurImp(int color, Context context, int marginTop, int textSize, String units) {
    super(color, context, marginTop, textSize, units);
    digitPaint.setMaskFilter(new BlurMaskFilter(6, BlurMaskFilter.Blur.NORMAL));
  }
}
