package com.th7.flinspirer;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import java.security.interfaces.DSAPublicKey;
import java.util.ArrayList;

public class Hook implements IXposedHookLoadPackage {
    public final Context[] context = {null,null};
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
    
    Class AppInstrumentation = XposedHelpers.findClass("android.app.Instrumentation", null);
    
        if (loadPackageParam.packageName.equals("com.android.launcher3")) {
        
        String NickName="FLinspirer";
        
            //wanpeng_5.03.012.1
            Class DSAUtil = loadPackageParam.classLoader.loadClass("com.innofidei.guardsecure.util.d");
            Class PullNewsActivity = loadPackageParam.classLoader.loadClass("com.innofidei.guardsecure.dataclean.PullNewsActivity");
            Class UserInfoUtil = loadPackageParam.classLoader.loadClass("com.android.launcher3.a.o");
            Class LTKTactics = loadPackageParam.classLoader.loadClass("com.android.launcher3.model.LTKTactics");
            Class TacticsIllegal = loadPackageParam.classLoader.loadClass("com.android.launcher3.model.TacticsIllegal");
            Class DeviceSetting = loadPackageParam.classLoader.loadClass("com.android.launcher3.model.DeviceSetting");
            Class LogOutPassword = loadPackageParam.classLoader.loadClass("com.drupe.swd.launcher.huoshan.utils.a");
            Class DataCleanActivity = loadPackageParam.classLoader.loadClass("com.innofidei.guardsecure.dataclean.DataCleanActivity");
            Class CmdManager = loadPackageParam.classLoader.loadClass("com.drupe.swd.launcher.huoshan.mdm.tool.a");
            Class LTKLog = loadPackageParam.classLoader.loadClass("com.linspirer.utils.d.f");
            //Class LauncherNew = loadPackageParam.classLoader.loadClass("com.android.launcher3.LauncherNew");
            Class SystemPackageConstants = loadPackageParam.classLoader.loadClass("com.android.launcher3.etc.n");
            
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
            //改名
            XposedHelpers.findAndHookMethod(UserInfoUtil, "j", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(NickName);
                    XposedBridge.log("FLinspirer: Set Student Nickname "+NickName);
                }
            });
            */
            
            //log写入文件
            XposedHelpers.findAndHookMethod(LTKLog, "a",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                Log2File.Log("d "+param.args[0]);
                }
            });  
            
            XposedHelpers.findAndHookMethod(LTKLog, "a",String.class,String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log2File.Log("d "+param.args[0]+" "+param.args[1]);
                }
            });  
            
            XposedHelpers.findAndHookMethod(LTKLog, "b",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log2File.Log("i "+param.args[0]);
                }
            });  
            
            XposedHelpers.findAndHookMethod(LTKLog, "b",String.class,String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log2File.Log("i "+param.args[0]+" "+param.args[1]);
                }
            });  
            
            XposedHelpers.findAndHookMethod(LTKLog, "c",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log2File.Log("w "+param.args[0]);
                }
            });  
            
            XposedHelpers.findAndHookMethod(LTKLog, "c",String.class,String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log2File.Log("w "+param.args[0]+" "+param.args[1]);
                }
            });  
            
            XposedHelpers.findAndHookMethod(LTKLog, "d",String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log2File.Log("e "+param.args[0]);
                }
            });  
            
            XposedHelpers.findAndHookMethod(LTKLog, "d",String.class,String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log2File.Log("e "+param.args[0]+" "+param.args[1]);
                }
            });  
            //结束
            
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
                    boolean s1 = (boolean) param.args[0];
                    if(!s1){
                    param.args[0] = true;
                    XposedBridge.log("FLinspirer: Set Workspace Status Fucked ");
                    } 
                }
             });

            XposedHelpers.findAndHookMethod(TacticsIllegal, "getAlready_root", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(null);
                    XposedBridge.log("FLinspirer: Get Already Root Fucked.");
                    }
            });

            XposedHelpers.findAndHookMethod(TacticsIllegal, "getUsb_to_pc", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(null);
                    XposedBridge.log("FLinspirer: Get Usb to PC Fucked.");
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

             XposedHelpers.findAndHookMethod(CmdManager, "a",String.class,int.class,int.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                String s1 = (String) param.args[0];
                switch(s1) {
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
                    XposedBridge.log("FLinspirer: Command "+s1+" "+param.args[1]+" "+param.args[2]+" was given a green light.");
                    break;
                    }
                }
            });  
            
        }
        
        if (loadPackageParam.packageName.equals("com.ndwill.swd.appstore")) {
            //5.6.005
            Class AppItem = loadPackageParam.classLoader.loadClass("com.ndwill.swd.appstore.model.AppItem");
            Class DownloadCountUtil = loadPackageParam.classLoader.loadClass("com.ndwill.swd.appstore.a.b");
            Class LTKApkUtil = loadPackageParam.classLoader.loadClass("com.linspirer.utils.b");
            
                XposedHelpers.findAndHookMethod(AppInstrumentation, "callApplicationOnCreate", Application.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                }

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
            
            XposedHelpers.findAndHookMethod(DownloadCountUtil, "a", int.class,Context.class, new XC_MethodHook() {
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
}