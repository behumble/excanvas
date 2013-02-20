package com.thinkfree.android.excanvas.replay;

import android.graphics.*;
import com.thinkfree.android.excanvas.ExCanvas;

import java.util.ArrayList;
import java.util.List;

/**
 * an ExCanvas recording mutation operations.
 */
public class ReplayableCanvas extends ExCanvas {
    public static final int ID_SET_BITMAP_Bitmap = 0;
    public static final int ID_SET_DENSITY = 1;
    public static final int ID_SAVE = 2;
    public static final int ID_SAVE_int = 3;
    public static final int ID_SAVE_LAYER_RectF_Paint_int = 4;
    public static final int ID_SAVE_LAYER_float_float_float_float_Paint_int = 5;
    public static final int ID_SAVE_LAYER_ALPHA_RectF_int_int = 6;
    public static final int ID_SAVE_LAYER_ALPHA_float_float_float_float_int_int = 7;
    public static final int ID_RESTORE = 8;
    public static final int ID_RESTORE_TO_COUNT_int = 9;
    public static final int ID_TRANSLATE_float_float = 10;
    public static final int ID_SCALE_float_float = 11;
    public static final int ID_ROTATE_float = 12;
    public static final int ID_SKEW_float_float = 13;
    public static final int ID_CONCAT_Matrix = 14;
    public static final int ID_SET_MATRIX_Matrix = 15;
    public static final int ID_CLIP_RECT_RectF_Op = 16;
    public static final int ID_CLIP_RECT_Rect_Op = 17;
    public static final int ID_CLIP_RECT_RectF = 18;
    public static final int ID_CLIP_RECT_Rect = 19;
    public static final int ID_CLIP_RECT_float_float_float_float_Op = 20;
    public static final int ID_CLIP_RECT_float_float_float_float = 21;
    public static final int ID_CLIP_RECT_int_int_int_int = 22;
    public static final int ID_CLIP_PATH_Path_Op = 23;
    public static final int ID_CLIP_PATH_Path = 24;
    public static final int ID_CLIP_REGION_Region_Op = 25;
    public static final int ID_CLIP_REGION_Region = 26;
    public static final int ID_SET_DRAW_FILTER_DrawFilter = 27;
    public static final int ID_DRAW_RGB_int_int_int = 28;
    public static final int ID_DRAW_ARGB_int_int_int_int = 29;
    public static final int ID_DRAW_COLOR_int = 30;
    public static final int ID_DRAW_COLOR_int_Mode = 31;
    public static final int ID_DRAW_PAINT_Paint = 32;
    public static final int ID_DRAW_POINTS_floats_int_int_Paint = 33;
    public static final int ID_DRAW_POINTS_floats_Paint = 34;
    public static final int ID_DRAW_POINT_float_float_Paint = 35;
    public static final int ID_DRAW_LINE_float_float_float_float_Paint = 36;
    public static final int ID_DRAW_LINES_floats_int_int_Paint = 37;
    public static final int ID_DRAW_LINES_floats_Paint = 38;
    public static final int ID_DRAW_RECT_RectF_Paint = 39;
    public static final int ID_DRAW_RECT_Rect_Paint = 40;
    public static final int ID_DRAW_RECT_float_float_float_float_Paint = 41;
    public static final int ID_DRAW_OVAL_RectF_Paint = 42;
    public static final int ID_DRAW_CIRCLE_float_float_float_Paint = 43;
    public static final int ID_DRAW_ARC_RectF_float_float_boolean_Paint = 44;
    public static final int ID_DRAW_ROUND_RECT_RectF_float_float_Paint = 45;
    public static final int ID_DRAW_PATH_Path_Paint = 46;
    public static final int ID_DRAW_BITMAP_Bitmap_float_float_Paint = 47;
    public static final int ID_DRAW_BITMAP_Bitmap_Rect_RectF_Paint = 48;
    public static final int ID_DRAW_BITMAP_Bitmap_Rect_Rect_Paint = 49;
    public static final int ID_DRAW_BITMAP_ints_int_int_float_float_int_int_boolean_Paint = 50;
    public static final int ID_DRAW_BITMAP_ints_int_int_int_int_int_int_boolean_Paint = 51;
    public static final int ID_DRAW_BITMAP_Bitmap_Matrix_Paint = 52;
    public static final int ID_DRAW_BITMAP_MESH_Bitmap_int_int_floats_int_ints_int_Paint = 53;
    public static final int ID_DRAW_VERTICES_VertexMode_int_floats_int_floats_int_ints_int_shorts_int_int_Paint = 54;
    public static final int ID_DRAW_TEXT_chars_int_int_float_float_Paint = 55;
    public static final int ID_DRAW_TEXT_String_float_float_Paint = 56;
    public static final int ID_DRAW_TEXT_String_int_int_float_float_Paint = 57;
    public static final int ID_DRAW_TEXT_CharSequence_int_int_float_float_Paint = 58;
    public static final int ID_DRAW_POS_TEXT_chars_int_int_floats_Paint = 59;
    public static final int ID_DRAW_POS_TEXT_String_floats_Paint = 60;
    public static final int ID_DRAW_TEXT_ON_PATH_chars_int_int_Path_float_float_Paint = 61;
    public static final int ID_DRAW_TEXT_ON_PATH_String_Path_float_float_Paint = 62;
    public static final int ID_DRAW_PICTURE_Picture = 63;
    public static final int ID_DRAW_PICTURE_Picture_RectF = 64;
    public static final int ID_DRAW_PICTURE_Picture_Rect = 65;

