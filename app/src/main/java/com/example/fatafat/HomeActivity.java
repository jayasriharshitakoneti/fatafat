package com.example.fatafat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.fatafat.MainRecyclerView.VerticalSpacingItemDecorator;
import com.example.fatafat.MainRecyclerView.VideoPlayerRecyclerView;
import com.example.fatafat.Models.MediaObject;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<MediaObject> mediaObjectList= new ArrayList<>();
    private VideoPlayerRecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    }

    private void init() {
//
//        sound=(ImageView) findViewById(R.id.image_disc);
//        Glide.with(this).load(R.drawable.disc).into(sound);

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        //recycler view
        recyclerview = (VideoPlayerRecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);

        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(0);
        recyclerview.addItemDecoration(itemDecorator);


        SnapHelper mSnapHelper = new PagerSnapHelper();
        mSnapHelper.attachToRecyclerView(recyclerview);



    }

    public static void setWindowFlag (@NotNull Activity activity, final int bits, boolean on){
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.color.design_default_color_primary_dark)
                .error(R.color.design_default_color_primary_dark);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }

    @Override
    protected void onDestroy() {
        if(recyclerview!=null)
            recyclerview.releasePlayer();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(recyclerview!=null)
            recyclerview.releasePlayer();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }




}