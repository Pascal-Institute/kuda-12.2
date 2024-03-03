package kuda.runtimeapi.prop

import kuda.driverapi.prop.FuncCache

enum class FunctionCache(val num : Int) {
    PREFER_NONE(0),
    PREFER_SHARED(1),
    PREFER_L1(2),
    PREFER_EQUAL(3);

    companion object{
        fun fromInt(num : Int) : FunctionCache? = FunctionCache.entries.find { it.num == num }
    }
}