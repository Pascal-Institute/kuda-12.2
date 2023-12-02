import kuda.DriverAPI
import kuda.RuntimeAPI

fun main(args: Array<String>) {
    val kudaRuntimeAPI = RuntimeAPI()
    val driverAPI = DriverAPI()
    val cudaVersion = kudaRuntimeAPI.getRuntimeVersion()
    val divice = kudaRuntimeAPI.getDivice()

    driverAPI.init(0)
    println("CUDA Version: $cudaVersion")
    println("CUDA Divice: $divice")
}