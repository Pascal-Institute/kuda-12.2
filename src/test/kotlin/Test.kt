import kuda.driverapi.DriverAPI
import kuda.driverapi.prop.Result
import kuda.kublas.Kublas
import kuda.runtimeapi.RuntimeAPI
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

        val device = runtimeAPI.getDevice()

        runtimeAPI.initDevice(device, 0)

        val driverDevice = driverAPI.deviceGet(0)
        val deviceCount = driverAPI.deviceGetCount()
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

        println(runtimeAPI.getPCIBusId(device))
        println(runtimeAPI.getStreamPriorityRange())

        println(runtimeAPI.setCacheConfig(FunctionCache.PREFER_NONE))
        println(runtimeAPI.synchronize())
        println(runtimeAPI.reset())

        println(runtimeAPI.driverGetVersion())

        println(runtimeAPI.getErrorName(kuda.runtimeapi.prop.Error.ERROR_UNKNOWN))
        println(runtimeAPI.getErrorString(kuda.runtimeapi.prop.Error.INITIALIZATION_ERROR))

        var stream = runtimeAPI.streamCreate()

        var mallocPointer = runtimeAPI.malloc(32)
        println(mallocPointer)

        val mallocHostPointer =  runtimeAPI.mallocHost(32)
        println(mallocHostPointer)
        runtimeAPI.freeHost(mallocHostPointer)

        runtimeAPI.getMemPool(device)

        var eventStart =  runtimeAPI.eventCreate()
        var eventEnd = runtimeAPI.eventCreate()
        runtimeAPI.eventDestroy(eventStart)
        eventStart = runtimeAPI.eventCreate()
        var time = runtimeAPI.eventElapsedTime(eventStart, eventEnd)
        println(time)

        val kublas = Kublas()
        val handle = kublas.create()
        kublas.destroy(handle)
        println(kublas.getVersion(handle))
    }

    @Test
    fun `test getDeviceProperties`(){
        val runtimeAPI = RuntimeAPI()
        val device = runtimeAPI.getDevice()
        runtimeAPI.initDevice(device, 0)
        val prop = runtimeAPI.getDeviceProperties(device)
    }

    @Test
    fun `test chooseDevice`(){
        val runtimeAPI = RuntimeAPI()
        val device = runtimeAPI.getDevice()
        runtimeAPI.initDevice(device, 0)
        val prop = runtimeAPI.getDeviceProperties(device)

        println(runtimeAPI.chooseDevice(prop))
    }

    @Test
    fun `test errorhandling`(){
        var driverAPI = DriverAPI()
        println(driverAPI.getErrorName(Result.ERROR_MPS_RPC_FAILURE))
        println(driverAPI.getErrorString(Result.ERROR_MPS_RPC_FAILURE))
    }
}