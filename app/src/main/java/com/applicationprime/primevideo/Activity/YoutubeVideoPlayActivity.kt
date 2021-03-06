package com.applicationprime.primevideo.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.applicationprime.primevideo.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_youtube_video_play.*


class YoutubeVideoPlayActivity : AppCompatActivity() {

    private lateinit var moviePlayLink: String

    var mYouTubePlayer: YouTubePlayer? = null
    var currentVolume = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_video_play)

        val i = intent
        moviePlayLink = i.getStringExtra("movieUrl")!!
        youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(moviePlayLink, 0f)
                youTubePlayer.setVolume(currentVolume)
            }
        })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            if (currentVolume >= 10) {
                currentVolume -= 10
                mYouTubePlayer?.setVolume(currentVolume)
            }
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            if (currentVolume <= 90) {
                currentVolume += 10
                mYouTubePlayer?.setVolume(currentVolume)
            }
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish()
        }
        return true
    }
}