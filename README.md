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

In the code, go to andrdoidManifest.xml and replace this line 


```js
// EXAMPLE: only log error responses
morgan('combined', {
  skip: function (req, res) { return res.statusCode < 400 }
})
```




#### Options

Morgan accepts these properties in the options object.

##### immediate

Write log line on request instead of response. This means that a requests will
be logged even if the server crashes, _but data from the response (like the
response code, content length, etc.) cannot be logged_.

##### skip

Function to determine if logging is skipped, defaults to `false`. This function
will be called as `skip(req, res)`.



[npm-image]: https://#
[npm-url]: https://#
[travis-image]: https://#
[travis-url]: https://#
