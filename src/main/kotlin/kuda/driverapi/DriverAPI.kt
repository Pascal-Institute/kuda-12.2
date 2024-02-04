package kuda.driverapi

import kuda.driverapi.prop.*

class DriverAPI {

    private external fun getErrorName(error : Int) : String
    fun getErrorName(error : Result) : String {
        return getErrorName(error.num)
    }

    private external fun getErrorString(error : Int) : String
    fun getErrorString(error : Result) : String {
        return getErrorString(error.num)
    }

    external fun init(flags : Int) : Int

    external fun driverGetVersion() : Int

    external fun deviceGet(ordinal : Int) : Int

    external fun deviceGetCount() : Int

    external fun devicePrimaryCtxRelease(dev : Int) : Int

    external fun devicePrimaryCtxReset(dev : Int) : Int

    /**
     *  Retain the primary context on the GPU. (cuDevicePrimaryCtxRetain)
     */
    external fun devicePrimaryCtxRetain(dev : Int) : Long

    external fun devicePrimaryCtxSetFlags(dev : Int, flags : UInt) : Int

    /**
     *  Destroy a CUDA context. (cuCtxDestroy)
     */
    external fun ctxDestroy(ctx : Long) : Int

    /**
     *  Gets the context's API version. (cuCtxGetApiVersion)
     */
    external fun ctxGetApiVersion(ctx : Long) : Int

    /**
     * Returns the preferred cache configuration for the current context. (cuCtxGetCacheConfig)
     */
    private external fun ctxGetCacheConfig(dummy : Boolean) : Int
    fun ctxGetCacheConfig() : FuncCache {
       return FuncCache.fromInt(ctxGetCacheConfig(false))!!
    }

    /**
     *  Returns the CUDA context bound to the calling CPU thread. (cuCtxGetCurrent)
     */
    external fun ctxGetCurrent() : Long


    /**
     * Returns the device ID for the current context. (cuCtxGetDevice)
     */
    external fun ctxGetDevice() : Int

    //8. Context Management
    /**
     *  Returns the flags for the current context. (cuCtxGetFlags)
     */
    external fun ctxGetFlags() : UInt

    /**
     *  Returns the current shared memory configuration for the current context. (cuCtxGetSharedMemConfig)
     */
    external fun ctxGetSharedMemConfig(dummy : Boolean) : Int
    fun ctxGetSharedMemConfig() : SharedConfig {
        return SharedConfig.fromInt(ctxGetSharedMemConfig(false))!!
    }

    /**
     *  Returns numerical values that correspond to the least and greatest stream priorities. (cuCtxGetStreamPriorityRange)
     */
    external fun ctxGetStreamPriorityRange() : IntArray

    /**
     *  Pops the current CUDA context from the current CPU thread. (cuCtxPopCurrent)
     */
    external fun ctxPopCurrent() : Long

    /**
     *  Pushes a context on the current CPU thread. (cuCtxPushCurrent)
     */
    external fun ctxPushCurrent(ctx : Long) : Int

    /**
     * Resets all persisting lines in cache to normal status.
     */
    external fun ctxResetPersistingL2Cache() : Int

    /**
     * Sets the preferred cache configuration for the current context.
     */
    private external fun ctxSetCacheConfig(config : Int) : Int
    fun ctxSetCacheConfig(config : FuncCache) : Int {
        return ctxSetCacheConfig(config.num)
    }

    /**
     * Sets the flags for the current context.
     */
    external fun ctxSetFlags(flags : UInt) : Int

    /**
     * Set resource limits.
     */
    private external fun ctxSetLimit(limit : Byte, value : Int) : Int
    fun ctxSetLimit(limit : Limit, value : Int) : Int {
        return ctxSetLimit(limit.byte, value)
    }

    /**
     * Block for a context's tasks to complete.
     */
    external fun ctxSynchronize() : Int

    //9. Context Management (DEPRECATED)

    //10. Module Management
    /**
     *  Destroys state for a JIT linker invocation. (cuLinkDestroy)
     */
    external fun linkDestroy(state : Long) : Int

    /**
     *  Query lazy loading mode. (cuModuleGetLoadingMode)
     */
    private external fun moduleGetLoadingMode(dummy : Boolean) : Int
    fun moduleGetLoadingMode() : ModuleLoadingMode {
        return ModuleLoadingMode.fromInt(moduleGetLoadingMode(false))!!
    }

    /**
     * Unloads a module. (cuModuleUnload)
     */
    external fun moduleUnload(hmod : Long) : Int

    //11. Module Management (DEPRECATED)

