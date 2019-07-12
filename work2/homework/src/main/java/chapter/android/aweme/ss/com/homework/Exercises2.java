package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View inflate= LayoutInflater.from(this).inflate(R.layout.activity_chatroom,null);
        System.out.println(getViewCount(inflate));
    }

       public static int getViewCount(View view) {
        //todo 补全你的代码
           int num=0;
           if(view instanceof ViewGroup)
           {
               ViewGroup vp=(ViewGroup) view;
               for(int i=0;i<vp.getChildCount();i++)
               {
                   num++;
                   View child_view=vp.getChildAt(i);
                   if(child_view instanceof  ViewGroup)//当子类是派生类时
                        num+=getViewCount(child_view);
               }
           }
        return num;
    }
}
