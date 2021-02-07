package com.nezamipour.mehdi.tapselltask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nezamipour.mehdi.admadiator.mainclasses.AdMediator;
import com.nezamipour.mehdi.admadiator.mainclasses.listeners.AdRequestCallback;
import com.nezamipour.mehdi.admadiator.mainclasses.listeners.AdShowCallback;

public class MainActivity extends AppCompatActivity {

    public static final String AD_MEDIATOR_INTERSTITIAL_BANNER = "adMediatorInterstitialBanner";
    private String mZoneId;
    private String mAdId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdMediator.initialize(getApplication(), "appId");
        AdMediator.requestAd(this, AD_MEDIATOR_INTERSTITIAL_BANNER, new AdRequestCallback() {
            @Override
            public void onSuccess(String adId) {
                super.onSuccess(adId);
                MainActivity.this.mZoneId = AD_MEDIATOR_INTERSTITIAL_BANNER;
                MainActivity.this.mAdId = adId;
            }

            @Override
            public void error(String message) {
                super.error(message);
            }
        });

        AdMediator.showAd(this, this, mZoneId, new AdShowCallback() {
            @Override
            public void onOpened() {
                super.onOpened();
            }

            @Override
            public void onError(String message) {
                super.onError(message);
            }
        });

    }
}