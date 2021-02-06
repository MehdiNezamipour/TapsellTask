
package com.nezamipour.mehdi.admadiator.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Waterfall implements Serializable {

    @SerializedName("adNetwork")
    @Expose
    private String adNetwork;
    @SerializedName("zoneId")
    @Expose
    private String zoneId;
    @SerializedName("timeout")
    @Expose
    private Integer timeout;


    public String getAdNetwork() {
        return adNetwork;
    }

    public void setAdNetwork(String adNetwork) {
        this.adNetwork = adNetwork;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

}
