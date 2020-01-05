package com.homework1_3.androiddeynenko342;

import android.app.Activity;
import android.content.Intent;

public class Indent {
    private static int sTheme;

    public final static int THEME_LITTLE = 0;
    public final static int THEME_MIDDLE= 1;
    public final static int THEME_BIG = 2;

    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_LITTLE:
                activity.setTheme(R.style.MarginLittle);
                break;
            case THEME_MIDDLE:
                activity.setTheme(R.style.MarginMiddle);
                break;
            case THEME_BIG:
                activity.setTheme(R.style.MarginBig);
                break;
        }
    }
}
