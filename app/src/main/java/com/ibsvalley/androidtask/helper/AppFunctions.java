package com.ibsvalley.androidtask.helper;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.kaopiz.kprogresshud.KProgressHUD;


import java.text.DecimalFormat;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class AppFunctions {


    public static void setMarginTop(View v, int top) {
        ViewGroup.MarginLayoutParams params =
                (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        params.setMargins(params.leftMargin, top,
                params.rightMargin, params.bottomMargin);
    }

    public static void setFlagLine(TextView view) {
        view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public static KProgressHUD getKProgressHUD(Context context) {

        return KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("please_wait")
                .setCancellable(false)
                .setAnimationSpeed(1)
                .setDimAmount(0.5f);
//                .setBackgroundColor(context.getColor(R.color.colorPrimary));
    }


    public static void loadImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext()).load(url).placeholder(getCircularProgressDrawable(imageView.getContext())).into(imageView);

    }

    public static CircularProgressDrawable getCircularProgressDrawable(Context context) {

        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            circularProgressDrawable.setColorSchemeColors(context.getColor(R.color.colorAccent));
//        }
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }

}