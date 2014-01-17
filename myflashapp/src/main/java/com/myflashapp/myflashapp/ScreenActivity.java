package com.myflashapp.myflashapp;

/**
 * Created by sambulosenda on 15/01/14.
 */
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class ScreenActivity extends Activity {
    private RelativeLayout screenLayout;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        screenLayout = (RelativeLayout) findViewById(R.id.screenlayoutId);

        screenLayout.setBackgroundResource(R.color.pink);

        bright(1.0f);

        ExitApplication.getInstance().addActivity(this);
    }

    //点击屏幕触发事件
//        @Override
//    public boolean onTouchEvent(MotionEvent event){
//            openOptionsMenu();
//            return false;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.screen_menu, menu);
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
            MenuOption.getInstance().about(ScreenActivity.this);
        }
        else if (item.getItemId() == R.id.exitId)
        {
            MenuOption.getInstance().exit();
        }
        else if (item.getItemId() == R.id.colorId)
        {
            setColor();
        }
        else if (item.getItemId() == R.id.brightId)
        {
            setBright();
        }
        else
        {
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setColor()
    {
        final String[] colors = {"白色","红色","黑色","黄色","蓝色","粉色","绿色","紫色"};
        new AlertDialog.Builder(ScreenActivity.this)
                .setTitle("选择颜色")
                .setItems(colors, new OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(), colors[which], Toast.LENGTH_SHORT).show();
                        //System.out.println(which + colors[which]);

                        switch (which)
                        {
                            case 0:
                                screenLayout.setBackgroundResource(R.color.white);
                                break;
                            case 1:
                                screenLayout.setBackgroundResource(R.color.red);
                                break;
                            case 2:
                                screenLayout.setBackgroundResource(R.color.black);
                                //System.out.println(R.color.black);
                                break;
                            case 3:
                                screenLayout.setBackgroundResource(R.color.yellow);
                                break;
                            case 4:
                                screenLayout.setBackgroundResource(R.color.blue);
                                break;
                            case 5:
                                screenLayout.setBackgroundResource(R.color.pink);
                                break;
                            case 6:
                                screenLayout.setBackgroundResource(R.color.green);
                                break;
                            case 7:
                                screenLayout.setBackgroundResource(R.color.purple);
                                break;

                            default:
                                screenLayout.setBackgroundResource(R.color.white);
                                break;
                        }
                    }
                }).show();
    }

    public void setBright()
    {
        final String[] brights = {"100%", "75%", "50%","25%","10%"};
        new AlertDialog.Builder(ScreenActivity.this)
                .setTitle("选择亮度")
                .setSingleChoiceItems(brights, i, new DialogInterface.OnClickListener() { //此处数字为选项的下标，从0开始， 表示默认哪项被选中
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(), brights[which],Toast.LENGTH_SHORT).show();
                        i = which;
                        switch (which) {
                            case 0:
                                bright(1.0F);
                                break;
                            case 1:
                                bright(0.75F);
                                break;
                            case 2:
                                bright(0.5F);
                                break;
                            case 3:
                                bright(0.25F);
                                break;
                            case 4:
                                bright(0.1F);
                                break;
                            default:
                                bright(1.0F);
                                break;
                        }
                        dialog.cancel();
                    }
                }).show();
    }


    private void bright(float light)
    {
        WindowManager.LayoutParams lp=getWindow().getAttributes();
        lp.screenBrightness=light;
        getWindow().setAttributes(lp);

    }

}
