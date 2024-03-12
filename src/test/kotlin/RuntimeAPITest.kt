import kuda.runtimeapi.RuntimeAPI
import kuda.runtimeapi.prop.DeviceAttribute
import org.junit.jupiter.api.Test

class RuntimeAPITest {
    @Test
    fun `test deviceGetAttribute`(){
        var runtimeAPI = RuntimeAPI()
        runtimeAPI.initDevice(0,0)
        var device = runtimeAPI.getDevice()
        println(runtimeAPI.deviceGetAttribute(DeviceAttribute.ASYNC_ENGINE_COUNT, device))
    }

    @Test
    fun `test malloc`(){
        var runtimeAPI = RuntimeAPI()
        runtimeAPI.initDevice(0,0)
        var devPtr = runtimeAPI.malloc(64)
        println(devPtr)

    }

    @Test
    fun `test ipcGetMemHandle`(){
        var runtimeAPI = RuntimeAPI()
        runtimeAPI.initDevice(0,0)
        var devPtr = runtimeAPI.malloc(64)
        var memHandle = runtimeAPI.ipcGetMemHandle(devPtr)
        println(memHandle.reserved)
    }

    @Test
    fun `test streamSynchronize`(){
        var runtimeAPI = RuntimeAPI()
        runtimeAPI.initDevice(0,0)
        var stream = runtimeAPI.streamCreate()
        assertEquals(0, runtimeAPI.streamSynchronize(stream))
    }
}