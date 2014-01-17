package com.myflashapp.myflashapp;

/**
 * Created by sambulosenda on 15/01/14.
 */
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FlashLightActivity extends Activity {
    private Button button;
    private Camera camera;
    private Parameters parameters;
    public static Boolean onoff = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashlight);

        button = (Button) findViewById(R.id.buttonId);
        button.setOnClickListener(new ButtonListener());

        ExitApplication.getInstance().addActivity(this);

    }

    class ButtonListener implements OnClickListener
    {

        @Override
        public void onClick(View v) {
            if (onoff)
            {
                button.setBackgroundResource(R.drawable.torch_on);
                camera = Camera.open();
                parameters = camera.getParameters();
                parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                camera.startPreview();
                onoff = false;
            }
            else
            {
                button.setBackgroundResource(R.drawable.torch_off);
                parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                camera.setParameters(parameters);
                camera.stopPreview();
                camera.release();

                onoff = true;
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.flashlight_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.backId)
        {
            MenuOption.getInstance().back();
        }
        else if (item.getItemId() == R.id.aboutId)
        {
            MenuOption.getInstance().about(FlashLightActivity.this);
        }
        else if (item.getItemId() == R.id.exitId)
        {
            MenuOption.getInstance().exit();
        }
        else if (item.getItemId() == R.id.screenId)
        {
            screen();
        }
        else
        {
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    public void screen()
    {
        Intent intent = new Intent();
        intent.setClass(FlashLightActivity.this, ScreenActivity.class);
        startActivity(intent);
    }

}