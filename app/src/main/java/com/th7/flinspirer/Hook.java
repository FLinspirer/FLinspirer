package com.th7.flinspirer;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.th7.shellentry.Tencent;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Hook implements IXposedHookLoadPackage {
    public final Context[] context = {null,null};
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.android.launcher3")) {
            Class AppInstrumentation = XposedHelpers.findClass("android.app.Instrumentation", null);
            Class TXShell = XposedHelpers.findClassIfExists("com.wrapper.proxyapplication.WrapperProxyApplication", loadPackageParam.classLoader);
            XposedHelpers.findAndHookMethod(AppInstrumentation, "callApplicationOnCreate", Application.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    if(param.args[0] instanceof Application){
                        context[0] = ((Application) param.args[0]).getApplicationContext();
                    } else {
                        return;
                    }
                    Toast.makeText(context[0], "FLinspirer: Got Context "+context[0].getPackageName(), Toast.LENGTH_LONG).show();
                }
            });

            if (TXShell == null){
                LinspirerHook.hook(loadPackageParam.classLoader);
            }
            else {
                Tencent.LinspirerHook(loadPackageParam);
            }

        }
        
        else if (loadPackageParam.packageName.equals("com.ndwill.swd.appstore")) {
            Class AppInstrumentation = XposedHelpers.findClass("android.app.Instrumentation", null);
            Class TXShell = XposedHelpers.findClassIfExists("com.wrapper.proxyapplication.WrapperProxyApplication", loadPackageParam.classLoader);
            XposedHelpers.findAndHookMethod(AppInstrumentation, "callApplicationOnCreate", Application.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    if(param.args[0] instanceof Application){
                        context[1] = ((Application) param.args[0]).getApplicationContext();
                    } else {
                        return;
                    }
                    Toast.makeText(context[1], "FLinspirer: Got Context "+context[1].getPackageName(), Toast.LENGTH_LONG).show();
                }
            });

            if (TXShell == null){
                AppStoreHook.hook(loadPackageParam.classLoader);
            }
            else {
                Tencent.AppStoreHook(loadPackageParam);
            }


        }
    }
}