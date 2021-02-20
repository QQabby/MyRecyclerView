package com.qq.myrecyclerview;

import android.graphics.Color;
import android.graphics.Paint;
import android.widget.TextView;

public class ColorUtil {

    public static void setPaintColor(TextView mPaint, int position) {
        int pos = position % 6;
        switch (pos) {
            case 0:
                mPaint.setBackgroundColor(Color.parseColor("#EC5745"));
                break;
            case 1:
                mPaint.setBackgroundColor(Color.parseColor("#377caf"));
                break;
            case 2:
                mPaint.setBackgroundColor(Color.parseColor("#4ebcd3"));
                break;
            case 3:
                mPaint.setBackgroundColor(Color.parseColor("#6fb30d"));
                break;
            case 4:
                mPaint.setBackgroundColor(Color.parseColor("#FFA500"));
                break;
            case 5:
                mPaint.setBackgroundColor(Color.parseColor("#bf9e5a"));
                break;
        }
    }
}
