class KudaRuntimeAPI {
    external fun syncDevice() : Int
    external fun getRuntimeVersion(): Int
    external fun getDivice() : Int
    external fun getDeviceCount() : Int
    external fun setDevice(device : Int) : Int
    external fun setDeviceFlags(flags : Int) : Int

    companion object {
        init {
            System.loadLibrary("kuda_runtime_api")
        }
    }
}