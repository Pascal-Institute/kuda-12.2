import kuda.driverapi.DriverAPI
import kuda.driverapi.prop.Result
import kuda.kublas.Kublas
import kuda.runtimeapi.DeviceManager
import kuda.runtimeapi.EventManager
import kuda.runtimeapi.RuntimeAPI
import kuda.runtimeapi.StreamManager
import kuda.runtimeapi.prop.FunctionCache
import kuda.runtimeapi.prop.Limit
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun `test get os name`(){
        println(System.getProperty("os.name"))
    }

    @Test
    fun `test defalut`(){
        val runtimeAPI = RuntimeAPI()
        val driverAPI = DriverAPI()


        val cudaVersion = runtimeAPI.runtimeGetVersion()
        val driverVersion = driverAPI.driverGetVersion()

        val device = DeviceManager.getDevice()

        DeviceManager.initDevice(device, 0)

        val driverDevice = driverAPI.deviceGet(0)
        val deviceCount = driverAPI.deviceGetCount()
        driverAPI.init(0)
        println("CUDA Version : $cudaVersion")
        println("CUDA Driver version : $driverVersion")
        println("CUDA Device: $device")
        println("CUDA Device count : $deviceCount")
        println(driverDevice)
        println(DeviceManager.getLimit(Limit.PRINT_FIFO_SIZE))
        println(DeviceManager.getLimit(Limit.MALLOC_HEAP_SIZE))
        println(DeviceManager.getLimit(Limit.STACK_SIZE))
        println(DeviceManager.getLimit(Limit.DEV_RUNTIME_SYNC_DEPTH))
        println(DeviceManager.getLimit(Limit.MAX_L2_FETCH_GRANULARITY))
        println(DeviceManager.getLimit(Limit.DEV_RUNTIME_PENDING_LAUNCH_COUNT))
        println(DeviceManager.getLimit(Limit.PERSISTING_L2_CACHE_SIZE))

        println(DeviceManager.getPCIBusId(device))
        println(DeviceManager.getStreamPriorityRange())

        println(DeviceManager.setCacheConfig(FunctionCache.PREFER_NONE))
        println(DeviceManager.synchronize())
        println(DeviceManager.reset())

        println(runtimeAPI.driverGetVersion())

        println(runtimeAPI.getErrorName(kuda.runtimeapi.prop.Error.ERROR_UNKNOWN))
        println(runtimeAPI.getErrorString(kuda.runtimeapi.prop.Error.INITIALIZATION_ERROR))

        var stream = StreamManager.create()

        var mallocPointer = runtimeAPI.malloc(32)
        println(mallocPointer)

        val mallocHostPointer =  runtimeAPI.mallocHost(32)
        println(mallocHostPointer)
        runtimeAPI.freeHost(mallocHostPointer)

        DeviceManager.getMemPool(device)

        var eventStart = EventManager.create()
        var eventEnd = EventManager.create()
        EventManager.destroy(eventStart)
        eventStart = EventManager.create()
        var time = EventManager.elapsedTime(eventStart, eventEnd)
        println(time)

        val kublas = Kublas()
        val handle = kublas.create()
        kublas.destroy(handle)
        println(kublas.getVersion(handle))
    }

    @Test
    fun `test getDeviceProperties`(){
        val device = DeviceManager.getDevice()
        DeviceManager.initDevice(device, 0)
        val prop = DeviceManager.getDeviceProperties(device)
    }

    @Test
    fun `test chooseDevice`(){
        val device = DeviceManager.getDevice()
        DeviceManager.initDevice(device, 0)
        val prop = DeviceManager.getDeviceProperties(device)

        println(DeviceManager.chooseDevice(prop))
    }

    @Test
    fun `test errorhandling`(){
        var driverAPI = DriverAPI()
        println(driverAPI.getErrorName(Result.ERROR_MPS_RPC_FAILURE))
        println(driverAPI.getErrorString(Result.ERROR_MPS_RPC_FAILURE))
    }
}