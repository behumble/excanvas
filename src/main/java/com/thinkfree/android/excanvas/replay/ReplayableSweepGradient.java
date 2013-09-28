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

import android.graphics.SweepGradient;

public class ReplayableSweepGradient extends SweepGradient {
    public static final int ID_SWEEP_GRADIENT_float_float_ints_floats = 0;
    public static final int ID_SWEEP_GRADIENT_float_float_int_int = 1;

    public Instruction op;

    public ReplayableSweepGradient(float cx, float cy, int[] colors, float[] positions) {
        super(cx, cy, colors, positions);
        Object[] param = new Object[] { cx, cy, colors, positions };
        op = new Instruction(ID_SWEEP_GRADIENT_float_float_ints_floats, param);
    }

    public ReplayableSweepGradient(float cx, float cy, int color0, int color1) {
        super(cx, cy, color0, color1);
        Object[] param = new Object[] { cx, cy, color0, color1 };
        op = new Instruction(ID_SWEEP_GRADIENT_float_float_int_int, param);
    }
}
