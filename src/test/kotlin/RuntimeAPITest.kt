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
}