    //12. Library Management
    /**
     * Unloads a library. (cuLibraryUnload)
     */
    external fun libraryUnload(library : Long) : Int

    //13. Memory Management
    /**
    * Destroys a CUDA array. (cuArrayDestroy)
    */
    external fun destroyArray(hArray : Long) : Int

    /**
     * Attempts to close memory mapped with cuIpcOpenMemHandle. (cuIpcCloseMemHandle)
     */
    external fun ipcCloseMemHandle(dptr : Long) : Int

    /**
     * Frees device memory. (cuMemFree)
     */
    external fun memFree(dptr : Long) : Int

    /**
     * Frees page-locked host memory. (cuMemFreeHost)
     */
    external fun memFreeHost(p : Long) : Int

    /**
     *  Unregisters a memory range that was registered with cuMemHostRegister. (cuMemHostUnregister)
     */
    external fun memHostUnregister(p : Long) : Int

    //14. Virtual Memory Management
    //CUresult cuMemAddressFree(CUdeviceptr ptr, size_t size)
    //CUresult cuMemAddressReserve(CUdeviceptr* ptr, size_t size, size_t alignment, CUdeviceptr addr, unsigned long long flags)
    //CUresult cuMemCreate(CUmemGenericAllocationHandle* handle, size_t size, const CUmemAllocationProp* prop, unsigned long long flags)
    //CUresult cuMemExportToShareableHandle(void* shareableHandle, CUmemGenericAllocationHandle handle, CUmemAllocationHandleType handleType, unsigned long long flags)
    //CUresult cuMemGetAccess(unsigned long long* flags, const CUmemLocation* location, CUdeviceptr ptr)
    //CUresult cuMemGetAllocationGranularity(size_t * granularity, const CUmemAllocationProp * prop, CUmemAllocationGranularity_flags option)
    //CUresult cuMemGetAllocationPropertiesFromHandle(CUmemAllocationProp * prop, CUmemGenericAllocationHandle handle)
    //CUresult cuMemImportFromShareableHandle(CUmemGenericAllocationHandle * handle, void* osHandle, CUmemAllocationHandleType shHandleType)
    //CUresult cuMemMap(CUdeviceptr ptr, size_t size, size_t offset, CUmemGenericAllocationHandle handle, unsigned long long flags)
    //CUresult cuMemMapArrayAsync(CUarrayMapInfo * mapInfoList, unsigned int  count, CUstream hStream)

    /**
     * 	Release a memory handle representing a memory allocation which was previously allocated through cuMemCreate. (cuMemRelease)
     */
    external fun memRelease(handle : Long) : Int

    //CUresult cuMemRetainAllocationHandle(CUmemGenericAllocationHandle * handle, void* addr)
    //CUresult cuMemSetAccess(CUdeviceptr ptr, size_t size, const CUmemAccessDesc * desc, size_t count)	//CUresult cuMemUnmap(CUdeviceptr ptr, size_t size)

    //15. Steam Ordered Memory Allocator
    //CUresult cuMemAllocAsync(CUdeviceptr* dptr, size_t bytesize, CUstream hStream)
    //CUresult cuMemAllocFromPoolAsync(CUdeviceptr* dptr, size_t bytesize, CUmemoryPool pool, CUstream hStream)
    //CUresult cuMemFreeAsync(CUdeviceptr dptr, CUstream hStream)
    //CUresult cuMemPoolCreate(CUmemoryPool* pool, const CUmemPoolProps* poolProps)

    /**
     * 	Destroys the specified memory pool. (cuMemPoolDestroy)
     */
    external fun memPoolDestroy(pool : Long) : Int

    //CUresult cuMemPoolExportPointer(CUmemPoolPtrExportData* shareData_out, CUdeviceptr ptr)
    //CUresult cuMemPoolExportToShareableHandle(void* handle_out, CUmemoryPool pool, CUmemAllocationHandleType handleType, unsigned long long flags)
    //CUresult cuMemPoolGetAccess(CUmemAccess_flags* flags, CUmemoryPool memPool, CUmemLocation* location)
    //CUresult cuMemPoolGetAttribute(CUmemoryPool pool, CUmemPool_attribute attr, void* value)
    //CUresult cuMemPoolImportFromShareableHandle(CUmemoryPool* pool_out, void* handle, CUmemAllocationHandleType handleType, unsigned long long flags)
    //CUresult cuMemPoolImportPointer(CUdeviceptr* ptr_out, CUmemoryPool pool, CUmemPoolPtrExportData* shareData)
    //CUresult cuMemPoolSetAccess(CUmemoryPool pool, const CUmemAccessDesc* map, size_t count)
    //CUresult cuMemPoolSetAttribute(CUmemoryPool pool, CUmemPool_attribute attr, void* value)
    //CUresult cuMemPoolTrimTo(CUmemoryPool pool, size_t minBytesToKeep)

