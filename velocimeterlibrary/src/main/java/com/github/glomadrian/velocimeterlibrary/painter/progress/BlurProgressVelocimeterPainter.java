package com.github.glomadrian.velocimeterlibrary.painter.progress;

import android.content.Context;
import android.graphics.BlurMaskFilter;

/**
 * @author Adrián García Lomas
 */
public class BlurProgressVelocimeterPainter extends ProgressVelocimeterPainterImp {

  public BlurProgressVelocimeterPainter(int color, float max, int margin, Context context) {
    super(color, max, margin, context);
    paint.setMaskFilter(new BlurMaskFilter(45, BlurMaskFilter.Blur.NORMAL));
  }
}
