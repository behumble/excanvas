package net.hanjava.android;


import android.graphics.*;
import android.util.Log;

import javax.microedition.khronos.opengles.GL;
import java.util.Arrays;

public class ExCanvas extends Canvas {
    public static boolean debug = false;

    public static ExCanvas getExCanvas(Canvas canvas) {
        ExCanvas result = null;
        if (canvas instanceof ExCanvas) {
            result = (ExCanvas) canvas;
        } else {
            result = new ExCanvas(canvas);
        }
        return result;
    }

    private final Canvas peer;
    private final String tag;

    private ExCanvas(Canvas peer) {
        this.peer = peer;
        tag = "ExCanvas:" + peer.getClass().getSimpleName();
    }

    public Canvas getPeer() {
        return this.peer;
    }

    public GL getGL() {
        final GL gl = peer.getGL();
        if (debug) {
            Log.d(tag, "getGL():" + gl);
        }
        return gl;
    }

    public void setBitmap(Bitmap bitmap) {
        peer.setBitmap(bitmap);
        if (debug) {
            Log.d(tag, "setBitmap(" + bitmap + ")");
        }
    }

    public void setViewport(int width, int height) {
        peer.setViewport(width, height);
        if (debug) {
            Log.d(tag, "setViewport(" + width + "," + height + ")");
        }
    }

    public boolean isOpaque() {
        final boolean result = peer.isOpaque();
        if (debug) {
            Log.d(tag, "isOpaque():" + result);
        }
        return result;
    }

    public int getWidth() {
        final int result = peer.getWidth();
        if (debug) {
            Log.d(tag, "getWidth():" + result);
        }
        return result;
    }

    public int getHeight() {
        final int result = peer.getHeight();
        if (debug) {
            Log.d(tag, "getHeight():" + result);
        }
        return result;
    }

    public int getDensity() {
        final int result = peer.getDensity();
        if (debug) {
            Log.d(tag, "getDensity():" + result);
        }
        return result;
    }

    public void setDensity(int density) {
        peer.setDensity(density);
        if (debug) {
            Log.d(tag, "setDensity(" + density + ")");
        }
    }

    public int save() {
        final int result = peer.save();
        if (debug) {
            Log.d(tag, "save():" + result);
        }
        return result;
    }

