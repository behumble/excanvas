package com.thinkfree.android.excanvas.replay;

import android.graphics.Path;
import com.thinkfree.android.excanvas.GraphicsFactory;

/**
 * Extended Graphics Factory
 * @author Alan Goo
 */
public class ReplayableGraphicsFactory extends GraphicsFactory {
    @Override
    public Path newPath() {
        return new ReplayablePath();
    }
}