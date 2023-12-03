import kuda.DeviceAttribute
import kuda.DriverAPI
import kuda.Limit
import kuda.RuntimeAPI

fun main(args: Array<String>) {
    val runtimeAPI = RuntimeAPI()
    val driverAPI = DriverAPI()

    val cudaVersion = runtimeAPI.getRuntimeVersion()
    val driverVersion = driverAPI.getDriverVersion()

    val device = runtimeAPI.getDivice()
    val driverDevice = driverAPI.getDevice(0)
    val deviceCount = driverAPI.getDeviceCount()

    driverAPI.init(0)
    println("CUDA Version : $cudaVersion")
    println("CUDA Driver version : $driverVersion")
    println("CUDA Device: $device")
    println("CUDA Device count : $deviceCount")
    println(driverDevice)
    println(runtimeAPI.getLimit(Limit.PRINT_FIFO_SIZE))
    println(runtimeAPI.getLimit(Limit.MALLOC_HEAP_SIZE))
    println(runtimeAPI.getLimit(Limit.STACK_SIZE))
    println(runtimeAPI.getLimit(Limit.DEV_RUNTIME_SYNC_DEPTH))
    println(runtimeAPI.getLimit(Limit.MAX_L2_FETCH_GRANULARITY))
    println(runtimeAPI.getLimit(Limit.DEV_RUNTIME_PENDING_LAUNCH_COUNT))
    println(runtimeAPI.getLimit(Limit.PERSISTING_L2_CACHE_SIZE))

}