    //16. Multicast Object Management
    //CUresult cuMulticastAddDevice(CUmemGenericAllocationHandle mcHandle, CUdevice dev)
    //CUresult cuMulticastBindAddr(CUmemGenericAllocationHandle mcHandle, size_t mcOffset, CUdeviceptr memptr, size_t size, unsigned long long flags)
    //CUresult cuMulticastBindMem(CUmemGenericAllocationHandle mcHandle, size_t mcOffset, CUmemGenericAllocationHandle memHandle, size_t memOffset, size_t size, unsigned long long flags)
    //CUresult cuMulticastCreate(CUmemGenericAllocationHandle* mcHandle, const CUmulticastObjectProp* prop)
    //CUresult cuMulticastGetGranularity(size_t* granularity, const CUmulticastObjectProp* prop, CUmulticastGranularity_flags option)
    //CUresult cuMulticastUnbind(CUmemGenericAllocationHandle mcHandle, CUdevice dev, size_t mcOffset, size_t size)

    //17. Unified Addressing
    //CUresult cuMemAdvise(CUdeviceptr devPtr, size_t count, CUmem_advise advice, CUdevice device)
    //CUresult cuMemAdvise_v2(CUdeviceptr devPtr, size_t count, CUmem_advise advice, CUmemLocation location)
    //CUresult cuMemPrefetchAsync(CUdeviceptr devPtr, size_t count, CUdevice dstDevice, CUstream hStream)
    //CUresult cuMemPrefetchAsync_v2(CUdeviceptr devPtr, size_t count, CUmemLocation location, unsigned int  flags, CUstream hStream)
    //CUresult cuMemRangeGetAttribute(void* data, size_t dataSize, CUmem_range_attribute attribute, CUdeviceptr devPtr, size_t count)
    //CUresult cuMemRangeGetAttributes(void** data, size_t* dataSizes, CUmem_range_attribute* attributes, size_t numAttributes, CUdeviceptr devPtr, size_t count)
    //CUresult cuPointerGetAttribute(void* data, CUpointer_attribute attribute, CUdeviceptr ptr)
    //CUresult cuPointerGetAttributes(unsigned int  numAttributes, CUpointer_attribute* attributes, void** data, CUdeviceptr ptr)
    //CUresult cuPointerSetAttribute(const void* value, CUpointer_attribute attribute, CUdeviceptr ptr)

    //18. Stream Management
    //CUresult cuStreamAddCallback(CUstream hStream, CUstreamCallback callback, void* userData, unsigned int  flags)
    //CUresult cuStreamAttachMemAsync(CUstream hStream, CUdeviceptr dptr, size_t length, unsigned int  flags)
    //CUresult cuStreamBeginCapture(CUstream hStream, CUstreamCaptureMode mode)
    //CUresult cuStreamBeginCaptureToGraph(CUstream hStream, CUgraph hGraph, const CUgraphNode* dependencies, const CUgraphEdgeData* dependencyData, size_t numDependencies, CUstreamCaptureMode mode)
    //CUresult cuStreamCopyAttributes(CUstream dst, CUstream src)
    //CUresult cuStreamCreate(CUstream* phStream, unsigned int  Flags)
    //CUresult cuStreamCreateWithPriority(CUstream* phStream, unsigned int  flags, int  priority)

    /**
     * 	Destroys a stream. (cuStreamDestroy)
     */
    external fun streamDestroy(hStream : Long) : Int

    //CUresult cuStreamEndCapture(CUstream hStream, CUgraph* phGraph)
    //CUresult cuStreamGetAttribute(CUstream hStream, CUstreamAttrID attr, CUstreamAttrValue* value_out)
    //CUresult cuStreamGetCaptureInfo(CUstream hStream, CUstreamCaptureStatus* captureStatus_out, cuuint64_t* id_out, CUgraph* graph_out, const CUgraphNode** dependencies_out, size_t* numDependencies_out)
    //CUresult cuStreamGetCaptureInfo_v3(CUstream hStream, CUstreamCaptureStatus * captureStatus_out, cuuint64_t * id_out, CUgraph * graph_out, const CUgraphNode * *dependencies_out, const CUgraphEdgeData * *edgeData_out, size_t * numDependencies_out)
    //CUresult cuStreamGetCtx(CUstream hStream, CUcontext * pctx)
    //CUresult cuStreamGetFlags(CUstream hStream, unsigned int* flags)
    //CUresult cuStreamGetId(CUstream hStream, unsigned long long* streamId)
    //CUresult cuStreamGetPriority(CUstream hStream, int* priority)
    //CUresult cuStreamIsCapturing(CUstream hStream, CUstreamCaptureStatus * captureStatus)

