package com.example.f9898.androidfinal;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory{
    private MediaPlayer mp=new MediaPlayer();
    private Button mSongBtn1,mSongBtn2,mSongBtn3,mSongBtn4,mSongBtn5,mSongBtn6,mPlayBtn,mStopBtn;
    private Integer[] mImgArr = {
            R.drawable.the_lazy_song,R.drawable.call_me_maybe,R.drawable.gift_of_a_friend,
            R.drawable.radioactive,R.drawable.in_the_end,R.drawable.talking_body};
    private Integer[] mMscArr = {
            R.raw.the_lazy_song,R.raw.call_me_maybe,R.raw.gift_of_a_friend,R.raw.radioactive,
            R.raw.in_the_end,R.raw.talking_body};
    private ImageSwitcher mImgSwitcher;
    int MusicNum=0;
    boolean IsPlaying;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSongBtn1=(Button)findViewById(R.id.SongBtn1);
        mSongBtn2=(Button)findViewById(R.id.SongBtn2);
        mSongBtn3=(Button)findViewById(R.id.SongBtn3);
        mSongBtn4=(Button)findViewById(R.id.SongBtn4);
        mSongBtn5=(Button)findViewById(R.id.SongBtn5);
        mSongBtn6=(Button)findViewById(R.id.SongBtn6);
        mPlayBtn=(Button)findViewById(R.id.PlayBtn);
        mStopBtn=(Button)findViewById(R.id.StopBtn);

        mImgSwitcher =findViewById(R.id.imgSwitcher);
        mImgSwitcher.setFactory(this);
        mImgSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        mImgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        mSongBtn1.setOnClickListener(btn1OnClick);
        mSongBtn2.setOnClickListener(btn2OnClick);
        mSongBtn3.setOnClickListener(btn3OnClick);
        mSongBtn4.setOnClickListener(btn4OnClick);
        mSongBtn5.setOnClickListener(btn5OnClick);
        mSongBtn6.setOnClickListener(btn6OnClick);
        mPlayBtn.setOnClickListener(btnPlayOnclick);
        mStopBtn.setOnClickListener(btnStopOnclick);

    }
    private Button.OnClickListener btn1OnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            mImgSwitcher.setImageResource(mImgArr[0]);
            MusicNum=0;

        }
    };
    private Button.OnClickListener btn2OnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            mImgSwitcher.setImageResource(mImgArr[1]);
            MusicNum=1;
        }
    };
    private Button.OnClickListener btn3OnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            mImgSwitcher.setImageResource(mImgArr[2]);
            MusicNum=2;
        }
    };
    private Button.OnClickListener btn4OnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            mImgSwitcher.setImageResource(mImgArr[3]);
            MusicNum=3;
        }
    };
    private Button.OnClickListener btn5OnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            mImgSwitcher.setImageResource(mImgArr[4]);
            MusicNum=4;
        }
    };
    private Button.OnClickListener btn6OnClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            mImgSwitcher.setImageResource(mImgArr[5]);
            MusicNum=5;
        }
    };

    private Button.OnClickListener btnPlayOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if (!IsPlaying) {
                mp = MediaPlayer.create(MainActivity.this, mMscArr[MusicNum]);
                mp.start();
                IsPlaying=true;
            }

        }
    };

    private Button.OnClickListener btnStopOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if (IsPlaying) {
                mp.stop();
                IsPlaying = false;
            }
        }
    };



    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
        v.setBackgroundColor(Color.WHITE);
        return v;
    }
}