    public List<Instruction> opList = new ArrayList<Instruction>();

    private ReplayableCanvas(Canvas peer) {
        super(peer);
    }

    /**
     * Specify a bitmap for the canvas to draw into.  As a side-effect, also
     * updates the canvas's target density to match that of the bitmap.
     *
     * @param bitmap Specifies a mutable bitmap for the canvas to draw into.
     * @see #setDensity(int)
     * @see #getDensity()
     */
    @Override
    public void setBitmap(Bitmap bitmap) {
        super.setBitmap(bitmap);
        recordOp(ID_SET_BITMAP_Bitmap, bitmap);
    }

    /**
     * <p>Specifies the density for this Canvas' backing bitmap.  This modifies
     * the target density of the canvas itself, as well as the density of its
     * backing bitmap via {@link android.graphics.Bitmap#setDensity(int) Bitmap.setDensity(int)}.
     *
     * @param density The new target density of the canvas, which is used
     *                to determine the scaling factor when drawing a bitmap into it.  Use
     *                {@link android.graphics.Bitmap#DENSITY_NONE} to disable bitmap scaling.
     * @see #getDensity()
     * @see android.graphics.Bitmap#setDensity(int)
     */
    @Override
    public void setDensity(int density) {
        super.setDensity(density);
        recordOp(ID_SET_DENSITY, density);
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
        int result = super.save();
        recordOp(ID_SAVE);
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
        int result = super.save(saveFlags);
        recordOp(ID_SAVE_int);
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
     * @param bounds    May be null. The maximum size the offscreen bitmap
     *                  needs to be (in local coordinates)
     * @param paint     This is copied, and is applied to the offscreen when
     *                  restore() is called.
     * @param saveFlags see _SAVE_FLAG constants
     * @return value to pass to restoreToCount() to balance this save()
     */
    @Override
    public int saveLayer(RectF bounds, Paint paint, int saveFlags) {
        int result = super.saveLayer(bounds, paint, saveFlags);
        recordOp(ID_SAVE_LAYER_RectF_Paint_int, bounds, paint, saveFlags);
        return result;
    }

    /**
     * Helper version of saveLayer() that takes 4 values rather than a RectF.
     */
    @Override
    public int saveLayer(float left, float top, float right, float bottom, Paint paint, int saveFlags) {
        int result = super.saveLayer(left, top, right, bottom, paint, saveFlags);
        recordOp(ID_SAVE_LAYER_float_float_float_float_Paint_int, left, top, right, bottom, paint, saveFlags);
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
     * @return value to pass to restoreToCount() to balance this call
     */
    @Override
    public int saveLayerAlpha(RectF bounds, int alpha, int saveFlags) {
        int result = super.saveLayerAlpha(bounds, alpha, saveFlags);
        recordOp(ID_SAVE_LAYER_ALPHA_RectF_int_int, bounds, alpha, saveFlags);
        return result;
    }

    /**
     * Helper for saveLayerAlpha() that takes 4 values instead of a RectF.
     */
    @Override
    public int saveLayerAlpha(float left, float top, float right, float bottom, int alpha, int saveFlags) {
        int result = super.saveLayerAlpha(left, top, right, bottom, alpha, saveFlags);
        recordOp(ID_SAVE_LAYER_ALPHA_float_float_float_float_int_int, left, top, right, bottom, alpha, saveFlags);
        return result;
    }

    /**
     * This call balances a previous call to save(), and is used to remove all
     * modifications to the matrix/clip state since the last save call. It is
     * an error to call restore() more times than save() was called.
     */
    @Override
    public void restore() {
        super.restore();
        recordOp(ID_RESTORE);
    }

    /**
     * Efficient way to pop any calls to save() that happened after the save
     * count reached saveCount. It is an error for saveCount to be less than 1.
     * <p/>
     * Example:
     * int count = canvas.save();
     * ... // more calls potentially to save()
     * canvas.restoreToCount(count);
     * // now the canvas is back in the same state it was before the initial
     * // call to save().
     *
     * @param saveCount The save level to restore to.
     */
    @Override
    public void restoreToCount(int saveCount) {
        super.restoreToCount(saveCount);
        recordOp(ID_RESTORE_TO_COUNT_int, saveCount);
    }

    /**
     * Preconcat the current matrix with the specified translation
     *
     * @param dx The distance to translate in X
     * @param dy The distance to translate in Y
     */
    @Override
    public void translate(float dx, float dy) {
        super.translate(dx, dy);
        recordOp(ID_TRANSLATE_float_float, dx, dy);
    }

    /**
     * Preconcat the current matrix with the specified scale.
     *
     * @param sx The amount to scale in X
     * @param sy The amount to scale in Y
     */
    @Override
    public void scale(float sx, float sy) {
        super.scale(sx, sy);
        recordOp(ID_SCALE_float_float, sx, sy);
    }

    /**
     * Preconcat the current matrix with the specified rotation.
     *
     * @param degrees The amount to rotate, in degrees
     */
    @Override
    public void rotate(float degrees) {
        super.rotate(degrees);
        recordOp(ID_ROTATE_float, degrees);
    }

    /**
     * Preconcat the current matrix with the specified skew.
     *
     * @param sx The amount to skew in X
     * @param sy The amount to skew in Y
     */
    @Override
    public void skew(float sx, float sy) {
        super.skew(sx, sy);
        recordOp(ID_SKEW_float_float, sx, sy);
    }

    /**
     * Preconcat the current matrix with the specified matrix.
     *
     * @param matrix The matrix to preconcatenate with the current matrix
     */
    @Override
    public void concat(Matrix matrix) {
        super.concat(matrix);
        recordOp(ID_CONCAT_Matrix, matrix);
    }

    /**
     * Completely replace the current matrix with the specified matrix. If the
     * matrix parameter is null, then the current matrix is reset to identity.
     * <p/>
     * <strong>Note:</strong> it is recommended to use {@link #concat(android.graphics.Matrix)},
     * {@link #scale(float, float)}, {@link #translate(float, float)} and
     * {@link #rotate(float)} instead of this method.
     *
     * @param matrix The matrix to replace the current matrix with. If it is
     *               null, set the current matrix to identity.
     * @see #concat(android.graphics.Matrix)
     */
    @Override
    public void setMatrix(Matrix matrix) {
        super.setMatrix(matrix);
        recordOp(ID_SET_MATRIX_Matrix, matrix);
    }

    /**
     * Modify the current clip with the specified rectangle.
     *
     * @param rect The rect to intersect with the current clip
     * @param op   How the clip is modified
     * @return true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(RectF rect, Region.Op op) {
        boolean result = super.clipRect(rect, op);
        recordOp(ID_CLIP_RECT_RectF_Op, rect, op);
        return result;
    }

    /**
     * Modify the current clip with the specified rectangle, which is
     * expressed in local coordinates.
     *
     * @param rect The rectangle to intersect with the current clip.
     * @param op   How the clip is modified
     * @return true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(Rect rect, Region.Op op) {
        boolean result = super.clipRect(rect, op);
        recordOp(ID_CLIP_RECT_Rect_Op, rect, op);
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
        boolean result = super.clipRect(rect);
        recordOp(ID_CLIP_RECT_RectF, rect);
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
        boolean result = super.clipRect(rect);
        recordOp(ID_CLIP_RECT_Rect, rect);
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
     * @return true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(float left, float top, float right, float bottom, Region.Op op) {
        boolean result = super.clipRect(left, top, right, bottom, op);
        recordOp(ID_CLIP_RECT_float_float_float_float_Op, left, top, right, bottom, op);
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
     * @return true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(float left, float top, float right, float bottom) {
        boolean result = super.clipRect(left, top, right, bottom);
        recordOp(ID_CLIP_RECT_float_float_float_float, left, top, right, bottom);
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
     * @return true if the resulting clip is non-empty
     */
    @Override
    public boolean clipRect(int left, int top, int right, int bottom) {
        boolean result = super.clipRect(left, top, right, bottom);
        recordOp(ID_CLIP_RECT_int_int_int_int, left, top, right, bottom);
        return result;
    }

    /**
     * Modify the current clip with the specified path.
     *
     * @param path The path to operate on the current clip
     * @param op   How the clip is modified
     * @return true if the resulting is non-empty
     */
    @Override
    public boolean clipPath(Path path, Region.Op op) {
        boolean result = super.clipPath(path, op);
        recordOp(ID_CLIP_PATH_Path_Op, path, op);
        return result;
    }

    /**
     * Intersect the current clip with the specified path.
     *
     * @param path The path to intersect with the current clip
     * @return true if the resulting is non-empty
     */
    @Override
    public boolean clipPath(Path path) {
        boolean result = super.clipPath(path);
        recordOp(ID_CLIP_PATH_Path, path);
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
     * @param op     How the clip is modified
     * @return true if the resulting is non-empty
     */
    @Override
    public boolean clipRegion(Region region, Region.Op op) {
        boolean result = super.clipRegion(region, op);
        recordOp(ID_CLIP_REGION_Region_Op, region, op);
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
        boolean result = super.clipRegion(region);
        recordOp(ID_CLIP_REGION_Region, region);
        return result;
    }

    @Override
    public void setDrawFilter(DrawFilter filter) {
        super.setDrawFilter(filter);
        recordOp(ID_SET_DRAW_FILTER_DrawFilter, filter);
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
        super.drawRGB(r, g, b);
        recordOp(ID_DRAW_RGB_int_int_int, r, g, b);
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
        super.drawARGB(a, r, g, b);
        recordOp(ID_DRAW_ARGB_int_int_int_int, a, r, g, b);
    }

    /**
     * Fill the entire canvas' bitmap (restricted to the current clip) with the
     * specified color, using srcover porterduff mode.
     *
     * @param color the color to draw onto the canvas
     */
    @Override
    public void drawColor(int color) {
        super.drawColor(color);
        recordOp(ID_DRAW_COLOR_int, color);
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
        super.drawColor(color, mode);
        recordOp(ID_DRAW_COLOR_int_Mode, color, mode);
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
        super.drawPaint(paint);
        recordOp(ID_DRAW_PAINT_Paint, paint);
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
     * @param pts    Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
     * @param offset Number of values to skip before starting to draw.
     * @param count  The number of values to process, after skipping offset
     *               of them. Since one point uses two values, the number of
     *               "points" that are drawn is really (count >> 1).
     * @param paint  The paint used to draw the points
     */
    @Override
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        super.drawPoints(pts, offset, count, paint);
        recordOp(ID_DRAW_POINTS_floats_int_int_Paint, pts, offset, count, paint);
    }

    /**
     * Helper for drawPoints() that assumes you want to draw the entire array
     */
    @Override
    public void drawPoints(float[] pts, Paint paint) {
        super.drawPoints(pts, paint);
        recordOp(ID_DRAW_POINTS_floats_Paint, pts, paint);
    }

    /**
     * Helper for drawPoints() for drawing a single point.
     */
    @Override
    public void drawPoint(float x, float y, Paint paint) {
        super.drawPoint(x, y, paint);
        recordOp(ID_DRAW_POINT_float_float_Paint, x, y, paint);
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
        super.drawLine(startX, startY, stopX, stopY, paint);
        recordOp(ID_DRAW_LINE_float_float_float_float_Paint, startX, startY, stopX,  stopY, paint);
    }

    /**
     * Draw a series of lines. Each line is taken from 4 consecutive values
     * in the pts array. Thus to draw 1 line, the array must contain at least 4
     * values. This is logically the same as drawing the array as follows:
     * drawLine(pts[0], pts[1], pts[2], pts[3]) followed by
     * drawLine(pts[4], pts[5], pts[6], pts[7]) and so on.
     *
     * @param pts    Array of points to draw [x0 y0 x1 y1 x2 y2 ...]
     * @param offset Number of values in the array to skip before drawing.
     * @param count  The number of values in the array to process, after
     *               skipping "offset" of them. Since each line uses 4 values,
     *               the number of "lines" that are drawn is really
     *               (count >> 2).
     * @param paint  The paint used to draw the points
     */
    @Override
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        super.drawLines(pts, offset, count, paint);
        recordOp(ID_DRAW_LINES_floats_int_int_Paint, pts, offset, count, paint);
    }

    @Override
    public void drawLines(float[] pts, Paint paint) {
        super.drawLines(pts, paint);
        recordOp(ID_DRAW_LINES_floats_Paint, pts, paint);
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
        super.drawRect(rect, paint);
        recordOp(ID_DRAW_RECT_RectF_Paint, rect, paint);
    }

    /**
     * Draw the specified Rect using the specified Paint. The rectangle
     * will be filled or framed based on the Style in the paint.
     *
     * @param r     The rectangle to be drawn.
     * @param paint The paint used to draw the rectangle
     */
    @Override
    public void drawRect(Rect r, Paint paint) {
        super.drawRect(r, paint);
        recordOp(ID_DRAW_RECT_Rect_Paint, r, paint);
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
        super.drawRect(left, top, right, bottom, paint);
        recordOp(ID_DRAW_RECT_float_float_float_float_Paint, left, top, right, right, bottom, paint);
    }

    /**
     * Draw the specified oval using the specified paint. The oval will be
     * filled or framed based on the Style in the paint.
     *
     * @param oval The rectangle bounds of the oval to be drawn
     */
    @Override
    public void drawOval(RectF oval, Paint paint) {
        super.drawOval(oval, paint);
        recordOp(ID_DRAW_OVAL_RectF_Paint, oval, paint);
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
        super.drawCircle(cx, cy, radius, paint);
        recordOp(ID_DRAW_CIRCLE_float_float_float_Paint, cx, cy, radius, paint);
    }

    /**
     * <p>Draw the specified arc, which will be scaled to fit inside the
     * specified oval.</p>
     * <p/>
     * <p>If the start angle is negative or >= 360, the start angle is treated
     * as start angle modulo 360.</p>
     * <p/>
     * <p>If the sweep angle is >= 360, then the oval is drawn
     * completely. Note that this differs slightly from SkPath::arcTo, which
     * treats the sweep angle modulo 360. If the sweep angle is negative,
     * the sweep angle is treated as sweep angle modulo 360</p>
     * <p/>
     * <p>The arc is drawn clockwise. An angle of 0 degrees correspond to the
     * geometric angle of 0 degrees (3 o'clock on a watch.)</p>
     *
     * @param oval       The bounds of oval used to define the shape and size
     *                   of the arc
     * @param startAngle Starting angle (in degrees) where the arc begins
     * @param sweepAngle Sweep angle (in degrees) measured clockwise
     * @param useCenter  If true, include the center of the oval in the arc, and close it if it is being stroked. This will draw a wedge
     * @param paint      The paint used to draw the arc
     */
    @Override
    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        super.drawArc(oval, startAngle, sweepAngle, useCenter, paint);
        recordOp(ID_DRAW_ARC_RectF_float_float_boolean_Paint, oval, startAngle, sweepAngle, useCenter, paint);
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
        super.drawRoundRect(rect, rx, ry, paint);
        recordOp(ID_DRAW_ROUND_RECT_RectF_float_float_Paint, rx, ry, paint);
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
        super.drawPath(path, paint);
        recordOp(ID_DRAW_PATH_Path_Paint, path, paint);
    }

    /**
     * Draw the specified bitmap, with its top/left corner at (x,y), using
     * the specified paint, transformed by the current matrix.
     * <p/>
     * <p>Note: if the paint contains a maskfilter that generates a mask which
     * extends beyond the bitmap's original width/height (e.g. BlurMaskFilter),
     * then the bitmap will be drawn as if it were in a Shader with CLAMP mode.
     * Thus the color outside of the original width/height will be the edge
     * color replicated.
     * <p/>
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
        super.drawBitmap(bitmap, left, top, paint);
        recordOp(ID_DRAW_BITMAP_Bitmap_float_float_Paint, bitmap, left, top, paint);
    }

    /**
     * Draw the specified bitmap, scaling/translating automatically to fill
     * the destination rectangle. If the source rectangle is not null, it
     * specifies the subset of the bitmap to draw.
     * <p/>
     * <p>Note: if the paint contains a maskfilter that generates a mask which
     * extends beyond the bitmap's original width/height (e.g. BlurMaskFilter),
     * then the bitmap will be drawn as if it were in a Shader with CLAMP mode.
     * Thus the color outside of the original width/height will be the edge
     * color replicated.
     * <p/>
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
        super.drawBitmap(bitmap, src, dst, paint);
        recordOp(ID_DRAW_BITMAP_Bitmap_Rect_RectF_Paint, bitmap, src, dst, paint);
    }

    /**
     * Draw the specified bitmap, scaling/translating automatically to fill
     * the destination rectangle. If the source rectangle is not null, it
     * specifies the subset of the bitmap to draw.
     * <p/>
     * <p>Note: if the paint contains a maskfilter that generates a mask which
     * extends beyond the bitmap's original width/height (e.g. BlurMaskFilter),
     * then the bitmap will be drawn as if it were in a Shader with CLAMP mode.
     * Thus the color outside of the original width/height will be the edge
     * color replicated.
     * <p/>
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
        super.drawBitmap(bitmap, src, dst, paint);
        recordOp(ID_DRAW_BITMAP_Bitmap_Rect_Rect_Paint, bitmap, src, dst, paint);
    }

    /**
     * Treat the specified array of colors as a bitmap, and draw it. This gives
     * the same result as first creating a bitmap from the array, and then
     * drawing it, but this method avoids explicitly creating a bitmap object
     * which can be more efficient if the colors are changing often.
     *
     * @param colors   Array of colors representing the pixels of the bitmap
     * @param offset   Offset into the array of colors for the first pixel
     * @param stride   The number of colors in the array between rows (must be
     *                 >= width or <= -width).
     * @param x        The X coordinate for where to draw the bitmap
     * @param y        The Y coordinate for where to draw the bitmap
     * @param width    The width of the bitmap
     * @param height   The height of the bitmap
     * @param hasAlpha True if the alpha channel of the colors contains valid
     *                 values. If false, the alpha byte is ignored (assumed to
     *                 be 0xFF for every pixel).
     * @param paint    May be null. The paint used to draw the bitmap
     */
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y, int width, int height, boolean hasAlpha, Paint paint) {
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        recordOp(ID_DRAW_BITMAP_ints_int_int_float_float_int_int_boolean_Paint, colors, offset, stride, x, y, width, height, hasAlpha, paint);
    }

