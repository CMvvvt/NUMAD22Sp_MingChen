package edu.neu.madcourse.numad22sp_mingchen;

import android.content.Intent;
import android.net.Uri;

public class UrlItem {
    private String itemName;
    private String itemUrl;
    private boolean isChecked;

    public UrlItem(String itemName, String itemUrl, boolean isChecked) {
        this.itemName = itemName;
        this.itemUrl = itemUrl;
        this.isChecked = isChecked;
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

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "UrlItem{" +
                "itemName='" + itemName + '\'' +
                ", itemUrl='" + itemUrl + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }

}
