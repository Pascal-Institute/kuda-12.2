package kuda.driverapi.prop

/**
 *
 * Flags for instantiating a graph (CUgraphInstantiate_flags)
 *
 * @property AUTO_FREE_ON_LAUNCH Automatically free memory allocated in a graph before relaunching.
 * @property UPLOAD Automatically upload the graph after instantiation. Only supported by cuGraphInstantiateWithParams. The upload will be performed using the stream provided in instantiateParams.
 * @property DEVICE_LAUNCH Instantiate the graph to be launchable from the device. This flag can only be used on platforms which support unified addressing. This flag cannot be used in conjunction with AUTO_FREE_ON_LAUNCH.
 * @property USE_NODE_PRIORITY Run the graph using the per-node priority attributes rather than the priority of the stream it is launched into.
 */
enum class GraphInstantiateFlags(val num : Int) {
    AUTO_FREE_ON_LAUNCH(1),
    UPLOAD(2),
    DEVICE_LAUNCH(4),
    USE_NODE_PRIORITY(8)
}
