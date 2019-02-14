package com.chyrta.onboarder;


import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class OnboarderAdapter extends FragmentStatePagerAdapter {

    List<OnboarderPage> pages = new ArrayList<OnboarderPage>();

    public OnboarderAdapter(List<OnboarderPage> pages, FragmentManager fm) {
        super(fm);
        this.pages = pages;
    }

    @Override
    public Fragment getItem(int position) {
        return OnboarderFragment.newInstance(pages.get(position));
    }

    @Override
    public int getCount() {
        return pages.size();
    }


}
