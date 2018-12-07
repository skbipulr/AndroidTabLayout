package com.example.user.androidtablayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost=findViewById(R.id.tabHost);
        tabHost.setup();

        //Tab1
        TabHost.TabSpec spec = tabHost.newTabSpec(getResources().getString(R.string.tab_one_title));
        spec.setContent(R.id.tab1);
        spec.setIndicator(getResources().getString(R.string.tab_one_title));
        tabHost.addTab(spec);

        //Tab2
        spec = tabHost.newTabSpec(getResources().getString(R.string.tab_two_title));
        spec.setContent(R.id.tab2);
        spec.setIndicator(getResources().getString(R.string.tab_two_title));
        tabHost.addTab(spec);

        //Tab 3
        spec = tabHost.newTabSpec(getResources().getString(R.string.tab_three_title));
        spec.setContent(R.id.tab3);
        spec.setIndicator(getResources().getString(R.string.tab_three_title));
        tabHost.addTab(spec);

        //Event
        tabHost.setOnTabChangedListener(new AnimationTabListener(this,tabHost));

    }
}
