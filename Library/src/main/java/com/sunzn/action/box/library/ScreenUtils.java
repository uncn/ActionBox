package com.sunzn.action.box.library;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by sunzn on 2017/2/16.
 */

class ScreenUtils {

    static int getScreenWidth(Context context) {
        context = context.getApplicationContext();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

}
