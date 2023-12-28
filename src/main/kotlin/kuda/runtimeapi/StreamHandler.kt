package kuda.runtimeapi

import kuda.prop.StreamCaptureStatus

class StreamHandler {
    companion object{
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
        external fun ctxResetPersistingL2Cache() : Int

        //cudaStreamAddCallback

        //cudaStreamAttachMemAsync

        @JvmStatic
        private external fun beginCapture(stream : Long, mode : Int) : Int

        fun beginCapture(stream: Long, streamCaptureStatus: StreamCaptureStatus) : Int{
            return beginCapture(stream, streamCaptureStatus.num)
        }

        //cudaStreamBeginCaptureToGraph

        @JvmStatic
        external fun copyAttributes(dst : Long, src : Long) : Int

        @JvmStatic
        external fun create() : Long

        @JvmStatic
        external fun createWithFlags(flags : Int) : Long

        @JvmStatic
        external fun createWithPriority(flags : Int, priority : Int) : Long

        @JvmStatic
        external fun destroy(stream : Long) : Int

        @JvmStatic
        external fun query(stream : Long) : Int

        //cudaStreamSetAttribute

        @JvmStatic
        external fun synchronize(stream : Long) : Int

        //cudaStreamUpdateCaptureDependencies

        //cudaStreamUpdateCaptureDependencies_v2

        @JvmStatic
        external fun waitEvent(stream : Long, event : Long, flags : Int) : Int
    }
}