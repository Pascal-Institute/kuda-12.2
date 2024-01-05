package kuda.kublas.prop

enum class Status(val num : Int) {
    SUCCESS(0),
    NOT_INITIALIZED(1),
    ALLOC_FAILED(3),
    INVALID_VALUE(7),
    ARCH_MISMATCH(8),
    MAPPING_ERROR(11),
    EXECUTION_FAILED(13),
    INTERNAL_ERROR(14),
    NOT_SUPPORTED(15),
    LICENSE_ERROR(16)
}