package com.th7.flinspirer;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends Activity {
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(String str:PERMISSIONS_STORAGE){
            if(this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED){
                this.requestPermissions(PERMISSIONS_STORAGE,101);
                return;
            }
        }

    }
}