package kuda

import kuda.type.Error

class RuntimeAPI {
    external fun runtimeGetVersion(): Int
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
    external fun streamCreate() : Long

    external fun streamCreateWithFlags(flags : Int) : Long
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