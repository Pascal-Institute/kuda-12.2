package kuda.driverapi

class DriverAPI {

    external fun init(flags : Int) : Int
    external fun getDriverVersion() : Int
    external fun getDevice(ordinal : Int) : Int
    external fun getDeviceCount() : Int

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