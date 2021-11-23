package com.drivemode.harmony.typeface;

import ohos.agp.text.Font;
import ohos.app.Context;
import ohos.app.Environment;
import ohos.global.resource.RawFileEntry;
import ohos.global.resource.Resource;
import ohos.global.resource.ResourceManager;

import java.io.*;
import java.util.Hashtable;
class TypefaceCache {
    private static TypefaceCache sInstance;

    private final Hashtable<String, Font> mCache = new Hashtable<String, Font>();

    private final Context mApplication;

    private TypefaceCache(Context application) {
        mApplication = application;
    }

    /**
     * If the cache has an instance for the typeface name, this will return the instance immediately.
     * Otherwise this method will create typeface instance and put it into the cache and return the instance.
     * @param name the typeface name.
     * @return {} instance.
     */
    public synchronized Font get(String name) {
        Font typeface = mCache.get(name);
        if(typeface == null) {
            try {
                typeface = createFontBuild(mApplication, name);
            } catch (Exception exp) {
                return null;
            }
            mCache.put(name, typeface);
        }
        return typeface;
    }

    Font createFontBuild(Context context, String name) throws IOException {
        ResourceManager resManager = context.getResourceManager();
        RawFileEntry rawFileEntry = resManager.getRawFileEntry("resources/rawfile/" + name);
        Resource resource = null;
        try {
            resource = rawFileEntry.openRawFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer fileName = new StringBuffer(name);
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), fileName.toString());
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            int index;
            byte[] bytes = new byte[1024];
            while ((index = resource.read(bytes)) != -1) {
                outputStream.write(bytes, 0, index);
                outputStream.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(resource != null){
                resource.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
        }
        Font.Builder builder = new Font.Builder(file);
        return builder.build();
    }

    /**
     * Retrieve this cache.
     * @param context the context.
     * @return the cache instance.
     */
    public static synchronized TypefaceCache getInstance(Context context) {
        if (sInstance == null)
            sInstance = new TypefaceCache(context.getApplicationContext());
        return sInstance;
    }
}
