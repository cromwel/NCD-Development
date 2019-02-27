package org.development.aihd.adapters.pages;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.development.aihd.fragments.initial.Initial_page_1;
import org.development.aihd.fragments.initial.Initial_page_2;
import org.development.aihd.fragments.initial.Initial_page_3;
import org.development.aihd.fragments.initial.Initial_page_4;
import org.development.aihd.fragments.initial.Initial_page_5;
import org.development.aihd.fragments.initial.Initial_page_6;

/**
 * Created : dennis on 3/23/18.
 */

public class DM_Initial_Adapter extends FragmentStatePagerAdapter {

    private int tabsNumber;

    public DM_Initial_Adapter(FragmentManager fm, int tabsNumber) {
        super(fm);
        this.tabsNumber = tabsNumber;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Initial_page_1();
            case 1:
                return new Initial_page_2();
            case 2:
                return new Initial_page_3();
            case 3:
                return new Initial_page_4();
            case 4:
                return new Initial_page_5();
            case 5:
                return new Initial_page_6();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }

}
