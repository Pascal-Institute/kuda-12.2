package kuda.driverapi

import kuda.driverapi.prop.FuncCache
import kuda.driverapi.prop.Limit
import kuda.driverapi.prop.Result
import kuda.driverapi.prop.StreamCaptureMode

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

    external fun devicePrimaryCtxSetFlags(dev : Int, flags : UInt) : Int

    /**
     * Returns the preferred cache configuration for the current context. (cuCtxGetCacheConfig)
     */
    private external fun ctxGetCacheConfig(dummy : Boolean) : Int
    fun ctxGetCacheConfig() : FuncCache {
       return FuncCache.fromInt(ctxGetCacheConfig(false))!!
    }

    /**
     * Returns the device ID for the current context. (cuCtxGetDevice)
     */
    external fun ctxGetDevice() : Int

    //8. Context Management
    /**
     * Returns the flags for the current context.
     */
    external fun ctxGetFlags() : UInt

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
     * Destroys state for a JIT linker invocation. (cuLinkDestroy)
     */
    external fun linkDestroy(state : Long) : Int

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