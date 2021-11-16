package com.example.typefacesample;


import com.example.typefacesample.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility extends Ability {


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getCanonicalName());
        //super.setUIContent(ResourceTable.Layout_ability_main);

    }


}
