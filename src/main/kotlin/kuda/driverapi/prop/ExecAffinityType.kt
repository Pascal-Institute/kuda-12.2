package kuda.driverapi.prop

/**
 *  Execution Affinity Types (CUexecAffinityType)
 *
 *  @property SM_COUNT Create a context with limited SMs.
 */
enum class ExecAffinityType(val num : Int) {
    SM_COUNT(0)
    //MAX
}