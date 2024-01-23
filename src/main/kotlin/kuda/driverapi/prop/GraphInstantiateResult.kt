package kuda.driverapi.prop

/**
 *
 * Graph instantiation results (CUgraphInstantiateResult)
 *
 * @property SUCCESS Instantiation succeeded
 * @property ERROR Instantiation failed for an unexpected reason which is described in the return value of the function
 * @property INVALID_STRUCTURE Instantiation failed due to invalid structure, such as cycles
 * @property NODE_OPERATION_NOT_SUPPORTED Instantiation for device launch failed because the graph contained an unsupported operation
 * @property MULTIPLE_CTXS_NOT_SUPPORTED Instantiation for device launch failed due to the nodes belonging to different contexts
 */
enum class GraphInstantiateResult(val num : Int) {
    SUCCESS(0),
    ERROR(1),
    INVALID_STRUCTURE(2),
    NODE_OPERATION_NOT_SUPPORTED(3),
    MULTIPLE_CTXS_NOT_SUPPORTED(4)
}