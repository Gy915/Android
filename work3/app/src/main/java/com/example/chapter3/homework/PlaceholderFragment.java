package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private ListView listView;
    private LottieAnimationView animationView;
    private AnimatorSet animatorSet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        View v = inflater.inflate(R.layout.fragment_placeholder, container, false);
        listView=v.findViewById(R.id.list_1);
        animationView=v.findViewById(R.id.animation_view);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //简单设置测试字符数组
        String []data ={"friend1","friend2","friend3","friend4"};
        ArrayAdapter<String> array=new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,data);
        listView.setAdapter(array);
        listView.setAlpha(0f);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator Alpha1=ObjectAnimator.ofFloat(animationView,"alpha",1f,0f);
                Alpha1.setInterpolator(new LinearInterpolator());
                Alpha1.setDuration(500);
                ObjectAnimator Alpha2=ObjectAnimator.ofFloat(listView,"alpha",0f,1f);
                Alpha2.setInterpolator(new LinearInterpolator());
                Alpha2.setDuration(500);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(Alpha1,Alpha2);
                animatorSet.start();
            }
        }, 5000);
    }
}
