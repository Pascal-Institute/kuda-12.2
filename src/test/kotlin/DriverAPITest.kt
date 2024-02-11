import kuda.driverapi.DriverAPI
import kuda.driverapi.prop.Result
import kuda.driverapi.prop.FuncCache
import org.junit.jupiter.api.Test

class DriverAPITest {
    @Test
    fun `test errorhandling`(){
        var driverAPI = DriverAPI()
        driverAPI.init(0)
        println(driverAPI.getErrorName(Result.SUCCESS))
        println(driverAPI.getErrorString(Result.SUCCESS))
    }

    @Test
    fun `test ctxSetCacheConfig`(){
        var driverAPI = DriverAPI()
        driverAPI.init(0)
        driverAPI.ctxSetCacheConfig(FuncCache.PREFER_L1)
    }

    @Test
    fun `test eventCreate`(){
        var driverAPI = DriverAPI()
        driverAPI.init(0)
        val event = driverAPI.eventCreate(0)
        println(event)
    }
}