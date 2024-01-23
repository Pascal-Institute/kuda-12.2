package kuda.driverapi.prop

/**
 *
 * CUDA Graph Update error types (CUgraphExecUpdateResult)
 *
 * @property SUCCESS The update succeeded
 * @property ERROR The update failed for an unexpected reason which is described in the return value of the function
 * @property ERROR_TOPOLOGY_CHANGED The update failed because the topology changed
 * @property ERROR_NODE_TYPE_CHANGED The update failed because a node type changed
 * @property ERROR_FUNCTION_CHANGED The update failed because the function of a kernel node changed (CUDA driver < 11.2)
 * @property ERROR_PARAMETERS_CHANGED The update failed because the parameters changed in a way that is not supported
 * @property ERROR_NOT_SUPPORTED The update failed because something about the node is not supported
 * @property ERROR_UNSUPPORTED_FUNCTION_CHANGE The update failed because the function of a kernel node changed in an unsupported way
 * @property ERROR_ATTRIBUTES_CHANGED The update failed because the node attributes changed in a way that is not supported
 */
enum class GraphExecUpdateResult(val num : Int) {
    SUCCESS(0x0),
    ERROR(0x1),
    ERROR_TOPOLOGY_CHANGED(0x2),
    ERROR_NODE_TYPE_CHANGED(0x3),
    ERROR_FUNCTION_CHANGED(0x4),
    ERROR_PARAMETERS_CHANGED(0x5),
    ERROR_NOT_SUPPORTED(0x6),
    ERROR_UNSUPPORTED_FUNCTION_CHANGE(0x7),
    ERROR_ATTRIBUTES_CHANGED(0x8)
}