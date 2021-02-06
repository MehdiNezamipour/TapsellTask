
package com.nezamipour.mehdi.admadiator.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AdConfig implements Serializable {

    @SerializedName("zoneType")
    @Expose
    private String zoneType;
    @SerializedName("waterfall")
    @Expose
    private List<Waterfall> waterfall = null;
    @SerializedName("ttl")
    @Expose
    private Integer ttl;

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    public List<Waterfall> getWaterfall() {
        return waterfall;
    }

    public void setWaterfall(List<Waterfall> waterfall) {
        this.waterfall = waterfall;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

}
