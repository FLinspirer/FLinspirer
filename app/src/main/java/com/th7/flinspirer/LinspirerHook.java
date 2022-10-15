package com.th7.flinspirer;

import android.app.Application;
import android.widget.Toast;

import java.security.interfaces.DSAPublicKey;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class LinspirerHook {
    public static void hook(ClassLoader classLoader) throws Throwable {

            String NickName = "FLinspirer";

            //wanpeng_5.03.012.1
            Class DSAUtil = classLoader.loadClass("com.innofidei.guardsecure.util.d");
            Class PullNewsActivity = classLoader.loadClass("com.innofidei.guardsecure.dataclean.PullNewsActivity");
            Class UserInfoUtil = classLoader.loadClass("com.android.launcher3.a.o");
            Class LTKTactics = classLoader.loadClass("com.android.launcher3.model.LTKTactics");
            Class DeviceSetting = classLoader.loadClass("com.android.launcher3.model.DeviceSetting");
            Class LogOutPassword = classLoader.loadClass("com.drupe.swd.launcher.huoshan.utils.a");
            Class DataCleanActivity = classLoader.loadClass("com.innofidei.guardsecure.dataclean.DataCleanActivity");
            Class CmdManager = classLoader.loadClass("com.drupe.swd.launcher.huoshan.mdm.tool.a");
            Class LTKLog = classLoader.loadClass("com.linspirer.utils.d.f");
            //Class LauncherNew = classLoader.loadClass("com.android.launcher3.LauncherNew");
            Class SystemPackageConstants = classLoader.loadClass("com.android.launcher3.etc.n");

            /*
            XposedHelpers.findAndHookMethod(SystemPackageConstants, "a", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    ArrayList arrayList = (ArrayList) param.getResult();
                    arrayList.add("com.innofidei.guardsecure.AdminActivity");
                    arrayList.add("com.innofidei.guardsecure.WebSiteWhiteActivity");
                    arrayList.add("com.innofidei.guardsecure.ProtocolActivity");
                    arrayList.add("com.innofidei.guardsecure.RemoveControlDialogActivity");
                    arrayList.add("com.innofidei.guardsecure.AirSharingActivity");
                    arrayList.add("com.drupe.swd.launcher.huoshan.mdm.activity.DeviceRotatingActivity");
                    arrayList.add("com.innofidei.guardsecure.dataclean.MemoryUseDetailedActivity");
                    arrayList.add("com.innofidei.guardsecure.ParentalPatternActivity");
                    param.setResult(arrayList);
                }
            });
            */

            /*
            XposedHelpers.setStaticObjectField(LauncherNew, "W", new String[]{"com.ndwill.swd.appstore", "com.innofidei.guardsecure.LoginActivity","com.innofidei.guardsecure.networktest.NetworkTestActivity", "com.linspirer.android.networktest", "com.android.launcher3.protecteye.IndexActivity", "com.iflytek.zaowanting", "com.android.settings", "com.android.calendar", "com.android.deskclock", "com.android.camera.CameraLauncher", "com.android.gallery3d.app.GalleryActivity", "hugh.android.app.zidian", "com.innofidei.guardsecure.dataclean.DataCleanActivity", "com.innofidei.guardsecure.dataclean.PullNewsActivity",
             "com.innofidei.guardsecure.dataclean.MemoryUseDetailedActivity", "com.android.launcher3.ChangePwdActivity", "com.drupe.swd.launcher.huoshan.mdm.activity.DeviceRotatingActivity", "com.innofidei.guardsecure.AdminActivity", "com.innofidei.guardsecure.WebSiteWhiteActivity", "com.innofidei.guardsecure.PromptDialogActivity", "com.innofidei.guardsecure.RemoveControlDialogActivity"
            });
            */

        /*
            XposedHelpers.findAndHookMethod(UserInfoUtil, "j", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(NickName);
                    XposedBridge.log("FLinspirer: Set Student Nickname "+NickName);
                }
            });

         */

            //log写入文件
            XposedHelpers.findAndHookMethod(LTKLog, "a", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    Log2File.Log("d " + param.args[0]);
                }
            });

            XposedHelpers.findAndHookMethod(LTKLog, "a", String.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Log2File.Log("d " + param.args[0] + " " + param.args[1]);
                }
            });

            XposedHelpers.findAndHookMethod(LTKLog, "b", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Log2File.Log("i " + param.args[0]);
                }
            });

            XposedHelpers.findAndHookMethod(LTKLog, "b", String.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Log2File.Log("i " + param.args[0] + " " + param.args[1]);
                }
            });

            XposedHelpers.findAndHookMethod(LTKLog, "c", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Log2File.Log("w " + param.args[0]);
                }
            });

            XposedHelpers.findAndHookMethod(LTKLog, "c", String.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Log2File.Log("w " + param.args[0] + " " + param.args[1]);
                }
            });

            XposedHelpers.findAndHookMethod(LTKLog, "d", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Log2File.Log("e " + param.args[0]);
                }
            });

            XposedHelpers.findAndHookMethod(LTKLog, "d", String.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Log2File.Log("e " + param.args[0] + " " + param.args[1]);
                }
            });
            //结束

            XposedBridge.hookAllMethods(android.app.AlertDialog.Builder.class, "setFinishOnTouchOutside", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0] = true;
                }
            });


            XposedHelpers.findAndHookMethod(DSAUtil, "a", DSAPublicKey.class, String.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    DSAPublicKey s1 = (DSAPublicKey) param.args[0];
                    String s2 = (String) param.args[1];
                    String s3 = (String) param.args[2];
                    XposedBridge.log("FLinspirer: DSAPublicKey: " + s1 + " String after decode should be: " + s2 + " Barcode: " + s3 + "");
                    param.setResult(true);
                    XposedBridge.log("FLinspirer: Admin Login Fucked.");
                }
            });


            XposedHelpers.findAndHookMethod(PullNewsActivity, "a", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                    XposedBridge.log("FLinspirer: Pull News Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(PullNewsActivity, "b", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                    XposedBridge.log("FLinspirer: Pull News Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(LTKTactics, "isIllegal_status", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                    XposedBridge.log("FLinspirer: Get Illegal Status Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(LTKTactics, "setIllegal_status", boolean.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0] = false;
                    XposedBridge.log("FLinspirer: Set Illegal Status Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(LTKTactics, "isWorkspace_status", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(true);
                    XposedBridge.log("FLinspirer: Get Workspace Status Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(LTKTactics, "setWorkspace_status", boolean.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0] = true;
                    XposedBridge.log("FLinspirer: Set Workspace Status Fucked ");
                }
            });

            XposedHelpers.findAndHookMethod(LTKTactics, "getIllegal_tactics", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(null);
                    XposedBridge.log("FLinspirer: Get Illegal Tactics Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(DeviceSetting, "setGallery_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Gallery Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(DeviceSetting, "getGallery_status", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Gallery Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(DeviceSetting, "setCamera_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Camera Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(DeviceSetting, "getCamera_status", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Camera Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(DeviceSetting, "setCalendar_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Calendar Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(DeviceSetting, "getCalendar_status", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Calendar Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(DeviceSetting, "setAlarm_clock_status", int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.args[0] = 0;
                    XposedBridge.log("FLinspirer: Hide Clock Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(DeviceSetting, "getAlarm_clock_status", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(0);
                    XposedBridge.log("FLinspirer: Get Show Clock Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(LogOutPassword, "a", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String s = (String) param.args[0];
                    XposedBridge.log("FLinspirer: Log Out Password: " + s);
                    param.setResult(true);
                    XposedBridge.log("FLinspirer: Login Out Password Fucked.");
                }
            });

            XposedHelpers.findAndHookMethod(CmdManager, "a", String.class, int.class, int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String s1 = (String) param.args[0];
                    switch (s1) {
                        case "command_reset_factory":
                            param.args[0] = "";
                            XposedBridge.log("FLinspirer: Command Factory Reset Fucked.");
                            param.setResult(null);
                            break;
                        case "command_reboot_device":
                            param.args[0] = "";
                            XposedBridge.log("FLinspirer: Command Reboot Fucked.");
                            param.setResult(null);
                            break;
                        case "command_location":
                            param.args[1] = 0;
                            XposedBridge.log("FLinspirer: Command Report Location Fucked.");
                            break;
                        default:
                            XposedBridge.log("FLinspirer: Command " + s1 + " " + param.args[1] + " " + param.args[2] + " was given a green light.");
                            break;
                    }
                }
            });

    }
}
