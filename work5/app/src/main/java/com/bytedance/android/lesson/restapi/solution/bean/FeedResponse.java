package com.bytedance.android.lesson.restapi.solution.bean;

import android.widget.ArrayAdapter;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @author Xavier.S
 * @date 2019.01.20 14:17
 */
public class FeedResponse {

    // TODO-C2 (2) Implement your FeedResponse Bean here according to the response json
    @SerializedName("success")
    private boolean success;
    @SerializedName("feeds")
    private List<Feed> feeds;
    public List<Feed> getfeeds()
    {
        return feeds;
    }
    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }
}
