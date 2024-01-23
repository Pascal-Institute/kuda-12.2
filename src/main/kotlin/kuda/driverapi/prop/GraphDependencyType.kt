package kuda.driverapi.prop

/**
 *
 * Type annotations that can be applied to graph edges as part of CUgraphEdgeData. (CUgraphDependencyType)
 *
 * @property DEFAULT This is an ordinary dependency.
 * @property PROGRAMMATIC This dependency type allows the downstream node to use cudaGridDependencySynchronize(). It may only be used between kernel nodes, and must be used with either the CU_GRAPH_KERNEL_NODE_PORT_PROGRAMMATIC or CU_GRAPH_KERNEL_NODE_PORT_LAUNCH_ORDER outgoing port.
 */
enum class GraphDependencyType(val num : Int) {
    DEFAULT(0),
    PROGRAMMATIC(1)
}