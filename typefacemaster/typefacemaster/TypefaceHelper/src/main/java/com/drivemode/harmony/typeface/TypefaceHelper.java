package com.drivemode.harmony.typeface;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.Text;
import ohos.agp.render.Paint;
import ohos.agp.text.Font;
import ohos.agp.window.dialog.BaseDialog;
import ohos.agp.window.dialog.ToastDialog;
import ohos.app.Context;

import java.lang.reflect.Field;

public final class TypefaceHelper {
    public static final String TAG = TypefaceHelper.class.getSimpleName();
    private static TypefaceHelper sHelper;
    private final Context mApplication;
    private final TypefaceCache mCache;

    private TypefaceHelper(Context application) {
        mApplication = application;
        mCache = TypefaceCache.getInstance(application);
    }

    public static synchronized void initialize(Context application) {
        if (sHelper != null) {
            LogUtil.d(TAG, "already initialized");
        }
        sHelper = new TypefaceHelper(application);
    }

    public static synchronized void destroy() {
        if (sHelper == null) {
            LogUtil.d(TAG, "not initialized yet");
            return;
        }
        sHelper = null;
    }

    public static synchronized TypefaceHelper getInstance() {
        if (sHelper == null) {
            throw new IllegalArgumentException("Instance is not initialized yet. Call initialize() first.");
        }
        return sHelper;
    }

    /**
     * Fetches font instance from TypefaceCache
     * @param typefaceName typeface name.
     * @return requested typeface
     */
    public Font getTypeface(String typefaceName){
        return mCache.get(typefaceName);
    }
    /**
     * Set the typeface to the target view.
     * @param view to set typeface.
     * @param typefaceName typeface name.
     * @param <V> text view parameter.
     */
    public <V extends Text> void setTypeface(V view, String typefaceName) {
        Font typeface = mCache.get(typefaceName);
        view.setFont(typeface);
    }

    /**
     * Set the typeface to the target view.
     * @param view to set typeface.
     * @param strResId string resource containing typeface name.
     * @param <V> text view parameter.
     */
    public <V extends Text> void setTypeface(V view, int strResId) {
        setTypeface(view, mApplication.getString(strResId));
    }

    /**
     * Set the typeface to the target view.
     * @param view to set typeface.
     * @param typefaceName typeface name.
     * @param style the typeface style.
     * @param <V> text view parameter. */

    public <V extends Text> void setTypeface(V view, String typefaceName, int style) {
        Font typeface = mCache.get(typefaceName);
        view.setFont(typeface);
    }

    /**
     * Set the typeface to the target view.
     * @param view to set typeface.
     * @param strResId string resource containing typeface name.
     * @param style the typeface style.
     * @param <V> text view parameter.*/

