import kuda.DeviceAttribute
import kuda.DriverAPI
import kuda.RuntimeAPI

fun main(args: Array<String>) {
    val runtimeAPI = RuntimeAPI()
    val driverAPI = DriverAPI()

    val cudaVersion = runtimeAPI.getRuntimeVersion()
    val driverVersion = driverAPI.getDriverVersion()

    val device = runtimeAPI.getDivice()
    val driverDevice = driverAPI.getDevice(0)
    val deviceCount = driverAPI.getDeviceCount()

    driverAPI.init(0)
    println("CUDA Version : $cudaVersion")
    println("CUDA Driver version : $driverVersion")
    println("CUDA Device: $device")
    println("CUDA Device count : $deviceCount")
    println(driverDevice)
}