    /**
     * 	Determine status of a compute stream. (cuStreamQuery)
     */
    external fun streamQuery(hStream : Long) : Int

    //CUresult cuStreamSetAttribute(CUstream hStream, CUstreamAttrID attr, const CUstreamAttrValue * value)

    /**
     * 	Wait until a stream's tasks are completed. (cuStreamSynchronize)
     */
    external fun streamSynchronize(hStream : Long) : Int

    //CUresult cuStreamUpdateCaptureDependencies(CUstream hStream, CUgraphNode * dependencies, size_t numDependencies, unsigned int  flags)
    //CUresult cuStreamUpdateCaptureDependencies_v2(CUstream hStream, CUgraphNode * dependencies, const CUgraphEdgeData * dependencyData, size_t numDependencies, unsigned int  flags)
    //CUresult cuStreamWaitEvent(CUstream hStream, CUevent hEvent, unsigned int  Flags)

    /**
     *  Update the set of dependencies in a capturing stream (11.3+). (cuThreadExchangeStreamCaptureMode)
     */
    private external fun threadExchangeStreamCaptureMode(mode : Int) : Int
    fun threadExchangeStreamCaptureMode(mode : StreamCaptureMode) : Int {
        return threadExchangeStreamCaptureMode(mode.num)
    }

    //19.Event Management
    //CUresult cuEventCreate(CUevent * phEvent, unsigned int  Flags)

    /**
     *  Destroys an event. (cuEventDestroy)
     */
    external fun eventDestroy(hEvent : Long) : Int

    //CUresult cuEventElapsedTime(float* pMilliseconds, CUevent hStart, CUevent hEnd)

    /**
     *  Queries an event's status (cuEventQuery)
     */
    external fun eventQuery(hEvent : Long) : Int

    //CUresult cuEventRecord(CUevent hEvent, CUstream hStream)
    //CUresult cuEventRecordWithFlags(CUevent hEvent, CUstream hStream, unsigned int  flags)

    /**
     *  Waits for an event to complete. (cuEventSynchronize)
     */
    external fun eventSynchronize(hEvent : Long) : Int

    //20. External Resource Interoperability
    /**
     *  Destroys an external memory object. (cuDestroyExternalMemory)
     */
    external fun destroyExternalMemory(extMem : Long) : Int

    /**
     *  Destroys an external semaphore. (cuDestroyExternalSemaphore)
     */
    external fun destroyExternalSemaphore(extSem : Long) : Int

    //CUresult cuExternalMemoryGetMappedBuffer(CUdeviceptr* devPtr, CUexternalMemory extMem, const CUDA_EXTERNAL_MEMORY_BUFFER_DESC* bufferDesc)
    //CUresult cuExternalMemoryGetMappedMipmappedArray(CUmipmappedArray* mipmap, CUexternalMemory extMem, const CUDA_EXTERNAL_MEMORY_MIPMAPPED_ARRAY_DESC* mipmapDesc)
    //CUresult cuImportExternalMemory(CUexternalMemory* extMem_out, const CUDA_EXTERNAL_MEMORY_HANDLE_DESC* memHandleDesc)
    //CUresult cuImportExternalSemaphore(CUexternalSemaphore* extSem_out, const CUDA_EXTERNAL_SEMAPHORE_HANDLE_DESC* semHandleDesc)
    //CUresult cuSignalExternalSemaphoresAsync(const CUexternalSemaphore* extSemArray, const CUDA_EXTERNAL_SEMAPHORE_SIGNAL_PARAMS* paramsArray, unsigned int  numExtSems, CUstream stream)
    //CUresult cuWaitExternalSemaphoresAsync(const CUexternalSemaphore* extSemArray, const CUDA_EXTERNAL_SEMAPHORE_WAIT_PARAMS* paramsArray, unsigned int  numExtSems, CUstream stream)

