package com.example.androidbase.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by chenxiaozhou on 16/8/9.
 */
public class RceycleImageTool {

    public static void recycleImageViewBitMap(ImageView imageView) {
        if (imageView != null) {
            imageView.setBackgroundDrawable(null);
            BitmapDrawable bd = (BitmapDrawable) imageView.getDrawable();
            rceycleBitmapDrawable(bd);
        }
    }

    private static void rceycleBitmapDrawable(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable != null) {
            Bitmap bitmap = bitmapDrawable.getBitmap();
            rceycleBitmap(bitmap);
        }
        bitmapDrawable = null;
    }

    public static void rceycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            bitmap = null;
        }
    }

    //将view 装换成bitmap
    public Bitmap createViewBitmap(View tipView) {
        tipView.setDrawingCacheEnabled(true);
        tipView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        tipView.layout(0, 0, tipView.getMeasuredWidth(), tipView.getMeasuredHeight());
        tipView.buildDrawingCache();
        Bitmap b = tipView.getDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(b);
        tipView.destroyDrawingCache();
        return bitmap;
    }
}
