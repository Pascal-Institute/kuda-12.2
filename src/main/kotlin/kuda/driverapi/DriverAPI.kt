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
     * Unregisters a memory range that was registered with cuMemHostRegister. (cuMemHostUnregister)
     */
    external fun memHostUnregister(p : Long) : Int

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