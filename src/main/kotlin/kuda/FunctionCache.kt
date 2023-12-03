package kuda

enum class FunctionCache(val num : Int) {
    PREFER_NONE(0),
    PREFER_SHARED(1),
    PREFER_L1(2),
    PREFER_EQUAL(3)
}