    //21. Stream Memory Operations
    //CUresult cuStreamBatchMemOp(CUstream stream, unsigned int  count, CUstreamBatchMemOpParams* paramArray, unsigned int  flags)
    //CUresult cuStreamWaitValue32(CUstream stream, CUdeviceptr addr, cuuint32_t value, unsigned int  flags)
    //CUresult cuStreamWaitValue64(CUstream stream, CUdeviceptr addr, cuuint64_t value, unsigned int  flags)
    //CUresult cuStreamWriteValue32(CUstream stream, CUdeviceptr addr, cuuint32_t value, unsigned int  flags)
    //CUresult cuStreamWriteValue64(CUstream stream, CUdeviceptr addr, cuuint64_t value, unsigned int  flags)

    //22. Execution Control
    //CUresult cuFuncGetAttribute(int* pi, CUfunction_attribute attrib, CUfunction hfunc)
    //CUresult cuFuncGetModule(CUmodule* hmod, CUfunction hfunc)
    //CUresult cuFuncGetName(const char** name, CUfunction hfunc)
    //CUresult cuFuncSetAttribute(CUfunction hfunc, CUfunction_attribute attrib, int  value)
    //CUresult cuFuncSetCacheConfig(CUfunction hfunc, CUfunc_cache config)
    //CUresult cuFuncSetSharedMemConfig(CUfunction hfunc, CUsharedconfig config)
    //CUresult cuLaunchCooperativeKernel(CUfunction f, unsigned int  gridDimX, unsigned int  gridDimY, unsigned int  gridDimZ, unsigned int  blockDimX, unsigned int  blockDimY, unsigned int  blockDimZ, unsigned int  sharedMemBytes, CUstream hStream, void** kernelParams)
    //CUresult cuLaunchCooperativeKernelMultiDevice(CUDA_LAUNCH_PARAMS * launchParamsList, unsigned int  numDevices, unsigned int  flags)
    //CUresult cuLaunchHostFunc(CUstream hStream, CUhostFn fn, void* userData)
    //CUresult cuLaunchKernel(CUfunction f, unsigned int  gridDimX, unsigned int  gridDimY, unsigned int  gridDimZ, unsigned int  blockDimX, unsigned int  blockDimY, unsigned int  blockDimZ, unsigned int  sharedMemBytes, CUstream hStream, void** kernelParams, void** extra)
    //CUresult cuLaunchKernelEx(const CUlaunchConfig * config, CUfunction f, void** kernelParams, void** extra)

    //24. Graph Management

    //CUresult cuDeviceGetGraphMemAttribute(CUdevice device, CUgraphMem_attribute attr, void* value)

    /**
     *  Free unused memory that was cached on the specified device for use with graphs back to the OS. (cuDeviceGraphMemTrim)
     */
    external fun deviceGraphMemTrim(device : Int) : Int
    //CUresult cuDeviceSetGraphMemAttribute(CUdevice device, CUgraphMem_attribute attr, void* value)
    //CUresult cuGraphAddBatchMemOpNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_BATCH_MEM_OP_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddChildGraphNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUgraph childGraph)
    //CUresult cuGraphAddDependencies(CUgraph hGraph, const CUgraphNode * from, const CUgraphNode * to, size_t numDependencies)
    //CUresult cuGraphAddDependencies_v2(CUgraph hGraph, const CUgraphNode * from, const CUgraphNode * to, const CUgraphEdgeData * edgeData, size_t numDependencies)
    //CUresult cuGraphAddEmptyNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies)
    //CUresult cuGraphAddEventRecordNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUevent event)
    //CUresult cuGraphAddEventWaitNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUevent event)
    //CUresult cuGraphAddExternalSemaphoresSignalNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_EXT_SEM_SIGNAL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddExternalSemaphoresWaitNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_EXT_SEM_WAIT_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddHostNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_HOST_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddKernelNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_KERNEL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddMemAllocNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUDA_MEM_ALLOC_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddMemFreeNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUdeviceptr dptr)
    //CUresult cuGraphAddMemcpyNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_MEMCPY3D * copyParams, CUcontext ctx)
    //CUresult cuGraphAddMemsetNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_MEMSET_NODE_PARAMS * memsetParams, CUcontext ctx)
    //CUresult cuGraphAddNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUgraphNodeParams * nodeParams)
    //CUresult cuGraphAddNode_v2(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, const CUgraphEdgeData * dependencyData, size_t numDependencies, CUgraphNodeParams * nodeParams)
    //CUresult cuGraphBatchMemOpNodeGetParams(CUgraphNode hNode, CUDA_BATCH_MEM_OP_NODE_PARAMS * nodeParams_out)
    //CUresult cuGraphBatchMemOpNodeSetParams(CUgraphNode hNode, const CUDA_BATCH_MEM_OP_NODE_PARAMS * nodeParams)
    //CUresult cuGraphChildGraphNodeGetGraph(CUgraphNode hNode, CUgraph * phGraph)
    //CUresult cuGraphClone(CUgraph * phGraphClone, CUgraph originalGraph)
    //CUresult cuGraphConditionalHandleCreate(CUgraphConditionalHandle * pHandle_out, CUgraph hGraph, CUcontext ctx, unsigned int  defaultLaunchValue, unsigned int  flags)
    //CUresult cuGraphCreate(CUgraph * phGraph, unsigned int  flags)
    //CUresult cuGraphDebugDotPrint(CUgraph hGraph, const char* path, unsigned int  flags)

