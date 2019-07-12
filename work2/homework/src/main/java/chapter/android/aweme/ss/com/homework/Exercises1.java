package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 * on create->on start->on resume->on pause->on stop->on destroy
 * 将执行一个完整的生命周期，维护成本高，运行速度慢
 */
public class Exercises1 extends AppCompatActivity {

    final static String tag="mainactivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag,"on create");

    }
    protected void onStart()
    {
        super.onStart();
        Log.d(tag,"on start");
    }
    protected void onResume()
    {
        super.onResume();
        Log.d(tag,"on resume");
    }
    protected void onPause()
    {
        super.onPause();
        Log.d(tag,"on pause");
    }
    protected void onStop()
    {
        super.onStop();
        Log.d(tag,"on stop");
    }
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(tag,"on destroy");
    }
    protected void onRestart()
    {
        super.onRestart();
        Log.d(tag,"on Restart");
    }

}
