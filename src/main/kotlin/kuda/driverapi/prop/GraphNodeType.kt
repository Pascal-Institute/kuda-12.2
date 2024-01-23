package kuda.driverapi.prop

/**
 *
 * Graph node types
 *
 * @property KERNEL GPU kernel node
 * @property MEMCPY Memcpy node
 * @property MEMSET Memset node
 * @property HOST Host (executable) node
 * @property GRAPH Node which executes an embedded graph
 * @property EMPTY Empty (no-op) node
 * @property WAIT_EVENT External event wait node
 * @property EVENT_RECORD External event record node
 * @property EXT_SEMAS_SIGNAL External semaphore signal node
 * @property EXT_SEMAS_WAIT External semaphore wait node
 * @property MEM_ALLOC Memory Allocation Node
 * @property MEM_FREE Memory Free Node
 * @property BATCH_MEM_OP Batch MemOp Node
 * @property CONDITIONAL Conditional NodeMay be used to implement a conditional execution path or loop inside of a graph. The graph(s) contained within the body of the conditional node can be selectively executed or iterated upon based on the value of a conditional variable.Handles must be created in advance of creating the node using cuGraphConditionalHandleCreate.The following restrictions apply to graphs which contain conditional nodes: The graph cannot be used in a child node. Only one instantiation of the graph may exist at any point in time. The graph cannot be cloned.To set the control value:In a kernel or kernels at appropriate locations in the graph, insert a call to void cudaGraphSetConditional(CUgraphConditionalHandle handle, unsigned int value). Supply a default value when creating the handle.
 */
enum class GraphNodeType(val num : Int) {
    KERNEL(0),
    MEMCPY(1),
    MEMSET(2),
    HOST(3),
    GRAPH(4),
    EMPTY(5),
    WAIT_EVENT(6),
    EVENT_RECORD(7),
    EXT_SEMAS_SIGNAL(8),
    EXT_SEMAS_WAIT(9),
    MEM_ALLOC(10),
    MEM_FREE(11),
    BATCH_MEM_OP(12),
    CONDITIONAL(13)
}