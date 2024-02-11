package kuda.runtimeapi

import kuda.runtimeapi.prop.StreamCaptureStatus

class RuntimeAPI {
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