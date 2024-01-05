package kuda.runtimeapi.prop

enum class AccessProperty(val num : Int) {
    NORMAL(0),
    STREAMING(1),
    PERSISTING(2)
}