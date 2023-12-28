package kuda.prop

enum class SharedMemoryConfig(val num : Int) {
    BANK_SIZE_DEFAULT(0),
    BANK_SIZE_FOUR_BYTE(1),
    BANK_SIZE_EIGHT_BYTE(2)
}