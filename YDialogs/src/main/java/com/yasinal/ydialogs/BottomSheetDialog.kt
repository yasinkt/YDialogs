@file:OptIn(ExperimentalMaterial3Api::class)

package com.yasinal.ydialogs

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun BottomSheetDialog(
    isOpen: State<Boolean>,
    shape: Shape = RoundedCornerShape(topStart = 13.dp, topEnd = 13.dp),
    onDismiss: () -> Unit,
    confirmValueChange: Boolean = true,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val configuration = LocalContext.current.resources.configuration
    val density = LocalDensity.current
    val screenHeightPx = configuration.screenHeightDp * density.density
    val topPadding = with(density) { (screenHeightPx * 0.04f / density.density).dp }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { confirmValueChange }
    )
    val scope = rememberCoroutineScope()

    LaunchedEffect(isOpen.value) {
        println("isOpen.value: ${isOpen.value}")
        if (isOpen.value) {
            scope.launch {
                sheetState.show()
            }
        } else {
            scope.launch {
                sheetState.hide()
            }
        }
    }

    if (sheetState.isVisible || isOpen.value) {
        ModalBottomSheet(
            modifier = Modifier
                .padding(top = topPadding),
            sheetState = sheetState,
            shape = shape,
            onDismissRequest = {
                onDismiss()
            },
            dragHandle = null
        ) {
            content()
            if (isTabletBasedOnSW(context)) {
                Spacer(modifier = Modifier.height(100.dp))
            } else {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

private fun isTabletBasedOnSW(context: Context): Boolean {
    val configuration = context.resources.configuration
    return configuration.smallestScreenWidthDp >= 600
}