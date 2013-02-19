package com.thinkfree.android.excanvas.replay;

import org.junit.Assert;
import org.junit.Test;

public class InstructionTest {
    @Test
    public void toStringTestNull() {
        Instruction op = new Instruction(1, null);
        Assert.assertEquals("Instruction[opid:1] ", op.toString());
    }

    @Test
    public void toStringSingle() {
        Instruction op = new Instruction(2, 3.2);
        Assert.assertEquals("Instruction[opid:2] 3.2", op.toString());
    }

    @Test
    public void toStringMultiple() {
        Instruction op = new Instruction(3, new Object[] { 3, "three", 5.5f });
        Assert.assertEquals("Instruction[opid:3] [3, three, 5.5]", op.toString());
    }
}