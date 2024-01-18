package kuda.runtimeapi

import kuda.runtimeapi.prop.*
import kuda.runtimeapi.structure.DeviceProp

class DeviceManager {
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

        /**
         * Queries attributes of the link between two devices.
         *
         * @param attr
         * @param srcDevice The source device of the target link.
         * @param dstDevice The destination device of the target link.
         * @return Returns in *value the value of the requested attribute attrib of the link between srcDevice and dstDevice.
         */
        @JvmStatic
        private external fun getP2PAttribute(attr : Int, scrDevice : Int, dstDevice : Int) : Int
        fun getP2PAttribute(attr : DeviceP2PAttr, scrDevice : Int, dstDevice : Int) : Int {
            return getP2PAttribute(attr.num, scrDevice, dstDevice)
        }

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
        external fun setValidDevices() : Int

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