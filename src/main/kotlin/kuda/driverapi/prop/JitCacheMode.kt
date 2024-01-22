package kuda.driverapi.prop

/**
 *
 * Caching modes for dlcm
 *
 * @property OPTION_NONE Compile with no -dlcm flag specified
 */
enum class JitCacheMode(val num : Int) {
    OPTION_NONE(0)
    //OPTION_CG
    //OPTION_CA
}