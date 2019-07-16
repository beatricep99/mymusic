package com.bpetrean.mymusic;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Song implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("uId")
    @Expose
    private String uId;
    @SerializedName("uNm")
    @Expose
    private String uNm;
    @SerializedName("text")
    @Expose
    private Object text;
    @SerializedName("pl")
    @Expose
    private Pl pl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("eId")
    @Expose
    private String eId;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("repost")
    @Expose
    private Repost repost;
    @SerializedName("lov")
    @Expose
    private List<String> lov = null;
    @SerializedName("nbR")
    @Expose
    private int nbR;
    @SerializedName("nbP")
    @Expose
    private int nbP;
    @SerializedName("ctx")
    @Expose
    private String ctx;
    @SerializedName("src")
    @Expose
    private Src src;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
    }

    public Pl getPl() {
        return pl;
    }

    public void setPl(Pl pl) {
        this.pl = pl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEId() {
        return eId;
    }

    public void setEId(String eId) {
        this.eId = eId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Repost getRepost() {
        return repost;
    }

    public void setRepost(Repost repost) {
        this.repost = repost;
    }

    public List<String> getLov() {
        return lov;
    }

    public void setLov(List<String> lov) {
        this.lov = lov;
    }

    public int getNbR() {
        return nbR;
    }

    public void setNbR(int nbR) {
        this.nbR = nbR;
    }

    public int getNbP() {
        return nbP;
    }

    public void setNbP(int nbP) {
        this.nbP = nbP;
    }

    public String getCtx() {
        return ctx;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    public Src getSrc() {
        return src;
    }

    public void setSrc(Src src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", uId='" + uId + '\'' +
                ", uNm='" + uNm + '\'' +
                ", text=" + text +
                ", pl=" + pl +
                ", name='" + name + '\'' +
                ", eId='" + eId + '\'' +
                ", img='" + img + '\'' +
                ", repost=" + repost +
                ", lov=" + lov +
                ", nbR=" + nbR +
                ", nbP=" + nbP +
                ", ctx='" + ctx + '\'' +
                ", src=" + src +
                '}';
    }
}