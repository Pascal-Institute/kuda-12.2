package kuda.kublas

import kuda.kublas.prop.LibraryPropertyType

class Kublas {

    external fun create(): Long

    external fun destroy(handle: Long): Int

    external fun getVersion(handle: Long): Int

    fun getProperty(libraryPropertyType: LibraryPropertyType): Int {
        return getProperty(libraryPropertyType.num)
    }

    private external fun getProperty(type: Int): Int

    companion object {
        private var isLibraryLoaded = false

        init {
            loadLibraryIfNotLoaded()
        }

        @Synchronized
        private fun loadLibraryIfNotLoaded() {
            if (!isLibraryLoaded) {
                System.loadLibrary("kublas")
                isLibraryLoaded = true
            }
        }
    }
}