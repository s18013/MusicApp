package com.example.musicapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    private lateinit var player : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pause = findViewById<Button>(R.id.pause)
        val start = findViewById<Button>(R.id.start)
        val stop = findViewById<Button>(R.id.stop)
        val seekBarTime = findViewById<SeekBar>(R.id.seekBarTime)

        player = MediaPlayer.create(this, R.raw.senbonzakura)

        pause.setOnClickListener {
            player.pause()
        }
        start.setOnClickListener {
            player.start()
        }
        stop.setOnClickListener {
            player.stop()
            player = MediaPlayer.create(this, R.raw.senbonzakura)
        }
        seekBarTime.max = player.duration
        seekBarTime.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) {
                    player.seekTo(progress)
                    if (seekBar != null) {
                        seekBar.progress = progress
                    }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
}