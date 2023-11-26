class KudaRuntimeAPI {
    external fun getRuntimeVersion(): Int
    external fun getDivice() : Int

    companion object {
        init {
            System.loadLibrary("kuda_runtime_api")
        }
    }
}