    /**
     * Legacy version of drawBitmap(int[] colors, ...) that took ints for x,y
     */
    @Override
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y, int width, int height, boolean hasAlpha, Paint paint) {
        super.drawBitmap(colors, offset, stride, x, y, width, height, hasAlpha, paint);
        recordOp(ID_DRAW_BITMAP_ints_int_int_int_int_int_int_boolean_Paint);
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
        super.drawBitmap(bitmap, matrix, paint);
        recordOp(ID_DRAW_BITMAP_Bitmap_Matrix_Paint, bitmap, matrix, paint);
    }

    /**
     * Draw the bitmap through the mesh, where mesh vertices are evenly
     * distributed across the bitmap. There are meshWidth+1 vertices across, and
     * meshHeight+1 vertices down. The verts array is accessed in row-major
     * order, so that the first meshWidth+1 vertices are distributed across the
     * top of the bitmap from left to right. A more general version of this
     * methid is drawVertices().
     *
     * @param bitmap      The bitmap to draw using the mesh
     * @param meshWidth   The number of columns in the mesh. Nothing is drawn if
     *                    this is 0
     * @param meshHeight  The number of rows in the mesh. Nothing is drawn if
     *                    this is 0
     * @param verts       Array of x,y pairs, specifying where the mesh should be
     *                    drawn. There must be at least
     *                    (meshWidth+1) * (meshHeight+1) * 2 + meshOffset values
     *                    in the array
     * @param vertOffset  Number of verts elements to skip before drawing
     * @param colors      May be null. Specifies a color at each vertex, which is
     *                    interpolated across the cell, and whose values are
     *                    multiplied by the corresponding bitmap colors. If not null,
     *                    there must be at least (meshWidth+1) * (meshHeight+1) +
     *                    colorOffset values in the array.
     * @param colorOffset Number of color elements to skip before drawing
     * @param paint       May be null. The paint used to draw the bitmap
     */
    @Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts, int vertOffset, int[] colors, int colorOffset, Paint paint) {
        super.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset, paint);
        recordOp(ID_DRAW_BITMAP_MESH_Bitmap_int_int_floats_int_ints_int_Paint, bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset, paint);
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
     * @param mode        How to interpret the array of vertices
     * @param vertexCount The number of values in the vertices array (and
     *                    corresponding texs and colors arrays if non-null). Each logical
     *                    vertex is two values (x, y), vertexCount must be a multiple of 2.
     * @param verts       Array of vertices for the mesh
     * @param vertOffset  Number of values in the verts to skip before drawing.
     * @param texs        May be null. If not null, specifies the coordinates to sample
     *                    into the current shader (e.g. bitmap tile or gradient)
     * @param texOffset   Number of values in texs to skip before drawing.
     * @param colors      May be null. If not null, specifies a color for each
     *                    vertex, to be interpolated across the triangle.
     * @param colorOffset Number of values in colors to skip before drawing.
     * @param indices     If not null, array of indices to reference into the
     *                    vertex (texs, colors) array.
     * @param indexCount  number of entries in the indices array (if not null).
     * @param paint       Specifies the shader to use if the texs array is non-null.
     */
    @Override
    public void drawVertices(VertexMode mode, int vertexCount, float[] verts, int vertOffset, float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices, int indexOffset, int indexCount, Paint paint) {
        super.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors, colorOffset, indices, indexOffset, indexCount, paint);
        recordOp(ID_DRAW_VERTICES_VertexMode_int_floats_int_floats_int_ints_int_shorts_int_int_Paint, mode, vertexCount, verts, vertOffset, texs, texOffset, colors, colorOffset, indices, indexOffset, indexCount, paint);
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
        super.drawText(text, index, count, x, y, paint);
        recordOp(ID_DRAW_TEXT_chars_int_int_float_float_Paint, text, index, count, x, y, paint);
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
        super.drawText(text, x, y, paint);
        recordOp(ID_DRAW_TEXT_String_float_float_Paint, text, x, y, paint);
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
        super.drawText(text, start, end, x, y, paint);
        recordOp(ID_DRAW_TEXT_String_int_int_float_float_Paint, text, start, end, x, y, paint);
    }

    /**
     * Draw the specified range of text, specified by start/end, with its
     * origin at (x,y), in the specified Paint. The origin is interpreted
     * based on the Align setting in the Paint.
     *
     * @param text  The text to be drawn
     * @param start The index of the first character in text to draw
     * @param end   (end - 1) is the index of the last character in text
     *              to draw
     * @param x     The x-coordinate of origin for where to draw the text
     * @param y     The y-coordinate of origin for where to draw the text
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        super.drawText(text, start, end, x, y, paint);
        recordOp(ID_DRAW_TEXT_CharSequence_int_int_float_float_Paint, text, start, end, x, y, paint);
    }

    /**
     * Draw the text in the array, with each character's origin specified by
     * the pos array.
     * <p/>
     * This method does not support glyph composition and decomposition and
     * should therefore not be used to render complex scripts.
     *
     * @param text  The text to be drawn
     * @param index The index of the first character to draw
     * @param count The number of characters to draw, starting from index.
     * @param pos   Array of [x,y] positions, used to position each
     *              character
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        super.drawPosText(text, index, count, pos, paint);
        recordOp(ID_DRAW_POS_TEXT_chars_int_int_floats_Paint, text, index, count, pos, paint);
    }

    /**
     * Draw the text in the array, with each character's origin specified by
     * the pos array.
     * <p/>
     * This method does not support glyph composition and decomposition and
     * should therefore not be used to render complex scripts.
     *
     * @param text  The text to be drawn
     * @param pos   Array of [x,y] positions, used to position each character
     * @param paint The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawPosText(String text, float[] pos, Paint paint) {
        super.drawPosText(text, pos, paint);
        recordOp(ID_DRAW_POS_TEXT_String_floats_Paint, text, pos, paint);

    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint, along
     * the specified path. The paint's Align setting determins where along the
     * path to start the text.
     *
     * @param text    The text to be drawn
     * @param path    The path the text should follow for its baseline
     * @param hOffset The distance along the path to add to the text's
     *                starting position
     * @param vOffset The distance above(-) or below(+) the path to position
     *                the text
     * @param paint   The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint) {
        super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
        recordOp(ID_DRAW_TEXT_ON_PATH_chars_int_int_Path_float_float_Paint, text, index, count, path, hOffset, vOffset, paint);
    }

    /**
     * Draw the text, with origin at (x,y), using the specified paint, along
     * the specified path. The paint's Align setting determins where along the
     * path to start the text.
     *
     * @param text    The text to be drawn
     * @param path    The path the text should follow for its baseline
     * @param hOffset The distance along the path to add to the text's
     *                starting position
     * @param vOffset The distance above(-) or below(+) the path to position
     *                the text
     * @param paint   The paint used for the text (e.g. color, size, style)
     */
    @Override
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        super.drawTextOnPath(text, path, hOffset, vOffset, paint);
        recordOp(ID_DRAW_TEXT_ON_PATH_String_Path_float_float_Paint, text, path, hOffset, vOffset, paint);
    }

    /**
     * Save the canvas state, draw the picture, and restore the canvas state.
     * This differs from picture.draw(canvas), which does not perform any
     * save/restore.
     *
     * @param picture The picture to be drawn
     */
    @Override
    public void drawPicture(Picture picture) {
        super.drawPicture(picture);
        recordOp(ID_DRAW_PICTURE_Picture, picture);
    }

    /**
     * Draw the picture, stretched to fit into the dst rectangle.
     */
    @Override
    public void drawPicture(Picture picture, RectF dst) {
        super.drawPicture(picture, dst);
        recordOp(ID_DRAW_PICTURE_Picture_RectF, picture, dst);
    }

    /**
     * Draw the picture, stretched to fit into the dst rectangle.
     */
    @Override
    public void drawPicture(Picture picture, Rect dst) {
        super.drawPicture(picture, dst);
        recordOp(ID_DRAW_PICTURE_Picture_Rect, picture, dst);
    }

    public static ReplayableCanvas getReplayableCanvas(Canvas canvas) {
        ReplayableCanvas result = null;
        if (canvas instanceof ReplayableCanvas) {
            result = (ReplayableCanvas) canvas;
        } else {
            result = new ReplayableCanvas(canvas);
        }
        return result;
    }

    private void recordOp(int opId, Object... param) {
        Instruction inst = new Instruction(opId, param);
        opList.add(inst);
    }
}
