package com.nezamipour.mehdi.admadiator.mainclasses;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.chartboost.sdk.Chartboost;
import com.google.gson.Gson;
import com.nezamipour.mehdi.admadiator.mainclasses.listeners.AdRequestCallback;
import com.nezamipour.mehdi.admadiator.mainclasses.listeners.AdShowCallback;
import com.nezamipour.mehdi.admadiator.mainclasses.listeners.UnityAdListeners;
import com.nezamipour.mehdi.admadiator.models.AdConfig;
import com.nezamipour.mehdi.admadiator.models.AppConfig;
import com.nezamipour.mehdi.admadiator.models.Waterfall;
import com.nezamipour.mehdi.admadiator.utils.Constants;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;

import ir.tapsell.sdk.Tapsell;
import ir.tapsell.sdk.TapsellAdRequestListener;
import ir.tapsell.sdk.TapsellAdShowListener;


public class AdMediator {

    private static AppConfig sAppConfig;
    private static AdConfig sAdConfig;
    private static Integer sIndex = 0;

    private static Handler sHandler = new Handler();
    private static Waterfall sWaterfall;
    private static String sAdId;
    private static String sZoneId;

    public AdMediator() {
    }


    public static void initialize(Application application, String adMediatorAppId) {
        getConfig();
        // initialization adNetworks base on appConfig
        if (sAppConfig.getAdNetworks().getTapsell() != null)
            Tapsell.initialize(application, sAppConfig.getAdNetworks().getTapsell());
        if (sAppConfig.getAdNetworks().getChartboost() != null)
            Chartboost.startWithAppId(application, sAppConfig.getAdNetworks().getChartboost(), null);
        if (sAppConfig.getAdNetworks().getUnityAds() != null)
            UnityAds.initialize(application, sAppConfig.getAdNetworks().getUnityAds());

    }

    private static void getConfig() {
        sAppConfig = new AppConfig();
        sAdConfig = new AdConfig();
        //get add config from server with appId
        // we use fake info here
        Gson gson = new Gson();
        sAppConfig = gson.fromJson(Constants.APP_CONFIG, AppConfig.class);
        sAdConfig = gson.fromJson(Constants.AD_CONFIG, AdConfig.class);
    }

    public static void requestAd(Context context, String adMediatorZoneId, AdRequestCallback adRequestCallback) {
        sIndex = 0;
        loadAd(context, adRequestCallback);
    }

    private static void loadAd(Context context, AdRequestCallback adRequestCallback) {
        if (sIndex > sAdConfig.getWaterfall().size()) {
            adRequestCallback.error("not exist ad");
            return;
        }

        String zoneType = sAdConfig.getZoneType();
        sWaterfall = sAdConfig.getWaterfall().get(sIndex);


        switch (sWaterfall.getAdNetwork()) {
            case "Tapsell":
                sHandler.postDelayed(() -> {
                    sIndex++;
                    loadAd(context, adRequestCallback);

                }, sWaterfall.getTimeout());
                requestFromTapSell(context, sWaterfall.getZoneId(), adRequestCallback);
                break;
            case "UnityAds":
                sHandler.postDelayed(() -> {
                    sIndex++;
                    loadAd(context, adRequestCallback);
                }, sWaterfall.getTimeout());
                requestFromUnityAd(context, sWaterfall.getZoneId(), adRequestCallback);
                break;
            case "Chartboost":
                sHandler.postDelayed(() -> {
                    sIndex++;
                    loadAd(context, adRequestCallback);
                }, sWaterfall.getTimeout());
                if (zoneType.equals("Interstitial"))
                    requestInterstitialFromChartBoost(sWaterfall.getZoneId());
                else if (zoneType.equals("Rewarded"))
                    requestRewardedFromChartBoost(sWaterfall.getZoneId());
                break;
            default:
                adRequestCallback.error("network not exist");
                break;
        }

    }

