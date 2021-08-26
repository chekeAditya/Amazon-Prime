package com.example.primevideo.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import com.example.primevideo.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_youtube_video_play.*

class YoutubeVideoPlayActivity : AppCompatActivity() {

    var mYouTubePlayer: YouTubePlayer? = null
    var currentVolume = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_video_play)

        youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                mYouTubePlayer = youTubePlayer
                val videoId = getString(R.string.video_id)
                youTubePlayer.loadVideo(videoId, 0f)
                youTubePlayer.setVolume(currentVolume)
            }
        })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            if(currentVolume>=10) {
                currentVolume = currentVolume - 10
                mYouTubePlayer?.setVolume(currentVolume)
            }
        }else  if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            if(currentVolume<=90) {
                currentVolume = currentVolume + 10
                mYouTubePlayer?.setVolume(currentVolume)
            }
        } else if(keyCode == KeyEvent.KEYCODE_BACK){
            finish()
        }
        return true
    }
}