package com.thinkfree.android.excanvas.replay;

import java.util.Arrays;

/**
 * for Save/Load with minimal number of classes and members.
 * note that not optimized and subject to change
 * @author Alan Goo
 */
public class Instruction {
    public int opId;
    public Object param;

    public Instruction(int opId, Object param) {
        this.opId = opId;
        this.param = param;
    }

    @Override
    public String toString() {
        return String.format("Instruction[opid:%d] %s", opId, paramToString(param));
    }

    private static String paramToString(Object param) {
        if(param==null) return "";  // do not print
        if(param instanceof Object[]) return Arrays.deepToString((Object[]) param);
        return param.toString();
    }
}