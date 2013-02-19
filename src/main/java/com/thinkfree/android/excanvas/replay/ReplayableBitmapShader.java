package com.thinkfree.android.excanvas.replay;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;

public class ReplayableBitmapShader extends BitmapShader {
    public TileMode tileX;
    public TileMode tileY;

    public ReplayableBitmapShader(Bitmap bitmap, TileMode tileX, TileMode tileY) {
        super(bitmap, tileX, tileY);
        this.tileX = tileX;
        this.tileY = tileY;
    }
}