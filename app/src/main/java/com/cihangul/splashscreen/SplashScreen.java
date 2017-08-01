package com.cihangul.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class SplashScreen extends AppCompatActivity {

    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        relativeLayout= (RelativeLayout) findViewById(R.id.root);
        if (baglimi()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();
                }
            }, 2000);
        }else
        {
            Snackbar.make(relativeLayout,"İnternet Bağlantısı Bulunamadı",Snackbar.LENGTH_INDEFINITE).show();
        }

    }

    public  boolean baglimi()
    {
        boolean baglandi = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            baglandi = true;
        }
        else
            baglandi = false;

        return baglandi;
    }
}
