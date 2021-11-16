package com.drivemode.harmony.typeface;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
public class LogUtil {
    private static final String TAG_LOG = "SlideLayout";

    private static final int DOMAIN_ID = 0xD000F00;

    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, DOMAIN_ID, LogUtil.TAG_LOG);

    private static final String LOG_FORMAT = "%{public}s: %{public}s";

    private static boolean isLog = false;

    public static void setIsLog(boolean isLog) {
        LogUtil.isLog = isLog;
    }

    private LogUtil() {
        /* Do nothing */
    }

    /**
     * Print debug log
     *
     * @param tag log tag
     * @param msg log message
     */
    public static void d(String tag, String msg) {
        if (isLog) {
            HiLog.debug(LABEL_LOG, LOG_FORMAT, tag, msg);
        }
    }

    /**
     * Print info log
     *
     * @param tag log tag
     * @param msg log message
     */
    public static void i(String tag, String msg) {
        if (isLog) {
            HiLog.info(LABEL_LOG, LOG_FORMAT, tag, msg);
        }
    }

}
