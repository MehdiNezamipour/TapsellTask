package com.nezamipour.mehdi.ad_mediator.MainClasses;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AdMediator.initialize(this);
        
    }
}
