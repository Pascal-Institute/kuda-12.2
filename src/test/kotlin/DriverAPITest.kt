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

    @Test
    fun `test streamGetId`(){
        val driverAPI = DriverAPI()
        driverAPI.init(0)
        val device = driverAPI.deviceGet(0)
        println(device)
        val ctx = driverAPI.ctxCreate(0, device)
        println(ctx)
        driverAPI.ctxSetCurrent(ctx)
        val stream= driverAPI.streamCreate(0)
        println(stream)
        val id = driverAPI.streamGetId(stream)
        println(id)
    }
}