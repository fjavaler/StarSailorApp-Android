package com.frederickjavalera.starsailorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;

public class MainActivity extends AppCompatActivity
{
  private static final String TAG = "MainActivity";
  private final int interval = 2000;
  private Handler handler = new Handler();
  private Runnable runnable = new Runnable()
  {
    @Override
    public void run()
    {
      Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
      startActivity(intent);
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);

    try
    {
      this.getSupportActionBar().hide();
    } catch (NullPointerException e)
    {
      Log.e(TAG, "onCreate: failed to hide support action bar.", e);
    }

    setContentView(R.layout.activity_main);

    handler.postAtTime(runnable, System.currentTimeMillis()+interval);
    handler.postDelayed(runnable, interval);
  }

  @Override
  protected void onResume()
  {
    super.onResume();

    View decorView = getWindow().getDecorView();
    // Hide the status bar.
    int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
    decorView.setSystemUiVisibility(uiOptions);
  }
}