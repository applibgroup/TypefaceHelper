package com.example.typefacesample;


import com.drivemode.harmony.typeface.TypefaceHelper;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.agp.window.dialog.ToastDialog;
import ohos.app.Context;
import ohos.global.resource.NotExistException;
import ohos.global.resource.ResourceManager;
import ohos.global.resource.WrongTypeException;

import java.io.IOException;

public class MainAbility extends Ability {


    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        //super.setMainRoute(MainAbilitySlice.class.getName());

        ListContainer lv = (ListContainer) findComponentById(ResourceTable.Id_list_container);
        String welcome = getString(ResourceTable.String_welcome);
        MainListProvider listProvider = new MainListProvider(getStringArray(ResourceTable.Strarray_sample_list));

        lv.setItemProvider(listProvider);
        lv.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                ToastDialog toastDialog = new ToastDialog(MainAbility.this);
                toastDialog.setText("pos: " + i);
                toastDialog.setAlignment(TableLayout.Alignment.ALIGNMENT_BOTTOM);
                TypefaceHelper.getInstance().setTypeface(
                        toastDialog,
                        "Isserley-Regular.ttf").show();
            }
        });

        // You can also pass the typeface name stored in a string resource
        TypefaceHelper.getInstance().setTypeface(this, ResourceTable.String_mainability_description);
    }

    /**
     * The type Main list provider.
     */
    public class MainListProvider extends BaseItemProvider {
        /**
         * The List items.
         */
        String[] list_items;

        /**
         * Instantiates a new Main list provider.
         *
         * @param lst the lst
         */
        MainListProvider(String[] lst) {
            list_items = lst;
        }

        @Override
        public int getCount() {
            return list_items.length;
        }

        @Override
        public Object getItem(int position) {
            return list_items[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
            Component convertView = component;
            if (convertView == null) {
                convertView = LayoutScatter.getInstance(getContext()).parse
                        (ResourceTable.Layout_list_item, componentContainer, false);
            }
            ((Text) (convertView.findComponentById(ResourceTable.Id_list_component))).setText
                    ((String) getItem(position));
            TypefaceHelper.getInstance().setTypeface((Text) convertView, "Isserley-Regular.ttf");
            convertView.setClickable(false);
            return convertView;
        }
    }

    public static String[] getInt(Context context, int id) {
        String[] result = new String[0];
        if (context == null) {
            return result;
        }
        ResourceManager manager = context.getResourceManager();
        if (manager == null) {
            return result;
        }
        try {
            result = manager.getElement(id).getStringArray();
        } catch (NotExistException e) {
            e.printStackTrace();
        } catch (WrongTypeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

