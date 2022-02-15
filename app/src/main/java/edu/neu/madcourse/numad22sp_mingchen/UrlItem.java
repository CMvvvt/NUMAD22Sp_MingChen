package edu.neu.madcourse.numad22sp_mingchen;

import android.content.Intent;
import android.net.Uri;

public class UrlItem {
    private String itemName;
    private String itemUrl;


    public UrlItem(String itemName, String itemUrl) {
        this.itemName = itemName;
        this.itemUrl = itemUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }


    @Override
    public String toString() {
        return "UrlItem{" +
                "itemName='" + itemName + '\'' +
                ", itemUrl='" + itemUrl + '\'' +
                '}';
    }

}
