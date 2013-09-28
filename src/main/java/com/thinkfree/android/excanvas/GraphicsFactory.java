/*
 * Copyright 2013 Alan Goo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thinkfree.android.excanvas;

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