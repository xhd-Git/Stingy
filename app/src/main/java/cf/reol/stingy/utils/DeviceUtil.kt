package cf.reol.stingy.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by reol on 03/09/2017.
 */
class DeviceUtil{
    companion object {
        fun width(context: Context): Int{
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            return dm.widthPixels
        }

        fun height(context: Context): Int {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }
    }
}