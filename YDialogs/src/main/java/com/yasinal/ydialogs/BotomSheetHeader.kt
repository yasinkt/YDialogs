package com.yasinal.ydialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetHeader(
    title: String,
    indicatorColor: Color = Color(0xFF000000),
    titleColor: Color = Color(0xFF000000),
    titleStyle: TextStyle = TextStyle.Default,
    isVisibleIndicator: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (isVisibleIndicator) {
            Box (
                modifier = Modifier
                    .width(44.dp)
                    .height(5.dp)
                    .background(
                        color = indicatorColor,
                        shape = RoundedCornerShape(13.dp)
                    )
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Text(
            text = title,
            color = titleColor,
            style = titleStyle
        )
    }
}