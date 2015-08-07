package com.example.root.com.example.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by root on 15-8-7.
 */
public class ScreenPix {

    private DisplayMetrics dm = null;
    private Activity activity = null;
    private int screenWidth = 0;
    private int screenHeight = 0;

    public ScreenPix(Activity activity){
        super();
        this.activity = activity;
        if (activity != null) {
            dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        }
    }

    public int getScreenWidth(){
        if (dm != null) {
            screenWidth = dm.widthPixels;
            return screenWidth;
        }else{
            return 0;
        }
    }

    public int getScreenHeight(){
        if (dm != null) {
            screenHeight = dm.heightPixels;
            return screenHeight;
        }else{
            return 0;
        }
    }
}
