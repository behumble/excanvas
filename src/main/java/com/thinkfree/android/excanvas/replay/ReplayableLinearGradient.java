package com.thinkfree.android.excanvas.replay;

import android.graphics.LinearGradient;

public class ReplayableLinearGradient extends LinearGradient {
    public static final int ID_LINEAR_GRADIENT_float_float_float_float_ints_floats_TileMode = 0;
    public static final int ID_LINEAR_GRADIENT_float_float_float_float_int_int_TileMode = 1;

    public Instruction op;

    public ReplayableLinearGradient(float x0, float y0, float x1, float y1, int[] colors, float[] positions, TileMode tile) {
        super(x0, y0, x1, y1, colors, positions, tile);
        Object[] param = new Object[] { x0, y0, x1, y1, colors, positions, tile };
        op = new Instruction(ID_LINEAR_GRADIENT_float_float_float_float_ints_floats_TileMode, param);
    }

    public ReplayableLinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, TileMode tile) {
        super(x0, y0, x1, y1, color0, color1, tile);
        Object[] param = new Object[] { x0, y0, x1, y1, color0, color1, tile };
        op = new Instruction(ID_LINEAR_GRADIENT_float_float_float_float_ints_floats_TileMode, param);
    }
}