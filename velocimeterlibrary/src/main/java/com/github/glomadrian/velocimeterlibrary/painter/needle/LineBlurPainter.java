package com.github.glomadrian.velocimeterlibrary.painter.needle;

import android.content.Context;
import android.graphics.BlurMaskFilter;

/**
 * @author Adrián García Lomas
 */
public class LineBlurPainter extends NeedlePainterImp {

  public LineBlurPainter(int color, float max, Context context) {
    super(color, max, context);
    paint.setMaskFilter(new BlurMaskFilter(25, BlurMaskFilter.Blur.NORMAL));
  }
}
