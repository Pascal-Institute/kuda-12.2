package kuda.driverapi.prop

/**
 *
 * Shared memory configurations (CUsharedconfig)
 *
 * @property DEFAULT_BANK_SIZE set default shared memory bank size
 * @property FOUR_BYTE_BANK_SIZE set shared memory bank width to four bytes
 * @property EIGHT_BYTE_BANK_SIZE set shared memory bank width to eight bytes
 */
enum class SharedConfig(val num : Int) {
   DEFAULT_BANK_SIZE(0x00),
   FOUR_BYTE_BANK_SIZE(0x01),
   EIGHT_BYTE_BANK_SIZE(0x02)

   companion object{
      fun fromInt(num : Int) : SharedConfig ? = entries.find { it.num == num }
   }
}