fun main(args: Array<String>) {
    val kudaRuntimeAPI = KudaRuntimeAPI()
    val cudaVersion = kudaRuntimeAPI.getRuntimeVersion()
    val divice = kudaRuntimeAPI.getDivice()
    println("CUDA Version: $cudaVersion")
    println("CUDA Divice: $divice")
}