package com.bytedance.android.lesson.restapi.solution.bean;

import android.support.v7.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

/**
 * @author Xavier.S
 * @date 2019.01.17 18:08
 */
public class Cat {

    // TODO-C1 (1) Implement your Cat Bean here according to the response json
    @SerializedName("id") private String id;
    @SerializedName("url") private String url;
    @SerializedName("width")private int width;
    @SerializedName("height")private int height;
    public String getid() {
        return id;
    }

    public String getUrl()
    {
        return url;
    }
}
