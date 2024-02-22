# kuda
The gpu library (wrapping cuda) written by Kotlin

[![](https://jitpack.io/v/kudakit/kuda-12.2.svg)](https://jitpack.io/#kudakit/kuda-12.2)
[![](https://jitpack.io/v/kudakit/kuda-12.2/month.svg)](https://jitpack.io/#kudakit/kuda-12.2)

![kuda_icon.png](src%2Fmain%2Fresources%2Fkuda_icon.png)

## How to use? (Please Check Latest Version)

### 0. Install JDK(17) & CUDA Toolkit (12.2)

### 1. Add library in build.gradle.kts
```kotlin
repositories {
    maven{
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation ("com.github.kudakit:kuda-12.2:3.1.0")
}

```

### 2. add vm options

```kotlin
-Djava.library.path=./src/main/resources
```

### 3. add dll files into /src/main/resources

![img.png](img.png)

## Support OS
Windows

## JDK Version
17

## CUDA Version
12.2

