package kuda

import kuda.type.Error
import kuda.type.StreamCaptureStatus

class RuntimeAPI {
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

    external fun streamDestroy(stream : Long)

    //6.27 Version Management
    external fun driverGetVersion() : Int
    external fun runtimeGetVersion() : Int

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