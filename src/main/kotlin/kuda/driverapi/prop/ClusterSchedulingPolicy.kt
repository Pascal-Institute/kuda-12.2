package kuda.driverapi.prop

/**
 * Cluster scheduling policies. These may be passed to cuFuncSetAttribute or cuKernelSetAttribute (CUclusterSchedulingPolicy)
 *
 * @property DEFAULT the default policy
 * @property SPREAD spread the blocks within a cluster to the SMs
 * @property LOAD_BALANCING allow the hardware to load-balance the blocks in a cluster to the SMs
 */
enum class ClusterSchedulingPolicy(val num : Int) {
    DEFAULT(0),
    SPREAD(1),
    LOAD_BALANCING(2)
}