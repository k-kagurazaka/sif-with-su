package jp.keita.kagurazaka.sifsu;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class SifSu implements IXposedHookLoadPackage {

  public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
    if (!lpparam.packageName.equals("klb.android.lovelive")) {
      return;
    }

    findAndHookMethod("klb.android.GameEngine.GameEngineActivity", lpparam.classLoader,
                      "isSuBinaryPresent", new XC_MethodReplacement() {
      @Override
      protected Object replaceHookedMethod(MethodHookParam methodHookParam)
          throws Throwable {
        return false;
      }
    });
  }
}
