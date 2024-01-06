import kuda.DriverAPI
import kuda.runtimeapi.RuntimeAPI
import org.junit.jupiter.api.Test

class Fail {

    @Test
    fun `test getDeviceProperties`(){
        val runtimeAPI = RuntimeAPI()
        val device = runtimeAPI.getDevice()
        runtimeAPI.initDevice(device, 0)
        val prop = runtimeAPI.getDeviceProperties(device)
    }
}