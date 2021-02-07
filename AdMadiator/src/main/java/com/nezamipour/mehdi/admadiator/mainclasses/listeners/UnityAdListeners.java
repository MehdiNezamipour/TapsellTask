package com.nezamipour.mehdi.admadiator.mainclasses.listeners;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

public abstract class UnityAdListeners implements IUnityAdsListener {

    public UnityAdListeners() {
    }

    @Override
    public void onUnityAdsReady(String placementId) {

    }

    @Override
    public void onUnityAdsStart(String placementId) {

    }

    @Override
    public void onUnityAdsFinish(String placementId, UnityAds.FinishState result) {

    }

    @Override
    public void onUnityAdsError(UnityAds.UnityAdsError error, String message) {

    }
}
