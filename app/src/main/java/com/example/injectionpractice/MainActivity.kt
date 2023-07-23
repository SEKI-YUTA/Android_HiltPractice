package com.example.injectionpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.injectionpractice.ui.theme.InjectionPracticeTheme
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InjectionPracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = hiltViewModel<MainViewModel>()
                    Column(modifier = Modifier.width(IntrinsicSize.Max), verticalArrangement = Arrangement.Center) {
                        Text("Count: ${viewModel.count.value}",
                            modifier = Modifier.fillMaxWidth().pointerInput(Unit) {
                                detectTapGestures(
                                    onLongPress = {
                                        viewModel.countReset()
                                    },
                                    onPress = {
                                        viewModel.countUp()
                                    }
                                )
                            }, style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center)
                        Button(onClick = {
                            viewModel.runProxy()
                        }) {
                            Text("Run Proxy")
                        }
                    }
                }
            }
        }
    }
}