    /**
     *  Destroys a graph. (cuGraphDestroy)
     */
    external fun graphDestroy(hGraph : Long) : Int

    /**
     * 	Remove a node from the graph. (cuGraphDestroyNode)
     */
    external fun graphDestroyNode(hNode : Long) : Int

    //CUresult cuGraphEventRecordNodeGetEvent(CUgraphNode hNode, CUevent * event_out)
    //CUresult cuGraphEventRecordNodeSetEvent(CUgraphNode hNode, CUevent event)
    //CUresult cuGraphEventWaitNodeGetEvent(CUgraphNode hNode, CUevent * event_out)
    //CUresult cuGraphEventWaitNodeSetEvent(CUgraphNode hNode, CUevent event)
    //CUresult cuGraphExecBatchMemOpNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_BATCH_MEM_OP_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExecChildGraphNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, CUgraph childGraph)

    /**
     * 	Destroys an executable graph. (cuGraphExecDestroy)
     */
    external fun graphExecDestroy(hGraphExec : Long) : Int

    //CUresult cuGraphExecEventRecordNodeSetEvent(CUgraphExec hGraphExec, CUgraphNode hNode, CUevent event)
    //CUresult cuGraphExecEventWaitNodeSetEvent(CUgraphExec hGraphExec, CUgraphNode hNode, CUevent event)
    //CUresult cuGraphExecExternalSemaphoresSignalNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_EXT_SEM_SIGNAL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExecExternalSemaphoresWaitNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_EXT_SEM_WAIT_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExecGetFlags(CUgraphExec hGraphExec, cuuint64_t * flags)
    //CUresult cuGraphExecHostNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_HOST_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExecKernelNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_KERNEL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExecMemcpyNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_MEMCPY3D * copyParams, CUcontext ctx)
    //CUresult cuGraphExecMemsetNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_MEMSET_NODE_PARAMS * memsetParams, CUcontext ctx)
    //CUresult cuGraphExecNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, CUgraphNodeParams * nodeParams)
    //CUresult cuGraphExecUpdate(CUgraphExec hGraphExec, CUgraph hGraph, CUgraphExecUpdateResultInfo * resultInfo)
    //CUresult cuGraphExternalSemaphoresSignalNodeGetParams(CUgraphNode hNode, CUDA_EXT_SEM_SIGNAL_NODE_PARAMS * params_out)
    //CUresult cuGraphExternalSemaphoresSignalNodeSetParams(CUgraphNode hNode, const CUDA_EXT_SEM_SIGNAL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExternalSemaphoresWaitNodeGetParams(CUgraphNode hNode, CUDA_EXT_SEM_WAIT_NODE_PARAMS * params_out)
    //CUresult cuGraphExternalSemaphoresWaitNodeSetParams(CUgraphNode hNode, const CUDA_EXT_SEM_WAIT_NODE_PARAMS * nodeParams)
    //CUresult cuGraphGetEdges(CUgraph hGraph, CUgraphNode * from, CUgraphNode * to, size_t * numEdges)
    //CUresult cuGraphGetEdges_v2(CUgraph hGraph, CUgraphNode * from, CUgraphNode * to, CUgraphEdgeData * edgeData, size_t * numEdges)
    //CUresult cuGraphGetNodes(CUgraph hGraph, CUgraphNode * nodes, size_t * numNodes)
    //CUresult cuGraphGetRootNodes(CUgraph hGraph, CUgraphNode * rootNodes, size_t * numRootNodes)
    //CUresult cuGraphHostNodeGetParams(CUgraphNode hNode, CUDA_HOST_NODE_PARAMS * nodeParams)
    //CUresult cuGraphHostNodeSetParams(CUgraphNode hNode, const CUDA_HOST_NODE_PARAMS * nodeParams)
    //CUresult cuGraphInstantiate(CUgraphExec * phGraphExec, CUgraph hGraph, unsigned long long flags)
    //CUresult cuGraphInstantiateWithParams(CUgraphExec * phGraphExec, CUgraph hGraph, CUDA_GRAPH_INSTANTIATE_PARAMS * instantiateParams)
    //CUresult cuGraphKernelNodeCopyAttributes(CUgraphNode dst, CUgraphNode src)
    //CUresult cuGraphKernelNodeGetAttribute(CUgraphNode hNode, CUkernelNodeAttrID attr, CUkernelNodeAttrValue * value_out)
    //CUresult cuGraphKernelNodeGetParams(CUgraphNode hNode, CUDA_KERNEL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphKernelNodeSetAttribute(CUgraphNode hNode, CUkernelNodeAttrID attr, const CUkernelNodeAttrValue * value)
    //CUresult cuGraphKernelNodeSetParams(CUgraphNode hNode, const CUDA_KERNEL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphLaunch(CUgraphExec hGraphExec, CUstream hStream)
    //CUresult cuGraphMemAllocNodeGetParams(CUgraphNode hNode, CUDA_MEM_ALLOC_NODE_PARAMS * params_out)
    //CUresult cuGraphMemFreeNodeGetParams(CUgraphNode hNode, CUdeviceptr * dptr_out)
    //CUresult cuGraphMemcpyNodeGetParams(CUgraphNode hNode, CUDA_MEMCPY3D * nodeParams)
    //CUresult cuGraphMemcpyNodeSetParams(CUgraphNode hNode, const CUDA_MEMCPY3D * nodeParams)
    //CUresult cuGraphMemsetNodeGetParams(CUgraphNode hNode, CUDA_MEMSET_NODE_PARAMS * nodeParams)
    //CUresult cuGraphMemsetNodeSetParams(CUgraphNode hNode, const CUDA_MEMSET_NODE_PARAMS * nodeParams)
    //CUresult cuGraphNodeFindInClone(CUgraphNode * phNode, CUgraphNode hOriginalNode, CUgraph hClonedGraph)
    //CUresult cuGraphNodeGetDependencies(CUgraphNode hNode, CUgraphNode * dependencies, size_t * numDependencies)
    //CUresult cuGraphNodeGetDependencies_v2(CUgraphNode hNode, CUgraphNode * dependencies, CUgraphEdgeData * edgeData, size_t * numDependencies)
    //CUresult cuGraphNodeGetDependentNodes(CUgraphNode hNode, CUgraphNode * dependentNodes, size_t * numDependentNodes)
    //CUresult cuGraphNodeGetDependentNodes_v2(CUgraphNode hNode, CUgraphNode * dependentNodes, CUgraphEdgeData * edgeData, size_t * numDependentNodes)
    //CUresult cuGraphNodeGetEnabled(CUgraphExec hGraphExec, CUgraphNode hNode, unsigned int* isEnabled)
    //CUresult cuGraphNodeGetType(CUgraphNode hNode, CUgraphNodeType * type)
    //CUresult cuGraphNodeSetEnabled(CUgraphExec hGraphExec, CUgraphNode hNode, unsigned int  isEnabled)
    //CUresult cuGraphNodeSetParams(CUgraphNode hNode, CUgraphNodeParams * nodeParams)
    //CUresult cuGraphReleaseUserObject(CUgraph graph, CUuserObject object, unsigned int  count)
    //CUresult cuGraphRemoveDependencies(CUgraph hGraph, const CUgraphNode * from, const CUgraphNode * to, size_t numDependencies)
    //CUresult cuGraphRemoveDependencies_v2(CUgraph hGraph, const CUgraphNode * from, const CUgraphNode * to, const CUgraphEdgeData * edgeData, size_t numDependencies)
    //CUresult cuGraphRetainUserObject(CUgraph graph, CUuserObject object, unsigned int  count, unsigned int  flags)
    //CUresult cuGraphUpload(CUgraphExec hGraphExec, CUstream hStream)
    //CUresult cuUserObjectCreate(CUuserObject * object_out, void* ptr, CUhostFn destroy, unsigned int  initialRefcount, unsigned int  flags)
    //CUresult cuUserObjectRelease(CUuserObject object, unsigned int  count)
    //CUresult cuUserObjectRetain(CUuserObject object, unsigned int  count)

