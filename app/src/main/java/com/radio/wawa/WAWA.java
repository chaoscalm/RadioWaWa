package com.radio.wawa;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class WAWA implements IXposedHookLoadPackage {
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.caf.fmradio"))
            return;

        // XposedBridge.log("[WAWA] started");

        // https://github.com/LineageOS/android_vendor_qcom_opensource_fm-commonsys/blob/lineage-21.0/fmapp2/src/com/caf/fmradio/FMRadioService.java
        // https://github.com/LineageOS/android_vendor_qcom_opensource_fm-commonsys
       findAndHookMethod("com.caf.fmradio.FMRadioService", lpparam.classLoader, "isAntennaAvailable", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                // XposedBridge.log("[WAWA] hooked FMRadioService.isAntennaAvailable");
                return true;
            }
        });
        findAndHookMethod("com.caf.fmradio.FMRadio", lpparam.classLoader, "isAntennaAvailable", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                // XposedBridge.log("[WAWA] hooked FMRadio.isAntennaAvailable");
                return true;
            }
        });
    }
}
