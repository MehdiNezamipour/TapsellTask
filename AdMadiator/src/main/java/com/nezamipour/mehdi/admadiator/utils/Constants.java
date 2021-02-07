package com.nezamipour.mehdi.admadiator.utils;

public class Constants {


    //TapSell
    public static final String TAPSELL_KEY = "kttjtpmdehsmnhlkkrlfekisnfifqtdallotfeccaspodsnqspelhcinjjdbiqtmhaglsn";
    public static final String TAPSELL_INTERSTITIAL_BANNER = "5caae7c33a2e170001ef9392";
    public static final String TAPSELL_INTERSTITIAL_VIDEO = "5caaeffec1ed8b000149cedc";
    public static final String TAPSELL_REWARDED_VIDEO = "5caaf03dc1ed8b000149cedd";


    //UnityAd
    public static final String UNITY_AD_INTERSTITIAL_BANNER = null;
    public static final String UNITY_AD_INTERSTITIAL_VIDEO = null;
    public static final String UNITY_AD_REWARDED_VIDEO = null;


    //Chartboost
    public static final String CHART_BOOST_INTERSTITIAL_BANNER = null;
    public static final String CHART_BOOST_INTERSTITIAL_VIDEO = null;
    public static final String CHART_BOOST_REWARDED_VIDEO = null;


    public static final String APP_CONFIG = "{\n" +
            "\"adNetworks\" : {\n" +
            "\"Tapsell\" : \"appIdInTapsell\",\n" +
            "\"UnityAds\" : \"appIdInUnityAds\",\n" +
            "\"Chartboost\" : \"appIdInChartboost\"\n" +
            "}\n" +
            "}";

    public static final String AD_CONFIG = "{\n" +
            "\"zoneType\": \"Interstitial\",\n" +
            "\"waterfall\": [\n" +
            "{\n" +
            "\"adNetwork\": \"UnityAds\",\n" +
            "\"zoneId\": \"zoneIdInUnityAds\",\n" +
            "\"timeout\": 2000\n" +
            "},\n" +
            "{\n" +
            "\"adNetwork\": \"Tapsell\",\n" +
            "\"zoneId\": \"zoneIdInTapsell\",\n" +
            "\"timeout\": 3000\n" +
            "},\n" +
            "{\n" +
            "\"adNetwork\": \"Chartboost\",\n" +
            "\"zoneId\": \"zoneIdInChartboost\",\n" +
            "\"timeout\": 1000\n" +
            "}\n" +
            "],\n" +
            "\"ttl\": 3600000\n" +
            "}";

}
