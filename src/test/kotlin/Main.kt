
import kuda.DriverAPI
import kuda.RuntimeAPI
import kuda.runtimeapi.DeviceHandler
import kuda.runtimeapi.EventHandler
import kuda.runtimeapi.StreamHandler
import kuda.prop.Error
import kuda.prop.FunctionCache
import kuda.prop.Limit

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
    println(DeviceHandler.getLimit(Limit.PRINT_FIFO_SIZE))
    println(DeviceHandler.getLimit(Limit.MALLOC_HEAP_SIZE))
    println(DeviceHandler.getLimit(Limit.STACK_SIZE))
    println(DeviceHandler.getLimit(Limit.DEV_RUNTIME_SYNC_DEPTH))
    println(DeviceHandler.getLimit(Limit.MAX_L2_FETCH_GRANULARITY))
    println(DeviceHandler.getLimit(Limit.DEV_RUNTIME_PENDING_LAUNCH_COUNT))
    println(DeviceHandler.getLimit(Limit.PERSISTING_L2_CACHE_SIZE))

    println(DeviceHandler.getPCIBusId(device))
    println(DeviceHandler.getStreamPriorityRange())

    println(DeviceHandler.setCacheConfig(FunctionCache.PREFER_NONE))
    println(DeviceHandler.synchronize())
    println(DeviceHandler.reset())

    println(runtimeAPI.driverGetVersion())

    println(runtimeAPI.getErrorName(Error.ERROR_UNKNOWN))
    println(runtimeAPI.getErrorString(Error.INITIALIZATION_ERROR))

    var stream = StreamHandler.create()

    var eventStart = EventHandler.create()
    var eventEnd = EventHandler.create()
    EventHandler.destroy(eventStart)
    eventStart = EventHandler.create()
    var time = EventHandler.elapsedTime(eventStart, eventEnd)
    println(time)

}