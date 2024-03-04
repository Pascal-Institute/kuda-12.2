import kuda.runtimeapi.RuntimeAPI
import org.junit.jupiter.api.Test

class Fail {
    @Test
    fun `test IpcGetEventHandle`(){
        var runtimeAPI = RuntimeAPI()
        runtimeAPI.initDevice(0,0)
        var event = runtimeAPI.eventCreate()
        println(event)
        println(runtimeAPI.ipcGetEventHandle(event))
    }
}