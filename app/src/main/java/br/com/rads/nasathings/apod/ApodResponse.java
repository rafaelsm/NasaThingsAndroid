package br.com.rads.nasathings.apod;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rafael on 3/27/16.
 */
public class ApodResponse {

    @SerializedName("date")
    private String date;

    @SerializedName("explanation")
    private String description;

    @SerializedName("hdurl")
    private String imageUrlHD;

    @SerializedName("media_type")
    private String mediaType;

    @SerializedName("service_version")
    private String serviceVersion;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String imageUrl;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrlHD() {
        return imageUrlHD;
    }

    public void setImageUrlHD(String imageUrlHD) {
        this.imageUrlHD = imageUrlHD;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
