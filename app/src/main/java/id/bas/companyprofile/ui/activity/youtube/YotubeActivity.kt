package id.bas.companyprofile.ui.activity.youtube

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import id.bas.companyprofile.R
import kotlinx.android.synthetic.main.activity_yotube.*

class YotubeActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    var player : MyPlayerStateChangeListener? = null
    var playbackEvent : MyPlaybackEventListener? = null
    var key ="AIzaSyASxs8XEaG-cjcNu2Ubr75wb-5AxkPz27g"
    val RECOVERY_REQUEST =1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yotube)

        youtube.initialize(key, this@YotubeActivity)
        player = MyPlayerStateChangeListener()
        playbackEvent = MyPlaybackEventListener()

    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {

        p1?.setPlayerStateChangeListener(player)
        p1?.setPlaybackEventListener(playbackEvent)
        if (!p2){
            p1?.cueVideo("WdK9UP9PqAQ")
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {

        if (p1?.isUserRecoverableError()!!){
            p1?.getErrorDialog(this, RECOVERY_REQUEST).show()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider()?.initialize(key, this@YotubeActivity);
        }
    }

    protected fun getYouTubePlayerProvider(): YouTubePlayer.Provider? {
        return youtube
    }

    class MyPlaybackEventListener : YouTubePlayer.PlaybackEventListener {
        override fun onPlaying() { // Called when playback starts, either due to user action or call to play().

        }

        override fun onPaused() { // Called when playback is paused, either due to user action or call to pause().

        }

        override fun onStopped() { // Called when playback stops for a reason other than being paused.

        }

        override fun onBuffering(b: Boolean) { // Called when buffering starts or ends.
        }

        override fun onSeekTo(i: Int) { // Called when a jump in playback position occurs, either
// due to user scrubbing or call to seekRelativeMillis() or seekToMillis()
        }
    }

    class MyPlayerStateChangeListener : YouTubePlayer.PlayerStateChangeListener {
        override fun onLoading() { // Called when the player is loading a video
// At this point, it's not ready to accept commands affecting playback such as play() or pause()
        }

        override fun onLoaded(s: String) { // Called when a video is done loading.
// Playback methods such as play(), pause() or seekToMillis(int) may be called after this callback.
        }

        override fun onAdStarted() { // Called when playback of an advertisement starts.
        }

        override fun onVideoStarted() { // Called when playback of the video starts.
        }

        override fun onVideoEnded() { // Called when the video reaches its end.
        }

        override fun onError(errorReason: YouTubePlayer.ErrorReason) { // Called when an error occurs.
        }
    }

}