    //25. Occupancy
    //CUresult cuOccupancyAvailableDynamicSMemPerBlock(size_t* dynamicSmemSize, CUfunction func, int  numBlocks, int  blockSize)
    //CUresult cuOccupancyMaxActiveBlocksPerMultiprocessor(int* numBlocks, CUfunction func, int  blockSize, size_t dynamicSMemSize)
    //CUresult cuOccupancyMaxActiveBlocksPerMultiprocessorWithFlags(int* numBlocks, CUfunction func, int  blockSize, size_t dynamicSMemSize, unsigned int  flags)
    //CUresult cuOccupancyMaxActiveClusters(int* numClusters, CUfunction func, const CUlaunchConfig* config)
    //CUresult cuOccupancyMaxPotentialBlockSize(int* minGridSize, int* blockSize, CUfunction func, CUoccupancyB2DSize blockSizeToDynamicSMemSize, size_t dynamicSMemSize, int  blockSizeLimit)
    //CUresult cuOccupancyMaxPotentialBlockSizeWithFlags(int* minGridSize, int* blockSize, CUfunction func, CUoccupancyB2DSize blockSizeToDynamicSMemSize, size_t dynamicSMemSize, int  blockSizeLimit, unsigned int  flags)
    //CUresult cuOccupancyMaxPotentialClusterSize(int* clusterSize, CUfunction func, const CUlaunchConfig * config)

