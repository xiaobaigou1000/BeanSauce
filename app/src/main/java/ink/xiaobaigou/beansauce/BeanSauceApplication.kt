package ink.xiaobaigou.beansauce

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class BeanSauceApplication : Application() {
    companion object {
        lateinit var instance: BeanSauceApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(this);
    }
}