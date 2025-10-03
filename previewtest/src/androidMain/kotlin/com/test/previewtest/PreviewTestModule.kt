package com.test.previewtest


import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ButtonTest(){
    Button(onClick = { /*TODO*/ }) {
        Text("Test preview module")
    }
}

@Composable
@Preview
fun ButtonTestPreview(){
    ButtonTest()
}