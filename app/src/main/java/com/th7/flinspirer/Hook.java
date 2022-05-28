package com.th7.flinspirer;
import de.robv.android.xposed.*;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import java.security.interfaces.DSAPublicKey;

public class Hook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.android.launcher3")) {
        
            Class DSAUtil = loadPackageParam.classLoader.loadClass("com.innofidei.guardsecure.util.d");
            Class b = loadPackageParam.classLoader.loadClass("com.innofidei.guardsecure.dataclean.PullNewsActivity");
            Class c = loadPackageParam.classLoader.loadClass("com.AliPushReceiver");
            Class d = loadPackageParam.classLoader.loadClass("com.android.launcher3.model.LTKTactics");
            Class e = loadPackageParam.classLoader.loadClass("com.android.launcher3.model.TacticsIllegal");
            Class f = loadPackageParam.classLoader.loadClass("com.android.launcher3.model.DeviceSetting");
            Class g = loadPackageParam.classLoader.loadClass("com.drupe.swd.launcher.huoshan.utils.a");
            
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
            
            
            XposedHelpers.findAndHookMethod(b, "a", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                    XposedBridge.log("FLinspirer: Pull News Fucked.");
                }
            });
            
            XposedHelpers.findAndHookMethod(b, "b", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                    XposedBridge.log("FLinspirer: Pull News Fucked.");
                }
            });
            
            
            XposedHelpers.findAndHookMethod(c, "a",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.args[0] = "";
                XposedBridge.log("FLinspirer: Ali Push Fucked.");
                }
            });  
               
            XposedHelpers.findAndHookMethod(c, "a",String.class,int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.args[0] = "";
                XposedBridge.log("FLinspirer: Ali Push Fucked.");
                }
            });
            
            
            
            XposedHelpers.findAndHookMethod(d, "isIllegal_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    boolean res = (boolean) param.getResult();
                    if(res){
                    param.setResult(false);
                    XposedBridge.log("FLinspirer: Get Illegal Status Fucked.");
                    }
                }
            });
            
            XposedHelpers.findAndHookMethod(d, "setIllegal_status", boolean.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    boolean s1 = (boolean) param.args[0];
                    if(s1){
                    param.args[0] = false;
                    XposedBridge.log("FLinspirer: Set Illegal Status Fucked ");
                    } 
                }
               }); 
                XposedHelpers.findAndHookMethod(d, "isWorkspace_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    boolean res = (boolean) param.getResult();
                    if(!res){
                    param.setResult(true);
                    XposedBridge.log("FLinspirer: Get Workspace Status Fucked.");
                    }
                }
            });
            
            XposedHelpers.findAndHookMethod(d, "setWorkspace_status", boolean.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    boolean s1 = (boolean) param.args[0];
                    if(!s1){
                    param.args[0] = true;
                    XposedBridge.log("FLinspirer: Set Workspace Status Fucked ");
                    } 
                }
             });
             
            
            
            XposedHelpers.findAndHookMethod(e, "getAlready_root", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(null);
                    XposedBridge.log("FLinspirer: Get Already Root Fucked.");
                    }
            });

            XposedHelpers.findAndHookMethod(e, "getUsb_to_pc", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(null);
                    XposedBridge.log("FLinspirer: Get Usb to PC Fucked.");
                    }
            });
            
            
            
            XposedHelpers.findAndHookMethod(f, "setGallery_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    int s1 = (int) param.args[0];
                    if(s1==1){
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Gallery Fucked ");
                    } 
                }
             });
             
             XposedHelpers.findAndHookMethod(f, "getGallery_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    int res = (int) param.getResult();
                    if(res==1){
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Gallery Fucked.");
                    }
                }
            });
            
             XposedHelpers.findAndHookMethod(f, "setCamera_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    int s1 = (int) param.args[0];
                    if(s1==1){
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Camera Fucked ");
                    } 
                }
             });
             
             XposedHelpers.findAndHookMethod(f, "getCamera_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    int res = (int) param.getResult();
                    if(res==1){
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Camera Fucked.");
                    }
                    }
                
            });
            
             XposedHelpers.findAndHookMethod(f, "setCalendar_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    int s1 = (int) param.args[0];
                    if(s1==1){
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Calendar Fucked ");
                    } 
                }
             });
             
             XposedHelpers.findAndHookMethod(f, "getCalendar_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    int res = (int) param.getResult();
                    if(res==1){
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Calendar Fucked.");
                    }
                    }
                
            });
            
             XposedHelpers.findAndHookMethod(f, "setAlarm_clock_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    int s1 = (int) param.args[0];
                    if(s1==1){
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Clock Fucked ");
                    } 
                }
             });
            
            XposedHelpers.findAndHookMethod(f, "getAlarm_clock_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    int res = (int) param.getResult();
                    if(res==1){
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Clock Fucked.");
                    }
                }
            });
            
            XposedHelpers.findAndHookMethod(g, "a", String.class, new XC_MethodHook() {
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
