package com.dipen.funfact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.dipen.funfact.ui.screens.FunFactNavigationGraph
import com.dipen.funfact.ui.theme.FunFactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunFactTheme {
                FunFactApp()
            }
        }
    }

    @Composable
    private fun FunFactApp() {
        FunFactNavigationGraph()
    }
}
