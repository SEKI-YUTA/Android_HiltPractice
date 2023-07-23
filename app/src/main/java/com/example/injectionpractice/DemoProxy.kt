package com.example.injectionpractice

import android.content.Context
import android.widget.Toast
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

class DemoProxy(
    val url: String,
    val context: Context
) {
    fun getHTML() {
        println("Getting HTML from $url")
        Toast.makeText(context, "Getting HTML from $url", Toast.LENGTH_SHORT).show()
//            val url = URL(url)
//            val inputStream = url.openStream()
////        val html = inputStream.bufferedReader().use { it.readText() }
//            val inputStreamReader = InputStreamReader(inputStream)
//            val bufferedReader = BufferedReader(inputStreamReader)
//            val stringBuilder = StringBuilder()
//            while(true) {
//                val str = bufferedReader.readLine()
//                if(str == null) break
//                stringBuilder.append(str)
//            }
//
//            Log.d("DemoProxy", stringBuilder.toString())
    }
}