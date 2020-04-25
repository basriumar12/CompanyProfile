package id.bas.companyprofile.ui.activity.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import id.bas.companyprofile.MainActivity
import id.bas.companyprofile.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            //untuk pindah activity
            startActivity(
                Intent(this,
                    MainActivity::class.java)
            )

        },4000)

    }
}