    public <V extends Text> void setTypeface(V view, int strResId, int style) {
        setTypeface(view, mApplication.getString(strResId), style);
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * Note that this method recursively trace the child view groups and set typeface for the text views.
     * @param viewGroup the view group that contains text views.
     * @param typefaceName typeface name.
     * @param <V> view group parameter.
     */
    public <V extends ComponentContainer> void setTypeface(V viewGroup, String typefaceName) {
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            Component child = viewGroup.getComponentAt(i);
            if (child instanceof ComponentContainer) {
                setTypeface((ComponentContainer) child, typefaceName);
                continue;
            }
            if (!(child instanceof Text)) {
                continue;
            }
            setTypeface((Text) child, typefaceName);
        }
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * Note that this method recursively trace the child view groups and set typeface for the text views.
     * @param viewGroup the view group that contains text views.
     * @param strResId string resource containing typeface name.
     * @param <V> view group parameter.
     */
    public <V extends ComponentContainer> void setTypeface(V viewGroup, int strResId) {
        setTypeface(viewGroup, mApplication.getString(strResId));
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * Note that this method recursively trace the child view groups and set typeface for the text views.
     * @param viewGroup the view group that contains text views.
     * @param typefaceName typeface name.
     * @param style the typeface style.
     * @param <V> view group parameter.
     */
    public <V extends ComponentContainer> void setTypeface(V viewGroup, String typefaceName, int style) {
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            Component child = viewGroup.getComponentAt(i);
            if (child instanceof ComponentContainer) {
                setTypeface((ComponentContainer) child, typefaceName, style);
                continue;
            }
            if (!(child instanceof Text)) {
                continue;
            }

            setTypeface((Text) child, typefaceName, style);
        }
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * Note that this method recursively trace the child view groups and set typeface for the text views.
     * @param viewGroup the view group that contains text views.
     * @param strResId string resource containing typeface name.
     * @param style the typeface style.
     * @param <V> view group parameter.
     */
    public <V extends ComponentContainer> void setTypeface(V viewGroup, int strResId, int style) {
        setTypeface(viewGroup, mApplication.getString(strResId), style);
    }

    /**
     * Set the typeface to the target paint.
     * @param paint the set typeface.
     * @param typefaceName typeface name.
     */
    public void setTypeface(Paint paint, String typefaceName) {
        Font typeface = mCache.get(typefaceName);
        paint.setFont(typeface);
    }

    /**
     * Set the typeface to the target paint.
     * @param paint the set typeface.
     * @param strResId string resource containing typeface name.
     */
    public void setTypeface(Paint paint, int strResId) {
        setTypeface(paint, mApplication.getString(strResId));
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * @param context the context.
     * @param layoutRes the layout resource id.
     * @param typefaceName typeface name.
     * @return the view.
     */
    public Component setTypeface(Context context, int layoutRes, String typefaceName) {
        return setTypeface(context, layoutRes, null, typefaceName);
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * @param context the context.
     * @param layoutRes the layout resource id.
     * @param parent the parent view group to attach the layout.
     * @param typefaceName typeface name.
     * @return the view.
     */
    public Component setTypeface(Context context, int layoutRes, ComponentContainer parent, String typefaceName) {
        ComponentContainer view = (ComponentContainer)
                LayoutScatter.getInstance(context).parse(layoutRes, parent, false);
        setTypeface(view, typefaceName);
        return view;
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * @param context the context.
     * @param layoutRes the layout resource id.
     * @param parent the parent view group to attach the layout.
     * @param strResId string resource containing typeface name.
     * @return the view.
     */
    public Component setTypeface(Context context, int layoutRes, ComponentContainer parent, int strResId) {
        return setTypeface(context, layoutRes, parent, mApplication.getString(strResId));
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * @param context the context.
     * @param layoutRes the layout resource id.
     * @param typefaceName typeface name.
     * @param style the typeface style.
     * @return the view.
     */
    public Component setTypeface(Context context, int layoutRes, String typefaceName, int style) {
        return setTypeface(context, layoutRes, null, typefaceName, 0);
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * @param context the context.
     * @param layoutRes the layout resource id.
     * @param strResId string resource containing typeface name.
     * @param style the typeface style.
     * @return the view.
     */
    public Component setTypeface(Context context, int layoutRes, int strResId, int style) {
        return setTypeface(context, layoutRes, mApplication.getString(strResId), 0);
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * @param context the context.
     * @param layoutRes the layout resource id.
     * @param parent the parent view group to attach the layout.
     * @param typefaceName typeface name.
     * @param style the typeface style.
     * @return the view.
     */
    public Component setTypeface(Context context, int layoutRes, ComponentContainer parent, String typefaceName, int style) {
        ComponentContainer view = (ComponentContainer)
                LayoutScatter.getInstance(context).parse(layoutRes, parent,false);
        setTypeface(view, typefaceName, style);
        return view;
    }

    /**
     * Set the typeface to the all text views belong to the view group.
     * @param context the context.
     * @param layoutRes the layout resource id.
     * @param parent the parent view group to attach the layout.
     * @param strResId string resource containing typeface name.
     * @param style the typeface style.
     * @return the view.
     */
    public Component setTypeface(Context context, int layoutRes, ComponentContainer parent, int strResId, int style) {
        return setTypeface(context, layoutRes, parent, mApplication.getString(strResId), style);
    }

    /**
     * Set the typeface to the all text views belong to the activity.
     * Note that we use decor view of the activity so that the typeface will also be applied to action bar.
     * @param activity the activity.
     * @param typefaceName typeface name.
     */
    public void setTypeface(AbilitySlice activity, String typefaceName) {
        setTypeface(activity, typefaceName, 0);
    }

    /**
     * Set the typeface to the all text views belong to the activity.
     * Note that we use decor view of the activity so that the typeface will also be applied to action bar.
     * @param activity the activity.
     * @param strResId string resource containing typeface name.
     */
    public void setTypeface(AbilitySlice activity, int strResId) {
        setTypeface(activity, mApplication.getString(strResId));
    }

    /**
     * Set the typeface to the all text views belong to the activity.
     * Note that we use decor view of the activity so that the typeface will also be applied to action bar.
     * @param activity the activity.
     * @param typefaceName typeface name.
     * @param style the typeface style.
     */
    public void setTypeface(AbilitySlice activity, String typefaceName, int style) {
        //setTypeface((ComponentContainer) activity.getWindow().getCurrentComponentFocus().get(), typefaceName, style);
        setTypeface((ComponentContainer) getCurrentComponentContainer(activity), typefaceName, style);
    }

    public static Component getCurrentComponentContainer(AbilitySlice abilitySlice){
        try{
            Field uiContent = AbilitySlice.class.getDeclaredField("uiContent");
            uiContent.setAccessible(true);
            Object uiContentObj = uiContent.get(abilitySlice);
            LogUtil.i("Gowtham uiContentObj : " , uiContentObj.toString());

            Field curComponentContainer = uiContentObj.getClass().getSuperclass()
                    .getDeclaredField("curComponentContainer");
            curComponentContainer.setAccessible(true);
            Object curComponentContainerObj = curComponentContainer.get(uiContentObj);

            LogUtil.i("Gowtham curComponentContainerObj : " , curComponentContainerObj.toString());


            return (Component) curComponentContainerObj;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Set the typeface to the all text views belong to the activity.
     * Note that we use decor view of the activity so that the typeface will also be applied to action bar.
     * @param activity the activity.
     * @param strResId string resource containing typeface name.
     * @param style the typeface style.
     */
    public void setTypeface(AbilitySlice activity, int strResId, int style) {
        setTypeface(activity, mApplication.getString(strResId), style);
    }

    /**
     * Set the typeface to the all text views belong to the fragment.
     * Make sure to call this method after fragment view creation.
     * If you use fragments in the support package,
     * call {@link com.drivemode.harmony.typeface.TypefaceHelper#supportSetTypeface(ohos.aafwk.ability.fraction.Fraction, String)} instead.
     * @param fragment the fragment.
     * @param typefaceName typeface name.
     */
    public <F extends ohos.aafwk.ability.fraction.Fraction> void setTypeface(F fragment, String typefaceName) {
        setTypeface(fragment, typefaceName, 0);
    }

    /**
     * Set the typeface to the all text views belong to the fragment.
     * Make sure to call this method after fragment view creation.
     * If you use fragments in the support package,
     * call {@link com.drivemode.harmony.typeface.TypefaceHelper#supportSetTypeface(ohos.aafwk.ability.fraction.Fraction, String)} instead.
     * @param fragment the fragment.
     * @param strResId string resource containing typeface name.
     */
    public <F extends ohos.aafwk.ability.fraction.Fraction> void setTypeface(F fragment, int strResId) {
        setTypeface(fragment, mApplication.getString(strResId));
    }

    /**
     * Set the typeface to the all text views belong to the fragment.
     * Make sure to call this method after fragment view creation.
     * If you use fragments in the support package,
     * call {@link com.drivemode.harmony.typeface.TypefaceHelper#supportSetTypeface(ohos.aafwk.ability.fraction.Fraction, String, int)} instead.
     * @param fragment the fragment.
     * @param typefaceName typeface name.
     * @param style the typeface style.
     */
    public <F extends ohos.aafwk.ability.fraction.Fraction> void setTypeface(F fragment, String typefaceName, int style) {
        Component root = fragment.getComponent();
        if (root instanceof Text) {
            setTypeface((Text) root, typefaceName, style);
        } else if (root instanceof ComponentContainer) {
            setTypeface((ComponentContainer) root, typefaceName, style);
        }
    }

    /**
     * Set the typeface to the all text belong to the fragment.
     * Make sure to call this method after fragment view creation.
     * If you use fragments in the support package,
     * call {@link com.drivemode.harmony.typeface.TypefaceHelper#supportSetTypeface(ohos.aafwk.ability.fraction.Fraction, String, int)} instead.
     * @param fragment the fragment.
     * @param strResId string resource containing typeface name.
     * @param style the typeface style.
     */
    public <F extends ohos.aafwk.ability.fraction.Fraction> void setTypeface(F fragment, int strResId, int style) {
        setTypeface(fragment, mApplication.getString(strResId), style);
    }

    /**
     * Set the typeface to the all text views belong to the fragment.
     * Make sure to call this method after fragment view creation.
     * And this is a support package fragments only.
     * @param fragment the fragment.
     * @param typefaceName typeface name.
     */
    public <F extends ohos.aafwk.ability.fraction.Fraction> void supportSetTypeface(F fragment, String typefaceName) {
        supportSetTypeface(fragment, typefaceName, 0);
    }

    /**
     * Set the typeface to the all text views belong to the fragment.
     * Make sure to call this method after fragment view creation.
     * And this is a support package fragments only.
     * @param fragment the fragment.
     * @param strResId string resource containing typeface name.
     */
    public <F extends ohos.aafwk.ability.fraction.Fraction> void supportSetTypeface(F fragment, int strResId) {
        supportSetTypeface(fragment, mApplication.getString(strResId));
    }

    /**
     * Set the typeface to the all text views belong to the fragment.
     * Make sure to call this method after fragment view creation.
     * And this is a support package fragments only.
     * @param fragment the fragment.
     * @param typefaceName typeface name.
     * @param style the typeface style.
     */
    public <F extends ohos.aafwk.ability.fraction.Fraction> void supportSetTypeface(F fragment, String typefaceName, int style) {
        Component root = fragment.getComponent();
        if (root instanceof Text) {
            setTypeface((Text) root, typefaceName, style);
        } else if (root instanceof ComponentContainer) {
            setTypeface((ComponentContainer) root, typefaceName, style);
        }
    }

    /**
     * Set the typeface to the all text views belong to the fragment.
     * Make sure to call this method after fragment view creation.
     * And this is a support package fragments only.
     * @param fragment the fragment.
     * @param strResId string resource containing typeface name.
     * @param style the typeface style.
     */
    public <F extends ohos.aafwk.ability.fraction.Fraction> void supportSetTypeface(F fragment, int strResId, int style) {
        supportSetTypeface(fragment, mApplication.getString(strResId), style);
    }

    /**
     * Set the typeface for the dialog view.
     * @param dialog the dialog.
     * @param typefaceName typeface name.
     */
    public <D extends BaseDialog> void setTypeface(D dialog, String typefaceName) {
        setTypeface(dialog, typefaceName, 0);
    }

    /**
     * Set the typeface for the dialog view.
     * @param dialog the dialog.
     * @param typefaceName typeface name.
     * @param style the typeface style.
     */
    public <D extends BaseDialog> void setTypeface(D dialog, String typefaceName, int style) {
        DialogUtils.setTypeface(this, dialog, typefaceName, style);
    }

    /**
     * Set the typeface for the dialog view.
     * @param dialog the dialog.
     * @param strResId string resource containing typeface name.
     * @param style the typeface style.
     */
    public <D extends BaseDialog> void setTypeface(D dialog, int strResId, int style) {
        setTypeface(dialog, mApplication.getString(strResId), style);
    }

    /**
     * Set the typeface for the toast view.
     * @param toast toast.
     * @param typefaceName typeface name.
     * @return toast that the typeface is injected.
     */
    public ToastDialog setTypeface(ToastDialog toast, String typefaceName) {
        return setTypeface(toast, typefaceName, 0);
    }

    /**
     * Set the typeface for the toast view.
     * @param toast toast.
     * @param strResId string resource containing typeface name.
     * @return toast that the typeface is injected.
     */
    public ToastDialog setTypeface(ToastDialog toast, int strResId) {
        return setTypeface(toast, mApplication.getString(strResId));
    }

    /**
     * Set the typeface for the toast view.
     * @param toast toast.
     * @param typefaceName typeface name.
     * @param style the typeface style.
     * @return toast that the typeface is injected.
     */
    public ToastDialog setTypeface(ToastDialog toast, String typefaceName, int style) {
        setTypeface((ComponentContainer) toast.getComponent(), typefaceName, style);
        return toast;
    }

    /**
     * Set the typeface for the toast view.
     * @param toast toast.
     * @param strResId string resource containing typeface name.
     * @param style the typeface style.
     * @return toast that the typeface is injected.
     */
    public ToastDialog setTypeface(ToastDialog toast, int strResId, int style) {
        return setTypeface(toast, mApplication.getString(strResId), style);
    }
}
