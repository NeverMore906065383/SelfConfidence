package com.example.selfconfidence.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.selfconfidence.BuildConfig;

import java.io.File;

/**
 * Copyright, 2017, WhyHow info, All right reserved.
 *
 * @author: yates
 * Mail: liyongchao@whyhowinfo.com
 * Created Time: 2017/3/2
 * Descroption:
 */
public class LogUtils {
    private static final String TAG = "WH_SDK ";
    /**
     * 类名
     */
    private static String CLASS_NAME;
    /**
     * 方法名
     */
    private static String METHOD_NAME;
    /**
     * 行数
     */
    private static int LINE_NUMBER;

    private static  LogUtils INSTANCE = null;
    private static String PATH_LOGCAT;
    private int mPId;


    private LogUtils(Context context) {
        init(context);
        mPId = android.os.Process.myPid();
    }

    private LogUtils() {
    }

    /**
     * 如果不是测试模式 则不进行日志打印  release
     */
//    public static boolean isDebuggable() {
//        return BuildConfig.DEBUG;
//    }
    public static boolean isDebuggable() {
        return BuildConfig.DEBUG;
    }

    private static String createLog(String log) {
        return TAG + METHOD_NAME +
                "(" + ":" + LINE_NUMBER + ")" +
                log;
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        CLASS_NAME = sElements[1].getFileName();
        METHOD_NAME = sElements[1].getMethodName();
        LINE_NUMBER = sElements[1].getLineNumber();
    }

    public void init(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            PATH_LOGCAT = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "LIDLOG";
        } else {// 如果SD卡不存在，就保存到本应用的目录下
            PATH_LOGCAT = context.getFilesDir().getAbsolutePath() + File.separator + "LIDLOG";
        }
        File file = new File(PATH_LOGCAT);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static LogUtils getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new LogUtils(context);
        }
        return INSTANCE;
    }

    public static LogUtils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogUtils();
        }
        return INSTANCE;
    }


    public static void e(String message) {
        if (!isDebuggable()) {
            return;
        }

        // Throwable instance must be created before any methods
        getMethodNames(new Throwable().getStackTrace());
        Log.e(CLASS_NAME, createLog(message));
    }


    public static void i(String message) {
        if (!isDebuggable()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.i(CLASS_NAME, createLog(message));
    }

    public static void d(String message) {
        if (!isDebuggable()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.d(CLASS_NAME, createLog(message));
    }

    public static void v(String message) {
        if (!isDebuggable()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.v(CLASS_NAME, createLog(message));
    }

    public static void w(String message) {
        if (!isDebuggable()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.w(CLASS_NAME, createLog(message));
    }

    public static void wtf(String message) {
        if (!isDebuggable()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(CLASS_NAME, createLog(message));
    }

    public static void info(String message) {
        if (!isDebuggable()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.d(CLASS_NAME, createLog(message));
    }

    public static void output(String message) {
        getMethodNames(new Throwable().getStackTrace());
        Log.i(CLASS_NAME, createLog(message));
    }

    public static void error(String message) {
        if (!isDebuggable()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        Log.e(CLASS_NAME, createLog(message));
    }



    public static String getMethodName() {
        return new Throwable().getStackTrace()[2].getMethodName();
    }
}