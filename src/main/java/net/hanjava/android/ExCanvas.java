package net.hanjava.android;


import android.graphics.*;
import android.util.Log;

import javax.microedition.khronos.opengles.GL;
import java.util.Arrays;

/**
 * Extended Canvas implemented in delegation.
 * use <code>ExCanvas.getExCanvas(Canvas)</code> to wrap a given Canvas object with ExCanvas instance.
 * the javadoc comments are copied from original <code>Canvas.java</code>
 * @author Alan Goo
 */
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

    /**
     * Specify a bitmap for the canvas to draw into.  As a side-effect, also
     * updates the canvas's target density to match that of the bitmap.
     *
     * @param bitmap Specifies a mutable bitmap for the canvas to draw into.
     *
     * @see #setDensity(int)
     * @see #getDensity()
     */
    @Override
    public void setBitmap(Bitmap bitmap) {
        peer.setBitmap(bitmap);
        if (debug) {
            Log.d(tag, "setBitmap(" + bitmap + ")");
        }
    }

    /**
     * Return true if the device that the current layer draws into is opaque
     * (i.e. does not support per-pixel alpha).
     */
    @Override
    public boolean isOpaque() {
        final boolean result = peer.isOpaque();
        if (debug) {
            Log.d(tag, "isOpaque():" + result);
        }
        return result;
    }

    /**
     * Returns the width of the current drawing layer
     */
    @Override
    public int getWidth() {
        final int result = peer.getWidth();
        if (debug) {
            Log.d(tag, "getWidth():" + result);
        }
        return result;
    }

    /**
     * Returns the height of the current drawing layer
     */
    @Override
    public int getHeight() {
        final int result = peer.getHeight();
        if (debug) {
            Log.d(tag, "getHeight():" + result);
        }
        return result;
    }

    /**
     * <p>Returns the target density of the canvas.  The default density is
     * derived from the density of its backing bitmap, or
     * {@link Bitmap#DENSITY_NONE} if there is not one.</p>
     *
     * @return Returns the current target density of the canvas, which is used
     * to determine the scaling factor when drawing a bitmap into it.
     *
     * @see #setDensity(int)
     * @see Bitmap#getDensity()
     */
    @Override
    public int getDensity() {
        final int result = peer.getDensity();
        if (debug) {
            Log.d(tag, "getDensity():" + result);
        }
        return result;
    }

    /**
     * <p>Specifies the density for this Canvas' backing bitmap.  This modifies
     * the target density of the canvas itself, as well as the density of its
     * backing bitmap via {@link Bitmap#setDensity(int) Bitmap.setDensity(int)}.
     *
     * @param density The new target density of the canvas, which is used
     * to determine the scaling factor when drawing a bitmap into it.  Use
     * {@link Bitmap#DENSITY_NONE} to disable bitmap scaling.
     *
     * @see #getDensity()
     * @see Bitmap#setDensity(int)
     */
    @Override
    public void setDensity(int density) {
        peer.setDensity(density);
        if (debug) {
            Log.d(tag, "setDensity(" + density + ")");
        }
    }

    /**
     * Saves the current matrix and clip onto a private stack. Subsequent
     * calls to translate,scale,rotate,skew,concat or clipRect,clipPath
     * will all operate as usual, but when the balancing call to restore()
     * is made, those calls will be forgotten, and the settings that existed
     * before the save() will be reinstated.
     *
     * @return The value to pass to restoreToCount() to balance this save()
     */
    @Override
    public int save() {
        final int result = peer.save();
        if (debug) {
            Log.d(tag, "save():" + result);
        }
        return result;
    }

    /**
     * Based on saveFlags, can save the current matrix and clip onto a private
     * stack. Subsequent calls to translate,scale,rotate,skew,concat or
     * clipRect,clipPath will all operate as usual, but when the balancing
     * call to restore() is made, those calls will be forgotten, and the
     * settings that existed before the save() will be reinstated.
     *
     * @param saveFlags flag bits that specify which parts of the Canvas state
     *                  to save/restore
     * @return The value to pass to restoreToCount() to balance this save()
     */
    @Override
    public int save(int saveFlags) {
        final int result = peer.save(saveFlags);
        if (debug) {
            Log.d(tag, "save(" + saveFlags + "):" + result);
        }
        return result;
    }

    /**
     * This behaves the same as save(), but in addition it allocates an
     * offscreen bitmap. All drawing calls are directed there, and only when
     * the balancing call to restore() is made is that offscreen transfered to
     * the canvas (or the previous layer). Subsequent calls to translate,
     * scale, rotate, skew, concat or clipRect, clipPath all operate on this
     * copy. When the balancing call to restore() is made, this copy is
     * deleted and the previous matrix/clip state is restored.
     *
     * @param bounds May be null. The maximum size the offscreen bitmap
     *               needs to be (in local coordinates)
     * @param paint  This is copied, and is applied to the offscreen when
     *               restore() is called.
     * @param saveFlags  see _SAVE_FLAG constants
     * @return       value to pass to restoreToCount() to balance this save()
     */
    @Override
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        final int result = peer.saveLayer(bounds, paint, saveFlags);
        if (debug) {
            Log.d(tag, "saveLayer(" + bounds + "," + paint + "," + saveFlags + "):" + result);
        }
        return result;
    }

    /**
     * Helper version of saveLayer() that takes 4 values rather than a RectF.
     */
    @Override
    public int saveLayer(float left, float top, float right, float bottom, Paint paint, int saveFlags) {
        final int result = peer.saveLayer(left, top, right, bottom, paint, saveFlags);
        if (debug) {
            Log.d(tag, "saveLayer(" + left + "," + top + "," + right + "," + bottom + "), " + paint + ", " + saveFlags + "):" + result);
        }
        return result;
    }

    /**
     * This behaves the same as save(), but in addition it allocates an
     * offscreen bitmap. All drawing calls are directed there, and only when
     * the balancing call to restore() is made is that offscreen transferred to
     * the canvas (or the previous layer). Subsequent calls to translate,
     * scale, rotate, skew, concat or clipRect, clipPath all operate on this
     * copy. When the balancing call to restore() is made, this copy is
     * deleted and the previous matrix/clip state is restored.
     *
     * @param bounds    The maximum size the offscreen bitmap needs to be
     *                  (in local coordinates)
     * @param alpha     The alpha to apply to the offscreen when when it is drawn during restore()
     * @param saveFlags see _SAVE_FLAG constants
     * @return          value to pass to restoreToCount() to balance this call
     */
    @Override
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        final int result = peer.saveLayerAlpha(bounds, alpha, saveFlags);
        if (debug) {
            Log.d(tag, "saveLayerAlpha(" + bounds + "," + alpha + "," + saveFlags + "):" + result);
        }
        return result;
    }

    /**
     * Helper for saveLayerAlpha() that takes 4 values instead of a RectF.
     */
    @Override
    public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha, int saveFlags) {
        final int result = peer.saveLayerAlpha(left, top, right, bottom, alpha, saveFlags);
        if (debug) {
            Log.d(tag, "saveLayerAlpha(" + left + "," + top + "," + right + "," + bottom + "," + alpha + "," + saveFlags + "):" + result);
        }
        return result;
    }

    /**
     * This call balances a previous call to save(), and is used to remove all
     * modifications to the matrix/clip state since the last save call. It is
     * an error to call restore() more times than save() was called.
     */
    @Override
    public void restore() {
        peer.restore();
        if (debug) {
            Log.d(tag, "restore()");
        }
    }

    /**
     * Returns the number of matrix/clip states on the Canvas' private stack.
     * This will equal # save() calls - # restore() calls.
     */
    @Override
    public int getSaveCount() {
        final int result = peer.getSaveCount();
        if (debug) {
            Log.d(tag, "getSaveCount():" + result);
        }
        return result;
    }

    /**
     * Efficient way to pop any calls to save() that happened after the save
     * count reached saveCount. It is an error for saveCount to be less than 1.
     *
     * Example:
     *    int count = canvas.save();
     *    ... // more calls potentially to save()
     *    canvas.restoreToCount(count);
     *    // now the canvas is back in the same state it was before the initial
     *    // call to save().
     *
     * @param saveCount The save level to restore to.
     */
    @Override
    public void restoreToCount(int saveCount) {
        peer.restoreToCount(saveCount);
        if (debug) {
            Log.d(tag, "restoreToCount(" + saveCount + ")");
        }
    }

    /**
     * Preconcat the current matrix with the specified translation
     *
     * @param dx The distance to translate in X
     * @param dy The distance to translate in Y
     */
    @Override
    public void translate(float dx, float dy) {
        peer.translate(dx, dy);
        if (debug) {
            Log.d(tag, "translate(" + dx + "," + dy + ")");
        }
    }

    /**
     * Preconcat the current matrix with the specified scale.
     *
     * @param sx The amount to scale in X
     * @param sy The amount to scale in Y
     */
    @Override
    public void scale(float sx, float sy) {
        peer.scale(sx, sy);
        if (debug) {
            Log.d(tag, "scale(" + sx + "," + sy + ")");
        }
    }

    /**
     * Preconcat the current matrix with the specified rotation.
     *
     * @param degrees The amount to rotate, in degrees
     */
    @Override
    public void rotate(float degrees) {
        peer.rotate(degrees);
        if (debug) {
            Log.d(tag, "rotate(" + degrees + ")");
        }
    }

    /**
     * Preconcat the current matrix with the specified skew.
     *
     * @param sx The amount to skew in X
     * @param sy The amount to skew in Y
     */
    @Override
    public void skew(float sx, float sy) {
        peer.skew(sx, sy);
        if (debug) {
            Log.d(tag, "skew(" + sx + "," + sy + ")");
        }
    }

    /**
     * Preconcat the current matrix with the specified matrix.
     *
     * @param matrix The matrix to preconcatenate with the current matrix
     */
    @Override
    public void concat(Matrix matrix) {
        peer.concat(matrix);
        if (debug) {
            Log.d(tag, "concat(" + matrix + ")");
        }
    }

    /**
     * Completely replace the current matrix with the specified matrix. If the
     * matrix parameter is null, then the current matrix is reset to identity.
     *
     * <strong>Note:</strong> it is recommended to use {@link #concat(Matrix)},
     * {@link #scale(float, float)}, {@link #translate(float, float)} and
     * {@link #rotate(float)} instead of this method.
     *
     * @param matrix The matrix to replace the current matrix with. If it is
     *               null, set the current matrix to identity.
     *
     * @see #concat(Matrix)
     */
    @Deprecated
    @Override
    public void setMatrix(Matrix matrix) {
        peer.setMatrix(matrix);
        if (debug) {
            Log.d(tag, "setMatrix(" + matrix + ")");
        }
    }

    /**
     * Return, in ctm, the current transformation matrix. This does not alter
     * the matrix in the canvas, but just returns a copy of it.
     */
    @Deprecated
    @Override
    public void getMatrix(Matrix ctm) {
        peer.getMatrix(ctm);
        if (debug) {
            Log.d(tag, "getMatrix(" + ctm + ")");
        }
    }

    /**
     * Modify the current clip with the specified rectangle.
     *
     * @param rect The rect to intersect with the current clip
     * @param op How the clip is modified
     * @return true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(RectF rect, Region.Op op) {
        final boolean result = peer.clipRect(rect, op);
        if (debug) {
            Log.d(tag, "clipRect(" + rect + "," + op + "):" + result);
        }
        return result;
    }

    /**
     * Modify the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param rect The rectangle to intersect with the current clip.
     * @param op How the clip is modified
     * @return true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(Rect rect, Region.Op op) {
        final boolean result = peer.clipRect(rect, op);
        if (debug) {
            Log.d(tag, "clipRect(" + rect + "," + op + "):" + result);
        }
        return result;
    }

    /**
     * Intersect the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param rect The rectangle to intersect with the current clip.
     * @return true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(RectF rect) {
        final boolean result = peer.clipRect(rect);
        if (debug) {
            Log.d(tag, "clipRect(" + rect + "):" + result);
        }
        return result;
    }

    /**
     * Intersect the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param rect The rectangle to intersect with the current clip.
     * @return true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(Rect rect) {
        final boolean result = peer.clipRect(rect);
        if (debug) {
            Log.d(tag, "clipRect(" + rect + "):" + result);
        }
        return result;
    }

    /**
     * Modify the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param left   The left side of the rectangle to intersect with the
     *               current clip
     * @param top    The top of the rectangle to intersect with the current
     *               clip
     * @param right  The right side of the rectangle to intersect with the
     *               current clip
     * @param bottom The bottom of the rectangle to intersect with the current
     *               clip
     * @param op     How the clip is modified
     * @return       true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(float left, float top, float right, float bottom, Region.Op op) {
        final boolean result = peer.clipRect(left, top, right, bottom, op);
        if (debug) {
            Log.d(tag, "clipRect(" + left + "," + top + "," + right + "," + bottom + "," + op + "):" + result);
        }
        return result;
    }

    /**
     * Intersect the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param left   The left side of the rectangle to intersect with the
     *               current clip
     * @param top    The top of the rectangle to intersect with the current clip
     * @param right  The right side of the rectangle to intersect with the
     *               current clip
     * @param bottom The bottom of the rectangle to intersect with the current
     *               clip
     * @return       true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(float left, float top, float right, float bottom) {
        final boolean result = peer.clipRect(left, top, right, bottom);
        if (debug) {
            Log.d(tag, "clipRect(" + left + "," + top + "," + right + "," + bottom + "):" + result);
        }
        return result;
    }

    /**
     * Intersect the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param left   The left side of the rectangle to intersect with the
     *               current clip
     * @param top    The top of the rectangle to intersect with the current clip
     * @param right  The right side of the rectangle to intersect with the
     *               current clip
     * @param bottom The bottom of the rectangle to intersect with the current
     *               clip
     * @return       true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(int left, int top, int right, int bottom) {
        final boolean result = peer.clipRect(left, top, right, bottom);
        if (debug) {
            Log.d(tag, "clipRect(" + left + "," + top + "," + right + "," + bottom + "):" + result);
        }
        return result;
    }

    /**
     * Modify the current clip with the specified path.
     *
     * @param path The path to operate on the current clip
     * @param op   How the clip is modified
     * @return     true if the resulting is non-empty
     */
    @Override
    public boolean clipPath(Path path, Region.Op op) {
        final boolean result = peer.clipPath(path, op);
        if (debug) {
            Log.d(tag, "clipPath(" + path + "," + op + "):" + result);
        }
        return result;
    }

    /**
     * Intersect the current clip with the specified path.
     *
     * @param path The path to intersect with the current clip
     * @return     true if the resulting is non-empty
     */
    @Override
    public boolean clipPath(Path path) {
        final boolean result = peer.clipPath(path);
        if (debug) {
            Log.d(tag, "clipPath(" + path + "):" + result);
        }
        return result;
    }

    /**
     * Modify the current clip with the specified region. Note that unlike
     * clipRect() and clipPath() which transform their arguments by the
     * current matrix, clipRegion() assumes its argument is already in the
     * coordinate system of the current layer's bitmap, and so not
     * transformation is performed.
     *
     * @param region The region to operate on the current clip, based on op
     * @param op How the clip is modified
     * @return true if the resulting is non-empty
     */
    @Override
    public boolean clipRegion(Region region, Region.Op op) {
        final boolean result = peer.clipRegion(region, op);
        if (debug) {
            Log.d(tag, "clipRegion(" + region + "," + op + "):" + result);
        }
        return result;
    }

    /**
     * Intersect the current clip with the specified region. Note that unlike
     * clipRect() and clipPath() which transform their arguments by the
     * current matrix, clipRegion() assumes its argument is already in the
     * coordinate system of the current layer's bitmap, and so not
     * transformation is performed.
     *
     * @param region The region to operate on the current clip, based on op
     * @return true if the resulting is non-empty
     */
    @Override
    public boolean clipRegion(Region region) {
        final boolean result = peer.clipRegion(region);
        if (debug) {
            Log.d(tag, "clipRegion(" + region + "):" + result);
        }
        return result;
    }

    @Override
    public DrawFilter getDrawFilter() {
        final DrawFilter result = peer.getDrawFilter();
        if (debug) {
            Log.d(tag, "getDrawFilter():" + result);
        }
        return result;
    }

    @Override
    public void setDrawFilter(DrawFilter filter) {
        peer.setDrawFilter(filter);
        if (debug) {
            Log.d(tag, "setDrawFilter(" + filter + ")");
        }
    }

    /**
     * Return true if the specified rectangle, after being transformed by the
     * current matrix, would lie completely outside of the current clip. Call
     * this to check if an area you intend to draw into is clipped out (and
     * therefore you can skip making the draw calls).
     *
     * @param rect  the rect to compare with the current clip
     * @param type  specifies how to treat the edges (BW or antialiased)
     * @return      true if the rect (transformed by the canvas' matrix)
     *              does not intersect with the canvas' clip
     */
    @Override
    public boolean quickReject(RectF rect, Canvas.EdgeType type) {
        final boolean result = peer.quickReject(rect, type);
        if (debug) {
            Log.d(tag, "quickReject(" + rect + "," + type + "):" + result);
        }
        return result;
    }

    /**
     * Return true if the specified path, after being transformed by the
     * current matrix, would lie completely outside of the current clip. Call
     * this to check if an area you intend to draw into is clipped out (and
     * therefore you can skip making the draw calls). Note: for speed it may
     * return false even if the path itself might not intersect the clip
     * (i.e. the bounds of the path intersects, but the path does not).
     *
     * @param path        The path to compare with the current clip
     * @param type        true if the path should be considered antialiased,
     *                    since that means it may
     *                    affect a larger area (more pixels) than
     *                    non-antialiased.
     * @return            true if the path (transformed by the canvas' matrix)
     *                    does not intersect with the canvas' clip
     */
    @Override
    public boolean quickReject(Path path, Canvas.EdgeType type) {
        final boolean result = peer.quickReject(path, type);
        if (debug) {
            Log.d(tag, "quickReject(" + path + "," + type + "):" + result);
        }
        return result;
    }

    /**
     * Return true if the specified rectangle, after being transformed by the
     * current matrix, would lie completely outside of the current clip. Call
     * this to check if an area you intend to draw into is clipped out (and
     * therefore you can skip making the draw calls).
     *
     * @param left        The left side of the rectangle to compare with the
     *                    current clip
     * @param top         The top of the rectangle to compare with the current
     *                    clip
     * @param right       The right side of the rectangle to compare with the
     *                    current clip
     * @param bottom      The bottom of the rectangle to compare with the
     *                    current clip
     * @param type        true if the rect should be considered antialiased,
     *                    since that means it may affect a larger area (more
     *                    pixels) than non-antialiased.
     * @return            true if the rect (transformed by the canvas' matrix)
     *                    does not intersect with the canvas' clip
     */
    @Override
    public boolean quickReject(float left, float top, float right, float bottom, Canvas.EdgeType type) {
        final boolean result = peer.quickReject(left, top, right, bottom, type);
        if (debug) {
            Log.d(tag, "quickReject(" + left + "," + top + "," + right + "," + bottom + "," + type + "):" + result);
        }
        return result;
    }

    /**
     * Retrieve the clip bounds, returning true if they are non-empty.
     *
     * @param bounds Return the clip bounds here. If it is null, ignore it but
     *               still return true if the current clip is non-empty.
     * @return true if the current clip is non-empty.
     */
    @Override
    public boolean getClipBounds(Rect bounds) {
        final boolean result = peer.getClipBounds(bounds);
        if (debug) {
            Log.d(tag, "getClipBounds(" + bounds + ")");
        }
        return result;
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with the
     * specified RGB color, using srcover porterduff mode.
     *
     * @param r red component (0..255) of the color to draw onto the canvas
     * @param g green component (0..255) of the color to draw onto the canvas
     * @param b blue component (0..255) of the color to draw onto the canvas
     */
    @Override
    public void drawRGB(int r, int g, int b) {
        peer.drawRGB(r, g, b);
        if (debug) {
            Log.d(tag, "drawRGB(" + r + "," + g + "," + b + ")");
        }
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with the
     * specified ARGB color, using srcover porterduff mode.
     *
     * @param a alpha component (0..255) of the color to draw onto the canvas
     * @param r red component (0..255) of the color to draw onto the canvas
     * @param g green component (0..255) of the color to draw onto the canvas
     * @param b blue component (0..255) of the color to draw onto the canvas
     */
    @Override
    public void drawARGB(int a, int r, int g, int b) {
        peer.drawARGB(a, r, g, b);
        if (debug) {
            Log.d(tag, "drawARGB(" + a + "," + r + "," + g + "," + b + ")");
        }
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with the
     * specified color, using srcover porterduff mode.
     *
     * @param color the color to draw onto the canvas
     */
    @Override
    public void drawColor(int color) {
        peer.drawColor(color);
        if (debug) {
            Log.d(tag, "drawColor(" + color + ")");
        }
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with the
     * specified color and porter-duff xfermode.
     *
     * @param color the color to draw with
     * @param mode  the porter-duff mode to apply to the color
     */
    @Override
    public void drawColor(int color, PorterDuff.Mode mode) {
        peer.drawColor(color, mode);
        if (debug) {
            Log.d(tag, "drawColor(" + color + "," + mode + ")");
        }
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with
     * the specified paint. This is equivalent (but faster) to drawing an
     * infinitely large rectangle with the specified paint.
     *
     * @param paint The paint used to draw onto the canvas
     */
    @Override
    public void drawPaint(Paint paint) {
        peer.drawPaint(paint);
        if (debug) {
            Log.d(tag, "drawPaint(" + paint + ")");
        }
    }

    /**
     * Draw a series of points. Each point is centered at the coordinate
     * specified by pts[], and its diameter is specified by the paint's stroke
     * width (as transformed by the canvas' CTM), with special treatment for
     * a stroke width of 0, which always draws exactly 1 pixel (or at most 4
     * if antialiasing is enabled). The shape of the point is controlled by
     * the paint's Cap type. The shape is a square, unless the cap type is
     * Round, in which case the shape is a circle.
     *
     * @param pts      Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
     * @param offset   Number of values to skip before starting to draw.
     * @param count    The number of values to process, after skipping offset
     *                 of them. Since one point uses two values, the number of
     *                 "points" that are drawn is really (count >> 1).
     * @param paint    The paint used to draw the points
     */
    @Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        peer.drawPoints(pts, offset, count, paint);
        if (debug) {
            Log.d(tag, "drawPoints(" + Arrays.toString(pts) + "," + offset + "," + count + "," + paint);
        }
    }

    /**
     * Helper for drawPoints() that assumes you want to draw the entire array
     */
    @Override
    public void drawPoints(float[] pts, Paint paint) {
        peer.drawPoints(pts, paint);
        if (debug) {
            Log.d(tag, "drawPoints(" + Arrays.toString(pts) + "," + paint + ")");
        }
    }

    /**
     * Helper for drawPoints() for drawing a single point.
     */
    @Override
    public void drawPoint(float v, float v2, Paint paint) {
        peer.drawPoint(v, v2, paint);
        if (debug) {
            Log.d(tag, "drawPoint(" + v + "," + v2 + "," + paint);
        }
    }

    /**
     * Draw a line segment with the specified start and stop x,y coordinates,
     * using the specified paint. NOTE: since a line is always "framed", the
     * Style is ignored in the paint.
     *
     * @param startX The x-coordinate of the start point of the line
     * @param startY The y-coordinate of the start point of the line
     * @param paint  The paint used to draw the line
     */
    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        peer.drawLine(startX, startY, stopX, stopY, paint);
        if (debug) {
            Log.d(tag, "drawLine(" + startX + "," + startY + "," + stopX + "," + stopY + "," + paint + ")");
        }
    }

    /**
     * Draw a series of lines. Each line is taken from 4 consecutive values
     * in the pts array. Thus to draw 1 line, the array must contain at least 4
     * values. This is logically the same as drawing the array as follows:
     * drawLine(pts[0], pts[1], pts[2], pts[3]) followed by
     * drawLine(pts[4], pts[5], pts[6], pts[7]) and so on.
     *
     * @param pts      Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
     * @param offset   Number of values in the array to skip before drawing.
     * @param count    The number of values in the array to process, after
     *                 skipping "offset" of them. Since each line uses 4 values,
     *                 the number of "lines" that are drawn is really
     *                 (count >> 2).
     * @param paint    The paint used to draw the points
     */
    @Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        peer.drawLines(pts, offset, count, paint);
        if (debug) {
            Log.d(tag, "drawLines(" + Arrays.toString(pts) + "," + offset + "," + count + "," + paint + ")");
        }
    }

    @Override
    public void drawLines(float[] pts, Paint paint) {
        peer.drawLines(pts, paint);
        if (debug) {
            Log.d(tag, "drawLines(" + Arrays.toString(pts) + "," + paint + ")");
        }
    }

    /**
     * Draw the specified Rect using the specified paint. The rectangle will
     * be filled or framed based on the Style in the paint.
     *
     * @param rect  The rect to be drawn
     * @param paint The paint used to draw the rect
     */
    @Override
    public void drawRect(RectF rect, Paint paint) {
        peer.drawRect(rect, paint);
        if (debug) {
            Log.d(tag, "drawRect(" + rect + "," + paint + ")");
        }
    }

    /**
     * Draw the specified Rect using the specified Paint. The rectangle
     * will be filled or framed based on the Style in the paint.
     *
     * @param r        The rectangle to be drawn.
     * @param paint    The paint used to draw the rectangle
     */
    @Override
    public void drawRect(Rect r, Paint paint) {
        peer.drawRect(r, paint);
        if (debug) {
            Log.d(tag, "drawRect(" + r + "," + paint + ")");
        }

    }

    /**
     * Draw the specified Rect using the specified paint. The rectangle will
     * be filled or framed based on the Style in the paint.
     *
     * @param left   The left side of the rectangle to be drawn
     * @param top    The top side of the rectangle to be drawn
     * @param right  The right side of the rectangle to be drawn
     * @param bottom The bottom side of the rectangle to be drawn
     * @param paint  The paint used to draw the rect
     */
    @Override
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        peer.drawRect(left, top, right, bottom, paint);
        if (debug) {
            Log.d(tag, "drawRect(" + left + "," + top + "," + right + "," + bottom + "," + paint + ")");
        }
    }

    /**
     * Draw the specified oval using the specified paint. The oval will be
     * filled or framed based on the Style in the paint.
     *
     * @param oval The rectangle bounds of the oval to be drawn
     */
    @Override
    public void drawOval(RectF oval, Paint paint) {
        peer.drawOval(oval, paint);
        if (debug) {
            Log.d(tag, "drawOval(" + oval + "," + paint + ")");
        }
    }

    /**
     * Draw the specified circle using the specified paint. If radius is <= 0,
     * then nothing will be drawn. The circle will be filled or framed based
     * on the Style in the paint.
     *
     * @param cx     The x-coordinate of the center of the cirle to be drawn
     * @param cy     The y-coordinate of the center of the cirle to be drawn
     * @param radius The radius of the cirle to be drawn
     * @param paint  The paint used to draw the circle
     */
    @Override
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        peer.drawCircle(cx, cy, radius, paint);
        if (debug) {
            Log.d(tag, "drawCircle(" + cx + "," + cy + "," + radius + "," + paint + ")");
        }
    }

    /**
     * <p>Draw the specified arc, which will be scaled to fit inside the
     * specified oval.</p>
     *
     * <p>If the start angle is negative or >= 360, the start angle is treated
     * as start angle modulo 360.</p>
     *
     * <p>If the sweep angle is >= 360, then the oval is drawn
     * completely. Note that this differs slightly from SkPath::arcTo, which
     * treats the sweep angle modulo 360. If the sweep angle is negative,
     * the sweep angle is treated as sweep angle modulo 360</p>
     *
     * <p>The arc is drawn clockwise. An angle of 0 degrees correspond to the
     * geometric angle of 0 degrees (3 o'clock on a watch.)</p>
     *
     * @param oval       The bounds of oval used to define the shape and size
     *                   of the arc
     * @param startAngle Starting angle (in degrees) where the arc begins
     * @param sweepAngle Sweep angle (in degrees) measured clockwise
     * @param useCenter If true, include the center of the oval in the arc, and close it if it is being stroked. This will draw a wedge
     * @param paint      The paint used to draw the arc
     */
    @Override
    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        peer.drawArc(oval, startAngle, sweepAngle, useCenter, paint);
        if (debug) {
            Log.d(tag, "drawArc(" + oval + "," + startAngle + "," + sweepAngle + "," + useCenter + "," + paint + ")");
        }
    }

    /**
     * Draw the specified round-rect using the specified paint. The roundrect
     * will be filled or framed based on the Style in the paint.
     *
     * @param rect  The rectangular bounds of the roundRect to be drawn
     * @param rx    The x-radius of the oval used to round the corners
     * @param ry    The y-radius of the oval used to round the corners
     * @param paint The paint used to draw the roundRect
     */
    @Override
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        peer.drawRoundRect(rect, rx, ry, paint);
        if (debug) {
            Log.d(tag, "drawRoundRect(" + rect + "," + rx + "," + ry + "," + paint + ")");
        }
    }

    /**
     * Draw the specified path using the specified paint. The path will be
     * filled or framed based on the Style in the paint.
     *
     * @param path  The path to be drawn
     * @param paint The paint used to draw the path
     */
    @Override
    public void drawPath(Path path, Paint paint) {
        peer.drawPath(path, paint);
        if (debug) {
            Log.d(tag, "drawPath(" + path + "," + paint + ")");
        }
    }

    /**
     * Draw the specified bitmap, with its top/left corner at (x,y), using
     * the specified paint, transformed by the current matrix.
     *
     * <p>Note: if the paint contains a maskfilter that generates a mask which
     * extends beyond the bitmap's original width/height (e.g. BlurMaskFilter),
     * then the bitmap will be drawn as if it were in a Shader with CLAMP mode.
     * Thus the color outside of the original width/height will be the edge
     * color replicated.
     *
     * <p>If the bitmap and canvas have different densities, this function
     * will take care of automatically scaling the bitmap to draw at the
     * same density as the canvas.
     *
     * @param bitmap The bitmap to be drawn
     * @param left   The position of the left side of the bitmap being drawn
     * @param top    The position of the top side of the bitmap being drawn
     * @param paint  The paint used to draw the bitmap (may be null)
     */
    @Override
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        peer.drawBitmap(bitmap, left, top, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + bitmap + "," + left + "," + top + "," + paint + ")");
        }
    }

    /**
     * Draw the specified bitmap, scaling/translating automatically to fill
     * the destination rectangle. If the source rectangle is not null, it
     * specifies the subset of the bitmap to draw.
     *
     * <p>Note: if the paint contains a maskfilter that generates a mask which
     * extends beyond the bitmap's original width/height (e.g. BlurMaskFilter),
     * then the bitmap will be drawn as if it were in a Shader with CLAMP mode.
     * Thus the color outside of the original width/height will be the edge
     * color replicated.
     *
     * <p>This function <em>ignores the density associated with the bitmap</em>.
     * This is because the source and destination rectangle coordinate
     * spaces are in their respective densities, so must already have the
     * appropriate scaling factor applied.
     *
     * @param bitmap The bitmap to be drawn
     * @param src    May be null. The subset of the bitmap to be drawn
     * @param dst    The rectangle that the bitmap will be scaled/translated
     *               to fit into
     * @param paint  May be null. The paint used to draw the bitmap
     */
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        peer.drawBitmap(bitmap, src, dst, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + bitmap + "," + src + "," + dst + "," + paint + ")");
        }
    }

    /**
     * Draw the specified bitmap, scaling/translating automatically to fill
     * the destination rectangle. If the source rectangle is not null, it
     * specifies the subset of the bitmap to draw.
     *
     * <p>Note: if the paint contains a maskfilter that generates a mask which
     * extends beyond the bitmap's original width/height (e.g. BlurMaskFilter),
     * then the bitmap will be drawn as if it were in a Shader with CLAMP mode.
     * Thus the color outside of the original width/height will be the edge
     * color replicated.
     *
     * <p>This function <em>ignores the density associated with the bitmap</em>.
     * This is because the source and destination rectangle coordinate
     * spaces are in their respective densities, so must already have the
     * appropriate scaling factor applied.
     *
     * @param bitmap The bitmap to be drawn
     * @param src    May be null. The subset of the bitmap to be drawn
     * @param dst    The rectangle that the bitmap will be scaled/translated
     *               to fit into
     * @param paint  May be null. The paint used to draw the bitmap
     */
    @Override
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        peer.drawBitmap(bitmap, src, dst, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + bitmap + "," + src + "," + dst + "," + paint + ")");
        }
    }

    /**
     * Treat the specified array of colors as a bitmap, and draw it. This gives
     * the same result as first creating a bitmap from the array, and then
     * drawing it, but this method avoids explicitly creating a bitmap object
     * which can be more efficient if the colors are changing often.
     *
     * @param colors Array of colors representing the pixels of the bitmap
     * @param offset Offset into the array of colors for the first pixel
     * @param stride The number of colors in the array between rows (must be
     *               >= width or <= -width).
     * @param x The X coordinate for where to draw the bitmap
     * @param y The Y coordinate for where to draw the bitmap
     * @param width The width of the bitmap
     * @param height The height of the bitmap
     * @param hasAlpha True if the alpha channel of the colors contains valid
     *                 values. If false, the alpha byte is ignored (assumed to
     *                 be 0xFF for every pixel).
     * @param paint  May be null. The paint used to draw the bitmap
     */
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y, int width, int height, boolean hasAlpha, Paint paint) {
        peer.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + Arrays.toString(colors) + "," + offset + "," + stride + "," + x + "," + y + "," + width + "," + height + "," + hasAlpha + "," + paint + ")");
        }
    }

    /** Legacy version of drawBitmap(int[] colors, ...) that took ints for x,y
     */
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y, int width, int height, boolean hasAlpha, Paint paint) {
        peer.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + Arrays.toString(colors) + "," + offset + "," + stride + "," + x + "," + y + "," + width + "," + height + "," + hasAlpha + "," + paint + ")");
        }
    }

    /**
     * Draw the bitmap using the specified matrix.
     *
     * @param bitmap The bitmap to draw
     * @param matrix The matrix used to transform the bitmap when it is drawn
     * @param paint  May be null. The paint used to draw the bitmap
     */
    @Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        peer.drawBitmap(bitmap, matrix, paint);
        if (debug) {
            Log.d(tag, "drawBitmap(" + bitmap + "," + matrix + "," + paint + ")");
        }
    }

    /**
     * Draw the bitmap through the mesh, where mesh vertices are evenly
     * distributed across the bitmap. There are meshWidth+1 vertices across, and
     * meshHeight+1 vertices down. The verts array is accessed in row-major
     * order, so that the first meshWidth+1 vertices are distributed across the
     * top of the bitmap from left to right. A more general version of this
     * methid is drawVertices().
     *
     * @param bitmap The bitmap to draw using the mesh
     * @param meshWidth The number of columns in the mesh. Nothing is drawn if
     *                  this is 0
     * @param meshHeight The number of rows in the mesh. Nothing is drawn if
     *                   this is 0
     * @param verts Array of x,y pairs, specifying where the mesh should be
     *              drawn. There must be at least
     *              (meshWidth+1) * (meshHeight+1) * 2 + meshOffset values
     *              in the array
     * @param vertOffset Number of verts elements to skip before drawing
     * @param colors May be null. Specifies a color at each vertex, which is
     *               interpolated across the cell, and whose values are
     *               multiplied by the corresponding bitmap colors. If not null,
     *               there must be at least (meshWidth+1) * (meshHeight+1) +
     *               colorOffset values in the array.
     * @param colorOffset Number of color elements to skip before drawing
     * @param paint  May be null. The paint used to draw the bitmap
     */
    @Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts, int vertOffset, int[] colors, int colorOffset, Paint paint) {
        peer.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset, paint);
        if (debug) {
            Log.d(tag, "drawBitmapMesh(" + bitmap + "," + meshWidth + "," + meshHeight + "," + Arrays.toString(verts) + "," + vertOffset + "," + Arrays.toString(colors) + "," + colorOffset + "," + paint + ")");
        }
    }

    /**
     * Draw the array of vertices, interpreted as triangles (based on mode). The
     * verts array is required, and specifies the x,y pairs for each vertex. If
     * texs is non-null, then it is used to specify the coordinate in shader
     * coordinates to use at each vertex (the paint must have a shader in this
     * case). If there is no texs array, but there is a color array, then each
     * color is interpolated across its corresponding triangle in a gradient. If
     * both texs and colors arrays are present, then they behave as before, but
     * the resulting color at each pixels is the result of multiplying the
     * colors from the shader and the color-gradient together. The indices array
     * is optional, but if it is present, then it is used to specify the index
     * of each triangle, rather than just walking through the arrays in order.
     *
     * @param mode How to interpret the array of vertices
     * @param vertexCount The number of values in the vertices array (and
     *      corresponding texs and colors arrays if non-null). Each logical
     *      vertex is two values (x, y), vertexCount must be a multiple of 2.
     * @param verts Array of vertices for the mesh
     * @param vertOffset Number of values in the verts to skip before drawing.
     * @param texs May be null. If not null, specifies the coordinates to sample
     *      into the current shader (e.g. bitmap tile or gradient)
     * @param texOffset Number of values in texs to skip before drawing.
     * @param colors May be null. If not null, specifies a color for each
     *      vertex, to be interpolated across the triangle.
     * @param colorOffset Number of values in colors to skip before drawing.
     * @param indices If not null, array of indices to reference into the
     *      vertex (texs, colors) array.
     * @param indexCount number of entries in the indices array (if not null).
     * @param paint Specifies the shader to use if the texs array is non-null.
     */
    @Override
    public void drawVertices(Canvas.VertexMode mode, int vertexCount, float[] verts, int vertOffset, float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices, int indexOffset, int indexCount, Paint paint) {
        peer.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors, colorOffset, indices, indexOffset, indexCount, paint);
        if(debug) {
            Log.d(tag, "drawVertices("+mode+","+vertexCount+","+Arrays.toString(verts)+","+vertOffset+","+Arrays.toString(texs)+","+texOffset+","+Arrays.toString(colors)+","+colorOffset+","+Arrays.toString(indices)+","+indexOffset+","+indexCount+","+paint+")");
        }
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint. The
     * origin is interpreted based on the Align setting in the paint.
     *
     * @param text  The text to be drawn
     * @param x     The x-coordinate of the origin of the text being drawn
     * @param y     The y-coordinate of the origin of the text being drawn
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        peer.drawText(text, index, count, x, y, paint);
        if(debug) {
            Log.d(tag, "drawText("+Arrays.toString(text)+","+index+","+count+","+x+","+y+","+paint+")");
        }
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint. The
     * origin is interpreted based on the Align setting in the paint.
     *
     * @param text  The text to be drawn
     * @param x     The x-coordinate of the origin of the text being drawn
     * @param y     The y-coordinate of the origin of the text being drawn
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawText(String text, float x, float y, Paint paint) {
        peer.drawText(text, x, y, paint);
        if(debug) {
            Log.d(tag, "drawText("+text+","+x+","+y+","+paint+")");
        }
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint.
     * The origin is interpreted based on the Align setting in the paint.
     *
     * @param text  The text to be drawn
     * @param start The index of the first character in text to draw
     * @param end   (end - 1) is the index of the last character in text to draw
     * @param x     The x-coordinate of the origin of the text being drawn
     * @param y     The y-coordinate of the origin of the text being drawn
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        peer.drawText(text, start, end, x, y, paint);
        if(debug) {
            Log.d(tag, "drawText("+text+","+start+","+end+","+x+","+y+","+paint+")");
        }
    }

    /**
     * Draw the specified range of text, specified by start/end, with its
     * origin at (x,y), in the specified Paint. The origin is interpreted
     * based on the Align setting in the Paint.
     *
     * @param text     The text to be drawn
     * @param start    The index of the first character in text to draw
     * @param end      (end - 1) is the index of the last character in text
     *                 to draw
     * @param x        The x-coordinate of origin for where to draw the text
     * @param y        The y-coordinate of origin for where to draw the text
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        peer.drawText(text, start, end, x, y, paint);
        if(debug) {
            Log.d(tag, "drawText("+text+","+start+","+end+","+x+","+y+","+paint+")");
        }
    }

    /**
     * Draw the text in the array, with each character's origin specified by
     * the pos array.
     *
     * This method does not support glyph composition and decomposition and
     * should therefore not be used to render complex scripts.
     *
     * @param text     The text to be drawn
     * @param index    The index of the first character to draw
     * @param count    The number of characters to draw, starting from index.
     * @param pos      Array of [x,y] positions, used to position each
     *                 character
     * @param paint    The paint used for the text (e.g. color, size, style)
     */
    @Deprecated
    @Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        peer.drawPosText(text, index, count, pos, paint);
        if(debug) {
            Log.d(tag, "drawPosText("+Arrays.toString(text)+","+index+","+count+","+Arrays.toString(pos)+","+paint+")");
        }
    }

    /**
     * Draw the text in the array, with each character's origin specified by
     * the pos array.
     *
     * This method does not support glyph composition and decomposition and
     * should therefore not be used to render complex scripts.
     *
     * @param text  The text to be drawn
     * @param pos   Array of [x,y] positions, used to position each character
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @Deprecated
    @Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        peer.drawPosText(text, pos, paint);
        if(debug) {
            Log.d(tag, "drawPosText("+text+","+Arrays.toString(pos)+","+paint+")");
        }
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint, along
     * the specified path. The paint's Align setting determins where along the
     * path to start the text.
     *
     * @param text     The text to be drawn
     * @param path     The path the text should follow for its baseline
     * @param hOffset  The distance along the path to add to the text's
     *                 starting position
     * @param vOffset  The distance above(-) or below(+) the path to position
     *                 the text
     * @param paint    The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint) {
        peer.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        if(debug) {
            Log.d(tag, "drawTextOnPath("+Arrays.toString(text)+","+index+","+count+","+path+","+hOffset+","+vOffset+","+paint+")");
        }
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint, along
     * the specified path. The paint's Align setting determins where along the
     * path to start the text.
     *
     * @param text     The text to be drawn
     * @param path     The path the text should follow for its baseline
     * @param hOffset  The distance along the path to add to the text's
     *                 starting position
     * @param vOffset  The distance above(-) or below(+) the path to position
     *                 the text
     * @param paint    The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        peer.drawTextOnPath(text, path, hOffset, vOffset, paint);
        if(debug) {
            Log.d(tag, "drawTextOnPath("+text+","+path+","+hOffset+","+vOffset+","+paint+")");
        }
    }

    /**
     * Save the canvas state, draw the picture, and restore the canvas state.
     * This differs from picture.draw(canvas), which does not perform any
     * save/restore.
     *
     * @param picture  The picture to be drawn
     */
    @Override
    public void drawPicture(Picture picture) {
        peer.drawPicture(picture);
        if(debug) {
            Log.d(tag, "drawPicture("+picture+")");
        }
    }

    /**
     * Draw the picture, stretched to fit into the dst rectangle.
     */
    @Override
    public void drawPicture(Picture picture, RectF dst) {
        peer.drawPicture(picture, dst);
        if(debug) {
            Log.d(tag, "drawPicture("+picture+","+dst+")");
        }
    }

    /**
     * Draw the picture, stretched to fit into the dst rectangle.
     */
    @Override
    public void drawPicture(Picture picture, Rect dst) {
        peer.drawPicture(picture, dst);
        if(debug) {
            Log.d(tag,"drawPicture("+picture+","+dst+")");
        }
    }
}