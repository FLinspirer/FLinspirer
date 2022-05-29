package com.th7.flinspirer;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import java.security.interfaces.DSAPublicKey;

public class Hook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.android.launcher3")) {
            //wanpeng_5.02.004
            Class AppInstrumentation = XposedHelpers.findClass("android.app.Instrumentation", null);
            Class DSAUtil = loadPackageParam.classLoader.loadClass("com.innofidei.guardsecure.util.d");
            Class PullNewsActivity = loadPackageParam.classLoader.loadClass("com.innofidei.guardsecure.dataclean.PullNewsActivity");
            Class AliPushReceiver = loadPackageParam.classLoader.loadClass("com.AliPushReceiver");
            Class LTKTactics = loadPackageParam.classLoader.loadClass("com.android.launcher3.model.LTKTactics");
            Class TacticsIllegal = loadPackageParam.classLoader.loadClass("com.android.launcher3.model.TacticsIllegal");
            Class DeviceSetting = loadPackageParam.classLoader.loadClass("com.android.launcher3.model.DeviceSetting");
            Class LogOutPassword = loadPackageParam.classLoader.loadClass("com.drupe.swd.launcher.huoshan.utils.a");
            final Context[] context = {null};

            XposedHelpers.findAndHookMethod(AppInstrumentation, "callApplicationOnCreate", Application.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                }

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

            XposedBridge.hookAllMethods(android.app.AlertDialog.Builder.class, "setCancelable", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0]=true;
                }
            });

            XposedBridge.hookAllMethods(android.app.AlertDialog.Builder.class, "setFinishOnTouchOutside", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0]=true;
                }
            });


            XposedHelpers.findAndHookMethod(DSAUtil, "a", DSAPublicKey.class,String.class,String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    DSAPublicKey s1 = (DSAPublicKey) param.args[0];
                    String s2 = (String) param.args[1];
                    String s3 = (String) param.args[2];
                    XposedBridge.log("FLinspirer: DSAPublicKey: " + s1+" String after decode should be: "+s2+" Barcode: "+s3+"");
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(true);
                    XposedBridge.log("FLinspirer: Admin Login Fucked.");
                }
            });
            
            
            XposedHelpers.findAndHookMethod(PullNewsActivity, "a", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                    XposedBridge.log("FLinspirer: Pull News Fucked.");
                }
            });
            
            XposedHelpers.findAndHookMethod(PullNewsActivity, "b", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                    XposedBridge.log("FLinspirer: Pull News Fucked.");
                }
            });
            
            
            XposedHelpers.findAndHookMethod(AliPushReceiver, "a",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.args[0] = "";
                XposedBridge.log("FLinspirer: Ali Push Fucked.");
                }
            });  
               
            XposedHelpers.findAndHookMethod(AliPushReceiver, "a",String.class,int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.args[0] = "";
                XposedBridge.log("FLinspirer: Ali Push Fucked.");
                }
            });
            
            
            
            XposedHelpers.findAndHookMethod(LTKTactics, "isIllegal_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    boolean res = (boolean) param.getResult();
                    if(res){
                    param.setResult(false);
                    XposedBridge.log("FLinspirer: Get Illegal Status Fucked.");
                    }
                }
            });
            
            XposedHelpers.findAndHookMethod(LTKTactics, "setIllegal_status", boolean.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    boolean s1 = (boolean) param.args[0];
                    if(s1){
                    param.args[0] = false;
                    XposedBridge.log("FLinspirer: Set Illegal Status Fucked.");
                    } 
                }
               }); 
                XposedHelpers.findAndHookMethod(LTKTactics, "isWorkspace_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    boolean res = (boolean) param.getResult();
                    if(!res){
                    param.setResult(true);
                    XposedBridge.log("FLinspirer: Get Workspace Status Fucked.");
                    }
                }
            });
            
            XposedHelpers.findAndHookMethod(LTKTactics, "setWorkspace_status", boolean.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    boolean s1 = (boolean) param.args[0];
                    if(!s1){
                    param.args[0] = true;
                    XposedBridge.log("FLinspirer: Set Workspace Status Fucked ");
                    } 
                }
             });
             
            
            
            XposedHelpers.findAndHookMethod(TacticsIllegal, "getAlready_root", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(null);
                    XposedBridge.log("FLinspirer: Get Already Root Fucked.");
                    }
            });

            XposedHelpers.findAndHookMethod(TacticsIllegal, "getUsb_to_pc", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(null);
                    XposedBridge.log("FLinspirer: Get Usb to PC Fucked.");
                    }
            });
            
            
            
            XposedHelpers.findAndHookMethod(DeviceSetting, "setGallery_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    int s1 = (int) param.args[0];
                    if(s1==1){
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Gallery Fucked.");
                    } 
                }
             });
             
             XposedHelpers.findAndHookMethod(DeviceSetting, "getGallery_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    int res = (int) param.getResult();
                    if(res==1){
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Gallery Fucked.");
                    }
                }
            });
            
             XposedHelpers.findAndHookMethod(DeviceSetting, "setCamera_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    int s1 = (int) param.args[0];
                    if(s1==1){
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Camera Fucked.");
                    } 
                }
             });
             
             XposedHelpers.findAndHookMethod(DeviceSetting, "getCamera_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    int res = (int) param.getResult();
                    if(res==1){
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Camera Fucked.");
                    }
                    }
                
            });
            
             XposedHelpers.findAndHookMethod(DeviceSetting, "setCalendar_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    int s1 = (int) param.args[0];
                    if(s1==1){
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Calendar Fucked.");
                    } 
                }
             });
             
             XposedHelpers.findAndHookMethod(DeviceSetting, "getCalendar_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    int res = (int) param.getResult();
                    if (res == 1) {
                        param.setResult(0);
                        XposedBridge.log("FLinspirer: Get Show Calendar Fucked.");
                    }
                }
            });
            
             XposedHelpers.findAndHookMethod(DeviceSetting, "setAlarm_clock_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    int s1 = (int) param.args[0];
                    if(s1==1){
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Clock Fucked.");
                    } 
                }
             });
            
            XposedHelpers.findAndHookMethod(DeviceSetting, "getAlarm_clock_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    int res = (int) param.getResult();
                    if(res==1){
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Clock Fucked.");
                    }
                }
            });
            
            XposedHelpers.findAndHookMethod(LogOutPassword, "a", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String s = (String) param.args[0];
                    XposedBridge.log("FLinspirer: Log Out Password: " + s);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(true);
                    XposedBridge.log("FLinspirer: Login Out Password Fucked.");
                }
             });

        }
    }
}
