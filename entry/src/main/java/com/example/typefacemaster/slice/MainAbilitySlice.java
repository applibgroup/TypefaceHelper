package com.example.typefacemaster.slice;

import com.drivemode.harmony.typeface.TypefaceHelper;
import com.example.typefacemaster.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.*;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.utils.TextAlignment;
import ohos.agp.window.dialog.ToastDialog;

public class MainAbilitySlice extends AbilitySlice {

    private static final String TYPEFACE_NAME = "Isserley-Regular.ttf";
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        TypefaceHelper.initialize(this);
        TypefaceHelper.getInstance().setTypeface(this, TYPEFACE_NAME);

        ListContainer lv = (ListContainer) findComponentById(ResourceTable.Id_list_container);
        MainListProvider listProvider = new MainListProvider(getStringArray(ResourceTable.Strarray_sample_list));

        lv.setItemProvider(listProvider);
        lv.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                ToastDialog toastDialog = createToast("pos: " + i);
                TypefaceHelper.getInstance().setTypeface(
                        toastDialog,
                        TYPEFACE_NAME).show();
            }
        });


    }

    /**
     * The type Main list provider.
     */
    public class MainListProvider extends BaseItemProvider {
        /**
         * The List items.
         */
        String[] listItems;

        /**
         * Instantiates a new Main list provider.
         *
         * @param lst the lst
         */
        MainListProvider(String[] lst) {
            listItems = lst;
        }

        @Override
        public int getCount() {
            return listItems.length;
        }

        @Override
        public Object getItem(int position) {
            return listItems[position];
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
            TypefaceHelper.getInstance().setTypeface((Text) convertView, TYPEFACE_NAME);
            convertView.setClickable(false);
            return convertView;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        TypefaceHelper.destroy();
    }

    public ToastDialog createToast(String str) {
        Text text = new Text(this);
        text.setWidth(ComponentContainer.LayoutConfig.MATCH_PARENT);
        text.setHeight(ComponentContainer.LayoutConfig.MATCH_CONTENT);
        text.setTextSize(48);
        text.setText(str);
        text.setMultipleLine(true);
        text.setTextAlignment(TextAlignment.CENTER);
        ShapeElement shapeElement = (ShapeElement) buildDrawableByColor(Color.WHITE.getValue());
        text.setBackground(shapeElement);
        DirectionalLayout directionalLayout = new DirectionalLayout(this);
        directionalLayout.setBackground(shapeElement);
        DirectionalLayout.LayoutConfig layoutConfig = new DirectionalLayout.LayoutConfig
                (DirectionalLayout.LayoutConfig.MATCH_PARENT, DirectionalLayout.LayoutConfig.MATCH_CONTENT);
        layoutConfig.setMarginBottom(100);
        directionalLayout.setLayoutConfig(layoutConfig);
        directionalLayout.setPadding(20, 30, 20, 30);
        directionalLayout.addComponent(text);
        ToastDialog toastDialog = new ToastDialog(this);
        toastDialog.setComponent(directionalLayout);
        toastDialog.setAlignment(LayoutAlignment.BOTTOM).setTransparent(true);
        return toastDialog;
    }

    public static Element buildDrawableByColor(int color) {
        ShapeElement drawable = new ShapeElement();
        drawable.setShape(ShapeElement.RECTANGLE);
        drawable.setRgbColor(RgbColor.fromArgbInt(color));
        return drawable;
    }
}
