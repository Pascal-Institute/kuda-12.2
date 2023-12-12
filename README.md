# kuda
The gpu library (wrapping cuda) written by Kotlin

[![](https://jitpack.io/v/volta2030/kuda.svg)](https://jitpack.io/#volta2030/kuda)
[![](https://jitpack.io/v/volta2030/kuda/month.svg)](https://jitpack.io/#volta2030/kuda)

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
    implementation ("com.github.volta2030:kuda:1.0.0")
}

```

### 2. add vm options

```kotlin
-Djava.library.path=./src/main/resources
```

### 3. add dll files into /src/main/resources

![img.png](img.png)

## JDK Version
17

## CUDA Version
12.2

