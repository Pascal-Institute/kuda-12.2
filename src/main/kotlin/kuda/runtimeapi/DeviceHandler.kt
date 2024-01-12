package kuda.runtimeapi

import kuda.runtimeapi.prop.FlushGPUDirectRDMAWritesScope
import kuda.runtimeapi.prop.FlushGPUDirectRDMAWritesTarget
import kuda.runtimeapi.prop.FunctionCache
import kuda.runtimeapi.prop.Limit
import kuda.runtimeapi.structure.DeviceProp

class DeviceHandler {
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

        @JvmStatic
        external fun chooseDevice(deviceProp : DeviceProp) : Int

        @JvmStatic
        private external fun flushGPUDirectRDMAWrites(scope : Int) : Int

        @JvmStatic
        external fun getDefaultMemPool(device: Int) : Long

        private fun flushGPUDirectRDMAWrites(target: FlushGPUDirectRDMAWritesTarget, scope : FlushGPUDirectRDMAWritesScope): Int {
            return flushGPUDirectRDMAWrites(scope.num)
        }

        fun getLimit(limit : Limit) : Int {
            return getLimit(limit.byte)
        }

        @JvmStatic
        private external fun getLimit(byte: Byte) : Int

        @JvmStatic
        external fun getMemPool(device : Int) : Long

        @JvmStatic
        external fun getPCIBusId(device : Int) : String

        @JvmStatic
        external fun getStreamPriorityRange() : Int

        @JvmStatic
        private external fun setCacheConfig(cacheConfig : Int) : Int
        fun setCacheConfig(functionCache: FunctionCache) : Int{
            return setCacheConfig(functionCache.num)
        }

        @JvmStatic
        private external fun setLimit(limit : Byte, size : Int) : Int
        fun setLimit(limit: Limit, size: Int) : Int{
            return setLimit(limit.byte, size)
        }

        @JvmStatic
        external fun synchronize() : Int

        @JvmStatic
        external fun reset() : Int

        @JvmStatic
        external fun getDevice() : Int

        @JvmStatic
        external fun getDeviceCount() : Int

        @JvmStatic
        external fun getDeviceProperties(device: Int) : DeviceProp

        @JvmStatic
        external fun initDevice(device : Int, flags : Int) : Int

        @JvmStatic
        external fun lpcCloseMemHandle(devicePtr : Long) : Int

        @JvmStatic
        external fun setDevice(device : Int) : Int

        @JvmStatic
        external fun setDeviceFlags(flags : Int) : Int
    }
}