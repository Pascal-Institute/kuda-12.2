import kuda.driverapi.DriverAPI
import kuda.driverapi.prop.Result
import org.junit.jupiter.api.Test

class DriverAPITest {
    @Test
    fun `test errorhandling`(){
        var driverAPI = DriverAPI()
        driverAPI.init(0)
        println(driverAPI.getErrorName(Result.SUCCESS))
        println(driverAPI.getErrorString(Result.SUCCESS))
    }
}