package com.example.joan.reparanpc;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class animacion extends ActionBarActivity {
    //declarar aanimacion de carga
    private AnimationDrawable mFrameAnimation;
    private ImageView mImageLoading;
    private LinearLayout mContLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_un_circuito);

        //animacion
        mContLoading = (LinearLayout) findViewById(R.id.contLoading);
        mImageLoading = (ImageView) findViewById(R.id.loadingView);
       // mImageLoading.setBackgroundResource(R.drawable.loading);
       mImageLoading.setBackgroundResource(R.drawable.errora);
        mImageLoading.setBackgroundResource(R.drawable.errorb);
        // Get the background, which has been compiled to an AnimationDrawable object.
        mFrameAnimation = (AnimationDrawable) mImageLoading.getBackground();

        new LongOperation().execute("");

    }
    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            //Start  Loading Animation
            mContLoading.setVisibility(View.VISIBLE);
            mFrameAnimation.start();
        }
        @Override
        protected String doInBackground(String... params) {
            //ToDo your Network Job/Request etc. here
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // Intent nuevofrom= new Intent(animacion.this,MainActivity.class );
           // startActivity(nuevofrom );
            return "OK";
        }
        @Override
        protected void onPostExecute(String result) {
            //ToDo with result you got from Task
            //Stop Loading Animation
            mFrameAnimation.stop();
            mContLoading.setVisibility(View.GONE);

        }

}

}
