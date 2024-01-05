package kuda.runtimeapi.prop

enum class FlushGPUDirectRDMAWritesScope(val num : Int) {
    TO_OWNER(100),
    TO_ALL_DEVICES(200)
}