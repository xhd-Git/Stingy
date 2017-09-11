package cf.reol.stingy.base

import android.app.Application
import io.realm.Realm

/**
 * Created by reol on 2017/9/11.
 */
class StingyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(applicationContext)
    }
}