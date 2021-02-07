
package com.nezamipour.mehdi.admadiator.models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppConfig implements Serializable {


    @SerializedName("adNetworks")
    @Expose
    private AdNetworks adNetworks;


    public AdNetworks getAdNetworks() {
        return adNetworks;
    }

    public void setAdNetworks(AdNetworks adNetworks) {
        this.adNetworks = adNetworks;
    }

}
