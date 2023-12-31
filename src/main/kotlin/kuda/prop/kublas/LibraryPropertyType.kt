package kuda.prop.kublas

//https://docs.nvidia.com/cuda/cublas/index.html#cublasgetproperty

enum class LibraryPropertyType(val num: Int) {
    MAJOR_VERSION(0),
    MINOR_VERSION(1),
    PATCH_LEVEL(2)
}