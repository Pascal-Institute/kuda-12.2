package kuda.runtimeapi.prop

/**
 * Launch attributes enum; used as id field of cudaLaunchAttribute
 *
 * @property IGNORE Ignored entry, for convenient composition
 * @property ACCESS_POLICY_WINDOW Valid for streams, graph nodes, launches. See Value::accessPolicyWindow.
 * @property COOPERATIVE  Valid for graph nodes, launches. See Value::cooperative.
 * @property SYNCHRONIZATION_POLICY Valid for streams. See Value::syncPolicy.
 * @property CLUSTER_DIMENSION  Valid for graph nodes, launches. See Value::clusterDim.
 * @property CLUSTER_SCHEDULING_POLICY_PREFERENCE Valid for graph nodes, launches. See Value::clusterSchedulingPolicyPreference.
 * @property PROGRAMMATIC_STREAM_SERIALIZATION Valid for launches. Setting Value::programmaticStreamSerializationAllowed to non-0 signals that the kernel will use programmatic means to resolve its stream dependency, so that the CUDA runtime should opportunistically allow the grid's execution to overlap with the previous kernel in the stream, if that kernel requests the overlap. The dependent launches can choose to wait on the dependency using the programmatic sync (cudaGridDependencySynchronize() or equivalent PTX instructions).
 * @property PROGRAMMATIC_EVENT Valid for launches. Set Value::programmaticEvent to record the event. Event recorded through this launch attribute is guaranteed to only trigger after all block in the associated kernel trigger the event. A block can trigger the event programmatically in a future CUDA release. A trigger can also be inserted at the beginning of each block's execution if triggerAtBlockStart is set to non-0. The dependent launches can choose to wait on the dependency using the programmatic sync (cudaGridDependencySynchronize() or equivalent PTX instructions). Note that dependents (including the CPU thread calling cudaEventSynchronize()) are not guaranteed to observe the release precisely when it is released. For example, cudaEventSynchronize() may only observe the event trigger long after the associated kernel has completed. This recording type is primarily meant for establishing programmatic dependency between device tasks. Note also this type of dependency allows, but does not guarantee, concurrent execution of tasks. The event supplied must not be an interprocess or interop event. The event must disable timing (i.e. must be created with the cudaEventDisableTiming flag set).
 * @property PRIORITY Valid for streams, graph nodes, launches. See Value::priority.
 * @property MEM_SYNC_DOMAIN_MAP Valid for streams, graph nodes, launches. See Value::memSyncDomainMap.
 * @property MEM_SYNC_DOMAIN Valid for streams, graph nodes, launches. See Value::memSyncDomain.
 * @property LAUNCH_COMPLETION_EVENT Valid for launches. Set Value::launchCompletionEvent to record the event. Nominally, the event is triggered once all blocks of the kernel have begun execution. Currently this is a best effort. If a kernel B has a launch completion dependency on a kernel A, B may wait until A is complete. Alternatively, blocks of B may begin before all blocks of A have begun, for example if B can claim execution resources unavailable to A (e.g. they run on different GPUs) or if B is a higher priority than A. Exercise caution if such an ordering inversion could lead to deadlock. A launch completion event is nominally similar to a programmatic event with triggerAtBlockStart set except that it is not visible to cudaGridDependencySynchronize() and can be used with compute capability less than 9.0. The event supplied must not be an interprocess or interop event. The event must disable timing (i.e. must be created with the cudaEventDisableTiming flag set).
 */

enum class LaunchAttributeID(val num: Int) {
    IGNORE(0),
    ACCESS_POLICY_WINDOW(1),
    COOPERATIVE(2),
    SYNCHRONIZATION_POLICY(3),
    CLUSTER_DIMENSION(4),
    CLUSTER_SCHEDULING_POLICY_PREFERENCE(5),
    PROGRAMMATIC_STREAM_SERIALIZATION(6),
    PROGRAMMATIC_EVENT(7),
    PRIORITY(8),
    MEM_SYNC_DOMAIN_MAP(9),
    MEM_SYNC_DOMAIN(10),
    LAUNCH_COMPLETION_EVENT(12)
}