package kuda.runtimeapi

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

    //5. Event Management
    external fun create() : Long

    external fun createWithFlags(flags : Int) : Long

    external fun destroy(event : Long) : Int

    external fun elapsedTime(start : Long, end : Long) : Float

    external fun query(event : Long) : Int

    external fun record(event : Long, stream : Long) : Int

    external fun recordWithFlags(event : Long, stream : Long, flags : Int) : Int

    external fun synchronize(event : Long) : Int

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