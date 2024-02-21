package kuda.mathapi

class MathAPI {
    companion object{

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