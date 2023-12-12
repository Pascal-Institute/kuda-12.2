package kuda.runtimeapi

class EventHandler {
    companion object {

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

        //6.5 Event Management

        @JvmStatic
        external fun create() : Long

        @JvmStatic
        external fun createWithFlags(flags : Int) : Long

        @JvmStatic
        external fun destroy(event : Long) : Int

        @JvmStatic
        external fun elapsedTime(start : Long, end : Long) : Float

        @JvmStatic
        external fun query(event : Long) : Int

        @JvmStatic
        external fun synchronize(event : Long) : Int

    }
}