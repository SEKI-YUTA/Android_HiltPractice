package com.example.injectionpractice

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val proxy: DemoProxy,
): ViewModel() {
    val count = mutableStateOf(0)

    fun countUp() {
        count.value++
    }

    fun countDown() {
        count.value--
    }

    fun countReset() {
        count.value = 0
    }

    fun runProxy() {
        proxy.getHTML()
    }
}