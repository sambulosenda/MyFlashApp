package com.myflashapp.myflashapp;

import android.app.Activity;
import android.app.AlertDialog;

/**
 * Created by sambulosenda on 15/01/14.
 */
public class MenuOption extends Activity {
    private  static MenuOption instance;

    private MenuOption()
    {

    }

    public static MenuOption getInstance()
    {
        if(instance == null)
        {
            instance = new MenuOption();
        }
        return instance;


    }


    public void back()
    {

    }

    public void exit()
    {
        ExitApplication.getInstance().exit();
        //System.exit(0);
        //android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void about(Activity activity)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity)
                .setTitle("about")
                .setMessage("Thanks for using Smile's flashlight 1.0\nauthor: SambuloSenda\nemail: sambulosendas@gmail.com")
                .setNegativeButton("ok", null);
        dialog.show();
    }
}
