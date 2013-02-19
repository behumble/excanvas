package com.thinkfree.android.excanvas.replay;

import org.junit.Assert;
import org.junit.Test;

public class PathOpTest {
    @Test
    public void toStringTestNull() {
        PathOp op = new PathOp(1, null);
        Assert.assertEquals("PathOp[opid:1] ", op.toString());
    }

    @Test
    public void toStringSingle() {
        PathOp op = new PathOp(2, 3.2);
        Assert.assertEquals("PathOp[opid:2] 3.2", op.toString());
    }

    @Test
    public void toStringMultiple() {
        PathOp op = new PathOp(3, new Object[] { 3, "three", 5.5f });
        Assert.assertEquals("PathOp[opid:3] [3, three, 5.5]", op.toString());
    }
}