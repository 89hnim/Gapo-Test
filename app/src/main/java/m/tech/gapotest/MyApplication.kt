package m.tech.gapotest

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.zxy.recovery.core.Recovery
import dagger.hilt.android.HiltAndroidApp
import m.tech.gapotest.framework.presentation.MainActivity

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //TODO: enable/disable dark theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        if (BuildConfig.DEBUG) {
            Recovery.getInstance()
                .debug(true)
                .recoverInBackground(false)
                .recoverStack(true)
                .mainPage(MainActivity::class.java)
                .recoverEnabled(true)
                .silent(false, Recovery.SilentMode.RECOVER_ACTIVITY_STACK)
                .init(this)
        }
    }

}
