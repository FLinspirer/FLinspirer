package com.th7.shellentry;

import android.content.Context;

import com.th7.flinspirer.AppStoreHook;
import com.th7.flinspirer.LinspirerHook;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Tencent {
    public static void LinspirerHook(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        XposedHelpers.findAndHookMethod("com.wrapper.proxyapplication.WrapperProxyApplication", loadPackageParam.classLoader, "attachBaseContext", Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Context context = (Context) param.args[0];
                ClassLoader classLoader = context.getClassLoader();
                LinspirerHook.hook(classLoader);
            }
        });
    }

    public static void AppStoreHook(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        XposedHelpers.findAndHookMethod("com.wrapper.proxyapplication.WrapperProxyApplication", loadPackageParam.classLoader, "attachBaseContext", Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Context context = (Context) param.args[0];
                ClassLoader classLoader = context.getClassLoader();
                AppStoreHook.hook(classLoader);
            }
        });
    }
}
