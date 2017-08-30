package cf.reol.stingy.utils

import android.util.Log

/**
 * Created by reol on 2017/8/30.
 */
class Logger{
    companion object {
        val logLevel: Boolean = true

        fun d(tag:String, text: String){
            if (logLevel){
                Log.d(tag, text)
            }
        }

        fun e(tag: String, text: String){
            if (logLevel){
                Log.e(tag, text)
            }
        }

    }
}