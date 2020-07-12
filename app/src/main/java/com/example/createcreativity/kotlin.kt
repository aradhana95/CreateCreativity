package com.example.createcreativity

import java.io.File

class kotlin {

    captureButton.setOnTouchListener { _, event ->
        if (event.action == MotionEvent.ACTION_DOWN) {
            captureButton.setBackgroundColor(Color.GREEN)
            videoCapture.startRecording(file, object: VideoCapture.OnVideoSavedListener{
                override fun onVideoSaved(file: File?) {
                }
}