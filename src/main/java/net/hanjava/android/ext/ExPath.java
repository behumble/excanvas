package net.hanjava.android.ext;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import net.hanjava.android.ExCanvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExPath extends Path {
    private static final String TAG = "ExPath";
    private List opList = new ArrayList<PathOp>();

    public ExPath() {
        if(ExCanvas.debug) {
            Log.d(TAG, "ExPath()");
        }
    }

    public ExPath(Path src) {
        throw new RuntimeException("Unsupported");
    }

    @Override
    public void reset() {
        super.reset();
        PathOp op = new PathOp(PathOp.ID_RESET, null);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "reset()");
        }
    }

    @Override
    public void rewind() {
        super.rewind();
        PathOp op = new PathOp(PathOp.ID_REWIND, null);
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
        PathOp op = new PathOp(PathOp.ID_MOVE_TO_float_float, new Object[] {x, y});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "moveTo("+x+","+y+")");
        }
    }

    @Override
    public void rMoveTo(float dx, float dy) {
        super.rMoveTo(dx, dy);
        PathOp op = new PathOp(PathOp.ID_RMOVE_TO_float_float, new Object[] {dx, dy});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "rMoveTo("+dx+","+dy+")");
        }
    }

    @Override
    public void lineTo(float x, float y) {
        super.lineTo(x, y);
        PathOp op = new PathOp(PathOp.ID_LINE_TO_float_float, new Object[] {x, y});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "lineTo("+x+","+y+")");
        }
    }

    @Override
    public void rLineTo(float dx, float dy) {
        super.rLineTo(dx, dy);
        PathOp op = new PathOp(PathOp.ID_RLINE_TO_float_float, new Object[] {dx, dy});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "rLineTo("+dx+","+dy+")");
        }
    }

    @Override
    public void quadTo(float x1, float y1, float x2, float y2) {
        super.quadTo(x1, y1, x2, y2);
        PathOp op = new PathOp(PathOp.ID_QUAD_TO_float_float_float_float, new Object[] {x1, y1, x2, y2});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "quadTo("+x1+","+y1+","+x2+","+y2);
        }
    }

    @Override
    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        super.rQuadTo(dx1, dy1, dx2, dy2);
        PathOp op = new PathOp(PathOp.ID_RQUAD_TO_float_float_float_float, new Object[] {dx1, dy1, dx2, dy2});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "rQuadTo("+dx1+","+dy1+","+dx2+","+dy2+")");
        }
    }

    @Override
    public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        super.cubicTo(x1, y1, x2, y2, x3, y3);
        PathOp op = new PathOp(PathOp.ID_CUBIC_TO_float_float_float_float_float_float, new Object[] {x1, y1, x2, y2, x3, y3});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "cubicTo("+x1+","+y1+","+x2+","+y2+","+x3+","+y3);
        }
    }

    @Override
    public void rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        super.rCubicTo(x1, y1, x2, y2, x3, y3);
        PathOp op = new PathOp(PathOp.ID_RCUBIC_TO_float_float_float_float_float_float, new Object[] {x1, y1, x2, y2, x3, y3});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "rCubicTo("+x1+","+y1+","+x2+","+y2+","+x3+","+y3);
        }
    }

    @Override
    public void arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) {
        super.arcTo(oval, startAngle, sweepAngle, forceMoveTo);
        PathOp op = new PathOp(PathOp.ID_ARC_TO_RectF_float_float_boolean, new Object[] {oval, startAngle, sweepAngle, forceMoveTo});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "arcTo("+oval+","+startAngle+","+sweepAngle+","+forceMoveTo+")");
        }
    }

    @Override
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        super.arcTo(oval, startAngle, sweepAngle);
        PathOp op = new PathOp(PathOp.ID_ARC_TO_RectF_float_float, new Object[] {oval, startAngle, sweepAngle});
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "arcTo("+oval+","+startAngle+","+sweepAngle+")");
        }
    }

    @Override
    public void close() {
        super.close();
        PathOp op = new PathOp(PathOp.ID_CLOSE, null);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "close()");
        }
    }

    @Override
    public void addRect(RectF r, Direction dir) {
        super.addRect(r, dir);
        Object[] param = new Object[] { r.left, r.top, r.right, r.bottom };
        PathOp op = new PathOp(PathOp.ID_ADD_RECT_float_float_float_float_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRect("+r+","+dir+")");
        }
    }

    @Override
    public void addRect(float left, float top, float right, float bottom, Direction dir) {
        super.addRect(left, top, right, bottom, dir);
        Object[] param = new Object[] { left, top, right, bottom, dir };
        PathOp op = new PathOp(PathOp.ID_ADD_RECT_float_float_float_float_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRect("+left+","+top+","+right+","+bottom+","+dir+")");
        }
    }

    @Override
    public void addOval(RectF oval, Direction dir) {
        super.addOval(oval, dir);
        Object[] param = new Object[] { oval, dir };
        PathOp op = new PathOp(PathOp.ID_ADD_OVAL_RectF_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addOval("+oval+","+dir+")");
        }
    }

    @Override
    public void addCircle(float x, float y, float radius, Direction dir) {
        super.addCircle(x, y, radius, dir);
        Object[] param = new Object[] { x, y, radius, dir };
        PathOp op = new PathOp(PathOp.ID_ADD_CIRCLE_float_float_float_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addCircle("+x+','+y+','+radius+','+dir+")");
        }
    }

    @Override
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        super.addArc(oval, startAngle, sweepAngle);
        Object[] param = new Object[] { oval, startAngle, sweepAngle };
        PathOp op = new PathOp(PathOp.ID_ADD_ARC_RectF_float_float, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addArc("+oval+','+startAngle+','+sweepAngle+')');
        }
    }

    @Override
    public void addRoundRect(RectF rect, float rx, float ry, Direction dir) {
        super.addRoundRect(rect, rx, ry, dir);
        Object[] param = new Object[] { rect, rx, ry, dir };
        PathOp op = new PathOp(PathOp.ID_ADD_ROUND_RECT_RectF_float_float_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRoundRect("+rect+','+rx+','+ry+','+dir+")");
        }
    }

    @Override
    public void addRoundRect(RectF rect, float[] radii, Direction dir) {
        super.addRoundRect(rect, radii, dir);
        Object[] param = new Object[] { rect, radii, dir };
        PathOp op = new PathOp(PathOp.ID_ADD_ROUND_RECT_RectF_floats_Direction, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRoundRect("+rect+','+ Arrays.toString(radii)+','+dir+")");
        }
    }

    @Override
    public void addPath(Path src, float dx, float dy) {
        super.addPath(src, dx, dy);
        Object[] param = new Object[] { src, dx, dy };
        PathOp op = new PathOp(PathOp.ID_ADD_PATH_Path_float_float, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addPath("+src+','+dx+','+dy+')');
        }
    }

    @Override
    public void addPath(Path src) {
        super.addPath(src);
        PathOp op = new PathOp(PathOp.ID_ADD_PATH_Path, new Object[] { src });
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addPath("+src+')');
        }
    }

    @Override
    public void addPath(Path src, Matrix matrix) {
        super.addPath(src, matrix);
        Object[] param = new Object[] { src, matrix };
        PathOp op = new PathOp(PathOp.ID_ADD_PATH_Path_Matrix, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "addPath("+src+','+matrix+')');
        }
    }

    @Override
    public void offset(float dx, float dy, Path dst) {
        super.offset(dx, dy, dst);
        Object[] param = new Object[] { dx, dy, dst };
        PathOp op = new PathOp(PathOp.ID_OFFSET_float_float_Path, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "offset("+dx+','+dy+')');
        }
    }

    @Override
    public void offset(float dx, float dy) {
        super.offset(dx, dy);
        Object[] param = new Object[] { dx, dy };
        PathOp op = new PathOp(PathOp.ID_OFFSET_float_float, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "offset("+dx+','+dy+')');
        }
    }

    @Override
    public void setLastPoint(float dx, float dy) {
        super.setLastPoint(dx, dy);
        Object[] param = new Object[] { dx, dy };
        PathOp op = new PathOp(PathOp.ID_SET_LAST_POINT_float_float, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "setLastPoint("+dx+','+dy+')');
        }
    }

    @Override
    public void transform(Matrix matrix, Path dst) {
        super.transform(matrix, dst);
        Object[] param = new Object[] { matrix, dst };
        PathOp op = new PathOp(PathOp.ID_TRANSFORM_Matrix_Path, param);
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "transform("+matrix+','+dst+')');
        }
    }

    @Override
    public void transform(Matrix matrix) {
        super.transform(matrix);
        PathOp op = new PathOp(PathOp.ID_TRANSFORM_Matrix, new Object[] { matrix });
        opList.add(op);
        if(ExCanvas.debug) {
            Log.d(TAG, "transform("+matrix+')');
        }
    }

    public final List<PathOp> getPathOps() {
        return opList;
    }
}