    //26. Texture Reference Management (DEPRECATED)

    //27. Surface Reference Management (DEPRECATED)

    //28. Texture Object Management
    //CUresult cuTexObjectCreate(CUtexObject* pTexObject, const CUDA_RESOURCE_DESC* pResDesc, const CUDA_TEXTURE_DESC* pTexDesc, const CUDA_RESOURCE_VIEW_DESC* pResViewDesc)

    /**
     * 	Destroys a texture object. (cuTextObjectDestroy)
     */
    external fun textObjectDestroy(textObject : Long) : Int

    //CUresult cuTexObjectDestroy(CUtexObject texObject)
    //CUresult cuTexObjectGetResourceDesc(CUDA_RESOURCE_DESC* pResDesc, CUtexObject texObject)
    //CUresult cuTexObjectGetResourceViewDesc(CUDA_RESOURCE_VIEW_DESC * pResViewDesc, CUtexObject texObject)
    //CUresult cuTexObjectGetTextureDesc(CUDA_TEXTURE_DESC * pTexDesc, CUtexObject texObject)

    //29. Surface Object Management
    //CUresult cuSurfObjectCreate(CUsurfObject* pSurfObject, const CUDA_RESOURCE_DESC* pResDesc)

    /**
     * 	Destroys a surface object. (cuSurfObjectDestroy)
     */
    external fun surfObjectDestroy(surfObject : Long) : Int

    //CUresult cuSurfObjectGetResourceDesc(CUDA_RESOURCE_DESC* pResDesc, CUsurfObject surfObject)

    //31. Peer Context Memory Access

    /**
     * 	Disables direct access to memory allocations in a peer context and unregisters any registered allocations. (cuCtxDisablePeerAccess)
     */
    external fun ctxDisablePeerAccess(peerContext : Long) : Int

    //CUresult cuCtxEnablePeerAccess(CUcontext peerContext, unsigned int  Flags)
    //CUresult cuDeviceCanAccessPeer(int* canAccessPeer, CUdevice dev, CUdevice peerDev)
    //CUresult cuDeviceGetP2PAttribute(int* value, CUdevice_P2PAttribute attrib, CUdevice srcDevice, CUdevice dstDevice)

    //32. Graphics Interoperability
    //CUresult cuGraphicsMapResources(unsigned int  count, CUgraphicsResource* resources, CUstream hStream)
    //CUresult cuGraphicsResourceGetMappedMipmappedArray(CUmipmappedArray * pMipmappedArray, CUgraphicsResource resource)
    //CUresult cuGraphicsResourceGetMappedPointer(CUdeviceptr * pDevPtr, size_t * pSize, CUgraphicsResource resource)
    //CUresult cuGraphicsResourceSetMapFlags(CUgraphicsResource resource, unsigned int  flags)
    //CUresult cuGraphicsSubResourceGetMappedArray(CUarray * pArray, CUgraphicsResource resource, unsigned int  arrayIndex, unsigned int  mipLevel)
    //CUresult cuGraphicsUnmapResources(unsigned int  count, CUgraphicsResource * resources, CUstream hStream)

    /**
     * 	Unregisters a graphics resource for access by CUDA. (cuGraphicsUnregisterResource)
     */
    external fun graphicsUnregisterResource(resource : Long) : Int

    companion object {
        private var isLibraryLoaded = false

        init {
            loadLibraryIfNotLoaded()
        }

        @Synchronized
        private fun loadLibraryIfNotLoaded() {
            if (!isLibraryLoaded) {
                System.loadLibrary("kudadll")
                isLibraryLoaded = true
            }
        }
    }
}