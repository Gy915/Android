package com.bytedance.videoplayer;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class MainActivity extends AppCompatActivity {
    private Button buttonPlay;
    private TextView textViewCurrent;
    private VideoView videoView;
    private SeekBar seekBar;
    private boolean start_pause=true;

    private Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if(videoView.isPlaying())
            {
                int current=  videoView.getCurrentPosition();
                seekBar.setProgress(current);//时时设置进度条位置
                textViewCurrent.setText(time(videoView.getCurrentPosition()));
            }
            handler.postDelayed(runnable,500);
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_video);
        setTitle("VideoView");
        textViewCurrent=findViewById(R.id.textView2);
        seekBar=findViewById(R.id.SeekBar);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start_pause)
                {
                    start_pause=false;
                    videoView.pause();
                    buttonPlay.setText("stop");
                }
                else
                {
                    start_pause=true;
                    videoView.start();;
                    buttonPlay.setText("start");
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath(getVideoPath(R.raw.bytedance));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(videoView.getDuration());
                handler.postDelayed(runnable,0);
                videoView.start();
            }
        });





    }
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            videoView.pause();
        }

        /*停止拖动时触发*/
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if(start_pause)
                videoView.start();
            int progress=seekBar.getProgress();
            videoView.seekTo(progress);
        }
    };
    private String getVideoPath(int resId) {
        return "android.resource://" + this.getPackageName() + "/" + resId;
    }

    @Override

    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        int orientation = newConfig.orientation;

        if (orientation == ORIENTATION_LANDSCAPE){
            videoView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            videoView.getLayoutParams().width=ViewGroup.LayoutParams.MATCH_PARENT;

        }
        else
        {
            videoView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            videoView.getLayoutParams().width=ViewGroup.LayoutParams.MATCH_PARENT;

        }



    }
    protected String time(long millionSeconds) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millionSeconds);
        return simpleDateFormat.format(c.getTime());
    }
}
