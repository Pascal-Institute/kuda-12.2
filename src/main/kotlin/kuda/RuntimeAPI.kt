package kuda

class RuntimeAPI {

    fun getLimit(limit : Limit) : Int {
        return getLimit(limit.byte)
    }
    private external fun getLimit(byte: Byte) : Int
    external fun syncDevice() : Int
    external fun getRuntimeVersion(): Int
    external fun getDivice() : Int
    external fun getDeviceCount() : Int
    external fun setDevice(device : Int) : Int
    external fun setDeviceFlags(flags : Int) : Int

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