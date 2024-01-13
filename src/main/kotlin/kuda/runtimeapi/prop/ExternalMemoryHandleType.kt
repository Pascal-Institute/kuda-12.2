package kuda.runtimeapi.prop

/**
 * @property OPAQUE_FD Handle is an opaque file descriptor
 * @property OPAQUE_WIN32 Handle is an opaque shared NT handle
 * @property OPAQUE_WIN32_KMT Handle is an opaque, globally shared handle
 * @property D3D12_HEAP Handle is a D3D12 heap object
 * @property D3D12_RESOURCE Handle is a D3D12 committed resource
 * @property D3D11_RESOURCE Handle is a shared NT handle to a D3D11 resource
 * @property D3D11_RESOURCE_KMT Handle is a globally shared handle to a D3D11 resource
 * @property NVSCI_BUF Handle is an NvSciBuf object
 */

enum class ExternalMemoryHandleType(val num : Int) {
    OPAQUE_FD(1),
    OPAQUE_WIN32(2),
    OPAQUE_WIN32_KMT(3),
    D3D12_HEAP(4),
    D3D12_RESOURCE(5),
    D3D11_RESOURCE(6),
    D3D11_RESOURCE_KMT(7),
    NVSCI_BUF(8),
}