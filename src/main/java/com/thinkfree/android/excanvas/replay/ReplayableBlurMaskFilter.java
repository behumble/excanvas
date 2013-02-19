package com.thinkfree.android.excanvas.replay;

import android.graphics.BlurMaskFilter;

public class ReplayableBlurMaskFilter extends BlurMaskFilter {
    public float radius;
    public Blur style;

    public ReplayableBlurMaskFilter(float radius, Blur style) {
        super(radius, style);
        this.radius = radius;
        this.style = style;
    }
}