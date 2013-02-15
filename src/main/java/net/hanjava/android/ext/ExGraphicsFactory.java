package net.hanjava.android.ext;

import android.graphics.Path;
import net.hanjava.android.GraphicsFactory;

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