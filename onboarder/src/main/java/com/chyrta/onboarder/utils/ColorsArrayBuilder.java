package com.chyrta.onboarder.utils;

import android.content.Context;

import com.chyrta.onboarder.OnboarderPage;

import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;

public class ColorsArrayBuilder {

    public static Integer[] getPageBackgroundColors(Context context, List<OnboarderPage> pages) {
        List<Integer> colorsList = new ArrayList<>();
        for (OnboarderPage page : pages) {
            colorsList.add(ContextCompat.getColor(context, page.getBackgroundColor()));
        }
        return colorsList.toArray(new Integer[pages.size()]);
    }

}
