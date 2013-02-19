package com.thinkfree.android.excanvas.replay;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import com.thinkfree.android.excanvas.ExCanvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplayablePath extends Path {
    public static final int ID_RESET = 0;
    public static final int ID_REWIND = 1;
    public static final int ID_MOVE_TO_float_float = 2;
    public static final int ID_RMOVE_TO_float_float = 3;
    public static final int ID_LINE_TO_float_float = 4;
    public static final int ID_RLINE_TO_float_float = 5;
    public static final int ID_QUAD_TO_float_float_float_float = 6;
    public static final int ID_RQUAD_TO_float_float_float_float = 7;
    public static final int ID_CUBIC_TO_float_float_float_float_float_float = 8;
    public static final int ID_RCUBIC_TO_float_float_float_float_float_float = 9;
    public static final int ID_ARC_TO_RectF_float_float_boolean = 10;
    public static final int ID_ARC_TO_RectF_float_float = 11;
    public static final int ID_CLOSE = 12;
    public static final int ID_ADD_RECT_float_float_float_float_Direction = 13;
    public static final int ID_ADD_OVAL_RectF_Direction = 14;
    public static final int ID_ADD_CIRCLE_float_float_float_Direction = 15;
    public static final int ID_ADD_ARC_RectF_float_float = 16;
    public static final int ID_ADD_ROUND_RECT_RectF_float_float_Direction = 17;
    public static final int ID_ADD_ROUND_RECT_RectF_floats_Direction = 18;
    public static final int ID_ADD_PATH_Path_float_float = 19;
    public static final int ID_ADD_PATH_Path = 20;
    public static final int ID_ADD_PATH_Path_Matrix = 21;
    public static final int ID_OFFSET_float_float_Path = 22;
    public static final int ID_OFFSET_float_float = 23;
    public static final int ID_SET_LAST_POINT_float_float = 24;
    public static final int ID_TRANSFORM_Matrix_Path = 25;
    public static final int ID_TRANSFORM_Matrix = 26;

    private static final String TAG = "ReplayablePath";
    private List opList = new ArrayList<Instruction>();

    public ReplayablePath() {
        if(ExCanvas.debug) {
            Log.d(TAG, "ReplayablePath()");
        }
    }

    public ReplayablePath(Path src) {
        throw new RuntimeException("Unsupported");
    }

    @Override
    public void reset() {
        super.reset();
        Instruction op = new Instruction(ID_RESET, null);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "reset()");
        }
    }

    @Override
    public void rewind() {
        super.rewind();
        Instruction op = new Instruction(ID_REWIND, null);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "rewind()");
        }
    }

    @Override
    public void set(Path src) {
        throw new RuntimeException("Unsupported");
    }

    @Override
    public void moveTo(float x, float y) {
        super.moveTo(x, y);
        Instruction op = new Instruction(ID_MOVE_TO_float_float, new Object[] {x, y});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "moveTo("+x+","+y+")");
        }
    }

    @Override
    public void rMoveTo(float dx, float dy) {
        super.rMoveTo(dx, dy);
        Instruction op = new Instruction(ID_RMOVE_TO_float_float, new Object[] {dx, dy});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "rMoveTo("+dx+","+dy+")");
        }
    }

    @Override
    public void lineTo(float x, float y) {
        super.lineTo(x, y);
        Instruction op = new Instruction(ID_LINE_TO_float_float, new Object[] {x, y});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "lineTo("+x+","+y+")");
        }
    }

    @Override
    public void rLineTo(float dx, float dy) {
        super.rLineTo(dx, dy);
        Instruction op = new Instruction(ID_RLINE_TO_float_float, new Object[] {dx, dy});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "rLineTo("+dx+","+dy+")");
        }
    }

    @Override
    public void quadTo(float x1, float y1, float x2, float y2) {
        super.quadTo(x1, y1, x2, y2);
        Instruction op = new Instruction(ID_QUAD_TO_float_float_float_float, new Object[] {x1, y1, x2, y2});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "quadTo("+x1+","+y1+","+x2+","+y2);
        }
    }

    @Override
    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        super.rQuadTo(dx1, dy1, dx2, dy2);
        Instruction op = new Instruction(ID_RQUAD_TO_float_float_float_float, new Object[] {dx1, dy1, dx2, dy2});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "rQuadTo("+dx1+","+dy1+","+dx2+","+dy2+")");
        }
    }

    @Override
    public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        super.cubicTo(x1, y1, x2, y2, x3, y3);
        Instruction op = new Instruction(ID_CUBIC_TO_float_float_float_float_float_float, new Object[] {x1, y1, x2, y2, x3, y3});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "cubicTo("+x1+","+y1+","+x2+","+y2+","+x3+","+y3);
        }
    }

    @Override
    public void rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        super.rCubicTo(x1, y1, x2, y2, x3, y3);
        Instruction op = new Instruction(ID_RCUBIC_TO_float_float_float_float_float_float, new Object[] {x1, y1, x2, y2, x3, y3});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "rCubicTo("+x1+","+y1+","+x2+","+y2+","+x3+","+y3);
        }
    }

    @Override
    public void arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) {
        super.arcTo(oval, startAngle, sweepAngle, forceMoveTo);
        Instruction op = new Instruction(ID_ARC_TO_RectF_float_float_boolean, new Object[] {oval, startAngle, sweepAngle, forceMoveTo});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "arcTo("+oval+","+startAngle+","+sweepAngle+","+forceMoveTo+")");
        }
    }

    @Override
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        super.arcTo(oval, startAngle, sweepAngle);
        Instruction op = new Instruction(ID_ARC_TO_RectF_float_float, new Object[] {oval, startAngle, sweepAngle});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "arcTo("+oval+","+startAngle+","+sweepAngle+")");
        }
    }

    @Override
    public void close() {
        super.close();
        Instruction op = new Instruction(ID_CLOSE, null);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "close()");
        }
    }

    @Override
    public void addRect(RectF r, Direction dir) {
        super.addRect(r, dir);
        Object[] param = new Object[] { r.left, r.top, r.right, r.bottom };
        Instruction op = new Instruction(ID_ADD_RECT_float_float_float_float_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRect("+r+","+dir+")");
        }
    }

    @Override
    public void addRect(float left, float top, float right, float bottom, Direction dir) {
        super.addRect(left, top, right, bottom, dir);
        Object[] param = new Object[] { left, top, right, bottom, dir };
        Instruction op = new Instruction(ID_ADD_RECT_float_float_float_float_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRect("+left+","+top+","+right+","+bottom+","+dir+")");
        }
    }

    @Override
    public void addOval(RectF oval, Direction dir) {
        super.addOval(oval, dir);
        Object[] param = new Object[] { oval, dir };
        Instruction op = new Instruction(ID_ADD_OVAL_RectF_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addOval("+oval+","+dir+")");
        }
    }

    @Override
    public void addCircle(float x, float y, float radius, Direction dir) {
        super.addCircle(x, y, radius, dir);
        Object[] param = new Object[] { x, y, radius, dir };
        Instruction op = new Instruction(ID_ADD_CIRCLE_float_float_float_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addCircle("+x+','+y+','+radius+','+dir+")");
        }
    }

    @Override
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        super.addArc(oval, startAngle, sweepAngle);
        Object[] param = new Object[] { oval, startAngle, sweepAngle };
        Instruction op = new Instruction(ID_ADD_ARC_RectF_float_float, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addArc("+oval+','+startAngle+','+sweepAngle+')');
        }
    }

    @Override
    public void addRoundRect(RectF rect, float rx, float ry, Direction dir) {
        super.addRoundRect(rect, rx, ry, dir);
        Object[] param = new Object[] { rect, rx, ry, dir };
        Instruction op = new Instruction(ID_ADD_ROUND_RECT_RectF_float_float_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRoundRect("+rect+','+rx+','+ry+','+dir+")");
        }
    }

    @Override
    public void addRoundRect(RectF rect, float[] radii, Direction dir) {
        super.addRoundRect(rect, radii, dir);
        Object[] param = new Object[] { rect, radii, dir };
        Instruction op = new Instruction(ID_ADD_ROUND_RECT_RectF_floats_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRoundRect("+rect+','+ Arrays.toString(radii)+','+dir+")");
        }
    }

    @Override
    public void addPath(Path src, float dx, float dy) {
        super.addPath(src, dx, dy);
        Object[] param = new Object[] { src, dx, dy };
        Instruction op = new Instruction(ID_ADD_PATH_Path_float_float, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addPath("+src+','+dx+','+dy+')');
        }
    }

    @Override
    public void addPath(Path src) {
        super.addPath(src);
        Instruction op = new Instruction(ID_ADD_PATH_Path, new Object[] { src });
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addPath("+src+')');
        }
    }

    @Override
    public void addPath(Path src, Matrix matrix) {
        super.addPath(src, matrix);
        Object[] param = new Object[] { src, matrix };
        Instruction op = new Instruction(ID_ADD_PATH_Path_Matrix, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addPath("+src+','+matrix+')');
        }
    }

    @Override
    public void offset(float dx, float dy, Path dst) {
        super.offset(dx, dy, dst);
        Object[] param = new Object[] { dx, dy, dst };
        Instruction op = new Instruction(ID_OFFSET_float_float_Path, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "offset("+dx+','+dy+')');
        }
    }

    @Override
    public void offset(float dx, float dy) {
        super.offset(dx, dy);
        Object[] param = new Object[] { dx, dy };
        Instruction op = new Instruction(ID_OFFSET_float_float, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "offset("+dx+','+dy+')');
        }
    }

    @Override
    public void setLastPoint(float dx, float dy) {
        super.setLastPoint(dx, dy);
        Object[] param = new Object[] { dx, dy };
        Instruction op = new Instruction(ID_SET_LAST_POINT_float_float, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "setLastPoint("+dx+','+dy+')');
        }
    }

    @Override
    public void transform(Matrix matrix, Path dst) {
        super.transform(matrix, dst);
        Object[] param = new Object[] { matrix, dst };
        Instruction op = new Instruction(ID_TRANSFORM_Matrix_Path, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "transform("+matrix+','+dst+')');
        }
    }

    @Override
    public void transform(Matrix matrix) {
        super.transform(matrix);
        Instruction op = new Instruction(ID_TRANSFORM_Matrix, new Object[] { matrix });
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "transform("+matrix+')');
        }
    }

    public final List<Instruction> getPathOps() {
        return opList;
    }
}