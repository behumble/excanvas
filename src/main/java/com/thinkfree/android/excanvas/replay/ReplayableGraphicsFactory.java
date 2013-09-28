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

package com.thinkfree.android.excanvas.replay;

import android.graphics.*;
import com.thinkfree.android.excanvas.GraphicsFactory;

/**
 * Extended Graphics Factory
 * @author Alan Goo
 */
public class ReplayableGraphicsFactory extends GraphicsFactory {
    @Override
    public Path newPath() {
        return new ReplayablePath();
    }

    @Override
    public BitmapShader newBitmapShader(Bitmap bitmap, Shader.TileMode tileX, Shader.TileMode tileY) {
        return new ReplayableBitmapShader(bitmap, tileX, tileY);
    }

    @Override
    public LinearGradient newLinearGradient(float x0, float y0, float x1, float y1, int[] colors, float[] positions, Shader.TileMode tile) {
        return new ReplayableLinearGradient(x0, y0, x1, y1, colors, positions, tile);
    }

    @Override
    public LinearGradient newLinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, Shader.TileMode tile) {
        return new ReplayableLinearGradient(x0, y0, x1, y1, color0, color1, tile);
    }

    @Override
    public RadialGradient newRadialGradient(float x, float y, float radius, int[] colors, float[] positions, Shader.TileMode tile) {
        return new ReplayableRadialGradient(x, y, radius, colors, positions, tile);
    }

    @Override
    public RadialGradient newRadialGradient(float x, float y, float radius, int color0, int color1, Shader.TileMode tile) {
        return new ReplayableRadialGradient(x, y, radius, color0, color1, tile);
    }

    @Override
    public SweepGradient newSweepGradient(float cx, float cy, int[] colors, float[] positions) {
        return new ReplayableSweepGradient(cx, cy, colors, positions);
    }

    @Override
    public SweepGradient newSweepGradient(float cx, float cy, int color0, int color1) {
        return new ReplayableSweepGradient(cx, cy, color0, color1);
    }

    @Override
    public BlurMaskFilter newBlurMaskFilter(float radius, BlurMaskFilter.Blur style) {
        return new ReplayableBlurMaskFilter(radius, style);
    }
}