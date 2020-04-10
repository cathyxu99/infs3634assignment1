package com.example.infs3634assignment;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrganImageResponse {

    @SerializedName("images")
    @Expose
    private List<OrganImage> organImages = null;

    public List<OrganImage> getOrganImages() {
        return organImages;
    }

    public void setOrganImages(List<OrganImage> organImages) {
        this.organImages = organImages;
    }

}