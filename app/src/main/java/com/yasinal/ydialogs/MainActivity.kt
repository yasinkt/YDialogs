package com.yasinal.ydialogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yasinal.ydialogs.ui.theme.YDialogsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YDialogsTheme {
                val isOpenBottomSheet = remember { mutableStateOf(false) }

                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(50.dp)
                ) {
                    Button(
                        onClick = {
                            isOpenBottomSheet.value = true
                        },
                    ) {
                        Text("Open Bottom Sheet")
                    }
                }

                BottomSheetDialog(
                    isOpen = isOpenBottomSheet,
                    onDismiss = {
                        isOpenBottomSheet.value = false
                    }
                ) { // content
                    Column {
                        BottomSheetHeader(
                            title = "Bottom Sheet Title",
                            isVisibleIndicator = true
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Box (
                            modifier = Modifier,
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Bottom Sheet Content",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}