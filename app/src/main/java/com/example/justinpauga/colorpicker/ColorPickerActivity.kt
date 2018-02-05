package com.example.justinpauga.colorpicker

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.SurfaceView
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_color_picker.*

class ColorPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_picker)

        // Get the values of the seekbars
        val seekRed = findViewById<SeekBar>(R.id.redSeekBar)
        val seekBlue = findViewById<SeekBar>(R.id.blueSeekBar)
        val seekGreen = findViewById<SeekBar>(R.id.greenSeekBar)

        //Set the color values to zero
        var red = 0
        var blue = 0
        var green = 0

        // Set the max value of the seekbars(default is 100)
        seekRed.max = 255
        seekBlue.max = 255
        seekGreen.max = 255

        // Get the value of the surfaceView
        val colorView = findViewById<SurfaceView>(R.id.colorView)

        // Set on change listener to get the value of the red seekBar and pass it to the surface view
        seekRed.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(SeekBar: SeekBar?) {}
            override fun onStartTrackingTouch(SeekBar: SeekBar?) {}
            override fun onProgressChanged(SeekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                redValue.text = progress.toString()
                red = progress
                setSurfaceViewColor(red, blue, green)
                Log.d("red", red.toString())
            }
        })

        // Set on change listener to get the value of the blue seekBar and pass it to the surface view
        seekBlue.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(SeekBar: SeekBar?) {}
            override fun onStartTrackingTouch(SeekBar: SeekBar?) {}
            override fun onProgressChanged(SeekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                blueValue.text = progress.toString()
                blue = progress
                setSurfaceViewColor(red, blue, green)
                Log.d("blue", blue.toString())
            }
        })

        // Set on change listener to get the value of the green seekBar and pass it to the surface view
        seekGreen.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(SeekBar: SeekBar?) {}
            override fun onStartTrackingTouch(SeekBar: SeekBar?) {}
            override fun onProgressChanged(SeekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                greenValue.text = progress.toString()
                green = progress
                setSurfaceViewColor(red,blue,green)
                Log.d("green", green.toString())
            }
        })
    }

    private fun setSurfaceViewColor(r: Int, b: Int, g: Int) {
        colorView.setBackgroundColor(Color.rgb(r,g,b))
    }
}
