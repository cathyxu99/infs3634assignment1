package com.example.infs3634assignment.Learn;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrganImage {

    @SerializedName("ns")
    @Expose
    private Integer ns;
    @SerializedName("title")
    @Expose
    private String title;

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}