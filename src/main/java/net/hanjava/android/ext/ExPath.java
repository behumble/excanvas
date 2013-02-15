package net.hanjava.android.ext;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import net.hanjava.android.ExCanvas;

import java.util.Arrays;

public class ExPath extends Path {
    private static final String TAG = "ExPath";

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
        if(ExCanvas.debug) {
            Log.d(TAG, "reset()");
        }
    }

    @Override
    public void rewind() {
        super.rewind();
        if(ExCanvas.debug) {
            Log.d(TAG, "rewind()");
        }
    }

    @Override
    public void set(Path src) {
        throw new RuntimeException("Unsupported");
    }

    @Override
    public FillType getFillType() {
        FillType result = super.getFillType();
        if(ExCanvas.debug) {
            Log.d(TAG, "getFillType():"+result);
        }
        return result;
    }

    @Override
    public void setFillType(FillType ft) {
        super.setFillType(ft);
        if(ExCanvas.debug) {
            Log.d(TAG, "setFillType("+ft+")");
        }
    }

    @Override
    public boolean isInverseFillType() {
        boolean result = super.isInverseFillType();
        if(ExCanvas.debug) {
            Log.d(TAG, "isInverseFillType():"+result);
        }
        return result;
    }

    @Override
    public void toggleInverseFillType() {
        super.toggleInverseFillType();
        if(ExCanvas.debug) {
            Log.d(TAG, "toggleInverseFillType()");
        }
    }

    @Override
    public boolean isEmpty() {
        boolean result = super.isEmpty();
        if(ExCanvas.debug) {
            Log.d(TAG, "isEmpty():"+result);
        }
        return result;
    }

    @Override
    public boolean isRect(RectF rect) {
        boolean result = super.isRect(rect);
        if(ExCanvas.debug) {
            Log.d(TAG, "isRect("+rect+"):"+result);
        }
        return result;
    }

    @Override
    public void computeBounds(RectF bounds, boolean exact) {
        super.computeBounds(bounds, exact);
        if(ExCanvas.debug) {
            Log.d(TAG, "computeBounds("+bounds+","+exact+")");
        }
    }

    @Override
    public void incReserve(int extraPtCount) {
        super.incReserve(extraPtCount);
        if(ExCanvas.debug) {
            Log.d(TAG, "incReserve("+extraPtCount+")");
        }
    }

    @Override
    public void moveTo(float x, float y) {
        super.moveTo(x, y);
        if(ExCanvas.debug) {
            Log.d(TAG, "moveTo("+x+","+y+")");
        }
    }

    @Override
    public void rMoveTo(float dx, float dy) {
        super.rMoveTo(dx, dy);
        if(ExCanvas.debug) {
            Log.d(TAG, "rMoveTo("+dx+","+dy+")");
        }
    }

    @Override
    public void lineTo(float x, float y) {
        super.lineTo(x, y);
        if(ExCanvas.debug) {
            Log.d(TAG, "lineTo("+x+","+y+")");
        }
    }

    @Override
    public void rLineTo(float dx, float dy) {
        super.rLineTo(dx, dy);
        if(ExCanvas.debug) {
            Log.d(TAG, "rLineTo("+dx+","+dy+")");
        }
    }

    @Override
    public void quadTo(float x1, float y1, float x2, float y2) {
        super.quadTo(x1, y1, x2, y2);
        if(ExCanvas.debug) {
            Log.d(TAG, "quadTo("+x1+","+y1+","+x2+","+y2);
        }
    }

    @Override
    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        super.rQuadTo(dx1, dy1, dx2, dy2);
        if(ExCanvas.debug) {
            Log.d(TAG, "rQuadTo("+dx1+","+dy1+","+dx2+","+dy2+")");
        }
    }

    @Override
    public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        super.cubicTo(x1, y1, x2, y2, x3, y3);
        if(ExCanvas.debug) {
            Log.d(TAG, "cubicTo("+x1+","+y1+","+x2+","+y2+","+x3+","+y3);
        }
    }

    @Override
    public void rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        super.rCubicTo(x1, y1, x2, y2, x3, y3);
        if(ExCanvas.debug) {
            Log.d(TAG, "rCubicTo("+x1+","+y1+","+x2+","+y2+","+x3+","+y3);
        }
    }

    @Override
    public void arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) {
        super.arcTo(oval, startAngle, sweepAngle, forceMoveTo);
        if(ExCanvas.debug) {
            Log.d(TAG, "arcTo("+oval+","+startAngle+","+sweepAngle+","+forceMoveTo+")");
        }
    }

    @Override
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        super.arcTo(oval, startAngle, sweepAngle);
        if(ExCanvas.debug) {
            Log.d(TAG, "arcTo("+oval+","+startAngle+","+sweepAngle+")");
        }
    }

    @Override
    public void close() {
        super.close();
        if(ExCanvas.debug) {
            Log.d(TAG, "close()");
        }
    }

    @Override
    public void addRect(RectF rect, Direction dir) {
        super.addRect(rect, dir);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRect("+rect+","+dir+")");
        }
    }

    @Override
    public void addRect(float left, float top, float right, float bottom, Direction dir) {
        super.addRect(left, top, right, bottom, dir);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRect("+left+","+top+","+right+","+bottom+","+dir+")");
        }
    }

    @Override
    public void addOval(RectF oval, Direction dir) {
        super.addOval(oval, dir);
        if(ExCanvas.debug) {
            Log.d(TAG, "addOval("+oval+","+dir+")");
        }
    }

    @Override
    public void addCircle(float x, float y, float radius, Direction dir) {
        super.addCircle(x, y, radius, dir);
        if(ExCanvas.debug) {
            Log.d(TAG, "addCircle("+x+','+y+','+radius+','+dir+")");
        }
    }

    @Override
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        super.addArc(oval, startAngle, sweepAngle);
        if(ExCanvas.debug) {
            Log.d(TAG, "addArc("+oval+','+startAngle+','+sweepAngle+')');
        }
    }

    @Override
    public void addRoundRect(RectF rect, float rx, float ry, Direction dir) {
        super.addRoundRect(rect, rx, ry, dir);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRoundRect("+rect+','+rx+','+ry+','+dir+")");
        }
    }

    @Override
    public void addRoundRect(RectF rect, float[] radii, Direction dir) {
        super.addRoundRect(rect, radii, dir);
        if(ExCanvas.debug) {
            Log.d(TAG, "addRoundRect("+rect+','+ Arrays.toString(radii)+','+dir+")");
        }
    }

    @Override
    public void addPath(Path src, float dx, float dy) {
        super.addPath(src, dx, dy);
        if(ExCanvas.debug) {
            Log.d(TAG, "addPath("+src+','+dx+','+dy+')');
        }
    }

    @Override
    public void addPath(Path src) {
        super.addPath(src);
        if(ExCanvas.debug) {
            Log.d(TAG, "addPath("+src+')');
        }
    }

    @Override
    public void addPath(Path src, Matrix matrix) {
        super.addPath(src, matrix);
        if(ExCanvas.debug) {
            Log.d(TAG, "addPath("+src+','+matrix+')');
        }
    }

    @Override
    public void offset(float dx, float dy, Path dst) {
        super.offset(dx, dy, dst);
        if(ExCanvas.debug) {
            Log.d(TAG, "offset("+dx+','+dy+')');
        }
    }

    @Override
    public void offset(float dx, float dy) {
        super.offset(dx, dy);
        if(ExCanvas.debug) {
            Log.d(TAG, "offset("+dx+','+dy+')');
        }
    }

    @Override
    public void setLastPoint(float dx, float dy) {
        super.setLastPoint(dx, dy);
        if(ExCanvas.debug) {
            Log.d(TAG, "setLastPoint("+dx+','+dy+')');
        }
    }

    @Override
    public void transform(Matrix matrix, Path dst) {
        super.transform(matrix, dst);
        if(ExCanvas.debug) {
            Log.d(TAG, "transform("+matrix+','+dst+')');
        }
    }

    @Override
    public void transform(Matrix matrix) {
        super.transform(matrix);
        if(ExCanvas.debug) {
            Log.d(TAG, "transform("+matrix+')');
        }
    }
}