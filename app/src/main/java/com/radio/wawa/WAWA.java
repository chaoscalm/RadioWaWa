package com.radio.wawa;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class WAWA implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        // Check if the loaded package is the target FM radio package
        if (!lpparam.packageName.equals("com.caf.fmradio"))
            return;

        // XposedBridge.log("[WAWA] started");

        // Hook the isAntennaAvailable method in FMRadioService
        findAndHookMethod("com.caf.fmradio.FMRadioService", lpparam.classLoader, "isAntennaAvailable", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                // XposedBridge.log("[WAWA] hooked FMRadioService.isAntennaAvailable");
                return true;
            }
        });

        // Hook the isAntennaAvailable method in FMRadio
        findAndHookMethod("com.caf.fmradio.FMRadio", lpparam.classLoader, "isAntennaAvailable", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                // XposedBridge.log("[WAWA] hooked FMRadio.isAntennaAvailable");
                return true;
            }
        });
    }
}
