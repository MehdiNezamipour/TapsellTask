package com.nezamipour.mehdi.admadiator.mainclasses;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import ir.tapsell.sdk.Tapsell;

public class AdMediator {


    public static final String TAPSELL_KEY = "kttjtpmdehsmnhlkkrlfekisnfifqtdallotfeccaspodsnqspelhcinjjdbiqtmhaglsn";
    public static final String TAPSELL_INTERSTITIAL_BANNER = "5caae7c33a2e170001ef9392";

    public AdMediator() {
    }


    //for first Test after publish on github
    public static void TestMethod(Activity activity, String s) {
        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
    }


    public static void initialize(Application application) {
        Tapsell.initialize(application, TAPSELL_KEY);

    }

    public static void requestBanner(Context context, String appId, AdRequestCallback adRequestCallback) {

    }

    public static void requestInterstitial(Context context, String appId, AdRequestCallback adRequestCallback) {
        Tapsell.requestAd(context, TAPSELL_INTERSTITIAL_BANNER);

    }

    public static void requestRewardedVideo(Context context, String appId, AdRequestCallback adRequestCallback) {

    }


    public static void showAd(Context context, String appId, AdShowCallback adShowListener) {

    }


}
