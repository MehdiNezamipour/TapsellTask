package com.nezamipour.mehdi.admadiator.utils;

public class Constants {


    public static final String TAPSELL_KEY = "kttjtpmdehsmnhlkkrlfekisnfifqtdallotfeccaspodsnqspelhcinjjdbiqtmhaglsn";
    public static final String TAPSELL_INTERSTITIAL_BANNER = "5caae7c33a2e170001ef9392";
    public static final String TAPSELL_INTERSTITIAL_VIDEO = "5caaeffec1ed8b000149cedc";
    public static final String TAPSELL_REWARDED_VIDEO = "5caaf03dc1ed8b000149cedd";


    public static final String APP_CONFIG = "{\n" +
            "\"adNetworks\" : {\n" +
            "\"Tapsell\" : \"appIdInTapsell\",\n" +
            "\"UnityAds\" : \"appIdInUnityAds\",\n" +
            "\"Chartboost\" : \"appIdInChartboost\"\n" +
            "}\n" +
            "}";

    public static final String AD_CONFIG = "{\n" +
            "\"zoneType\": \"InterstitialOrRewarded\",\n" +
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
