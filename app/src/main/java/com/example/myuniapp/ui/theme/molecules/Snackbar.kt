package com.example.myuniapp.ui.theme.molecules

import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import com.example.myuniapp.DefaultSnackbar

@Composable
fun Snackbar(snackbarHostState: SnackbarHostState) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { data ->
            DefaultSnackbar(
                data = data,
                onDismiss = { data.dismiss() }
            )
        }
    )
}