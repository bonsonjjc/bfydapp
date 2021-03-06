package com.bonson.bfydapp.utils.binding;

import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

/**
 * Created by zjw on 2018/1/3.
 */

public abstract class CommBindingAdapter {

    @BindingAdapter("android:icon")
    public static void setIcon(ImageView imageView, String img) {
        if (TextUtils.isEmpty(img))
            return;
        Resources resources = imageView.getResources();
        int resId = resources.getIdentifier(img, "drawable", imageView.getContext().getPackageName());
        imageView.setImageResource(resId);
    }

    @BindingAdapter("android:url")
    public static void setUrl(ImageView imageView, String url) {
    }
}
