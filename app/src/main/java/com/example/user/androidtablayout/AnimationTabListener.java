package com.example.user.androidtablayout;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;
import android.widget.Toast;

public class AnimationTabListener implements TabHost.OnTabChangeListener {
    private Context context;
    private static final int ANIMATION_TIME = 240;
    private TabHost tabHost;
    private View priviousView;
    private View currntView;
    private int currentTab;

    public AnimationTabListener(Context context, TabHost tabHost) {
        this.context = context;
        this.tabHost = tabHost;
        this.priviousView = tabHost.getCurrentView();

    }

    @Override
    public void onTabChanged(String tabId) {

        //Here we can easy to manager tab without remember Tab title
        if (tabId.equals(context.getResources().getString(R.string.tab_one_title)));
        Toast.makeText(context, "This is 1st tab", Toast.LENGTH_SHORT).show();

        if (tabId.equals(context.getResources().getString(R.string.tab_two_title)));
        Toast.makeText(context, "This is Two tab", Toast.LENGTH_SHORT).show();

        if (tabId.equals(context.getResources().getString(R.string.tab_three_title)));
        Toast.makeText(context, "This is Three tab", Toast.LENGTH_SHORT).show();

        //Animation
        currntView = tabHost.getCurrentView();
        if(tabHost.getCurrentTab() > currentTab)
        {
            priviousView.setAnimation(outToLetfAnimation());
            currntView.setAnimation(inFromRightAnimation());
        }
        else {
            priviousView.setAnimation(outToRightAnimation());
            currntView.setAnimation(inFromLeftAnimation());
        }
        priviousView = currntView;
        currentTab = tabHost.getCurrentTab();

    }

    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                -1.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f);
        return setProperties(inFromLeft);
    }

    private Animation setProperties(Animation animation) {
    animation.setDuration(ANIMATION_TIME);
    animation.setInterpolator(new AccelerateInterpolator());
    return animation;
    }

    private Animation outToRightAnimation() {

        Animation outToRight = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                1.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f);
        return setProperties(outToRight);
    }

    private Animation inFromRightAnimation() {

        Animation inFromRight = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                1.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f);
        return setProperties(inFromRight);

    }

    private Animation outToLetfAnimation(){

        Animation outToLetf = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                -1.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f);
        return setProperties(outToLetf);


    }
}
