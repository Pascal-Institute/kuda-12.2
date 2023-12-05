import kuda.*
import kuda.type.Error
import kuda.type.FunctionCache
import kuda.type.Limit

fun main(args: Array<String>) {
    val runtimeAPI = RuntimeAPI()
    val driverAPI = DriverAPI()

    val cudaVersion = runtimeAPI.runtimeGetVersion()
    val driverVersion = driverAPI.getDriverVersion()

    val device = runtimeAPI.getDevice()
    val driverDevice = driverAPI.getDevice(0)
    val deviceCount = driverAPI.getDeviceCount()
    driverAPI.init(0)
    println("CUDA Version : $cudaVersion")
    println("CUDA Driver version : $driverVersion")
    println("CUDA Device: $device")
    println("CUDA Device count : $deviceCount")
    println(driverDevice)
    println(runtimeAPI.deviceGetLimit(Limit.PRINT_FIFO_SIZE))
    println(runtimeAPI.deviceGetLimit(Limit.MALLOC_HEAP_SIZE))
    println(runtimeAPI.deviceGetLimit(Limit.STACK_SIZE))
    println(runtimeAPI.deviceGetLimit(Limit.DEV_RUNTIME_SYNC_DEPTH))
    println(runtimeAPI.deviceGetLimit(Limit.MAX_L2_FETCH_GRANULARITY))
    println(runtimeAPI.deviceGetLimit(Limit.DEV_RUNTIME_PENDING_LAUNCH_COUNT))
    println(runtimeAPI.deviceGetLimit(Limit.PERSISTING_L2_CACHE_SIZE))

    println(runtimeAPI.deviceGetPCIBusId(device))
    println(runtimeAPI.deviceGetStreamPriorityRange())

    println(runtimeAPI.deviceSetCacheConfig(FunctionCache.PREFER_NONE))

    println(runtimeAPI.getErrorName(Error.ERROR_UNKNOWN))
    println(runtimeAPI.getErrorString(Error.INITIALIZATION_ERROR))

}