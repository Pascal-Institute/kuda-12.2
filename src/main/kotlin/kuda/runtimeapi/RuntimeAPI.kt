package kuda.runtimeapi

import kuda.runtimeapi.prop.*
import kuda.runtimeapi.structure.DeviceProp

class RuntimeAPI {
    private external fun getErrorName(error : Int) : String
    fun getErrorName(error: kuda.runtimeapi.prop.Error) : String{
        return getErrorName(error.num)
    }

    //1. Device Management
    external fun chooseDevice(deviceProp : DeviceProp) : Int

    private external fun deviceFlushGPUDirectRDMAWrites(scope : Int) : Int
    fun deviceFlushGPUDirectRDMAWrites(target: FlushGPUDirectRDMAWritesTarget, scope : FlushGPUDirectRDMAWritesScope): Int {
        return deviceFlushGPUDirectRDMAWrites(scope.num)
    }

    external fun deviceGetDefaultMemPool(device: Int) : Long

    private external fun deviceGetLimit(byte: Byte) : Int
    fun deviceGetLimit(limit : Limit) : Int {
        return deviceGetLimit(limit.byte)
    }

    external fun deviceGetMemPool(device : Int) : Long

    /**
     * Queries attributes of the link between two devices. (cudaDeviceGetP2PAttribute)
     *
     * @param attr
     * @param srcDevice The source device of the target link.
     * @param dstDevice The destination device of the target link.
     * @return Returns in *value the value of the requested attribute attrib of the link between srcDevice and dstDevice.
     */
    private external fun deviceGetP2PAttribute(attr : Int, scrDevice : Int, dstDevice : Int) : Int
    fun deviceGetP2PAttribute(attr : DeviceP2PAttr, scrDevice : Int, dstDevice : Int) : Int {
        return deviceGetP2PAttribute(attr.num, scrDevice, dstDevice)
    }

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

    external fun deviceReset() : Int

    external fun getDevice() : Int

    external fun getDeviceCount() : Int

    external fun getDeviceProperties(device: Int) : DeviceProp

    external fun initDevice(device : Int, flags : Int) : Int

    external fun lpcCloseMemHandle(devicePtr : Long) : Int

    external fun setDevice(device : Int) : Int

    external fun setDeviceFlags(flags : Int) : Int

    external fun setValidDevices(deviceArr : IntArray, len : Int) : Int

    //3. Error Handling
    private external fun getErrorString(error : Int) : String
    fun getErrorString(error: kuda.runtimeapi.prop.Error) : String{
        return getErrorName(error.num)
    }
    external fun getLastError() : Int

    external fun peekAtLastError() : Int

    //4. Stream Management
    external fun ctxResetPersistingL2Cache() : Int

    //cudaStreamAddCallback

    //cudaStreamAttachMemAsync

    private external fun streamBeginCapture(stream : Long, mode : Int) : Int

    fun streamBeginCapture(stream: Long, streamCaptureStatus: StreamCaptureStatus) : Int{
        return streamBeginCapture(stream, streamCaptureStatus.num)
    }

    //cudaStreamBeginCaptureToGraph

    external fun streamCopyAttributes(dst : Long, src : Long) : Int

    external fun streamCreate() : Long

    external fun streamCreateWithFlags(flags : Int) : Long

    external fun streamCreateWithPriority(flags : Int, priority : Int) : Long

    external fun streamDestroy(stream : Long) : Int

    external fun streamQuery(stream : Long) : Int

    //cudaStreamSetAttribute

    external fun streamSynchronize(stream : Long) : Int

    //cudaStreamUpdateCaptureDependencies

    //cudaStreamUpdateCaptureDependencies_v2

    external fun streamWaitEvent(stream : Long, event : Long, flags : Int) : Int

    //5. Event Management
    external fun eventCreate() : Long

    external fun eventCreateWithFlags(flags : Int) : Long

    external fun eventDestroy(event : Long) : Int

    external fun eventElapsedTime(start : Long, end : Long) : Float

    external fun eventQuery(event : Long) : Int

    external fun eventRecord(event : Long, stream : Long) : Int

    external fun eventRecordWithFlags(event : Long, stream : Long, flags : Int) : Int

    external fun eventSynchronize(event : Long) : Int

    //6.6 External Resource Interoperability
    external fun destroyExternalMemory(extMem : Long) : Int

    external fun destroyExternalSemaphore(extSem : Long) : Int

    //6.9 Memory Management
    external fun free(devPtr : Long) : Int

    external fun freeArray(array : Long) : Int

    external fun freeHost(ptr : Long) : Int

    external fun freeMipmappedArray(mipMappedArray : Long) : Int

    external fun hostRegister(size : Int, flags : Int) : Long

    external fun hostUnregister(ptr : Long) : Int

    external fun malloc(size : Int) : Long

    external fun mallocHost(size: Int) : Long

    //6.27 Version Management
    external fun driverGetVersion() : Int

    external fun runtimeGetVersion() : Int

    //6.13  Peer Device Memory Access
    external fun deviceCanAccessPeer(device : Int, peerDevice : Int) : Int

    external fun deviceDisablePeerAccess(peerDevice : Int): Int

    external fun deviceEnablePeerAccess(peerDevice : Int, flags : Int): Int

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