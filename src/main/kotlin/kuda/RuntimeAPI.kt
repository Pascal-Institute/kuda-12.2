package kuda

import kuda.type.Error
import kuda.type.FunctionCache
import kuda.type.Limit

class RuntimeAPI {

    fun deviceGetLimit(limit : Limit) : Int {
        return deviceGetLimit(limit.byte)
    }
    private external fun deviceGetLimit(byte: Byte) : Int
    external fun deviceGetPCIBusId(device : Int) : String
    external fun deviceGetStreamPriorityRange() : Int
    private external fun deviceSetCacheConfig(cacheConfig : Int) : Int
    fun deviceSetCacheConfig(functionCache: FunctionCache) : Int{
        return deviceSetCacheConfig(functionCache.num)
    }
    private external fun deviceSetLimit(limit : Byte, size : Int) : Int
    fun deviceSetLimit(limit: Limit, size: Int) : Int{
        return deviceSetLimit(limit.byte, size)
    }
    external fun deviceSynchronize() : Int
    external fun runtimeGetVersion(): Int
    external fun getDevice() : Int
    external fun getDeviceCount() : Int
    external fun setDevice(device : Int) : Int
    external fun setDeviceFlags(flags : Int) : Int
    private external fun getErrorName(error : Int) : String
    fun getErrorName(error: Error) : String{
        return getErrorName(error.num)
    }

    private external fun getErrorString(error : Int) : String
    fun getErrorString(error: Error) : String{
        return getErrorName(error.num)
    }
    external fun getLastError() : Int
    external fun peekAtLastError() : Int

    //6.4 Stream Management
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