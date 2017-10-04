package charleston.androidkotlinproject.extensions

import java.lang.IllegalStateException

/**
 * Created by charleston.anjos on 04/10/17.
 */
fun <T> loadJson(clazz: Class<T>, fileName: String): String {
    return try {
        val resource = clazz.javaClass.classLoader.getResource(fileName)
        val fileJSon = java.io.File(resource.file)
        val inputStream = fileJSon.inputStream()
        val jsonByte: ByteArray = kotlin.ByteArray(inputStream.available())
        inputStream.read(jsonByte)
        inputStream.close()
        kotlin.text.String(jsonByte)
    } catch (e: IllegalStateException) {
        e.printStackTrace().toString()
    }
}