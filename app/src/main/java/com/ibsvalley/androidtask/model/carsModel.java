package com.ibsvalley.androidtask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class carsModel {


    @Expose
    @SerializedName("data")
    private List<Data> data;
    @Expose
    @SerializedName("status")
    private int status;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class Data {
        @Expose
        @SerializedName("imageUrl")
        private String imageUrl;
        @Expose
        @SerializedName("isUsed")
        private boolean isUsed;
        @Expose
        @SerializedName("constructionYear")
        private String constructionYear;
        @Expose
        @SerializedName("brand")
        private String brand;
        @Expose
        @SerializedName("id")
        private int id;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public boolean getIsUsed() {
            return isUsed;
        }

        public void setIsUsed(boolean isUsed) {
            this.isUsed = isUsed;
        }

        public String getConstructionYear() {
            return constructionYear;
        }

        public void setConstructionYear(String constructionYear) {
            this.constructionYear = constructionYear;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
