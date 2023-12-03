package kuda

import kuda.type.FunctionCache
import kuda.type.Limit

class RuntimeAPI {

    fun getLimit(limit : Limit) : Int {
        return getLimit(limit.byte)
    }
    private external fun getLimit(byte: Byte) : Int
    external fun getPCIBusId(device : Int) : String
    external fun getStreamPriorityRange() : Int
    private external fun setCacheConfig(cacheConfig : Int) : Int
    fun setCacheConfig(functionCache: FunctionCache) : Int{
        return setCacheConfig(functionCache.num)
    }
    private external fun setLimit(limit : Byte, size : Int) : Int
    fun setLimit(limit: Limit, size: Int) : Int{
        return setLimit(limit.byte, size)
    }
    external fun syncDevice() : Int
    external fun getRuntimeVersion(): Int
    external fun getDevice() : Int
    external fun getDeviceCount() : Int
    external fun setDevice(device : Int) : Int
    external fun setDeviceFlags(flags : Int) : Int

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