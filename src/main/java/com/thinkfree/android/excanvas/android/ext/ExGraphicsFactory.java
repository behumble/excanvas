package com.thinkfree.android.excanvas.android.ext;

import android.graphics.Path;
import com.thinkfree.android.excanvas.android.GraphicsFactory;

/**
 * Extended Graphics Factory
 * @author Alan Goo
 */
public class ExGraphicsFactory extends GraphicsFactory {
    @Override
    public Path newPath() {
        return new ExPath();
    }
}