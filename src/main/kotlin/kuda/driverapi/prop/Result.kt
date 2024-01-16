package kuda.driverapi.prop

/**
 * @property SUCCESS The API call returned with no errors. In the case of query calls, this also means that the operation being queried is complete (see cuEventQuery() and cuStreamQuery()).
 * @property ERROR_INVALID_VALUE This indicates that one or more of the parameters passed to the API call is not within an acceptable range of values.
 * @property ERROR_OUT_OF_MEMORY The API call failed because it was unable to allocate enough memory or other resources to perform the requested operation.
 * @property ERROR_NOT_INITIALIZED This indicates that the CUDA driver has not been initialized with cuInit() or that initialization has failed.
 * @property ERROR_DEINITIALIZED This indicates that the CUDA driver is in the process of shutting down.
 * @property ERROR_PROFILER_DISABLED This indicates profiler is not initialized for this run. This can happen when the application is running with external profiling tools like visual profiler.
 * @property ERROR_PROFILER_NOT_INITIALIZED Deprecated. This error return is deprecated as of CUDA 5.0. It is no longer an error to attempt to enable/disable the profiling via cuProfilerStart or cuProfilerStop without initialization.
 * @property ERROR_PROFILER_ALREADY_STARTED This error return is deprecated as of CUDA 5.0. It is no longer an error to call cuProfilerStart() when profiling is already enabled.
 * @property ERROR_PROFILER_ALREADY_STOPPED Deprecated. This error return is deprecated as of CUDA 5.0. It is no longer an error to call cuProfilerStop() when profiling is already disabled.
 * @property ERROR_STUB_LIBRARY This indicates that the CUDA driver that the application has loaded is a stub library. Applications that run with the stub rather than a real driver loaded will result in CUDA API returning this error.
 * @property ERROR_DEVICE_UNAVAILABLE This indicates that requested CUDA device is unavailable at the current time. Devices are often unavailable due to use of CU_COMPUTEMODE_EXCLUSIVE_PROCESS or CU_COMPUTEMODE_PROHIBITED.
 * @property ERROR_NO_DEVICE This indicates that no CUDA-capable devices were detected by the installed CUDA driver.
 * @property ERROR_INVALID_DEVICE This indicates that the device ordinal supplied by the user does not correspond to a valid CUDA device or that the action requested is invalid for the specified device.
 * @property ERROR_DEVICE_NOT_LICENSED This error indicates that the Grid license is not applied.
 * @property ERROR_INVALID_IMAGE This indicates that the device kernel image is invalid. This can also indicate an invalid CUDA module.
 * @property ERROR_INVALID_CONTEXT This most frequently indicates that there is no context bound to the current thread. This can also be returned if the context passed to an API call is not a valid handle (such as a context that has had cuCtxDestroy() invoked on it). This can also be returned if a user mixes different API versions (i.e. 3010 context with 3020 API calls). See cuCtxGetApiVersion() for more details.
 * @property ERROR_CONTEXT_ALREADY_CURRENT Deprecated. This error return is deprecated as of CUDA 3.2. It is no longer an error to attempt to push the active context via cuCtxPushCurrent(). This indicated that the context being supplied as a parameter to the API call was already the active context.
 * @property ERROR_MAP_FAILED This indicates that a map or register operation has failed.
 * @property ERROR_UNMAP_FAILED This indicates that an unmap or unregister operation has failed.
 * @property ERROR_ARRAY_IS_MAPPED This indicates that the specified array is currently mapped and thus cannot be destroyed.
 * @property ERROR_ALREADY_MAPPED This indicates that the resource is already mapped.
 * @property ERROR_NO_BINARY_FOR_GPU This indicates that there is no kernel image available that is suitable for the device. This can occur when a user specifies code generation options for a particular CUDA source file that do not include the corresponding device configuration.
 * @property ERROR_ALREADY_ACQUIRED This indicates that a resource has already been acquired.
 * @property ERROR_NOT_MAPPED This indicates that a resource is not mapped.
 * @property ERROR_NOT_MAPPED_AS_ARRAY This indicates that a mapped resource is not available for access as an array.
 * @property ERROR_NOT_MAPPED_AS_POINTER This indicates that a mapped resource is not available for access as a pointer.
 * @property ERROR_ECC_UNCORRECTABLE This indicates that an uncorrectable ECC error was detected during execution.
 * @property ERROR_UNSUPPORTED_LIMIT This indicates that the CUlimit passed to the API call is not supported by the active device.
 * @property ERROR_CONTEXT_ALREADY_IN_USE This indicates that the CUcontext passed to the API call can only be bound to a single CPU thread at a time but is already bound to a CPU thread.
 * @property ERROR_PEER_ACCESS_UNSUPPORTED This indicates that peer access is not supported across the given devices.
 * @property ERROR_INVALID_PTX This indicates that a PTX JIT compilation failed.
 * @property ERROR_INVALID_GRAPHICS_CONTEXT This indicates an error with OpenGL or DirectX context.
 * @property ERROR_NVLINK_UNCORRECTABLE This indicates that an uncorrectable NVLink error was detected during the execution.
 * @property ERROR_JIT_COMPILER_NOT_FOUND This indicates that the PTX JIT compiler library was not found.
 * @property ERROR_UNSUPPORTED_PTX_VERSION This indicates that the provided PTX was compiled with an unsupported toolchain.
 * @property ERROR_JIT_COMPILATION_DISABLED This indicates that the PTX JIT compilation was disabled.
 * @property ERROR_UNSUPPORTED_EXEC_AFFINITY This indicates that the CUexecAffinityType passed to the API call is not supported by the active device.
 * @property ERROR_UNSUPPORTED_DEVSIDE_SYNC This indicates that the code to be compiled by the PTX JIT contains unsupported call to cudaDeviceSynchronize.
 * @property ERROR_INVALID_SOURCE This indicates that the device kernel source is invalid. This includes compilation/linker errors encountered in device code or user error.
 * @property ERROR_FILE_NOT_FOUND This indicates that the file specified was not found.
 * @property ERROR_SHARED_OBJECT_SYMBOL_NOT_FOUND This indicates that a link to a shared object failed to resolve.
 * @property ERROR_SHARED_OBJECT_INIT_FAILED This indicates that initialization of a shared object failed.
 * @property ERROR_OPERATING_SYSTEM This indicates that an OS call failed.
 * @property ERROR_INVALID_HANDLE This indicates that a resource handle passed to the API call was not valid. Resource handles are opaque types like CUstream and CUevent.
 * @property ERROR_ILLEGAL_STATE This indicates that a resource required by the API call is not in a valid state to perform the requested operation.
 * @property ERROR_LOSSY_QUERY This indicates an attempt was made to introspect an object in a way that would discard semantically important information. This is either due to the object using funtionality newer than the API version used to introspect it or omission of optional return arguments.
 * @property ERROR_NOT_FOUND This indicates that a named symbol was not found. Examples of symbols are global/constant variable names, driver function names, texture names, and surface names.
 * @property ERROR_NOT_READY This indicates that asynchronous operations issued previously have not completed yet. This result is not actually an error, but must be indicated differently than SUCCESS (which indicates completion). Calls that may return this value include cuEventQuery() and cuStreamQuery().
 * @property ERROR_ILLEGAL_ADDRESS While executing a kernel, the device encountered a load or store instruction on an invalid memory address. This leaves the process in an inconsistent state and any further CUDA work will return the same error. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_LAUNCH_OUT_OF_RESOURCES This indicates that a launch did not occur because it did not have appropriate resources. This error usually indicates that the user has attempted to pass too many arguments to the device kernel, or the kernel launch specifies too many threads for the kernel's register count. Passing arguments of the wrong size (i.e. a 64-bit pointer when a 32-bit int is expected) is equivalent to passing too many arguments and can also result in this error.
 * @property ERROR_LAUNCH_TIMEOUT This indicates that the device kernel took too long to execute. This can only occur if timeouts are enabled - see the device attribute CU_DEVICE_ATTRIBUTE_KERNEL_EXEC_TIMEOUT for more information. This leaves the process in an inconsistent state and any further CUDA work will return the same error. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_LAUNCH_INCOMPATIBLE_TEXTURING This error indicates a kernel launch that uses an incompatible texturing mode.
 * @property ERROR_PEER_ACCESS_ALREADY_ENABLED This error indicates that a call to cuCtxEnablePeerAccess() is trying to re-enable peer access to a context which has already had peer access to it enabled.
 * @property ERROR_PEER_ACCESS_NOT_ENABLED This error indicates that cuCtxDisablePeerAccess() is trying to disable peer access which has not been enabled yet via cuCtxEnablePeerAccess().
 * @property ERROR_PRIMARY_CONTEXT_ACTIVE This error indicates that the primary context for the specified device has already been initialized.
 * @property ERROR_CONTEXT_IS_DESTROYED This error indicates that the context current to the calling thread has been destroyed using cuCtxDestroy, or is a primary context which has not yet been initialized.
 * @property ERROR_ASSERT A device-side assert triggered during kernel execution. The context cannot be used anymore, and must be destroyed. All existing device memory allocations from this context are invalid and must be reconstructed if the program is to continue using CUDA.
 * @property ERROR_TOO_MANY_PEERS This error indicates that the hardware resources required to enable peer access have been exhausted for one or more of the devices passed to cuCtxEnablePeerAccess().
 * @property ERROR_HOST_MEMORY_ALREADY_REGISTERED This error indicates that the memory range passed to cuMemHostRegister() has already been registered.
 * @property ERROR_HOST_MEMORY_NOT_REGISTERED This error indicates that the pointer passed to cuMemHostUnregister() does not correspond to any currently registered memory region.
 * @property ERROR_HARDWARE_STACK_ERROR While executing a kernel, the device encountered a stack error. This can be due to stack corruption or exceeding the stack size limit. This leaves the process in an inconsistent state and any further CUDA work will return the same error. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_ILLEGAL_INSTRUCTION While executing a kernel, the device encountered an illegal instruction. This leaves the process in an inconsistent state and any further CUDA work will return the same error. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_MISALIGNED_ADDRESS While executing a kernel, the device encountered a load or store instruction on a memory address which is not aligned. This leaves the process in an inconsistent state and any further CUDA work will return the same error. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_INVALID_ADDRESS_SPACE While executing a kernel, the device encountered an instruction which can only operate on memory locations in certain address spaces (global, shared, or local), but was supplied a memory address not belonging to an allowed address space. This leaves the process in an inconsistent state and any further CUDA work will return the same error. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_INVALID_PC While executing a kernel, the device program counter wrapped its address space. This leaves the process in an inconsistent state and any further CUDA work will return the same error. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_LAUNCH_FAILED An exception occurred on the device while executing a kernel. Common causes include dereferencing an invalid device pointer and accessing out of bounds shared memory. Less common cases can be system specific - more information about these cases can be found in the system specific user guide. This leaves the process in an inconsistent state and any further CUDA work will return the same error. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_COOPERATIVE_LAUNCH_TOO_LARGE This error indicates that the number of blocks launched per grid for a kernel that was launched via either cuLaunchCooperativeKernel or cuLaunchCooperativeKernelMultiDevice exceeds the maximum number of blocks as allowed by cuOccupancyMaxActiveBlocksPerMultiprocessor or cuOccupancyMaxActiveBlocksPerMultiprocessorWithFlags times the number of multiprocessors as specified by the device attribute CU_DEVICE_ATTRIBUTE_MULTIPROCESSOR_COUNT.
 * @property ERROR_NOT_PERMITTED This error indicates that the attempted operation is not permitted.
 * @property ERROR_NOT_SUPPORTED This error indicates that the attempted operation is not supported on the current system or device.
 * @property ERROR_SYSTEM_NOT_READY This error indicates that the system is not yet ready to start any CUDA work. To continue using CUDA, verify the system configuration is in a valid state and all required driver daemons are actively running. More information about this error can be found in the system specific user guide.
 * @property ERROR_SYSTEM_DRIVER_MISMATCH This error indicates that there is a mismatch between the versions of the display driver and the CUDA driver. Refer to the compatibility documentation for supported versions.
 * @property ERROR_COMPAT_NOT_SUPPORTED_ON_DEVICE This error indicates that the system was upgraded to run with forward compatibility but the visible hardware detected by CUDA does not support this configuration. Refer to the compatibility documentation for the supported hardware matrix or ensure that only supported hardware is visible during initialization via the VISIBLE_DEVICES environment variable.
 * @property ERROR_MPS_CONNECTION_FAILED This error indicates that the MPS client failed to connect to the MPS control daemon or the MPS server.
 * @property ERROR_MPS_RPC_FAILURE This error indicates that the remote procedural call between the MPS server and the MPS client failed.
 * @property ERROR_MPS_SERVER_NOT_READY This error indicates that the MPS server is not ready to accept new MPS client requests. This error can be returned when the MPS server is in the process of recovering from a fatal failure.
 * @property ERROR_MPS_MAX_CLIENTS_REACHED This error indicates that the hardware resources required to create MPS client have been exhausted.
 * @property ERROR_MPS_MAX_CONNECTIONS_REACHED This error indicates the the hardware resources required to support device connections have been exhausted.
 * @property ERROR_MPS_CLIENT_TERMINATED This error indicates that the MPS client has been terminated by the server. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_CDP_NOT_SUPPORTED This error indicates that the module is using CUDA Dynamic Parallelism, but the current configuration, like MPS, does not support it.
 * @property ERROR_CDP_VERSION_MISMATCH This error indicates that a module contains an unsupported interaction between different versions of CUDA Dynamic Parallelism.
 * @property ERROR_STREAM_CAPTURE_UNSUPPORTED This error indicates that the operation is not permitted when the stream is capturing.
 * @property ERROR_STREAM_CAPTURE_INVALIDATED This error indicates that the current capture sequence on the stream has been invalidated due to a previous error.
 * @property ERROR_STREAM_CAPTURE_MERGE This error indicates that the operation would have resulted in a merge of two independent capture sequences.
 * @property ERROR_STREAM_CAPTURE_UNMATCHED This error indicates that the capture was not initiated in this stream.
 * @property ERROR_STREAM_CAPTURE_UNJOINED This error indicates that the capture sequence contains a fork that was not joined to the primary stream.
 * @property ERROR_STREAM_CAPTURE_ISOLATION This error indicates that a dependency would have been created which crosses the capture sequence boundary. Only implicit in-stream ordering dependencies are allowed to cross the boundary.
 * @property ERROR_STREAM_CAPTURE_IMPLICIT This error indicates a disallowed implicit dependency on a current capture sequence from cudaStreamLegacy.
 * @property ERROR_CAPTURED_EVENT This error indicates that the operation is not permitted on an event which was last recorded in a capturing stream.
 * @property ERROR_STREAM_CAPTURE_WRONG_THREAD A stream capture sequence not initiated with the CU_STREAM_CAPTURE_MODE_RELAXED argument to cuStreamBeginCapture was passed to cuStreamEndCapture in a different thread.
 * @property ERROR_TIMEOUT This error indicates that the timeout specified for the wait operation has lapsed.
 * @property ERROR_GRAPH_EXEC_UPDATE_FAILURE This error indicates that the graph update was not performed because it included changes which violated constraints specific to instantiated graph update.
 * @property ERROR_EXTERNAL_DEVICE This indicates that an async error has occurred in a device outside of CUDA. If CUDA was waiting for an external device's signal before consuming shared data, the external device signaled an error indicating that the data is not valid for consumption. This leaves the process in an inconsistent state and any further CUDA work will return the same error. To continue using CUDA, the process must be terminated and relaunched.
 * @property ERROR_INVALID_CLUSTER_SIZE Indicates a kernel launch error due to cluster misconfiguration.
 * @property ERROR_UNKNOWN This indicates that an unknown internal error has occurred.
 */

