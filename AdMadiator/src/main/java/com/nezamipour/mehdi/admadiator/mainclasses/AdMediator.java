package com.nezamipour.mehdi.admadiator.mainclasses;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.chartboost.sdk.CBLocation;
import com.google.gson.Gson;
import com.nezamipour.mehdi.admadiator.models.AdConfig;
import com.nezamipour.mehdi.admadiator.models.AdNetworks;
import com.nezamipour.mehdi.admadiator.models.AppConfig;

import ir.tapsell.sdk.Tapsell;

import com.nezamipour.mehdi.admadiator.models.Waterfall;
import com.nezamipour.mehdi.admadiator.utils.Constants;
import com.unity3d.ads.UnityAds;
import com.chartboost.sdk.Chartboost;

import java.util.ArrayList;
import java.util.List;


public class AdMediator {


    private static AppConfig sAppConfig;
    private static AdNetworks sAdNetworks;
    private static AdConfig sAdConfig;

    private static Handler sHandler = new Handler();

    public AdMediator() {
    }


    //appId is special id of app in our ad network
    //zoneId is String that show type of Ad like : interstitialBanner or rewardedVideo
    public static void initialize(Application application, String appId) {
        //get add config for server with appId
        // we use fake info here
        Gson gson = new Gson();
        sAppConfig = gson.fromJson(Constants.AD_CONFIG, AppConfig.class);
        sAdConfig = gson.fromJson(Constants.AD_CONFIG, AdConfig.class);


        getConfig();
        // initialization adNetworks base on appConfig
        if (sAppConfig.getAdNetworks().getTapsell() != null)
            Tapsell.initialize(application, appId);
        if (sAppConfig.getAdNetworks().getChartboost() != null)
            Chartboost.startWithAppId(application, appId, null);
        if (sAppConfig.getAdNetworks().getUnityAds() != null)
            UnityAds.initialize(application, appId);
    }

    private static void getConfig() {
        sAppConfig = new AppConfig();
        sAdNetworks = new AdNetworks();
        sAdConfig = new AdConfig();

        List<Waterfall> waterfalls = new ArrayList<>();
        waterfalls.add(new Waterfall("UnityAds", "zoneIdInUnityAds", 2000));
        waterfalls.add(new Waterfall("Tapsell", "zoneIdInTapsell", 3000));
        waterfalls.add(new Waterfall("Chartboost", "zoneIdInChartboost", 1000));
        sAdConfig.setZoneType("Interstitial");
        sAdConfig.setWaterfall(waterfalls);
        sAdConfig.setTtl(3600000);

        sAdNetworks.setTapsell("appIdInTapsell");
        sAdNetworks.setUnityAds("appIdInUnityAds");
        sAdNetworks.setChartboost("appIdInChartboost");
        sAppConfig.setAdNetworks(sAdNetworks);
    }

    public static void requestAd(Context context, String zoneId) {
        //TODO
        // if appConfig and AdConfig catch available dont need to request to get them again form server
        // else need to get all config again
        String zoneType = sAdConfig.getZoneType();
        for (Waterfall waterfall : sAdConfig.getWaterfall()) {

            sHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (waterfall.getAdNetwork()) {
                        case "Tapsell":
                            Tapsell.requestAd(context, zoneId);
                            break;
                        case "UnityAds":
                            UnityAds.load(zoneId);
                            break;
                        case "Chartboost":
                            Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
                            break;
                        default:
                            break;
                    }
                }
            }, waterfall.getTimeout());

        }


    }

    public static void requestFromTapSell(Context context, String zoneId, AdRequestCallback adRequestCallback) {
        Tapsell.requestAd(context, zoneId);
    }

    public static void requestInterstitialVideo(Context context, String appId, AdRequestCallback adRequestCallback) {

    }

    public static void requestRewardedVideo(Context context, String appId, AdRequestCallback adRequestCallback) {

    }


    public static void showAd(Context context, String appId, AdShowCallback adShowListener) {

    }


}
