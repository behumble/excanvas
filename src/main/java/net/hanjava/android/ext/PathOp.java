package net.hanjava.android.ext;

/**
 * for Save/Load with minimal number of classes and members.
 * note that not optimized and subject to change
 * @author Alan Goo
 */
public class PathOp {
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

    public int opId;
    public Object param;
    public PathOp(int opId, Object param) {
        this.opId = opId;
    }
}