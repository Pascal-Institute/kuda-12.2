package kuda.runtimeapi

import kuda.runtimeapi.prop.*
import kuda.runtimeapi.structure.DeviceProp
import kuda.runtimeapi.structure.IpcMemHandle

class RuntimeAPI {

    //1. Device Management
    external fun chooseDevice(deviceProp : DeviceProp) : Int

    private external fun deviceFlushGPUDirectRDMAWrites(scope : Int) : Int
    fun deviceFlushGPUDirectRDMAWrites(target: FlushGPUDirectRDMAWritesTarget, scope : FlushGPUDirectRDMAWritesScope): Int {
        return deviceFlushGPUDirectRDMAWrites(scope.num)
    }

    external fun deviceGetDefaultMemPool(device: Int) : Long

    private external fun deviceGetLimit(limit: Int) : Int
    fun deviceGetLimit(limit : Limit) : Int {
        return deviceGetLimit(limit.num)
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

    private external fun deviceGetAttribute(deviceAttr : Int, device : Int) : Int
    fun deviceGetAttribute(deviceAttr : DeviceAttribute, device: Int) : Int {
        return deviceGetAttribute(deviceAttr.num, device)
    }

    external fun deviceGetPCIBusId(device : Int) : String

    /**
     * Returns the preferred cache configuration for the current device. (cudaDeviceGetCacheConfig)
     *
     * @return Returned cache configuration
     */
    private external fun deviceGetCacheConfig(dummy: Boolean) : Int
    fun deviceGetCacheConfg() : FuncCache {
        return FuncCache.fromInt(deviceGetCacheConfig(false))!!
    }

    external fun deviceGetStreamPriorityRange() : Int

    private external fun deviceSetCacheConfig(cacheConfig : Int) : Int
    fun deviceSetCacheConfig(funcCache: FuncCache) : Int{
        return deviceSetCacheConfig(funcCache.num)
    }

    private external fun deviceSetLimit(limit : Int, size : Int) : Int
    fun deviceSetLimit(limit: Limit, size: Int) : Int{
        return deviceSetLimit(limit.num, size)
    }

    external fun deviceSetSharedMemConfig(config : Int) : Int

    external fun deviceSynchronize() : Int

    external fun deviceReset() : Int

    external fun getDevice() : Int

    external fun getDeviceCount() : Int

    external fun getDeviceProperties(device: Int) : DeviceProp

    external fun initDevice(device : Int, flags : Int) : Int

    external fun ipcCloseMemHandle(devicePtr : Long) : Int

    /**
     * Gets an interprocess handle for a previously allocated event. (cudaIpcGetEventHandle)
     *
     * @param event Event allocated with cudaEventInterprocess and cudaEventDisableTiming flags.
     *
     * @return Pointer to a user allocated cudaIpcEventHandle in which to return the opaque event handle
     */
    external fun ipcGetEventHandle(event : Long) : Long

    /**
     * Gets an interprocess memory handle for an existing device memory allocation. (cudaIpcGetMemHandle)
     *
     * @param devPtr Base pointer to previously allocated device memory
     *
     * @return Pointer to user allocated cudaIpcMemHandle to return the handle in.
     */
    external fun ipcGetMemHandle(devPtr: Long) : IpcMemHandle

    /**
     * Gets an interprocess handle for a previously allocated event. (cudaIpcOpenEventHandle)
     *
     * @param handle Interprocess handle to open
     *
     * @return Returns the imported event
     */
    external fun ipcOpenEventHandle(handle : Long) : Long

    external fun setDevice(device : Int) : Int

    external fun setDeviceFlags(flags : Int) : Int

    external fun setValidDevices(deviceArr : IntArray, len : Int) : Int

    //3. Error Handling
    private external fun getErrorName(error : Int) : String
    fun getErrorName(error: kuda.runtimeapi.prop.Error) : String{
        return getErrorName(error.num)
    }

    private external fun getErrorString(error : Int) : String
    fun getErrorString(error: kuda.runtimeapi.prop.Error) : String{
        return getErrorName(error.num)
    }
    external fun getLastError() : Int

    external fun peekAtLastError() : Int

    //4. Stream Management
    external fun ctxResetPersistingL2Cache() : Int

    //cudaStreamAddCallback

    /**
     * Attach memory to a stream asynchronously. (cudaStreamAttachMemAsync)
     *
     * @param stream Stream in which to enqueue the attach operation
     * @param devPtr Pointer to memory (must be a pointer to managed memory or to a valid host-accessible region of system-allocated memory)
     * @param length Length of memory (defaults to zero)
     * @param flags Must be one of cudaMemAttachGlobal, cudaMemAttachHost or cudaMemAttachSingle
     */
    external fun streamAttachMemAsync(stream : Long, devPtr : Long, length : Int, flags : Int) : Int

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

    /**
     * Ends capture on a stream, returning the captured graph. (cudaStreamEndCapture)
     *
     * @param stream Stream to query.
     *
     * @return the captured graph.
     */
    external fun streamEndCapture(stream : Long) : Long

    external fun streamQuery(stream : Long) : Int

    /**
     * Sets stream attribute. (cudaStreamSetAttribute)
     *
     * @param hStream
     * @param attr LaunchAttributeID
     */
    fun streamSetAttribute(hStream : Long, attr : LaunchAttributeID) : Int {
        return streamSetAttribute(hStream, attr.num)
    }
    private external fun streamSetAttribute(hStream : Long, attr : Int) : Int

    external fun streamSynchronize(stream : Long) : Int

    //cudaStreamUpdateCaptureDependencies

    //cudaStreamUpdateCaptureDependencies_v2

    external fun streamWaitEvent(stream : Long, event : Long, flags : Int) : Int

    /**
     * Sets stream attribute. (cudaStreamSetAttribute)
     *
     * @param hStream
     * @return Pointer to mode value to swap with the current mode
     */
    private external fun threadExchangeStreamCaptureMode(dummy: Boolean) : Int
    fun threadExchangeStreamCaptureMode() : StreamCaptureMode {
        return StreamCaptureMode.fromInt(threadExchangeStreamCaptureMode(false))!!
    }

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

    //28. Graph Management
    /**
     * Free unused memory that was cached on the specified device for use with graphs back to the OS. (cudaDeviceGraphMemTrim)
     *
     * @param device The device for which cached memory should be freed.
     */
    external fun deviceGraphMemTrim(device : Int) : Int

    /**
     * Clones a graph. (cudaGraphClone)
     *
     * @param originalGraph Graph to clone
     *
     * @return Returns newly created cloned graph
     */
    external fun graphClone(originalGraph : Long) : Long

    /**
     * Creates a graph. (cudaGraphCreate)
     *
     * @param flags Graph creation flags, must be 0
     *
     * @return Returns newly created graph
     */
    external fun graphCreate(flags: Int) : Long

    /**
     * Destroys a graph. (cudaGraphDestroy)
     *
     * @param graph Graph to destroy
     */
    external fun graphDestroy(graph : Long) : Int

    /**
     * Remove a node from the graph. (cudaGraphDestroyNode)
     *
     * @param node Node to remove
     */
    external fun graphDestroyNode(node : Long) : Int


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