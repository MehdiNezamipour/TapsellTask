
package com.nezamipour.mehdi.ad_mediator.models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdNetworks implements Serializable {

    @SerializedName("Tapsell")
    @Expose
    private String tapsell;
    @SerializedName("UnityAds")
    @Expose
    private String unityAds;
    @SerializedName("Chartboost")
    @Expose
    private String chartboost;


    public String getTapsell() {
        return tapsell;
    }

    public void setTapsell(String tapsell) {
        this.tapsell = tapsell;
    }

    public String getUnityAds() {
        return unityAds;
    }

    public void setUnityAds(String unityAds) {
        this.unityAds = unityAds;
    }

    public String getChartboost() {
        return chartboost;
    }

    public void setChartboost(String chartboost) {
        this.chartboost = chartboost;
    }

}
