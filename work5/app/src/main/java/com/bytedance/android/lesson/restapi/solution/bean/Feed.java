package com.bytedance.android.lesson.restapi.solution.bean;

import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.google.gson.annotations.SerializedName;

import java.sql.Array;

/**
 * @author Xavier.S
 * @date 2019.01.20 14:18
 */
public class Feed {


        // TODO-C2 (1) Implement your Feed Bean here according to the response json
        @SerializedName("student_id") private String student_id;
        @SerializedName("user_name") private String user_name;
        @SerializedName("image_url") private String image_url;
        @SerializedName("_id") private String _id;
        @SerializedName("image_w") private int image_w;
        @SerializedName("image_h") private int image_h;
        @SerializedName("video_url") private String video_url;
        @SerializedName("createdAt") private String createdAt;
        @SerializedName("updatedAt") private String updatedAt;
        @SerializedName("__v") private int __v;

        public String getImage_url() {
                return image_url;
        }
}