enum class Result(val num : Int) {
    SUCCESS(0),
    ERROR_INVALID_VALUE(1),
    ERROR_OUT_OF_MEMORY(2),
    ERROR_NOT_INITIALIZED(3),
    ERROR_DEINITIALIZED(4),
    ERROR_PROFILER_DISABLED(5),
    ERROR_PROFILER_NOT_INITIALIZED(6),
    ERROR_PROFILER_ALREADY_STARTED(7),
    ERROR_PROFILER_ALREADY_STOPPED(8),
    ERROR_STUB_LIBRARY(34),
    ERROR_DEVICE_UNAVAILABLE(46),
    ERROR_NO_DEVICE(100),
    ERROR_INVALID_DEVICE(101),
    ERROR_DEVICE_NOT_LICENSED(102),
    ERROR_INVALID_IMAGE(200),
    ERROR_INVALID_CONTEXT(201),
    ERROR_CONTEXT_ALREADY_CURRENT(202),
    ERROR_MAP_FAILED(205),
    ERROR_UNMAP_FAILED(206),
    ERROR_ARRAY_IS_MAPPED(207),
    ERROR_ALREADY_MAPPED(208),
    ERROR_NO_BINARY_FOR_GPU(209),
    ERROR_ALREADY_ACQUIRED(210),
    ERROR_NOT_MAPPED(211),
    ERROR_NOT_MAPPED_AS_ARRAY(212),
    ERROR_NOT_MAPPED_AS_POINTER(213),
    ERROR_ECC_UNCORRECTABLE(214),
    ERROR_UNSUPPORTED_LIMIT(215),
    ERROR_CONTEXT_ALREADY_IN_USE(216),
    ERROR_PEER_ACCESS_UNSUPPORTED(217),
    ERROR_INVALID_PTX(218),
    ERROR_INVALID_GRAPHICS_CONTEXT(219),
    ERROR_NVLINK_UNCORRECTABLE(220),
    ERROR_JIT_COMPILER_NOT_FOUND(221),
    ERROR_UNSUPPORTED_PTX_VERSION(222),
    ERROR_JIT_COMPILATION_DISABLED(223),
    ERROR_UNSUPPORTED_EXEC_AFFINITY(224),
    ERROR_UNSUPPORTED_DEVSIDE_SYNC(225),
    ERROR_INVALID_SOURCE(300),
    ERROR_FILE_NOT_FOUND(301),
    ERROR_SHARED_OBJECT_SYMBOL_NOT_FOUND(302),
    ERROR_SHARED_OBJECT_INIT_FAILED(303),
    ERROR_OPERATING_SYSTEM(304),
    ERROR_INVALID_HANDLE(400),
    ERROR_ILLEGAL_STATE(401),
    ERROR_LOSSY_QUERY(402),
    ERROR_NOT_FOUND(500),
    ERROR_NOT_READY(600),
    ERROR_ILLEGAL_ADDRESS(700),
    ERROR_LAUNCH_OUT_OF_RESOURCES(701),
    ERROR_LAUNCH_TIMEOUT(702),
    ERROR_LAUNCH_INCOMPATIBLE_TEXTURING(703),
    ERROR_PEER_ACCESS_ALREADY_ENABLED(704),
    ERROR_PEER_ACCESS_NOT_ENABLED(705),
    ERROR_PRIMARY_CONTEXT_ACTIVE(708),
    ERROR_CONTEXT_IS_DESTROYED(709),
    ERROR_ASSERT(710),
    ERROR_TOO_MANY_PEERS(711),
    ERROR_HOST_MEMORY_ALREADY_REGISTERED(712),
    ERROR_HOST_MEMORY_NOT_REGISTERED(713),
    ERROR_HARDWARE_STACK_ERROR(714),
    ERROR_ILLEGAL_INSTRUCTION(715),
    ERROR_MISALIGNED_ADDRESS(716),
    ERROR_INVALID_ADDRESS_SPACE(717),
    ERROR_INVALID_PC(718),
    ERROR_LAUNCH_FAILED(719),
    ERROR_COOPERATIVE_LAUNCH_TOO_LARGE(720),
    ERROR_NOT_PERMITTED(800),
    ERROR_NOT_SUPPORTED(801),
    ERROR_SYSTEM_NOT_READY(802),
    ERROR_SYSTEM_DRIVER_MISMATCH(803),
    ERROR_COMPAT_NOT_SUPPORTED_ON_DEVICE(804),
    ERROR_MPS_CONNECTION_FAILED(805),
    ERROR_MPS_RPC_FAILURE(806),
    ERROR_MPS_SERVER_NOT_READY(807),
    ERROR_MPS_MAX_CLIENTS_REACHED(808),
    ERROR_MPS_MAX_CONNECTIONS_REACHED(809),
    ERROR_MPS_CLIENT_TERMINATED(810),
    ERROR_CDP_NOT_SUPPORTED(811),
    ERROR_CDP_VERSION_MISMATCH(812),
    ERROR_STREAM_CAPTURE_UNSUPPORTED(900),
    ERROR_STREAM_CAPTURE_INVALIDATED(901),
    ERROR_STREAM_CAPTURE_MERGE(902),
    ERROR_STREAM_CAPTURE_UNMATCHED(903),
    ERROR_STREAM_CAPTURE_UNJOINED(904),
    ERROR_STREAM_CAPTURE_ISOLATION(905),
    ERROR_STREAM_CAPTURE_IMPLICIT(906),
    ERROR_CAPTURED_EVENT(907),
    ERROR_STREAM_CAPTURE_WRONG_THREAD(908),
    ERROR_TIMEOUT(909),
    ERROR_GRAPH_EXEC_UPDATE_FAILURE(910),
    ERROR_EXTERNAL_DEVICE(911),
    ERROR_INVALID_CLUSTER_SIZE(912),
    ERROR_UNKNOWN(999)
}