package com.nezamipour.mehdi.ad_mediator.MainClasses;

import android.app.Activity;
import android.app.Application;
import android.widget.Toast;

import ir.tapsell.sdk.Tapsell;
import ir.tapsell.sdk.TapsellAd;

public class AdMediator {


    public static final String TAPSELL_KEY = "kttjtpmdehsmnhlkkrlfekisnfifqtdallotfeccaspodsnqspelhcinjjdbiqtmhaglsn";

    public AdMediator() {
    }


    //for first Test after publish on github
    public static void TestMethod(Activity activity, String s) {
        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
    }


    public static void initialize(Application application) {
        Tapsell.initialize(application, TAPSELL_KEY);


    }

    public static void requestBanner(Activity activity, String appId, AdRequestCallback adRequestCallback) {

    }

    public static void requestInterstitial(Activity activity, String appId, AdRequestCallback adRequestCallback) {

    }

    public static void requestRewardedVideo(Activity activity, String appId, AdRequestCallback adRequestCallback) {

    }


    public static void showAd(Activity activity, String appId, AdShowCallback adShowListener) {

    }


}
