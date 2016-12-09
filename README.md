# Android-Google-Place-Photos

Simple android application which call the google place API to retrieve photos

You can access to the Google Place API guide [here](https://developers.google.com/places/android-api/photos)

App running on emulator NEXUS API 25

# Step 1

Create an account on https://console.developers.google.com, create your project and then activate the Google place API for android.

#Step 2 
Don't forget to add google 

compile 'com.google.android.gms:play-services:9.4.0'
compile 'com.google.android.gms:play-services-places:9.4.0'

The file should look like that:

```
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:25.0.1'
    compile 'com.android.support:design:25.0.1'compile 
    compile 'com.google.android.gms:play-services:9.4.0'
    compile 'com.google.android.gms:play-services-places:9.4.0'
}```
    
#Step 3

In the code, go to andrdoidManifest.xml and replace this line with your API KEY


```
	<meta-data
        android:name="com.google.android.geo.API_KEY"
        android:value="YOUR_API_KEY"/>

```


[npm-image]: https://#
[npm-url]: https://#
[travis-image]: https://#
[travis-url]: https://#
