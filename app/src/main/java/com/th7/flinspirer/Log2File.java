package com.th7.flinspirer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;

public class Log2File {
    private static boolean isLogOn = true;
    private static String PATH_LINSPIRER_LOG = "/sdcard/FLinspirer/Linspirer_log";
    private static SimpleDateFormat logNameFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat logInnerTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void Log(String text) {
        if(!isLogOn){
           return;
        }
        Date nowtime = new Date();
        String needWriteFile = logNameFormat.format(nowtime);
        String needWriteMessage = logInnerTimeFormat.format(nowtime) + "    " + text;
        String MYLOGFILEName = ".log";
        String FILENaMe = needWriteFile + MYLOGFILEName;
        File dirsFile = new File(PATH_LINSPIRER_LOG);
        if (!dirsFile.exists()){
            dirsFile.mkdirs();
        }
        
        File file = new File(dirsFile.toString(), FILENaMe);
        if (!file.exists()) {
            try {
                for (File filedel : dirsFile.listFiles()) {
                    filedel.delete();
                }
                file.createNewFile();
            } catch (Exception e) {}
        }   

        try {
            FileWriter filerWriter = new FileWriter(file, true);
            BufferedWriter bufWriter = new BufferedWriter(filerWriter);
            bufWriter.write(needWriteMessage);
            bufWriter.newLine();
            bufWriter.close();
            filerWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}