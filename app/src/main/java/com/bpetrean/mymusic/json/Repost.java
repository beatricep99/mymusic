package com.bpetrean.mymusic.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Repost implements Serializable {

    @SerializedName("pId")
    @Expose
    private String pId;
    @SerializedName("uId")
    @Expose
    private String uId;
    @SerializedName("uNm")
    @Expose
    private String uNm;

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public String getUNm() {
        return uNm;
    }

    public void setUNm(String uNm) {
        this.uNm = uNm;
    }

}