package com.example.typefacesample;

import com.drivemode.harmony.typeface.TypefaceHelper;
import ohos.aafwk.ability.AbilityPackage;

public abstract class MyApplication extends AbilityPackage {
    @Override
    public void onInitialize() {
        super.onInitialize();
        TypefaceHelper.initialize(this);
    }

    @Override
    public void onEnd() {
        super.onEnd();
        TypefaceHelper.destroy();
    }
}