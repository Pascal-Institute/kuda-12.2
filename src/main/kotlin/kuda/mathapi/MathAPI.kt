package kuda.mathapi

class MathAPI {
    companion object{

        /**
         * Calculate the arc cosine of the input argument.
         */
        @JvmStatic
        external fun acos(x : Double) : Double

        /**
         * Calculate the nonnegative inverse hyperbolic cosine of the input argument.
         */
        @JvmStatic
        external fun acosh(x : Double) : Double

        /**
         * Calculate the base logarithm of the input argument x
         */
        @JvmStatic
        external fun log(x : Double) : Double

        private var isLibraryLoaded = false

        init {
            loadLibraryIfNotLoaded()
        }

        @Synchronized
        private fun loadLibraryIfNotLoaded() {
            if (!isLibraryLoaded) {
                System.loadLibrary("kudadll")
                isLibraryLoaded = true
            }
        }
    }
}