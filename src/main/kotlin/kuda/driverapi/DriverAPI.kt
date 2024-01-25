package kuda.driverapi

import kuda.driverapi.prop.FuncCache
import kuda.driverapi.prop.Limit
import kuda.driverapi.prop.Result

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