package kuda

import kuda.prop.Error

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

    //6.6 External Resource Interoperability
    external fun destroyExternalMemory(extMem : Long) : Int

    external fun destroyExternalSemaphore(extSem : Long) : Int

    //6.6 Memory Management
    external fun free(devPtr : Long) : Int

    external fun freeHost(ptr : Long) : Int

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