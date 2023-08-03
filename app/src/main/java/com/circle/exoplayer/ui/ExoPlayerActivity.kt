package com.circle.exoplayer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.SimpleExoPlayer
import androidx.media3.ui.PlayerView
import com.circle.exoplayer.R
import com.circle.exoplayer.data.ExoPlayerViewModel
import com.circle.exoplayer.databinding.ActivityExoPlayerBinding

class ExoPlayerActivity : AppCompatActivity() {

    private lateinit var binding : ActivityExoPlayerBinding
    private lateinit var viewmodel : ExoPlayerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exo_player)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_exo_player)
        viewmodel = ViewModelProvider(this).get(ExoPlayerViewModel::class.java)
        binding.exoviewmodel = viewmodel

        val exoPlayerInstance = ExoPlayer.Builder(this).build()
        binding.exoplayerView.player = exoPlayerInstance

        // Build the media item.
        val mediaItem = MediaItem.fromUri(viewmodel.link)
        // Set the media item to be played.
        exoPlayerInstance.setMediaItem(mediaItem)
        // Prepare the player.
        exoPlayerInstance.prepare()
        // Start the playback.
        if (exoPlayerInstance.playWhenReady) exoPlayerInstance.play()   // this will play only when user clicks on play button of the playerview.

    }
}