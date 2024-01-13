package kuda.runtimeapi.prop
/**
 * @property OPAQUE_FD Handle is an opaque file descriptor
 * @property OPAQUE_WIN32 Handle is an opaque shared NT handle
 * @property OPAQUE_WIN32_KMT Handle is an opaque, globally shared handle
 * @property D3D12_FENCE Handle is a shared NT handle referencing a D3D12 fence object
 * @property D3D11_FENCE Handle is a shared NT handle referencing a D3D11 fence object
 * @property NVSCI_SYNC Opaque handle to NvSciSync Object
 * @property KEYED_MUTEX Handle is a shared NT handle referencing a D3D11 keyed mutex object
 * @property KEYED_MUTEX_KMT Handle is a shared KMT handle referencing a D3D11 keyed mutex object
 * @property TIMELINE_SEMAPHORE_FD Handle is an opaque handle file descriptor referencing a timeline semaphore
 * @property TIMELINE_SEMAPHORE_WIN32 Handle is an opaque handle file descriptor referencing a timeline semaphore
 */

enum class ExternalSemaphoreHandleType(val num : Int) {
    OPAQUE_FD(1),
    OPAQUE_WIN32(2),
    OPAQUE_WIN32_KMT(3),
    D3D12_FENCE(4),
    D3D11_FENCE(5),
    NVSCI_SYNC(6),
    KEYED_MUTEX(7),
    KEYED_MUTEX_KMT(8),
    TIMELINE_SEMAPHORE_FD(9),
    TIMELINE_SEMAPHORE_WIN32(10),
}