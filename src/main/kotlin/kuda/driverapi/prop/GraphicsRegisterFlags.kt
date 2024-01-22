package kuda.driverapi.prop

/**
 *
 * Flags to register a graphics resource
 *
 * @property NONE
 * @property READ_ONLY
 * @property WRITE_DISCARD
 * @property SURFACE_LDST
 * @property TEXTURE_GATHER
 */
enum class GraphicsRegisterFlags(val num : Int) {
   NONE(0x00),
   READ_ONLY(0x01),
   WRITE_DISCARD(0x02),
   SURFACE_LDST(0x04),
   TEXTURE_GATHER(0x08)
}