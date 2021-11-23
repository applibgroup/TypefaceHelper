package com.drivemode.harmony.typeface;

import ohos.agp.components.Button;
import ohos.agp.window.dialog.BaseDialog;
import ohos.agp.window.dialog.CommonDialog;
import ohos.agp.window.dialog.IDialog;

final class DialogUtils {

    private DialogUtils() {
        throw new IllegalStateException("Utility class");
    }
    public static <D extends BaseDialog> void setTypeface(TypefaceHelper helper, D dialog, String typefaceName, int style) {
        if (dialog instanceof CommonDialog) {
            setTypeface(helper, (CommonDialog) dialog, typefaceName, style);
        }
    }
    private static void setTypeface(TypefaceHelper helper, CommonDialog alertDialog, String typefaceName, int style) {
        Button positive = (Button) alertDialog.obtainComponentViaId(IDialog.BUTTON1);
        Button negative = (Button) alertDialog.obtainComponentViaId(IDialog.BUTTON2);
        Button neutral = (Button) alertDialog.obtainComponentViaId(IDialog.BUTTON3);
        if (positive != null) {
            helper.setTypeface(positive, typefaceName, style);
        }
        if (negative != null) {
            helper.setTypeface(negative, typefaceName, style);
        }
        if (neutral != null) {
            helper.setTypeface(neutral, typefaceName, style);
        }
    }
}
