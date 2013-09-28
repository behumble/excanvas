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

import android.graphics.RadialGradient;

public class ReplayableRadialGradient extends RadialGradient {
    public static final int ID_RADIAL_GRADIENT_float_float_float_ints_floats_TileMode = 0;
    public static final int ID_RADIAL_GRADIENT_float_float_float_int_int_TileMode = 1;

    public Instruction op;

    public ReplayableRadialGradient(float x, float y, float radius, int[] colors, float[] positions, TileMode tile) {
        super(x, y, radius, colors, positions, tile);
        Object[] param = new Object[] { x, y, radius, colors, positions, tile };
        op = new Instruction(ID_RADIAL_GRADIENT_float_float_float_ints_floats_TileMode, param);
    }

    public ReplayableRadialGradient(float x, float y, float radius, int color0, int color1, TileMode tile) {
        super(x, y, radius, color0, color1, tile);
        Object[] param = new Object[] { x, y, radius, color0, color1, tile };
        op = new Instruction(ID_RADIAL_GRADIENT_float_float_float_int_int_TileMode, param);
    }
}