    private static void requestFromTapSell(Context context, String tapSellZoneId, AdRequestCallback adRequestCallback) {
        Tapsell.requestAd(context, tapSellZoneId, null, new TapsellAdRequestListener() {
            @Override
            public void onAdAvailable(String adId) {
                super.onAdAvailable(adId);
                adRequestCallback.onSuccess(adId);
                sAdId = adId;
            }

            @Override
            public void onError(String adId) {
                super.onError(adId);
                sIndex++;
                loadAd(context, adRequestCallback);

            }
        });
    }


    private static void requestFromUnityAd(Context context, String unityAdZoneId, AdRequestCallback adRequestCallback) {
        UnityAds.load(unityAdZoneId, new IUnityAdsLoadListener() {
            @Override
            public void onUnityAdsAdLoaded(String adId) {
                adRequestCallback.onSuccess(adId);
            }

            @Override
            public void onUnityAdsFailedToLoad(String adId) {
                sIndex++;
                loadAd(context, adRequestCallback);
            }
        });
    }

    private static void requestInterstitialFromChartBoost(String chartBoostZoneId) {
        Chartboost.cacheInterstitial(chartBoostZoneId);
    }

    private static void requestRewardedFromChartBoost(String chartBoostZoneId) {
        Chartboost.cacheRewardedVideo(chartBoostZoneId);
    }


    public static void showAd(Context context, Activity activity, String zoneId, AdShowCallback adShowCallback) {

        sZoneId = sAdConfig.getWaterfall().get(sIndex).getZoneId();
        switch (sZoneId) {
            case Constants.TAPSELL_INTERSTITIAL_BANNER:
            case Constants.TAPSELL_INTERSTITIAL_VIDEO:
            case Constants.TAPSELL_REWARDED_VIDEO:
                showFromTapSell(context, sZoneId, sAdId, adShowCallback);
                break;
            case Constants.CHART_BOOST_INTERSTITIAL_BANNER:
            case Constants.CHART_BOOST_INTERSTITIAL_VIDEO:
                showInterstitialFromChartBoost(sZoneId);
                break;
            case Constants.CHART_BOOST_REWARDED_VIDEO:
                showRewardedFromChartBoost(sZoneId);
                break;
            case Constants.UNITY_AD_INTERSTITIAL_BANNER:
            case Constants.UNITY_AD_INTERSTITIAL_VIDEO:
            case Constants.UNITY_AD_REWARDED_VIDEO:
                showFromUnityAd(activity, sZoneId, adShowCallback);
                break;

            default:
                adShowCallback.onError("network not exist");
                break;
        }
    }

    private static void showFromTapSell(Context context, String zoneId, String adId, AdShowCallback adShowCallback) {
        Tapsell.showAd(context, zoneId, adId, null, new TapsellAdShowListener() {
            @Override
            public void onOpened() {
                super.onOpened();
                adShowCallback.onOpened();
            }

            @Override
            public void onError(String s) {
                super.onError(s);
                adShowCallback.onError(s);
            }
        });
    }

    private static void showFromUnityAd(Activity activity, String zoneId, AdShowCallback adShowCallback) {
        UnityAds.addListener(new UnityAdListeners() {
            @Override
            public void onUnityAdsStart(String placementId) {
                super.onUnityAdsStart(placementId);
                adShowCallback.onOpened();
            }

            @Override
            public void onUnityAdsError(UnityAds.UnityAdsError error, String message) {
                super.onUnityAdsError(error, message);
                adShowCallback.onError(message);
            }
        });
        if (UnityAds.isReady(zoneId))
            UnityAds.show(activity, zoneId);
    }

    private static void showInterstitialFromChartBoost(String zoneId) {
        Chartboost.showInterstitial(zoneId);
    }

    private static void showRewardedFromChartBoost(String zoneId) {
        Chartboost.showRewardedVideo(zoneId);
    }


}
