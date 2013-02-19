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