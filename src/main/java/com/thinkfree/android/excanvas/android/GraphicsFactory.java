package com.thinkfree.android.excanvas.android;

import android.graphics.*;

public class GraphicsFactory {
    private static GraphicsFactory defaultInstance;

    public static void setDefault(GraphicsFactory factory) {
        GraphicsFactory.defaultInstance = factory;
    }

    public static GraphicsFactory getDefault() {
        synchronized (GraphicsFactory.class) {
            if(defaultInstance==null) {
                defaultInstance = new GraphicsFactory();
            }
        }
        return GraphicsFactory.defaultInstance;
    }

    /**
     * Prevent instancing
     */
    protected GraphicsFactory() {
        // do nothing
    }

    public BitmapShader newBitmapShader(Bitmap bitmap, Shader.TileMode tileX, Shader.TileMode tileY) {
        return new BitmapShader(bitmap, tileX, tileY);
    }

    public LinearGradient newLinearGradient(float x0, float y0, float x1, float y1, int[] colors, float[] positions, Shader.TileMode tile) {
        return new LinearGradient(x0, y0, x1, y1, colors, positions, tile);
    }

    public LinearGradient newLinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, Shader.TileMode tile) {
        return new LinearGradient(x0, y0, x1, y1, color0, color1, tile);
    }

    public RadialGradient newRadialGradient(float x, float y, float radius, int[] colors, float[] positions, Shader.TileMode tile) {
        return new RadialGradient(x, y, radius, colors, positions, tile);
    }

    public RadialGradient newRadialGradient(float x, float y, float radius, int color0, int color1, Shader.TileMode tile) {
        return new RadialGradient(x, y, radius, color0, color1, tile);
    }

    public SweepGradient newSweepGradient(float cx, float cy, int[] colors, float[] positions) {
        return new SweepGradient(cx, cy, colors, positions);
    }

    public SweepGradient newSweepGradient(float cx, float cy, int color0, int color1) {
        return new SweepGradient(cx, cy, color0, color1);
    }

    public BlurMaskFilter newBlurMaskFilter(float radius, BlurMaskFilter.Blur style) {
        return new BlurMaskFilter(radius, style);
    }

    public Path newPath() {
        return new Path();
    }
}