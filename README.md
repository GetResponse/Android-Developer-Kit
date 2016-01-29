# GetResponseAPI Android SDK
![version](https://img.shields.io/github/release/GetResponse/Android-Developer-Kit.svg)
![licence](https://img.shields.io/github/license/GetResponse/Android-Developer-Kit.svg)
![platform](https://img.shields.io/badge/platform-android-green.svg)

GetResponse Android Developer Kit is a small SDK to help you with most common use cases in which you'd want to use GetResponse platform.

There is also a sample application where there are most simple examples of how to use our SDK. 

# Installation

In your app build.gradle add [jitpack.io](https://jitpack.io/docs/) repository add our library as dependency.
We use Jackson library, and because of their licence files inside jars you also have to exclude those files from your apk.

```
android { 
  ...
  packagingOptions {
    exclude 'META-INF/LICENSE'
  }
}
repositories {
  maven { url "https://jitpack.io" }
}

dependencies {
  compile 'com.github.GetResponse:Android-Developer-Kit:1.0.1'
}
```

Now you're ready to go. 
Check our [Cookbook](https://github.com/GetResponse/Android-Developer-Kit/wiki/cookbook) for usage examples.

