# TypefaceHelper

[![Build](https://github.com/applibgroup/TypefaceHelper/actions/workflows/main.yml/badge.svg)](https://github.com/applibgroup/TypefaceHelper/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=applibgroup_TypefaceHelper&metric=alert_status)](https://sonarcloud.io/dashboard?id=applibgroup_TypefaceHelper)

Helper object for injecting typeface into various text components of HarmonyOS.

## Overview

We can use various custom typefaces asset for any text components (like Text, Button, RadioButton, etc.),
but there's no way to set the typeface as a styled theme to apply the typeface for overall screens in the app.

This library helps to do it in easy way :)

And there's also a serious bug that creating typeface from asset resource will cause memory leak,
this library will take care about this problem as well.

## Source
This library has been inspired by https://github.com/Drivemode/TypefaceHelper

## How to use

In your MyApplication class, take care about the helper object lifecycle.

```java
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
```

And in your MainAbilitySlice, if you would like to set your typeface to a text ,

```java

public class MainAbilitySlice extends AbilitySlice {
    
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        
        Text hello = (Text) findComponentById(ResourceTable.Id_hello_world);
        TypefaceHelper.getInstance().setTypeface(hello, "font_file.ttf");
    }
}

```

You can also set your typeface for all text that belong to a specific ComoponentConatainer just like this.

```java
public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        DirectionalLayout container = (DirectionalLayout) findComponentById(ResourceTable.Id_container);
        TypefaceHelper.getInstance().setTypeface(container, "font_file.ttf");
    }
}
```

If you want to apply the typeface for all text under the AbilitySlice,

```java
public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        
        TypefaceHelper.getInstance().setTypeface(this, "font_file.ttf");
    }
}

```

Nice and easy!

You can apply the typeface to your whole window like this.

```java

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        
        TypefaceHelper.getInstance().setTypeface(this, "font_file.ttf");
    }
}

```

And... you can also pass the font name as a string resource id:

```java
 
 public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        
        TypefaceHelper.getInstance().setTypeface(this, Resourcetable.String_font_primary);
    }
}
```





## Integration

1. For using TypefaceHelper module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.
```java
 implementation project(path: ':TypefaceHelper')
```
2. For using TypefaceHelper module in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
 ```java
 implementation fileTree(dir: 'libs', include: ['*.har'])
```
3. For using TypefaceHelper module from a remote repository in separate application, add the below dependencies in entry/build.gradle file.
```java
implementation 'dev.applibgroup:TypefaceHelper:1.0.0'
```

## License

```
Copyright (C) 2014 Drivemode, Inc. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use
this file except in compliance with the License. You may obtain a copy of the
License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed
under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
CONDITIONS OF ANY KIND, either express or implied. See the License for the
specific language governing permissions and limitations under the License.
```

And the sample app uses the following font under [OFL](http://scripts.sil.org/cms/scripts/page.php?site_id=nrsi&id=OFL).

- [Isserley](http://openfontlibrary.org/en/font/isserley)
