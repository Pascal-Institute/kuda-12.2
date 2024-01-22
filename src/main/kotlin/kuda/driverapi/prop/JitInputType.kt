package kuda.driverapi.prop

/**
 *
 * Device code formats
 *
 * @property CUBIN Compiled device-class-specific device code Applicable options: none
 * @property PTX PTX source code Applicable options: PTX compiler options
 * @property FATBINARY Bundle of multiple cubins and/or PTX of some device code Applicable options: PTX compiler options, CU_JIT_FALLBACK_STRATEGY
 * @property OBJECT Host object with embedded device code Applicable options: PTX compiler options, CU_JIT_FALLBACK_STRATEGY
 * @property LIBRARY Archive of host objects with embedded device code Applicable options: PTX compiler options, CU_JIT_FALLBACK_STRATEGY
 * @property NVVM Deprecated, High-level intermediate code for link-time optimization Applicable options: NVVM compiler options, PTX compiler options. Only valid with LTO-IR compiled with toolkits prior to CUDA 12.0
 * @property TYPES
 */
enum class JitInputType(val num : Int) {
    CUBIN(0),
    PTX(1),
    FATBINARY(2),
    OBJECT(3),
    LIBRARY(4),
    NVVM(5),
    TYPES(6)
}
