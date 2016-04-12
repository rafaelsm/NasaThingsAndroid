package br.com.rads.nasathings.util;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntDef;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Menu;
import android.view.MenuItem;

import br.com.rads.nasathings.R;

/**
 * Created by Rafael on 4/11/16.
 */
public class TintUtil {

    public static void tintMenuItem(MenuItem menuItem, @ColorInt int color){
        Drawable drawable = menuItem.getIcon();
        drawable = DrawableCompat.wrap(drawable);

        DrawableCompat.setTint(drawable, color);

        menuItem.setIcon(drawable);
    }

}
