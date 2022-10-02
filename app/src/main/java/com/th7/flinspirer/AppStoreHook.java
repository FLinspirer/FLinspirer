package com.th7.flinspirer;

import android.content.Context;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class AppStoreHook {
    public static void hook(ClassLoader classLoader) throws Throwable {
        //5.6.005
        Class AppItem = classLoader.loadClass("com.ndwill.swd.appstore.model.AppItem");
        Class DownloadCountUtil = classLoader.loadClass("com.ndwill.swd.appstore.a.b");
        Class LTKApkUtil = classLoader.loadClass("com.linspirer.utils.b");

        XposedHelpers.findAndHookMethod(AppItem, "getIsforce", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(false);
                XposedBridge.log("FLinspirer: Get App Force Install Fucked.");
            }
        });

        XposedHelpers.findAndHookMethod(AppItem, "setIsforce", boolean.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.args[0] = false;
                XposedBridge.log("FLinspirer: Set App Force Install Fucked ");
            }
        });

        XposedHelpers.findAndHookMethod(AppItem, "getCanuninstall", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(true);
                XposedBridge.log("FLinspirer: Get App Can't Uninstall Fucked.");
            }
        });

        XposedHelpers.findAndHookMethod(AppItem, "setCanuninstall", boolean.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.args[0] = true;
                XposedBridge.log("FLinspirer: Set App Can't Uninstall Fucked ");
            }
        });

        XposedHelpers.findAndHookMethod(AppItem, "getException_white_url", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(1);
                XposedBridge.log("FLinspirer: Get App White Url Fucked.");
            }
        });

        XposedHelpers.findAndHookMethod(AppItem, "setException_white_url", int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.args[0] = 1;
                XposedBridge.log("FLinspirer: Set App White Url Fucked.");
            }
        });

             /*
             XposedHelpers.findAndHookMethod(AppItem, "getDownloadcount", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    int res = (int) param.getResult();
                    String s = String.valueOf(res);
                    Toast.makeText(context[1], "FLinspirer: Downloaded Count is "+s, Toast.LENGTH_LONG).show();
                }
            });
            */

        XposedHelpers.findAndHookMethod(DownloadCountUtil, "a", int.class, Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                int s1 = (int) param.args[0];
                String s = String.valueOf(s1);
                param.setResult(s);
            }
        });

        XposedHelpers.findAndHookMethod(LTKApkUtil, "a",String.class, String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(true);
                XposedBridge.log("FLinspirer: Apk Verfiy Fucked.");
            }
        });

    }
}
