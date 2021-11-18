# TypefaceHelper

[![Gitter](http://img.shields.io/badge/Gitter-Join%20Chat-brightgreen.svg?style=flat)](https://gitter.im/Drivemode/TypefaceHelper?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-TypefaceHelper-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1246)
[![License](http://img.shields.io/badge/License-Apache%202-brightgreen.svg?style=flat)](https://github.com/Drivemode/TypefaceHelper/blob/master/LICENSE)
[![Circle CI](https://circleci.com/gh/Drivemode/TypefaceHelper/tree/master.svg?style=shield)](https://circleci.com/gh/Drivemode/TypefaceHelper/tree/master)

Helper object for injecting typeface into various text views of android.

## Overview

We can use various custom typefaces asset for any text components (like Text, Button, RadioButton, etc.),
but there's no way to set the typeface as a styled theme to apply the typeface for overall screens in the app.

This library helps to do it in easy way :)

And there's also a serious bug that creating typeface from asset resource will cause memory leak ([See this link](https://code.google.com/p/android/issues/detail?id=9904) for more details),
this library will take care about this problem as well.

## TypefaceHelper 
A list inspired by the types of food 

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

And in your MainAbility, if you would like to set your typeface to a text ,

```java

public class MainAbility extends Ability {
    
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getCanonicalName());
        //super.setUIContent(ResourceTable.Layout_ability_main);
    }
}

```

You can also set your typeface for all text that belong to a specific ComoponentConatainer just like this.

```java
public class MyActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    LinearLayout container = (LinearLayout) findViewById(R.id.text_container);
    TypefaceHelper.getInstance().setTypeface(container, "font/font_file.ttf");
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
    }
}

```

Nice and easy!

You can apply the typeface to your whole window like this.

```java

public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                ToastDialog toastDialog = createToast("pos: " + i);
                TypefaceHelper.getInstance().setTypeface(
                        toastDialog,
                        "Isserley-Regular.ttf").show();
            }
        });

```

And... you can also pass the Component name as a string resource id:

```java
 
 public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
            Component convertView = component;
            if (convertView == null) {
                convertView = LayoutScatter.getInstance(getContext()).parse
                        (ResourceTable.Layout_list_item, componentContainer, false);
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
