## ohos-Bootstrap

## Introduction
ohos-Bootstrap is an Harmony library which provides custom views styled according to the
 [Twitter Bootstrap Specification](http://getbootstrap.com/). This allows you to spend more time
  on development rather than trying to get a consistent theme across your app, especially if you are already familiar with the Bootstrap Framework.

## Usage Instruction
Supported Features with usage Examples

### BootstrapButton
A button that supports Glyph icons, and is themeable using Bootstrap Brands.
```xml
<com.beardedhen.harmonybootstrap.BootstrapButton
    ohos:id="$+id:bbutton_example_corners"
    ohos:height="match_content"
    ohos:width="match_content"
    app:bootstrapBrand="success"
    app:bootstrapSize="lg"
    app:buttonMode="regular"
    ohos:right_margin="4vp"
    app:roundedCorners="true"
    app:showOutline="false"
    ohos:text="Corners" />
```
<img src="./images/bootstrap_button.png" width=450 ></img>


### BootstrapButtonGroup
Allows BootstrapButtons to be grouped together and their attributes controlled en masse.
```xml
<com.beardedhen.harmonybootstrap.BootstrapButtonGroup
    ohos:id="$+id:bbutton_group_orientation_change"
    ohos:width="match_content"
    ohos:height="match_content"
    ohos:bottom_margin="4vp"
    ohos:orientation="horizontal"
    app:bootstrapBrand="success"
    ohos:clickable="true"
    app:bootstrapSize="lg"
    app:roundedCorners="true" >
    
    <com.beardedhen.harmonybootstrap.BootstrapButton
        ohos:width="match_content"
        ohos:height="match_content"
        ohos:text="1"
        ohos:clickable="true" />

    <com.beardedhen.harmonybootstrap.BootstrapButton
        ohos:width="match_content"
        ohos:height="match_content"
        ohos:text="2"
        ohos:clickable="true" />
    
    <com.beardedhen.harmonybootstrap.BootstrapButton
        ohos:width="match_content"
        ohos:height="match_content"
        ohos:text="3"
        ohos:clickable="true" />
</com.beardedhen.harmonybootstrap.BootstrapButtonGroup>
```
<img src="./images/bootstrap_buttongroup.png" width=450 ></img>

### BootstrapProgressBar
Displays progress in a bar from 0-100, and animates updates to the current progress.
```xml
<com.beardedhen.harmonybootstrap.BootstrapProgressBar
    ohos:id="$+id:stripedProgressBar"
    ohos:height="15vp"
    ohos:left_margin="10vp"
    ohos:right_margin="5vp"
    ohos:padding="3vp"
    ohos:top_margin="5vp"
    ohos:width="match_parent"
    ohos:left_padding="3vp"
    app:bootstrapBrand="info"
    app:bootstrapProgress="60"
    app:bootstrapMaxProgress="200"
    app:striped="true" />
```
<img src="./images/bootstrap_progressbar.png" width=450 ></img>


### BootstrapLabel
Displays non-clickable text in a widget similar to the BootstrapButton, sizable using H1-H6 elements.
```xml
<com.beardedhen.harmonybootstrap.BootstrapLabel
    ohos:id="$+id:example_blabel_change_rounded"
    ohos:height="match_content"
    ohos:width="match_content"
    ohos:right_margin="4vp"
    ohos:text="Round"
    app:bootstrapBrand="primary"
    app:bootstrapHeading="h3"
    app:roundedCorners="true"/>
```
<img src="./images/bootstrap_label.png" width=450 ></img>

### BootstrapEditText
Allows editing of text in a widget themed using BootstrapBrand.
```xml
<com.beardedhen.harmonybootstrap.BootstrapEditText
    ohos:id="$+id:bedit_text_change_size"
    ohos:height="match_content"
    ohos:width="0vp"
    app:bootstrapSize="md"
    app:bootstrapBrand="info"
    ohos:weight="2"/>
```
<img src="./images/bootstrap_edittext.png" width=450 ></img>

### BootstrapCircleThumbnail
Displays images in a center-cropped Circular View, themed with BootstrapBrand.
```xml
<com.beardedhen.harmonybootstrap.BootstrapCircleThumbnail
    ohos:id="$+id:bcircle_theme_change_example"
    ohos:width="250vp"
    ohos:height="250vp"
    ohos:image_src="$media:small_daffodils"
    app:bootstrapBrand="success"
    app:hasBorder="true"/>
```
<img src="./images/bootstrap_circle_thumbnail.png" width=450 ></img>

### BootstrapThumbnail
Displays images in a rectangular View, themed with BootstrapBrand.
```xml
<com.beardedhen.harmonybootstrap.BootstrapThumbnail
    ohos:id="$+id:bthumb_theme_change_example"
    ohos:height="250vp"
    ohos:width="250vp"
    app:bootstrapBrand="success"
    app:hasBorder="true"
    ohos:image_src="$media:small_daffodils"/>
```
<img src="./images/bootstrap_thumbnail.png" width=450 ></img>

### BootstrapWell
Displays a view in a themed container.

```xml
<com.beardedhen.harmonybootstrap.BootstrapWell
    ohos:height="match_content"
    ohos:width="match_parent"
    ohos:layout_alignment="center"
    ohos:margin="8vp"
    app:bootstrapSize="xl">

    <Text
        ohos:height="match_content"
        ohos:width="match_content"
        ohos:text_alignment="right"
        ohos:text_size="14vp"
        ohos:text_color="$color:grey"
        ohos:text="$string:bootstrapwell_large"/>

</com.beardedhen.harmonybootstrap.BootstrapWell>
```
<img src="./images/bootstrap_well.png" width=450 ></img>


### BootstrapDropDown
Displays a view with dropdown options, supplied by an array of strings, use public void setDropdownData(String[] dropdownData) API to supply string array, refer sample app for more details.

```xml
<com.beardedhen.harmonybootstrap.BootstrapDropDown
    ohos:id="$+id:medium"
    ohos:height="match_content"
    ohos:width="match_content"
    ohos:left_margin="8vp"
    app:bootstrapBrand="regular"
    app:bootstrapExpandDirection="down"
    app:bootstrapSize="md"
    app:bootstrapText="Medium"
    app:roundedCorners="true" />
```
<img src="./images/bootstrap_dropdown.png" width=450 ></img>

### BootstrapBadge
Displays view with the bootstrap badges.

```xml
<com.beardedhen.harmonybootstrap.BootstrapBadge
    ohos:id="$+id:lonely_badge"
    ohos:height="12vp"
    ohos:width="80vp"
    app:badgeText="I am a Badge!!!"
    app:bootstrapSize="sm"
    ohos:layout_alignment="horizontal_center"/>
```
<img src="./images/bootstrap_badge.png" width=450 ></img>

### BootstrapAlert
Displays view with the bootstrap alert.

```xml
<com.beardedhen.harmonybootstrap.BootstrapAlert
        ohos:id="$+id:dynamic_alert"
        ohos:width="match_parent"
        ohos:height="match_content"
        ohos:top_margin="10vp"
        app:bootstrapBrand="success"
        ohos:layout_alignment="horizontal_center"
        app:dismissible="true"
        app:messageText="You successfully read this important alert message."
        app:strongText="Well done!"
        />
```
<img src="./images/bootstrap_alert.png" width=450 ></img>

### BootstrapProgressBarGroup
Displays view with the bootstrap progressbars grouped.

```xml
<com.beardedhen.harmonybootstrap.BootstrapProgressBarGroup
    ohos:id="$+id:example_progress_bar_group_add_group"
    ohos:height="match_content"
    ohos:width="match_parent"
    app:bootstrapMaxProgress="100"
    app:bootstrapSize="md">

    <com.beardedhen.harmonybootstrap.BootstrapProgressBar
        ohos:height="0vp"
        ohos:width="0vp"
        app:bootstrapBrand="success"
        app:bootstrapProgress="20"
        app:bootstrapSize="md"
        app:striped="true"
        />

    <com.beardedhen.harmonybootstrap.BootstrapProgressBar
        ohos:height="0vp"
        ohos:width="0vp"
        app:bootstrapBrand="warning"
        app:bootstrapProgress="20"
        app:bootstrapSize="md"
        />

</com.beardedhen.harmonybootstrap.BootstrapProgressBarGroup>
```

<img src="./images/bootstrap_progressbar_group.png" width=450 ></img>

## Installation instruction
```
Method 1:
Generate the .har package through the library and add the .har package to the libs folder.
Add the following code to the entry gradle:
    implementation fileTree  (dir: 'libs', include: ['*.jar', '*.har'])

Method 2:
In project level build.gradle:
    allprojects{
        repositories{
            mavenCentral()
        }
    }
Add the following code to the entry gradle:
    implementation 'io.openharmony.tpc.thirdlib:ohos-bootstrap:1.0.0'
```