    public int save(int i) {
        final int result = peer.save(i);
        if (debug) {
            Log.d(tag, "save(" + i + "):" + result);
        }
        return result;
    }

    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        final int result = peer.saveLayer(bounds, paint, saveFlags);
        if (debug) {
            Log.d(tag, "saveLayer(" + bounds + "," + paint + "," + saveFlags + "):" + result);
        }
        return result;
    }

    public int saveLayer(float left, float top, float right, float bottom, Paint paint, int saveFlags) {
        final int result = peer.saveLayer(left, top, right, bottom, paint, saveFlags);
        if (debug) {
            Log.d(tag, "saveLayer(" + left + "," + top + "," + right + "," + bottom + "), " + paint + ", " + saveFlags + "):" + result);
        }
        return result;
    }

    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        final int result = peer.saveLayerAlpha(bounds, alpha, saveFlags);
        if (debug) {
            Log.d(tag, "saveLayerAlpha(" + bounds + "," + alpha + "," + saveFlags + "):" + result);
        }
        return result;
    }

    public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha, int saveFlags) {
        final int result = peer.saveLayerAlpha(left, top, right, bottom, alpha, saveFlags);
        if (debug) {
            Log.d(tag, "saveLayerAlpha(" + left + "," + top + "," + right + "," + bottom + "," + alpha + "," + saveFlags + "):" + result);
        }
        return result;
    }

    public void restore() {
        peer.restore();
        if (debug) {
            Log.d(tag, "restore()");
        }
    }

    public int getSaveCount() {
        final int result = peer.getSaveCount();
        if (debug) {
            Log.d(tag, "getSaveCount():" + result);
        }
        return result;
    }

    public void restoreToCount(int i) {
        peer.restoreToCount(i);
        if (debug) {
            Log.d(tag, "restoreToCount(" + i + ")");
        }
    }

    public void translate(float v, float v2) {
        peer.translate(v, v2);
        if (debug) {
            Log.d(tag, "translate(" + v + "," + v2 + ")");
        }
    }

    public void scale(float v, float v2) {
        peer.scale(v, v2);
        if (debug) {
            Log.d(tag, "scale(" + v + "," + v2 + ")");
        }
    }

    public void rotate(float v) {
        peer.rotate(v);
        if (debug) {
            Log.d(tag, "rotate(" + v + ")");
        }
    }

    public void skew(float v, float v2) {
        peer.skew(v, v2);
        if (debug) {
            Log.d(tag, "skew(" + v + "," + v2 + ")");
        }
    }

    public void concat(Matrix matrix) {
        peer.concat(matrix);
        if (debug) {
            Log.d(tag, "concat(" + matrix + ")");
        }
    }

    public void setMatrix(Matrix matrix) {
        peer.setMatrix(matrix);
        if (debug) {
            Log.d(tag, "setMatrix(" + matrix + ")");
        }
    }

    public void getMatrix(Matrix ctm) {
        peer.getMatrix(ctm);
        if (debug) {
            Log.d(tag, "getMatrix(" + ctm + ")");
        }
    }

    public boolean clipRect(RectF rect, Region.Op op) {
        final boolean result = peer.clipRect(rect, op);
        if (debug) {
            Log.d(tag, "clipRect(" + rect + "," + op + "):" + result);
        }
        return result;
    }

    public boolean clipRect(Rect rect, Region.Op op) {
        final boolean result = peer.clipRect(rect, op);
        if (debug) {
            Log.d(tag, "clipRect(" + rect + "," + op + "):" + result);
        }
        return result;
    }

    public boolean clipRect(RectF rectF) {
        final boolean result = peer.clipRect(rectF);
        if (debug) {
            Log.d(tag, "clipRect(" + rectF + "):" + result);
        }
        return result;
    }

    public boolean clipRect(Rect rect) {
        final boolean result = peer.clipRect(rect);
        if (debug) {
            Log.d(tag, "clipRect(" + rect + "):" + result);
        }
        return result;
    }

    public boolean clipRect(float left, float top, float right, float bottom, Region.Op op) {
        final boolean result = peer.clipRect(left, top, right, bottom, op);
        if (debug) {
            Log.d(tag, "clipRect(" + left + "," + top + "," + right + "," + bottom + "," + op + "):" + result);
        }
        return result;
    }

    public boolean clipRect(float v, float v2, float v3, float v4) {
        final boolean result = peer.clipRect(v, v2, v3, v4);
        if (debug) {
            Log.d(tag, "clipRect(" + v + "," + v2 + "," + v3 + "," + v4 + "):" + result);
        }
        return result;
    }

    public boolean clipRect(int i, int i2, int i3, int i4) {
        final boolean result = peer.clipRect(i, i2, i3, i4);
        if (debug) {
            Log.d(tag, "clipRect(" + i + "," + i2 + "," + i3 + "," + i4 + "):" + result);
        }
        return result;
    }

    public boolean clipPath(Path path, Region.Op op) {
        final boolean result = peer.clipPath(path, op);
        if (debug) {
            Log.d(tag, "clipPath(" + path + "," + op + "):" + result);
        }
        return result;
    }

    public boolean clipPath(Path path) {
        final boolean result = peer.clipPath(path);
        if (debug) {
            Log.d(tag, "clipPath(" + path + "):" + result);
        }
        return result;
    }

    public boolean clipRegion(Region region, Region.Op op) {
        final boolean result = peer.clipRegion(region, op);
        if (debug) {
            Log.d(tag, "clipRegion(" + region + "," + op + "):" + result);
        }
        return result;
    }

    public boolean clipRegion(Region region) {
        final boolean result = peer.clipRegion(region);
        if (debug) {
            Log.d(tag, "clipRegion(" + region + "):" + result);
        }
        return result;
    }

    public DrawFilter getDrawFilter() {
        final DrawFilter result = peer.getDrawFilter();
        if (debug) {
            Log.d(tag, "getDrawFilter():" + result);
        }
        return result;
    }

    public void setDrawFilter(DrawFilter filter) {
        peer.setDrawFilter(filter);
        if (debug) {
            Log.d(tag, "setDrawFilter(" + filter + ")");
        }
    }

    public boolean quickReject(RectF rect, Canvas.EdgeType type) {
        final boolean result = peer.quickReject(rect, type);
        if (debug) {
            Log.d(tag, "quickReject(" + rect + "," + type + "):" + result);
        }
        return result;
    }

    public boolean quickReject(Path path, Canvas.EdgeType type) {
        final boolean result = peer.quickReject(path, type);
        if (debug) {
            Log.d(tag, "quickReject(" + path + "," + type + "):" + result);
        }
        return result;
    }

    public boolean quickReject(float left, float top, float right, float bottom, Canvas.EdgeType type) {
        final boolean result = peer.quickReject(left, top, right, bottom, type);
        if (debug) {
            Log.d(tag, "quickReject(" + left + "," + top + "," + right + "," + bottom + "," + type + "):" + result);
        }
        return result;
    }

    public boolean getClipBounds(Rect bounds) {
        final boolean result = peer.getClipBounds(bounds);
        if (debug) {
            Log.d(tag, "getClipBounds(" + bounds + ")");
        }
        return result;
    }

    public void drawRGB(int r, int g, int b) {
        peer.drawRGB(r, g, b);
        if (debug) {
            Log.d(tag, "drawRGB(" + r + "," + g + "," + b + ")");
        }
    }

    public void drawARGB(int a, int r, int g, int b) {
        peer.drawARGB(a, r, g, b);
        if (debug) {
            Log.d(tag, "drawARGB(" + a + "," + r + "," + g + "," + b + ")");
        }
    }

    public void drawColor(int color) {
        peer.drawColor(color);
        if (debug) {
            Log.d(tag, "drawColor(" + color + ")");
        }
    }

    public void drawColor(int color, PorterDuff.Mode mode) {
        peer.drawColor(color, mode);
        if (debug) {
            Log.d(tag, "drawColor(" + color + "," + mode + ")");
        }
    }

    public void drawPaint(Paint paint) {
        peer.drawPaint(paint);
        if (debug) {
            Log.d(tag, "drawPaint(" + paint + ")");
        }
    }

    public void drawPoints(float[] floats, int i, int i2, Paint paint) {
        peer.drawPoints(floats, i, i2, paint);
        if (debug) {
            Log.d(tag, "drawPoints(" + Arrays.toString(floats) + "," + i + "," + i2 + "," + paint);
        }
    }

    public void drawPoints(float[] pts, Paint paint) {
        peer.drawPoints(pts, paint);
        if (debug) {
            Log.d(tag, "drawPoints(" + Arrays.toString(pts) + "," + paint + ")");
        }
    }

    public void drawPoint(float v, float v2, Paint paint) {
        peer.drawPoint(v, v2, paint);
        if (debug) {
            Log.d(tag, "drawPoint(" + v + "," + v2 + "," + paint);
        }
    }

    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        peer.drawLine(startX, startY, stopX, stopY, paint);
        if (debug) {
            Log.d(tag, "drawLine(" + startX + "," + startY + "," + stopX + "," + stopY + "," + paint + ")");
        }
    }

    public void drawLines(float[] floats, int i, int i2, Paint paint) {
        peer.drawLines(floats, i, i2, paint);
        if (debug) {
            Log.d(tag, "drawLines(" + Arrays.toString(floats) + "," + i + "," + i2 + "," + paint + ")");
        }
    }

    public void drawLines(float[] pts, Paint paint) {
        peer.drawLines(pts, paint);
        if (debug) {
            Log.d(tag, "drawLines(" + Arrays.toString(pts) + "," + paint + ")");
        }
    }

    public void drawRect(RectF rect, Paint paint) {
        peer.drawRect(rect, paint);
        if (debug) {
            Log.d(tag, "drawRect(" + rect + "," + paint + ")");
        }
    }

    public void drawRect(Rect r, Paint paint) {
        peer.drawRect(r, paint);
        if (debug) {
            Log.d(tag, "drawRect(" + r + "," + paint + ")");
        }

    }

    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        peer.drawRect(left, top, right, bottom, paint);
        if (debug) {
            Log.d(tag, "drawRect(" + left + "," + top + "," + right + "," + bottom + "," + paint + ")");
        }
    }

    public void drawOval(RectF oval, Paint paint) {
        peer.drawOval(oval, paint);
        if (debug) {
            Log.d(tag, "drawOval(" + oval + "," + paint + ")");
        }
    }

    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        peer.drawCircle(cx, cy, radius, paint);
        if (debug) {
            Log.d(tag, "drawCircle(" + cx + "," + cy + "," + radius + "," + paint + ")");
        }
    }

    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        peer.drawArc(oval, startAngle, sweepAngle, useCenter, paint);
        if (debug) {
            Log.d(tag, "drawArc(" + oval + "," + startAngle + "," + sweepAngle + "," + useCenter + "," + paint + ")");
        }
    }

    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        peer.drawRoundRect(rect, rx, ry, paint);
        if (debug) {
            Log.d(tag, "drawRoundRect(" + rect + "," + rx + "," + ry + "," + paint + ")");
        }
    }

    public void drawPath(Path path, Paint paint) {
        peer.drawPath(path, paint);
        if (debug) {
            Log.d(tag, "drawPath(" + path + "," + paint + ")");
        }
    }

    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        peer.drawBitmap(bitmap, left, top, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + bitmap + "," + left + "," + top + "," + paint + ")");
        }
    }

    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        peer.drawBitmap(bitmap, src, dst, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + bitmap + "," + src + "," + dst + "," + paint + ")");
        }
    }

    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        peer.drawBitmap(bitmap, src, dst, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + bitmap + "," + src + "," + dst + "," + paint + ")");
        }
    }

    public void drawBitmap(int[] colors, int offset, int stride, float x, float y, int width, int height, boolean hasAlpha, Paint paint) {
        peer.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + Arrays.toString(colors) + "," + offset + "," + stride + "," + x + "," + y + "," + width + "," + height + "," + hasAlpha + "," + paint + ")");
        }
    }

    public void drawBitmap(int[] colors, int offset, int stride, int x, int y, int width, int height, boolean hasAlpha, Paint paint) {
        peer.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + Arrays.toString(colors) + "," + offset + "," + stride + "," + x + "," + y + "," + width + "," + height + "," + hasAlpha + "," + paint + ")");
        }
    }

    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        peer.drawBitmap(bitmap, matrix, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + bitmap + "," + matrix + "," + paint + ")");
        }
    }

    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts, int vertOffset, int[] colors, int colorOffset, Paint paint) {
        peer.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset, paint);
        if (debug) {
            Log.d(tag, "drawBitmapMesh(" + bitmap + "," + meshWidth + "," + meshHeight + "," + Arrays.toString(verts) + "," + vertOffset + "," + Arrays.toString(colors) + "," + colorOffset + "," + paint + ")");
        }
    }

    public void drawVertices(Canvas.VertexMode mode, int vertexCount, float[] verts, int vertOffset, float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices, int indexOffset, int indexCount, Paint paint) {
        peer.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors, colorOffset, indices, indexOffset, indexCount, paint);
        if(debug) {
            Log.d(tag, "drawVertices("+mode+","+vertexCount+","+Arrays.toString(verts)+","+vertOffset+","+Arrays.toString(texs)+","+texOffset+","+Arrays.toString(colors)+","+colorOffset+","+Arrays.toString(indices)+","+indexOffset+","+indexCount+","+paint+")");
        }
    }

    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        peer.drawText(text, index, count, x, y, paint);
        if(debug) {
            Log.d(tag, "drawText("+Arrays.toString(text)+","+index+","+count+","+x+","+y+","+paint+")");
        }
    }

    public void drawText(String s, float v, float v2, Paint paint) {
        peer.drawText(s, v, v2, paint);
        if(debug) {
            Log.d(tag, "drawText("+s+","+v+","+v2+","+paint+")");
        }
    }

    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        peer.drawText(text, start, end, x, y, paint);
        if(debug) {
            Log.d(tag, "drawText("+text+","+start+","+end+","+x+","+y+","+paint+")");
        }
    }

    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        peer.drawText(text, start, end, x, y, paint);
        if(debug) {
            Log.d(tag, "drawText("+text+","+start+","+end+","+x+","+y+","+paint+")");
        }
    }

    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        peer.drawPosText(text, index, count, pos, paint);
        if(debug) {
            Log.d(tag, "drawPosText("+Arrays.toString(text)+","+index+","+count+","+Arrays.toString(pos)+","+paint+")");
        }
    }

    public void drawPosText(String text, float[] pos, Paint paint) {
        peer.drawPosText(text, pos, paint);
        if(debug) {
            Log.d(tag, "drawPosText("+text+","+Arrays.toString(pos)+","+paint+")");
        }
    }

    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint) {
        peer.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        if(debug) {
            Log.d(tag, "drawTextOnPath("+Arrays.toString(text)+","+index+","+count+","+path+","+hOffset+","+vOffset+","+paint+")");
        }
    }

    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        peer.drawTextOnPath(text, path, hOffset, vOffset, paint);
        if(debug) {
            Log.d(tag, "drawTextOnPath("+text+","+path+","+hOffset+","+vOffset+","+paint+")");
        }
    }

    public void drawPicture(Picture picture) {
        peer.drawPicture(picture);
        if(debug) {
            Log.d(tag, "drawPicture("+picture+")");
        }
    }

    public void drawPicture(Picture picture, RectF dst) {
        peer.drawPicture(picture, dst);
        if(debug) {
            Log.d(tag, "drawPicture("+picture+","+dst+")");
        }
    }

    public void drawPicture(Picture picture, Rect dst) {
        peer.drawPicture(picture, dst);
        if(debug) {
            Log.d(tag,"drawPicture("+picture+","+dst+")");
        }
    }
}