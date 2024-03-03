package kuda.runtimeapi.prop

/**
 * CUDA function cache configurations (cudaFuncCache)
 *
 * @property PREFER_NONE Default function cache configuration, no preference
 * @property PREFER_SHARED prefer larger shared memory and smaller L1 cache
 * @property PREFER_L1 prefer larger L1 cache and smaller shared memory
 * @property PREFER_EQUAL prefer equal sized L1 cache and shared memory
 */
enum class FuncCache(val num : Int) {
    PREFER_NONE(0),
    PREFER_SHARED(1),
    PREFER_L1(2),
    PREFER_EQUAL(3);

    companion object{
        fun fromInt(num : Int) : FuncCache? = FuncCache.entries.find { it.num == num }
    }
}